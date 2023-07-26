package com.linkwin.web.controller.trace;

import com.linkwin.Integral.domain.IntegralPerson;
import com.linkwin.Integral.service.IIntegralPersonService;
import com.linkwin.common.annotation.Log;
import com.linkwin.common.core.controller.BaseController;
import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.common.json.JsonViewObject;
import com.linkwin.common.utils.StringUtils;
import com.linkwin.trace.service.IFwQueryLogService;
import com.linkwin.vo.FwQueryResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("fwQueryH5")
@Controller
public class fwQueryH5Controller extends BaseController {


    private String prefix = "trace/fwQueryH5";

    @Autowired
    private IFwQueryLogService fwQueryLogService;

    @Autowired
    private IIntegralPersonService integralPersonService;


    @GetMapping("/{openId}/{address}")
    public String log( @PathVariable("openId") String openId,
                       @PathVariable("address") String address,
                      ModelMap mmap,HttpServletRequest request)
    {
        IntegralPerson integralPerson = integralPersonService.selectByOpenId(openId);
        if (integralPerson==null||(integralPerson!=null&&StringUtils.isEmpty(integralPerson.getPhone()))){
            mmap.put("openId",openId);
            mmap.put("address",address);
            return prefix+"/bindPhone";
        }
        mmap.put("openId",openId);
        mmap.put("phone",integralPerson.getPhone());
        mmap.put("address",address);
        return prefix + "/fwQueryScan";
    }

    @GetMapping("fwQuery")
    public String fwQuery(@RequestParam("openId") String openId,
                          @RequestParam("address") String address,
                          @RequestParam("code") String code, ModelMap mmap, HttpServletRequest request)
    {
        FwQueryResultVo fwQuery=null;
        try {
            int i = code.indexOf("code=");
            if (i!=-1){
                code=code.substring(i+5);
            }
            IntegralPerson integralPerson = integralPersonService.selectByOpenId(openId);
            fwQuery = fwQueryLogService.fwQueryByCode(code,openId,integralPerson.getPhone(),address);
            mmap.put("fwQuery",fwQuery);
            mmap.put("activityIntroduction",fwQuery.getActivityIntroduction());
            mmap.put("openId",openId);
            mmap.put("phone",integralPerson.getPhone());
            mmap.put("address",address);
        }catch (Exception e){
            e.printStackTrace();
            mmap.put("fwQuery",fwQuery);
            mmap.put("activityIntroduction","查询异常，请重新扫码");
            mmap.put("openId",openId);
            mmap.put("address",address);
        }
            return prefix + "/fwQueryNew";
    }

    @Log(title = "防伪查询兑换积分")
    @GetMapping("exchangeIntegral")
    public String exchangeIntegral(@RequestParam("openId") String openId,
                                   @RequestParam("phone") String phone,
                                   @RequestParam("address") String address,
                                   ModelMap mmap,
                                   HttpServletRequest request){
        JsonViewObject jsonViewObject=new JsonViewObject();
        String code= request.getParameter("qrresult");
//        String code=qrresult;
        try {
            jsonViewObject = fwQueryLogService.exchangeIntegral(code, phone, address, openId);
        }catch (Exception e){
            e.printStackTrace();
            jsonViewObject.fail("处理异常");
        }
        if ("success".equals(jsonViewObject.getStatus())){
            if ("其他活动".equals(jsonViewObject.getMsg())){
                mmap.put("data",jsonViewObject.getData());
                return prefix+"/otherActivity";
            }
            mmap.put("data",jsonViewObject.getData());
            mmap.put("msg",jsonViewObject.getMsg());
            return prefix+"/exchangeIntegral";
        }else {
            mmap.put("data",jsonViewObject);
            return prefix+"/exchangeIntegralError";
        }
    }

    @Log(title = "绑定手机号")
    @PostMapping("bindPhone")
    @ResponseBody
    public AjaxResult bindPhone(IntegralPerson integralPerson){
//        JsonViewObject jsonViewObject=new JsonViewObject();
//        try {
            return toAjax( fwQueryLogService.bindPhone(integralPerson.getOpenId(), integralPerson.getPhone(), integralPerson.getAddress()));
//            return fwQueryLogService.bindPhone(integralPerson.getOpenId(), integralPerson.getPhone(), integralPerson.getAddress());
//        }catch (Exception e){
//            jsonViewObject.fail("处理异常");
//        }
//        return jsonViewObject;
    }

    @GetMapping("turntable")
    public String turntable(){
        return "activity/activityH5/index";
    }


    @GetMapping("fwQueryNew")
    public String fwQueryNew(@RequestParam("openId") String openId,
                             @RequestParam("address") String address,
                             @RequestParam("code") String code, ModelMap mmap, HttpServletRequest request)
    {

        FwQueryResultVo fwQuery=null;
        try {
            int i = code.indexOf("code=");
            if (i!=-1){
                code=code.substring(i+5);
            }
            IntegralPerson integralPerson = integralPersonService.selectByOpenId(openId);
            fwQuery = fwQueryLogService.fwQueryByCode(code,openId,integralPerson.getPhone(),address);
            mmap.put("fwQuery",fwQuery);
            mmap.put("activityIntroduction",fwQuery.getActivityIntroduction());
            mmap.put("openId",openId);
            mmap.put("phone",integralPerson.getPhone());
            mmap.put("address",address);
        }catch (Exception e){
            e.printStackTrace();
            mmap.put("fwQuery",fwQuery);
            mmap.put("activityIntroduction","查询异常，请重新扫码");
            mmap.put("openId",openId);
            mmap.put("address",address);
        }
        return prefix + "/fwQueryNew";
    }

    @GetMapping("fwQueryExternal")
    public String fwQueryExternal(@RequestParam("email") String email,
                             @RequestParam("code") String code, ModelMap mmap, HttpServletRequest request)
    {

        FwQueryResultVo fwQuery=null;
        try {
            int i = code.indexOf("code=");
            if (i!=-1){
                code=code.substring(i+5);
            }
            IntegralPerson integralPerson = integralPersonService.selectByOpenId(email);
            fwQuery = fwQueryLogService.fwQueryByCode(code,email,integralPerson.getPhone());
            mmap.put("fwQuery",fwQuery);
            mmap.put("activityIntroduction",fwQuery.getActivityIntroduction());
            mmap.put("openId",email);
            mmap.put("phone",integralPerson.getPhone());
            mmap.put("address","");
        }catch (Exception e){
            e.printStackTrace();
            mmap.put("fwQuery",fwQuery);
            mmap.put("activityIntroduction","The query is abnormal, please scan the code again");
            mmap.put("openId",email);
            mmap.put("address","");
        }
        return prefix + "/fwQueryExternal";
    }









}
