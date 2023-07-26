package com.linkwin.apply.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.linkwin.apply.domain.BarCode;
import com.linkwin.apply.domain.BarCodeApply;
import com.linkwin.apply.domain.BoxCode;
import com.linkwin.apply.domain.SubCode;
import com.linkwin.apply.mapper.BarCodeApplyMapper;
import com.linkwin.apply.service.IBarCodeApplyService;
import com.linkwin.apply.service.IBarCodeService;
import com.linkwin.apply.service.IBoxCodeService;
import com.linkwin.apply.service.ISubCodeService;
import com.linkwin.basedata.domain.ProductOrgan;
import com.linkwin.basedata.service.IProductOrganService;
import com.linkwin.common.exception.ServiceException;
import com.linkwin.common.utils.DateUtils;
import com.linkwin.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 字母码申请记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Service
public class BarCodeApplyServiceImpl implements IBarCodeApplyService
{
    @Autowired
    private BarCodeApplyMapper barCodeApplyMapper;

    @Autowired
    private ISubCodeService subCodeService;

    @Autowired
    private IBarCodeService barCodeService;

    @Autowired
    private IBoxCodeService boxCodeService;

    @Autowired
    private IProductOrganService productOrganService;

    /**
     * 查询字母码申请记录
     * 
     * @param id 字母码申请记录主键
     * @return 字母码申请记录
     */
    @Override
    public BarCodeApply selectBarCodeApplyById(Long id)
    {
        return barCodeApplyMapper.selectBarCodeApplyById(id);
    }

    /**
     * 查询字母码申请记录列表
     * 
     * @param barCodeApply 字母码申请记录
     * @return 字母码申请记录
     */
    @Override
    public List<BarCodeApply> selectBarCodeApplyList(BarCodeApply barCodeApply)
    {
        return barCodeApplyMapper.selectBarCodeApplyList(barCodeApply);
    }

    /**
     * 新增字母码申请记录
     * 
     * @param barCodeApply 字母码申请记录
     * @return 结果
     */
    @Override
    public int insertBarCodeApply(BarCodeApply barCodeApply)
    {
        barCodeApply.setCreateTime(DateUtils.getNowDate());
        return barCodeApplyMapper.insertBarCodeApply(barCodeApply);
    }

    /**
     * 修改字母码申请记录
     * 
     * @param barCodeApply 字母码申请记录
     * @return 结果
     */
    @Override
    public int updateBarCodeApply(BarCodeApply barCodeApply)
    {
        return barCodeApplyMapper.updateBarCodeApply(barCodeApply);
    }

    /**
     * 批量删除字母码申请记录
     * 
     * @param ids 需要删除的字母码申请记录主键
     * @return 结果
     */
    @Override
    public int deleteBarCodeApplyByIds(String ids)
    {
        return barCodeApplyMapper.deleteBarCodeApplyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除字母码申请记录信息
     * 
     * @param id 字母码申请记录主键
     * @return 结果
     */
    @Override
    public int deleteBarCodeApplyById(Long id)
    {
        return barCodeApplyMapper.deleteBarCodeApplyById(id);
    }

    @Override
    public void export() throws ServiceException {

        try {
//            String path="D:\\work\\leilifile\\码包2\\1_20220705162451_7763.txt";//第一批
            String path="D:\\work\\leilifile\\码包2\\3_20220705162816_575.txt";
            File file=new File(path);
            if (file!=null&&file.exists()){
                InputStreamReader inputReader = null;
                inputReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bf = new BufferedReader(inputReader);
                String str=null;
                String name = file.getName();
                String fileName="3_20220705162816_575";
                String[] fileNames = fileName.split("_");
                long applyId=Long.parseLong(fileNames[0]);
                while ((str=bf.readLine())!=null){
                    if ("".equals(str)){
                        continue;
                    }
                    String[] split = str.split(",");
                    String qrCode=split[0];
                    List<SubCode> subCodeList=new ArrayList<>();
                    BarCode barCode=new BarCode();
                    String prefixCode=CodeUtils.getPrefixCode(qrCode);
                    for (int i=1;i<split.length;i++){
                        SubCode subCode=new SubCode();
                        String s=split[i];
                        String sub=null;
                        String marCode=null;
                        if (s.indexOf("|")==-1){
                            int index = s.indexOf("code=");
                            if (index!=-1){
                                sub = s.substring(index + 5);
                            }
                        }else {//带营销码
                            String[] s1 = s.split("\\|");
                            int index = s1[0].indexOf("code=");
                            if (index!=-1){
                                sub = s1[0].substring(index + 5);
                            }
                            marCode=s1[1];
                        }
                        subCode.setSubCode(sub);
                        subCode.setMarkCode(marCode);
                        subCode.setApplyId(applyId);
                        subCode.setPrefixCode(prefixCode);
                        subCode.setSerialNum(Integer.valueOf(sub.substring(sub.length()-3)));
                        subCode.setCreateTime(new Date());
                        subCode.setSeed(CodeUtils.getSeed(sub));
                        subCode.setRemark("第一批缺失数据导入");
                        subCodeList.add(subCode);
                        //mapper
                        subCodeService.insertSubCode(subCode);
                    }
                    barCode = CodeUtils.getStartAndEndNumByCode(qrCode);
                    barCode.setApplyId(applyId);
                    barCode.setBarCode(qrCode);
                    barCode.setPrefixCode(prefixCode);
                    barCode.setRemark("第一批缺失数据导入");
                    //mapper
                    barCodeService.insertBarCode(barCode);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new ServiceException();
        }
    }

    @Override
    public void exportBoxCode() throws ServiceException {

        try {
            String path="D:\\work\\leilifile\\码包2\\2_20220705163130_31625.txt";
            File file=new File(path);
            if (file!=null&&file.exists()){
                InputStreamReader inputReader = null;
                inputReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bf = new BufferedReader(inputReader);
                String str=null;
                String name = file.getName();
                String fileName="2_20220705163130_31625";
                String[] fileNames = fileName.split("_");
                long applyId=Long.parseLong(fileNames[0]);
                while ((str=bf.readLine())!=null){
                    if ("".equals(str)){
                        continue;
                    }
                    int index = str.indexOf("code=");
                    String boxCode=null;
                    if (index!=-1){
                        boxCode=str.substring(index+5);
                    }
                    BoxCode boxCode1=new BoxCode();
                    boxCode1.setBoxCode(boxCode);
                    boxCode1.setApplyId(applyId);
                    boxCode1.setCreateTime(new Date());
                    boxCodeService.insertBoxCode(boxCode1);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new ServiceException();
        }






    }

    @Transactional
    @Override
    public void test(){
        try {
            ProductOrgan productOrgan=new ProductOrgan();
            productOrgan.setOrganCode("testOrganCode222");
            productOrgan.setPdCode("testPdCode222");
            productOrganService.insertProductOrgan(productOrgan);
            String tet=null;
            tet.equals("");
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
            //注解生效
        }

    }


}
