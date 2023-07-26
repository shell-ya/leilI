package com.linkwin.openInterface.impl;

import com.linkwin.Integral.service.IIntegralPersonService;
import com.linkwin.activity.domain.*;
import com.linkwin.activity.mapper.CodeActivityLogMapper;
import com.linkwin.activity.mapper.ExchangePrizeMapper;
import com.linkwin.activity.mapper.LuckdrawPrizeMapper;
import com.linkwin.activity.service.IActivityManagerService;
import com.linkwin.activity.service.IExchangePrizeService;
import com.linkwin.activity.service.IIntegralCodeStatusService;
import com.linkwin.apply.domain.BoxCode;
import com.linkwin.apply.domain.SubCode;
import com.linkwin.apply.mapper.BarCodeMapper;
import com.linkwin.apply.mapper.BoxCodeMapper;
import com.linkwin.apply.mapper.SubCodeMapper;
import com.linkwin.basedata.domain.Product;
import com.linkwin.basedata.service.IProductService;
import com.linkwin.common.exception.ServiceException;
import com.linkwin.common.json.JsonViewObject;
import com.linkwin.common.utils.MessageUtils;
import com.linkwin.common.utils.StringUtils;
import com.linkwin.common.utils.bean.BeanUtils;
import com.linkwin.openInterface.IMobileInterfaceService;
import com.linkwin.trace.domain.ConsumerLog;
import com.linkwin.trace.mapper.ConsumerLogMapper;
import com.linkwin.utils.CodeEnum;
import com.linkwin.utils.CodeUtils;
import com.linkwin.utils.TableUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class MobileInterfaceServiceImpl implements IMobileInterfaceService {

    @Autowired
    private ConsumerLogMapper consumerLogMapper;

    @Autowired
    private CodeActivityLogMapper codeActivityLogMapper;

    @Autowired
    private SubCodeMapper subCodeMapper;

    @Autowired
    private BoxCodeMapper boxCodeMapper;

    @Autowired
    private IExchangePrizeService exchangePrizeService;

    @Autowired
    private IIntegralPersonService integralPersonService;

    @Autowired
    private ExchangePrizeMapper exchangePrizeMapper;

    @Autowired
    private IIntegralCodeStatusService integralCodeStatusService;

    @Autowired
    private BarCodeMapper barCodeMapper;

    @Autowired
    private IProductService productService;

    @Autowired
    private IActivityManagerService activityManagerService;


    @Autowired
    private LuckdrawPrizeMapper luckdrawPrizeMapper;



    @Override
    public JsonViewObject uploadConsumer(List<ConsumerLog> consumerLogList) throws ServiceException{
        JsonViewObject jsonViewObject = new JsonViewObject();
        try {
            for (ConsumerLog consumerLog : consumerLogList) {
                CodeUtils.verifyCode(consumerLog.getCode());
                String codeType = CodeUtils.getCodeTypeByCode(consumerLog.getCode());
                consumerLog.setCodeType(codeType);
                consumerLog.setCreateTime(new Date());
            }
            int row = consumerLogMapper.batchInsert(consumerLogList);
            jsonViewObject.success("上传成功", row);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("上传消费者信息异常：" + e.getMessage());
//            jsonViewObject.fail("上传消费者信息异常");
            jsonViewObject.fail(MessageUtils.message("error.msg.uploadconsumer"));
            throw new ServiceException(e.getMessage());
        }
        return jsonViewObject;
    }

    @Override
    public JsonViewObject uploadActivityLog(CodeActivityLog activity) throws ServiceException{
        JsonViewObject jsonViewObject = new JsonViewObject();
        try {
            if (!(activity.getMarkCode().length() == CodeUtils.SUB_CODE_LENGTH || activity.getMarkCode().length() == CodeUtils.BOX_CODE_LENGTH)) {
//                jsonViewObject.fail("请上传正确条码");
                jsonViewObject.fail(MessageUtils.message("error.msg.correctbarcode"));
                return jsonViewObject;
            }
            String codeType = CodeUtils.getCodeTypeByCode(activity.getMarkCode());
            String lastYear = TableUtils.getYearByCode(activity.getMarkCode());
            String year = "20" + lastYear;

            if (CodeEnum.SUB_CODE.getValue().equals(codeType)) {
                String subTableName = TableUtils.getSubTableByYear(Integer.valueOf(year));
                int i = subCodeMapper.queryTableName(subTableName);
                if (i == 0) {
//                    jsonViewObject.fail("该条码在系统中不存在");
                    jsonViewObject.fail(MessageUtils.message("error.msg.barcodenotexistsystem"));
                    return jsonViewObject;
                }
                SubCode subCode = subCodeMapper.selectByCode(subTableName, activity.getMarkCode());
                if (subCode == null) {
//                    jsonViewObject.fail("该条码在系统中不存在");
                    jsonViewObject.fail(MessageUtils.message("error.msg.barcodenotexistsystem"));
                    return jsonViewObject;
                }
            } else if (CodeEnum.BOX_CODE.getValue().equals(codeType)) {
                String boxTableName = TableUtils.getBoxTableByYear(Integer.valueOf(year));
                int i = subCodeMapper.queryTableName(boxTableName);
                if (i == 0) {
//                    jsonViewObject.fail("该条码在系统中不存在");
                    jsonViewObject.fail(MessageUtils.message("error.msg.barcodenotexistsystem"));
                    return jsonViewObject;
                }
                BoxCode boxCode = boxCodeMapper.selectByCode(boxTableName, activity.getMarkCode());
                if (boxCode == null) {
//                    jsonViewObject.fail("该条码在系统中不存在");
                    jsonViewObject.fail(MessageUtils.message("error.msg.barcodenotexistsystem"));
                    return jsonViewObject;
                }
            }
            CodeActivityLog codeActivityLog = new CodeActivityLog();
            codeActivityLog.setMarkCode(activity.getMarkCode());
            List<CodeActivityLog> codeActivityLogs = codeActivityLogMapper.selectCodeActivityLogList(codeActivityLog);
            if (codeActivityLogs.size() > 0) {
//                jsonViewObject.fail("该码已参加过活动", codeActivityLogs.get(0));
                jsonViewObject.fail(MessageUtils.message("error.msg.participatedintheactivity"), codeActivityLogs.get(0));
                return jsonViewObject;
            }
            codeActivityLogMapper.insertCodeActivityLog(activity);
            jsonViewObject.success("上传成功", codeActivityLog.getId());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("MobileInterfaceServiceImpl uploadActivityLog is error", e.getMessage());
            jsonViewObject.fail("上传异常");
            throw new ServiceException(e.getMessage());
        }
        return jsonViewObject;
    }

    @Override
    public JsonViewObject queryActivityLog(String openId, String code) throws ServiceException {
        JsonViewObject jsonViewObject = new JsonViewObject();
        try {
            if (!(code.length() == CodeUtils.INTEGRAL_CODE_LENGTH)) {
//                jsonViewObject.fail("请上传正确条码");
                jsonViewObject.fail(MessageUtils.message("error.msg.correctbarcode"));
                return jsonViewObject;
            }
            String codeType = CodeUtils.getCodeTypeByCode(code);
            String lastYear = TableUtils.getYearByCode(code);
            String year = "20" + lastYear;
//            if (CodeEnum.SUB_CODE.getValue().equals(codeType)) {
            String subTableName = TableUtils.getSubTableByYear(Integer.valueOf(year));
            int i = subCodeMapper.queryTableName(subTableName);
            if (i == 0) {
//                jsonViewObject.fail("该条码在系统中不存在");
                jsonViewObject.fail(MessageUtils.message("error.msg.barcodenotexistsystem"));
                return jsonViewObject;
            }
            SubCode subCode = subCodeMapper.selectByMarkCode(subTableName, code);
            if (subCode == null) {
//                jsonViewObject.fail("该条码在系统中不存在");
                jsonViewObject.fail(MessageUtils.message("error.msg.barcodenotexistsystem"));
                return jsonViewObject;
            }
            IntegralCodeStatus integralCodeStatus = integralCodeStatusService.selectByMarkCode(code);
            if (integralCodeStatus==null||"1".equals(integralCodeStatus.getStatus())||"3".equals(integralCodeStatus.getStatus())) {//未激活
                if (integralCodeStatus!=null&&"1".equals(integralCodeStatus.getStatus())){
//                    jsonViewObject.fail("该营销码未激活，请在防伪查询处激活");
                    jsonViewObject.fail(MessageUtils.message("error.msg.anti-counterfeitinginquiry"));
                    return jsonViewObject;
                }else if (integralCodeStatus!=null&&"3".equals(integralCodeStatus.getStatus())){
//                    jsonViewObject.fail("该营销码已参加活动");
                    jsonViewObject.fail(MessageUtils.message("error.msg.participatedintheactivity"));
                    return jsonViewObject;
                }
            }
            CodeActivityLog codeActivityLog = new CodeActivityLog();
            codeActivityLog.setMarkCode(code);
            List<CodeActivityLog> codeActivityLogList = codeActivityLogMapper.selectCodeActivityLogList(codeActivityLog);
            if (codeActivityLogList.size() > 0) {
                CodeActivityPrizeResultVo activityPrizeResultVo = new CodeActivityPrizeResultVo();
                BeanUtils.copyBeanProp(activityPrizeResultVo, codeActivityLogList.get(0));
                if (ActivityTypeEnum.TRUNTABLE.getValue().equals(activityPrizeResultVo.getActivityType())) {
                    ExchangePrize exchangePrize = exchangePrizeMapper.selectByMarkCode(codeActivityLogList.get(0).getMarkCode());
                    if (exchangePrize != null && openId.equals(exchangePrize.getOpenId())) {
                        activityPrizeResultVo.setQueryDetailPrizeAuthority(true);//没有权限查看中奖明细
                        activityPrizeResultVo.setExchangePrize(exchangePrize);
                    } else {
                        activityPrizeResultVo.setQueryDetailPrizeAuthority(false);//没有权限查看中奖明细
                    }
                }
//                jsonViewObject.success("该条码参加过活动", activityPrizeResultVo);
                jsonViewObject.success(MessageUtils.message("error.msg.barcodeparticipatedintheactivity"), activityPrizeResultVo);
            } else {
//                jsonViewObject.success("该条码未参加过活动", true);
                jsonViewObject.success(MessageUtils.message("error.msg.barcodenotparticipatedactivity"), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("MobileInterfaceServiceImpl queryActivityLog is error", e.getMessage());
            jsonViewObject.fail("查询异常");
            throw new ServiceException(e.getMessage());
        }
        return jsonViewObject;
    }

    @Transactional
    @Override
    public JsonViewObject uploadExchangePrize(ExchangePrize exchangePrize) throws ServiceException{
        JsonViewObject jsonViewObject = new JsonViewObject();
        try {
            ExchangePrize prize = exchangePrizeService.selectByCode(exchangePrize.getCode());
            if (prize != null) {
//                jsonViewObject.fail("已上传过该中奖码", prize);
                jsonViewObject.fail(MessageUtils.message("error.msg.winningcodeuploaded"), prize);
                return jsonViewObject;
            }
            exchangePrize.setExchange(0);
            exchangePrize.setCreateTime(new Date());
            int i = exchangePrizeService.insertExchangePrize(exchangePrize);
            if (i > 0) {
                jsonViewObject.success("上传成功");
            } else {
                jsonViewObject.fail(MessageUtils.message("error.msg.uploadfail"));
//                jsonViewObject.fail("上传失败,未保存成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
//            jsonViewObject.fail("上传异常，请联系管理员");
            jsonViewObject.fail(MessageUtils.message("error.msg.uploadabnormal"));
            log.error("MobileInterfaceServiceImpl uploadExchangePrize is error", e.getMessage());
            throw new ServiceException(e.getMessage());
        }
        return jsonViewObject;
    }

    @Override
    public JsonViewObject queryExchangePrizeLog(String openId) throws ServiceException{
        JsonViewObject jsonViewObject = new JsonViewObject();
        try {
            List<ExchangePrize> exchangePrizeList = exchangePrizeService.selectByOpenId(openId);
            jsonViewObject.success(String.valueOf(exchangePrizeList.size()), exchangePrizeList);
        } catch (Exception e) {
            jsonViewObject.fail("查询异常");
            e.printStackTrace();
            log.error("MobileInterfaceServiceImpl queryExchangePrizeLog is error", e);
            throw new ServiceException(e.getMessage());
        }
        return jsonViewObject;
    }

    @Override
    public JsonViewObject getPrizeCode() throws ServiceException {
        JsonViewObject jsonViewObject = new JsonViewObject();
        try {
            String integralCode = CodeUtils.getIntegralCode(10);
            ExchangePrize exchangePrize = exchangePrizeService.selectByCode(integralCode);
            if (exchangePrize != null) {
                while (exchangePrize != null) {
                    integralCode = CodeUtils.getIntegralCode(10);
                    exchangePrize = exchangePrizeService.selectByCode(integralCode);
                }
            }
            ExchangePrize prize = new ExchangePrize();
            prize.setCode(integralCode);
            prize.setCreateTime(new Date());
            prize.setExchange(0);
            exchangePrizeService.insertExchangePrize(prize);
            jsonViewObject.success("获取成功", integralCode);
        } catch (Exception e) {
//            jsonViewObject.fail("获取中奖码异常");
            jsonViewObject.fail(MessageUtils.message("error.msg.winningcodeexception"));
            e.printStackTrace();
            log.error("MobileInterfaceServiceImpl getPrizeCode is error", e);
//            throw new ServiceException("获取中奖码异常" + e.getMessage());
            throw new ServiceException(MessageUtils.message("error.msg.winningcodeexception") + e.getMessage());
        }
        return jsonViewObject;
    }

    @Override
    public JsonViewObject bindPrizeMsg(String markCode,
                                       String code,
                                       String prize,
                                       String openId,
                                       String address,
                                       String activityType,
                                       Long luckdrawPrizeId
    ) throws ServiceException{
        JsonViewObject jsonViewObject = new JsonViewObject();
        try {
            ExchangePrize exchangePrize1 = exchangePrizeService.selectByCode(code);
            if (exchangePrize1 == null) {
//                jsonViewObject.fail("该中奖码不存在");
                jsonViewObject.fail(MessageUtils.message("error.msg.Thewinningcodedoesnotexist"));
                return jsonViewObject;
            }
            if (exchangePrize1.getExchange() == 1) {
//                jsonViewObject.fail("该中奖码已经兑换");
                jsonViewObject.fail(MessageUtils.message("error.msg.codehasredeenmed"));
                return jsonViewObject;
            }
            if (StringUtils.isNotEmpty(exchangePrize1.getPrize())) {
//                jsonViewObject.fail("该中奖码已经绑定中奖信息");
                jsonViewObject.fail(MessageUtils.message("error.msg.winningcodeboundinformation"));
                return jsonViewObject;
            }
            String lastYear = TableUtils.getYearByCode(markCode);
            String year = "20" + lastYear;
            String subTableName = TableUtils.getSubTableByYear(Integer.valueOf(year));
            int i = subCodeMapper.queryTableName(subTableName);
            if (i == 0) {
//                jsonViewObject.fail("该营销码在系统中不存在");
                jsonViewObject.fail(MessageUtils.message("error.msg.Themarketingcodedoesnotexistinthesystem"));
                return jsonViewObject;
            }
            SubCode subCode = subCodeMapper.selectByMarkCode(subTableName, markCode);
            if (subCode == null) {
//                jsonViewObject.fail("该营销码在系统中不存在");
                jsonViewObject.fail(MessageUtils.message("error.msg.Themarketingcodedoesnotexistinthesystem"));
                return jsonViewObject;
            }
            CodeActivityLog codeActivityLog = codeActivityLogMapper.selectByCode(markCode);
            if (codeActivityLog != null) {
//                jsonViewObject.fail("该营销码在已经参加过活动");
                jsonViewObject.fail(MessageUtils.message("error.msg.Themarketingcodehasparticipatedinthactivity"));
                return jsonViewObject;
            }
            LuckdrawPrize luckdraw = luckdrawPrizeMapper.selectLuckdrawPrizeById(luckdrawPrizeId);
            if (luckdraw == null){
//                jsonViewObject.fail("不存在该奖项");
                jsonViewObject.fail(MessageUtils.message("error.msg.Theprizeitemdoesnotexist"));
                return jsonViewObject;
            }
            int up = luckdrawPrizeMapper.updateReMainNum(luckdrawPrizeId);
            if (up==0){
                LuckdrawPrize luckdrawPrize = luckdrawPrizeMapper.selectLuckdrawPrizeById(luckdrawPrizeId);
                jsonViewObject.fail(luckdrawPrize.getName()+MessageUtils.message("error.msg.quantityremaining"));
//                jsonViewObject.fail(luckdrawPrize.getName()+"剩余数量不足");
                return jsonViewObject;
            }
            CodeActivityLog codeActivityLog1 = new CodeActivityLog();
            codeActivityLog1.setMarkCode(markCode);
            codeActivityLog1.setActivityTime(new Date());
            codeActivityLog1.setAddress(address);
            codeActivityLog1.setActivityType(activityType);
            codeActivityLog1.setCodeType(CodeEnum.INTEGRAL_CODE.getValue());
            codeActivityLogMapper.insertCodeActivityLog(codeActivityLog1);//营销码参加活动记录
            exchangePrize1.setPrize(prize);
            exchangePrize1.setOpenId(openId);
            exchangePrize1.setMarkCode(markCode);
            exchangePrize1.setActivityId(luckdraw.getActivityid());
            exchangePrize1.setLuckdrawPrizeId(luckdraw.getId());
            exchangePrizeService.updateExchangePrize(exchangePrize1);
//            jsonViewObject.success("绑定中奖信息成功");
            jsonViewObject.success(MessageUtils.message("error.msg.bindinformation"));
        } catch (Exception e) {
            e.printStackTrace();
//            jsonViewObject.fail("绑定异常");
            jsonViewObject.fail(MessageUtils.message("error.msg.Bindingexception"));
            log.error("MobileInterfaceServiceImpl bindPrizeMsg is error", e);
            throw new ServiceException(e.getMessage());
        }
        return jsonViewObject;
    }

    @Override
    public JsonViewObject getActivityByMarkCode(String markCode,String activityType) {

        JsonViewObject jsonViewObject=new JsonViewObject();

        try {
            String year = TableUtils.getYearByCode(markCode);
            year="20"+year;
            String tableName = TableUtils.getSubTableByYear(Integer.valueOf(year));

            SubCode subCode = subCodeMapper.selectByMarkCode(tableName, markCode);
            if (subCode==null|| StringUtils.isEmpty(subCode.getPdCode()) ||subCode.getProductionTime()==null){
//                jsonViewObject.fail("该营销码不存在");
                jsonViewObject.fail(MessageUtils.message("error.msg.Themarketingcodedoesnotexist"));
                return jsonViewObject;
            }
            Product product = productService.selectByPdCode(subCode.getPdCode());
            if (product==null){
//                jsonViewObject.fail("该码对应的产品不存在");
                jsonViewObject.fail(MessageUtils.message("error.msg.productcodenotexist"));
                return jsonViewObject;
            }
//            IntegralCodeStatus integralCodeStatus = integralCodeStatusService.selectByMarkCode(markCode);
//            if (integralCodeStatus==null||"1".equals(integralCodeStatus.getStatus())){
//                jsonViewObject.fail("该营销码未激活，请在防伪查询后扫描激活该码");
//                return jsonViewObject;
//            }
//            if ("3".equals(integralCodeStatus.getStatus())){
//                jsonViewObject.fail("该营销码已经参加过活动");
//                return jsonViewObject;
//            }
            ActivityManager activityManager = activityManagerService.getOneActivityByType(product.getCode(),activityType);
            if (activityManager==null){
//                jsonViewObject.fail("该产品目前没有该类型的活动，敬请期待");
                jsonViewObject.fail(MessageUtils.message("error.msg.noactivity"));
                return jsonViewObject;
            }
            LuckdrawPrize luckdrawPrize=new LuckdrawPrize();
            luckdrawPrize.setActivityid(activityManager.getId());
            List<LuckdrawPrize> luckdrawPrizes = luckdrawPrizeMapper.selectLuckdrawPrizeList(luckdrawPrize);
            activityManager.setLuckdrawPrizeList(luckdrawPrizes);
            if (activityManager!=null && StringUtils.isNotEmpty(activityManager.getTruntablePath())){
                String path = activityManager.getTruntablePath().replace("/img","");
                activityManager.setTruntablePath(path);
            }
//            jsonViewObject.success("获取活动成功",activityManager);
            jsonViewObject.success(MessageUtils.message("error.msg.gotactivity"),activityManager);
        }catch (Exception e){
            e.printStackTrace();
//            jsonViewObject.fail("活动获取异常");
            jsonViewObject.fail(MessageUtils.message("error.msg.Activityacquisitionexception"));
            log.error("MobileInterfaceServiceImpl getActivityByMarkCode is error ",e.getMessage());
        }
        return jsonViewObject;
    }
}
