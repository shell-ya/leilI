package com.linkwin.task.impl;

import com.linkwin.apply.domain.BoxCode;
import com.linkwin.apply.domain.BoxCodeApply;
import com.linkwin.apply.domain.BoxCodeApplyStatusMenu;
import com.linkwin.apply.mapper.BoxCodeApplyMapper;
import com.linkwin.apply.mapper.BoxCodeMapper;
import com.linkwin.apply.service.IBoxCodePreService;
import com.linkwin.common.utils.file.FileUtil;
import com.linkwin.system.service.ISysConfigService;
import com.linkwin.task.IDealBoxCodeApplyTaskService;
import com.linkwin.utils.ConfConst;
import com.linkwin.utils.TableUtils;
import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.joda.time.DateTime;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
public class BoxCodeApplyTaskServiceImpl implements IDealBoxCodeApplyTaskService {

    @Autowired
    private BoxCodeApplyMapper boxCodeApplyMapper;

    @Autowired
    private BoxCodeMapper boxCodeMapper;

    @Autowired
    private IBoxCodePreService boxCodePreService;

    @Autowired
    private ISysConfigService sysConfigService;

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public void dealApply() {
        BoxCodeApply oneApply = getOneApply();
        if (oneApply==null){
            return;
        }
        try {
            generate(oneApply);
            dealStatus(oneApply.getId(),BoxCodeApplyStatusMenu.HANDLE_STATUS_COMPLETED.getValue());
        }catch (Exception e){
            e.printStackTrace();
            log.error("生成箱码异常");
            dealStatus(oneApply.getId(),BoxCodeApplyStatusMenu.HANDLE_STATUS_FAILED.getValue());
        }
    }

    @Transactional
    public BoxCodeApply getOneApply() throws RuntimeException{
        BoxCodeApply boxCodeApply=null;
        try {
            BoxCodeApply boxCodeApply1=new BoxCodeApply();
            boxCodeApply1.setStatus(BoxCodeApplyStatusMenu.HANDLE_STATUS_NONE.getValue());
            boxCodeApply = boxCodeApplyMapper.getOneByWhere(boxCodeApply1);//获取待处理的
            if (boxCodeApply==null){
                log.info("没有需要处理的箱码申请");
                return null;
            }
            int i = boxCodeApplyMapper.changeStatus(boxCodeApply.getId(), BoxCodeApplyStatusMenu.HANDLE_STATUS_RUNNING.getValue(),
                    boxCodeApply.getStatus());
            if (i!=1){
                log.info(String.format("申请记录Id[%d]状态修改失败%s->%s", boxCodeApply.getId(), boxCodeApply.getStatus(), BoxCodeApplyStatusMenu.HANDLE_STATUS_RUNNING.getValue()));
                return null;
            }
            boxCodeApply.setStatus(BoxCodeApplyStatusMenu.HANDLE_STATUS_RUNNING.getValue());
        }catch (Exception e){
            e.printStackTrace();
            log.error("BoxCodeApplyTaskServiceImpl getOneApply 获取申请记录异常", e);
            throw new RuntimeException(e.getMessage());
        }
        return boxCodeApply;
    }

    public void generate(BoxCodeApply boxCodeApply) throws Exception{
        Integer totalNum = boxCodeApply.getTotalNum();
        final int year = new DateTime(boxCodeApply.getCreateTime()).getYear();
        final String yearFix = String.valueOf(year).substring(2); //截掉年份前两位,取后两位作为年份标识
        String tableName = TableUtils.getBoxTableByYear(year);
        int exitsNum = boxCodeMapper.selectExitsNum(boxCodeApply.getId(), tableName);
        if (exitsNum<totalNum){
            totalNum-=exitsNum;
            int dealMaxNum=2000;
            while (totalNum>0){
                if (totalNum>dealMaxNum){
                    generateCode(boxCodeApply.getId(),year,tableName,dealMaxNum);
                    totalNum-=dealMaxNum;
                }else {
                    generateCode(boxCodeApply.getId(),year,tableName,totalNum);
                    break;
                }
            }
        }
        //生成文件
        generateFile(boxCodeApply,tableName);
    }


    @Transactional
    @Override
    public void generateCode(long applyId,int year,String tableName,int generateNum) throws RuntimeException{
        //预生成码标记applyId
        boxCodePreService.updateBoxCodePreApplyId(applyId,year,generateNum);
        boxCodePreService.insertBoxCode(applyId,year,tableName);//将标记数据迁移至主码表
        boxCodePreService.deleteByApplyId(applyId);//删除预生成标记数据
        boxCodeApplyMapper.updateExitsAndEndNum(applyId,generateNum);
    }


    public void generateFile(BoxCodeApply boxCodeApply,String tableName) throws Exception{
        String fileFormat = boxCodeApply.getFileFormat();
        String path = sysConfigService.selectConfigByKey(ConfConst.BOX_CODE_FILE_PATH);
        final String dateStr = new SimpleDateFormat("yyyyMMddHHmmss").format(boxCodeApply.getCreateTime());
        File folder = getCodeFolder(path, dateStr);
        String fileName = getFileName(boxCodeApply.getId(), boxCodeApply.getTotalNum(), dateStr);
        File file=null;
        if ("1".equals(fileFormat)){//txt
            String filePath=folder.getCanonicalPath() + File.separator + fileName + ".txt";
            file=new File(filePath);
            if (file.exists()){
                file.delete();
            }
        }else if ("2".equals(fileFormat)){//mdb

        }

        queryCodeToFile(file,fileName,fileFormat,tableName,boxCodeApply);
        generateZipFile(file,fileName,boxCodeApply,dateStr);
    }


