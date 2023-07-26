package com.linkwin.web.controller.activity;


import com.linkwin.activity.domain.ExchangePrize;
import com.linkwin.activity.service.IExchangePrizeService;
import com.linkwin.common.core.controller.BaseController;
import com.linkwin.common.core.domain.entity.SysUser;
import com.linkwin.common.json.JsonViewObject;
import com.linkwin.common.utils.StringUtils;
import com.linkwin.framework.jwt.utils.JwtUtils;
import com.linkwin.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("exchangePrizeH5")
public class ExchangePrizeH5Controller extends BaseController {


    private static String prefix="activity/exchangeH5";

    @Autowired
    private IExchangePrizeService exchangePrizeService;


    @Autowired
    private ISysUserService userService;

    /**
     * 经销商登录
     * @return
     */
    @GetMapping("exchangeLogin")
    public String exchangeLogin(String checkAddress, ModelMap mmap){
        mmap.put("checkAddress",checkAddress);
        return prefix+"/exchangeLogin";
    }

    /**
     * 经销商兑奖
     * @return
     */
    @GetMapping("exchangePrize")
    public String exchangePrize(String checkAddress, ModelMap mmap){
        mmap.put("checkAddress",checkAddress);
        return prefix+"/exchangePrize";
    }

    /**
     * 经销商兑奖接口
     * @param exchangePrize
     * @Author qipeng.zheng
     * @Date 2022/6/10
     */
    @PostMapping("exchange")
    @ResponseBody
    public JsonViewObject exchange(ExchangePrize exchangePrize, HttpServletRequest request){
        JsonViewObject jsonViewObject=new JsonViewObject();
        try {

            String userName = JwtUtils.getUserName(request.getHeader("token"));
            if (StringUtils.isEmpty(userName)){
                jsonViewObject.fail("token参数为空");
            }
            SysUser sysUser = userService.selectUserByLoginName(userName);
            if (sysUser==null){
                jsonViewObject.fail("用户不存在");
                return jsonViewObject;
            }
            jsonViewObject=exchangePrizeService.exchange(exchangePrize,sysUser);
        }catch (Exception e){
            e.printStackTrace();
            jsonViewObject.fail("核销异常");
        }
        return jsonViewObject;
    }

    /**
     * 根据中奖码查询
     * @param code
     * @Author qipeng.zheng
     * @Date 2022/6/10
     */
    @PostMapping("queryExchangeByCode")
    @ResponseBody
    public JsonViewObject queryExchangeByCode(String code){
        JsonViewObject jsonViewObject=new JsonViewObject();
        try {
            ExchangePrize exchangePrize = exchangePrizeService.selectByCode(code);
            if (exchangePrize==null){
                jsonViewObject.fail("未查询到该中奖码信息！");
            }else {
                if (exchangePrize.getExchange()==1){
                    jsonViewObject.fail("该中奖码已经兑换过！",exchangePrize);
                }else {
                    jsonViewObject.success("查询成功",exchangePrize);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonViewObject.fail("查询异常，请联系管理员！");
        }
        return jsonViewObject;
    }






}