    private void generateZipFile(File file, String fileName, BoxCodeApply boxCodeApply, String dateStr) throws ZipException, IOException {
//        int index=fileName.lastIndexOf("_");
//        if (index==-1){
//            throw new ZipException();
//        }
//        fileName = fileName.substring(0,index);
        int zipPwdLength = Integer.parseInt(sysConfigService.selectConfigByKey(ConfConst.BAR_CODE_ZIP_PWD_LENGTH));//码包压缩文件密码长度
        String zipPassword; //压缩文件密码
        if (zipPwdLength > 0) {
            if (zipPwdLength > 10) zipPwdLength = 10; //压缩文件密码最大10位(数据库字段长度限制)
            zipPassword = RandomStringUtils.randomAlphanumeric(zipPwdLength);
        } else {
            zipPassword = null;
        }
        log.info("开始压缩文件");
        long start = System.currentTimeMillis();
        FileUtil.encryptZipFile(file, fileName, zipPassword);
        log.info(String.format("压缩文件 结束。耗时: %d 秒", (System.currentTimeMillis() - start) / 1000));
        BoxCodeApply upApply = new BoxCodeApply();
        upApply.setId(boxCodeApply.getId());
        upApply.setFilePath("/" + dateStr + "/" + fileName + ".zip");
        upApply.setPassword(zipPassword);
        upApply.setFileName(fileName + ".zip");
        boxCodeApplyMapper.updateBoxCodeApply(upApply); //更新条码申请的码包路径与压缩文件密码
    }


    public void queryCodeToFile(File file,String fileName,String fileFormat,String tableName,BoxCodeApply boxCodeApply) throws Exception{
        int writeMaxNum = Integer.parseInt(sysConfigService.selectConfigByKey(ConfConst.BAR_CODE_WRITE_COUNT));//最大写文件条数
        String url=sysConfigService.selectConfigByKey(ConfConst.GONGZHONGHAO_URL);
        log.info("开始生成文件");
        long start = System.currentTimeMillis();
        List<BoxCode> dataList = new ArrayList<>();
        //通过游标查询的方式分批读取数据分批写文件
        Cursor<BoxCode> cursor = null;
        SqlSession sqlSession = null;
        try {
            /**
             * 这里不要写成 Cursor<QrInnerCodeResult> cursor = qrInnerCodeMapper.queryCodeForFile(applyId, table) 的形式
             * 否则需要通过开启事务在方法前加 @Transactional 注解的方式 在遍历游标时来保持连接。
             * 但当cursor游标达到最后一条时会自动关闭，并连锁关闭statement，
             * 这样会导致这个方法结束后关闭事务执行关闭sqlSession会报异常 No operations allowed after statement closed.
             */
            sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession();
            cursor = sqlSession.getMapper(BoxCodeMapper.class).queryCodeForFile(boxCodeApply.getId(), tableName);
            Iterator<BoxCode> iterator = cursor.iterator();
            while (iterator.hasNext()) {
                dataList.add(iterator.next());
                if (dataList.size() == writeMaxNum) {
                    writeFile(file, fileFormat, dataList,url);
                    dataList.clear();
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != sqlSession) {
                try {
                    sqlSession.close();
                } catch (Exception e) {
                    /**
                     * cursor游标达到最后一条时会自动关闭，并连锁关闭statement，
                     * 导致sqlSession.close()关闭时会报异常 No operations allowed after statement closed.
                     * 所以这里不做处理
                     */
                }
            }
            if (null != cursor) {
                cursor.close(); //如果cursor已经是关闭状态，这里不会报异常
            }
        }
        if (dataList.size() > 0) {
            try {
                writeFile(file, fileFormat, dataList,url); //写入余下的未凑满writeMaxNum的数据
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        log.info(String.format("生成文件 结束。耗时: %d 秒", (System.currentTimeMillis() - start) / 1000));
    }


    public void writeFile(File file,String fileFormat,List<BoxCode> list,String url) throws Exception{
        if ("1".equals(fileFormat)){//写入txt
            writeTxtFile(file,list,url);
        }
    }

    public void writeTxtFile(File file,List<BoxCode> dataList,String url) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(file, true);
             OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
             BufferedWriter out = new BufferedWriter(osw)) {
            StringBuffer subString = new StringBuffer();
            dataList.forEach(code -> {
                subString.append(url);
                subString.append("code=");
                subString.append(code.getBoxCode());
                subString.append("\r\n");
            });
            out.write(subString.toString());
            out.flush();
        }
    }


    //创建目录
    private File getCodeFolder(String folderStr, String dateStr) {
        File folder = new File(folderStr);
        if (!folder.exists()){
            folder.mkdirs();
        }
        folder = new File(folderStr + File.separator + dateStr);
        if (!folder.exists()){
            folder.mkdirs();
        }
        return folder;
    }

    private String getFileName(long applyId,int applyNum,String dateStr){
        return applyId+"_"+dateStr+"_"+applyNum;
    }

    private void dealStatus(long id,Integer status){
        if (status.equals(BoxCodeApplyStatusMenu.HANDLE_STATUS_COMPLETED.getValue())){
            log.info("处理成功");
            boxCodeApplyMapper.changeStatus(id,
                    BoxCodeApplyStatusMenu.HANDLE_STATUS_COMPLETED.getValue(),
                    BoxCodeApplyStatusMenu.HANDLE_STATUS_RUNNING.getValue());
        }else {
            log.error("处理失败");
            boxCodeApplyMapper.changeStatus(id,
                    BoxCodeApplyStatusMenu.HANDLE_STATUS_FAILED.getValue(),
                    BoxCodeApplyStatusMenu.HANDLE_STATUS_RUNNING.getValue());
        }
    }

}
