package com.linkwin.common.utils.file;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FileUtil
 * @Description
 * @Author xiang.gao
 * @Date 2019/11/12 19:56
 * @Version 1.0
 **/
@Slf4j
public class FileUtil {

    public static String getImgBase64(String path) {
        String imgStr = "";
        if(StringUtil.isEmpty(path)){
            return "";
        }
        File file = new File(path);
        if(!file.exists()){
            return "";
        }
        try( FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[(int) file.length()];
            int offset = 0;
            int numRead = 0;
            while (offset < buffer.length && (numRead = fis.read(buffer, offset, buffer.length - offset)) >= 0) {
                offset += numRead;
            }

            if (offset != buffer.length) {
                throw new IOException("Could not completely read file "
                        + file.getName());
            }
//            BASE64Encoder encoder = new BASE64Encoder();
//            imgStr = encoder.encode(buffer);
        } catch (Exception e) {
//            log.error("图片转换错误",e);
        }
        return "data:image/jpeg;base64," + imgStr;
    }
    /**
     * 加密文件，产生一个zip文件
     * @param filesToAdd，传入的文件集合，zip文件中，只包含该文件
     * @param fileName，zip文件名
     * @param password，加密的密码
     * @throws ZipException
     * @throws IOException
     */
    public static ZipFile  encryptZipFile(ArrayList<File> filesToAdd, String fileName, String password) throws ZipException, IOException{
        ZipFile zipFile = new ZipFile(filesToAdd.get(0).getParentFile().getCanonicalPath() + File.separator + fileName);
        //如果不指定为GBK，很多压缩软件打开文件后，里面的文件名如果是中文的话，会产生乱码，导致无法打开
        zipFile.setFileNameCharset("GBK");
        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

        // Set password
        if(! StringUtil.isEmpty(password)){
            parameters.setEncryptFiles(true);
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
            parameters.setPassword(password);
        }

        zipFile.addFiles(filesToAdd, parameters);
        return zipFile;
    }

    /**
     * 加密文件，产生一个zip文件
     * @param file，传入的文件，zip文件中，只包含该文件
     * @param fileName，zip文件名
     * @param password，加密的密码
     * @throws ZipException
     * @throws IOException
     */
    public static void  encryptZipFile(File file, String fileName, String password) throws ZipException, IOException{
        ZipFile zipFile = new ZipFile(file.getParentFile().getCanonicalPath() + File.separator + fileName + ".zip");
        ArrayList<File> filesToAdd = new ArrayList<File>();
        filesToAdd.add(file);
        //如果不指定为GBK，很多压缩软件打开文件后，里面的文件名如果是中文的话，会产生乱码，导致无法打开
        zipFile.setFileNameCharset("GBK");
        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

        // Set password
        if(!StringUtil.isEmpty(password)){
            parameters.setEncryptFiles(true);
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
            parameters.setPassword(password);
        }
        zipFile.addFiles(filesToAdd, parameters);
    }

    /**
     * 获取一个文件的md5值(可处理大文件)
     * @return md5 value
     */
    public static String getMD5(File file) {
        FileInputStream fileInputStream = null;
        try {
            MessageDigest MD5 = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            int length;
            while ((length = fileInputStream.read(buffer)) != -1) {
                MD5.update(buffer, 0, length);
            }
            return new String(Hex.encodeHex(MD5.digest())).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (fileInputStream != null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 输入流取MD5
    public static String calcMD5(InputStream stream) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] buf = new byte[8192];
            int len;
            while ((len = stream.read(buf)) > 0) {
                digest.update(buf, 0, len);
            }
            String s=new String(Hex.encodeHex(digest.digest()));
            return s.toUpperCase();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 将集合以json格式写入文件
     * @param list
     * @param filePath
     * @param <T>
     */
    public  static <T> void writeListToFile(List<T> list, String filePath,String fileName) {
        String jsonstr=JSON.toJSONString(list);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(jsonstr);
            bw.newLine();
        } catch (IOException e) {
//            log.error("写入文件异常",e);
        }
    }
    public  static <T> List<T> getJosnFromFile(InputStream inputStream,Class<T> clazz) throws IOException {
        InputStreamReader reader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(reader);
        StringBuilder sb=new StringBuilder();
        String str="";
        while ((str=bufferedReader.readLine())!=null){
            sb.append(str);
        }
        String s=sb.toString();
        List<T> list=JSON.parseArray(sb.toString(),clazz);
        return list;
    }
    public  static <T> List<T> getJosnFromFileLins(InputStream inputStream,Class<T> clazz) throws IOException {
        InputStreamReader reader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(reader);
        String str="";
        List<T> list=new ArrayList<>();
        while ((str=bufferedReader.readLine())!=null){
            T t=JSON.parseObject(str,clazz);
            list.add(t);
        }
        return list;
    }

    public  static <T> T getJosnObjFromFile(InputStream inputStream,Class<T> clazz) throws IOException {
        InputStreamReader reader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(reader);
        StringBuilder sb=new StringBuilder();
        String str="";
        while ((str=bufferedReader.readLine())!=null){
            sb.append(str);
        }
        T obj = JSON.parseObject(sb.toString(),clazz);
        return obj;
    }

    public static void downloadFile(HttpServletResponse response, String fileName, String filePath) {
        if (fileName != null) {
            //设置文件路径
            File file = new File(filePath);
            if (file.exists()) {
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                try {
                    response.setHeader("Content-Disposition", "attachment;filename=\""+new String(fileName.getBytes("utf-8"),"ISO-8859-1") + "\"");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void copyFile(String src, String dest) throws IOException {
        src = URLDecoder.decode(src,"UTF-8");
//        dest = URLDecoder.decode(dest,"UTF-8");
        File file1 = new File(src);
        File file2 = new File(dest);
        copyFile(file1, file2);
    }



    public static void copyFile(File src, File dest) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        FileLock flock = null;
        try {
            in = new FileInputStream(src);
            if (!dest.exists()) {
                dest.createNewFile();
            }
            out = new FileOutputStream(dest);
            FileChannel fc = out.getChannel();
            flock = fc.tryLock();
            if (flock == null) {
                throw new IOException("目标文件正被独占，不能复制");
            }

            copy(in, out);
            out.flush();
        } catch (IOException var21) {
            log.error("复制文件失败,from:" + src.getPath() + ",to:" + dest.getPath(), var21);
            throw var21;
        } finally {
            if (flock != null) {
                try {
                    flock.release();
                } catch (Exception var19) {
                }
            }

            if (in != null) {
                try {
                    in.close();
                } catch (Exception var18) {
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (Exception var17) {
                }
            }
        }
        try {
            dest.setLastModified(src.lastModified());
        } catch (Exception var20) {
            var20.printStackTrace();
        }
    }

    public static void copyFile(MultipartFile src, File dest) throws IOException {
        InputStream in = null;
        FileOutputStream out = null;
        FileLock flock = null;
        try {
            in = src.getInputStream();
            if (!dest.exists()) {
                dest.createNewFile();
            }
            out = new FileOutputStream(dest);
            FileChannel fc = out.getChannel();
            flock = fc.tryLock();
            if (flock == null) {
                throw new IOException("目标文件正被独占，不能复制");
            }
            copy(in, out);
            out.flush();
        } catch (IOException var21) {
            log.error("复制文件失败,from:" + src.getOriginalFilename() + ",to:" + dest.getName(), var21);
            throw var21;
        } finally {
            if (flock != null) {
                try {
                    flock.release();
                } catch (Exception var19) {
                }
            }

            if (in != null) {
                try {
                    in.close();
                } catch (Exception var18) {
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (Exception var17) {
                }
            }
        }
    }

    public static void copy(InputStream in, OutputStream... out) throws IOException {
        byte[] buffer = new byte[4096];
        int c;
        while((c = in.read(buffer)) != -1) {
            for(int i = 0; i < out.length; ++i) {
                out[i].write(buffer, 0, c);
            }
        }
    }

    /**
     * 过滤文件名中的特殊字符
     * @param filename
     * @return
     */
    public static String filteFilename(String filename) {
        filename = filename.replace("*", "X");
        filename = filename.replace("?", "？");
        filename = filename.replace("<", "");
        filename = filename.replace(">", "");
        filename = filename.replace("/", "");
        filename = filename.replace("|", "");
        filename = filename.replace("\\", "");
        filename = filename.replace(":", "");
        filename = filename.replace(" ", "");
        return filename;
    }

    /**
     * 根据一个文件名，读取完文件，干掉bom头。
     *
     * @param fileName
     * @throws IOException
     */
    public static void trimBom(String fileName) throws IOException {
        File file = new File(fileName);
        if (file.exists()) {
            FileInputStream fin = new FileInputStream(fileName);
            // 开始写临时文件
            InputStream in = getInputStream(fin);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte b[] = new byte[4096];
            int len = 0;
            while (in.available() > 0) {
                len = in.read(b, 0, 4096);
                bos.write(b, 0, len);
            }
            in.close();
            fin.close();
            bos.close();
            // 临时文件写完，开始将临时文件写回本文件。
            FileOutputStream out = new FileOutputStream(fileName);
            out.write(bos.toByteArray());
            out.close();
        }
    }

    /**
     * 读取流中前面的字符，看是否有bom，如果有bom，将bom头先读掉丢弃
     *
     * @param in
     * @return
     * @throws IOException
     */
    public static InputStream getInputStream(InputStream in) throws IOException {
        PushbackInputStream testin = new PushbackInputStream(in);
        int ch = testin.read();
        if (ch != 0xEF) {
            testin.unread(ch);
        } else if ((ch = testin.read()) != 0xBB) {
            testin.unread(ch);
            testin.unread(0xef);
        } else if ((ch = testin.read()) != 0xBF) {
            throw new IOException("错误的UTF-8格式文件");
        } else {
            // 不需要做，这里是bom头被读完了
            // System.out.println("still exist bom");
        }
        return testin;
    }

    /**
     * 根据传入的文件路径及文件名、字符串生成文件
     * @param filePath
     * @param fileContent
     */
    public static void createFile(String filePath,String fileName,String fileContent){
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter out = null;
        File folder = new File(filePath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        try {
            File file = new File(folder.getCanonicalPath() + File.separator +fileName);
            fos = new FileOutputStream(file,true);
            osw = new OutputStreamWriter(fos,"utf-8");
            out = new BufferedWriter(osw);
            StringBuffer subString = new StringBuffer();
            subString.append(fileContent).append("\r\n");
            out.write(subString.toString());
            out.flush();
            subString.setLength(0);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<String> readLine(InputStream in) throws IOException{
        InputStreamReader reader=new InputStreamReader(in);
        BufferedReader bufferedReader=new BufferedReader(reader);
        String str="";
        List<String> list=new ArrayList<>();
        while ((str=bufferedReader.readLine())!=null){
            list.add(str);
        }
        return list;
    }


    /**
     * 将excel中的数据封装到二维数组中
     * @param file
     * @param colrowno 读取总列数 1开始
     * @return List<String[]>    String[]为一行各字段的数据数组 最末端为行号
     * @throws Exception
     */
    public static List<String[]> getExcelInputDate(File file, final int colrowno) throws Exception {
        String fileName = file.getName();
        String extension = FilenameUtils.getExtension(fileName);
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            Workbook book;
            if (extension.equalsIgnoreCase("xlsx")) {
                book = new XSSFWorkbook(fis);
            } else if (extension.equalsIgnoreCase("xls")) {
                book = new HSSFWorkbook(fis);
            } else {
                throw new Exception("不支持的文件格式");
            }
            List<String[]> excelrowdate = new ArrayList<>(); //key表示第几行
            Sheet sheet = book.getSheetAt(0);
            int maxrow = sheet.getLastRowNum();
            for (int i=1 ;i<=maxrow;i++){ //第一行不读，从第二行开始
                Row row = sheet.getRow(i);
                if (row == null) continue;
                //存数列数据
                String[] coldate = new String[colrowno + 1];
                for (int j=0 ;j<colrowno;j++){
                    Cell cell = row.getCell(j);
                    if (cell == null) continue;
                    CellType type = cell.getCellTypeEnum();
                    if (type == CellType.NUMERIC) {
                        double val = cell.getNumericCellValue();
                        if (isLong(val)) { //判断是否为整数
                            coldate[j] = String.valueOf((long) val);
                        } else {
                            coldate[j] = String.valueOf(val);
                        }
                    } else if (type == CellType.FORMULA) {
                        coldate[j] = cell.getStringCellValue();
                    } else {
                        coldate[j] = cell.getStringCellValue();
                    }
                }
                //判断是否需要加入到map中
                if(StringUtils.isBlank(coldate[0]) && StringUtils.isBlank(coldate[1])
                        && StringUtils.isBlank(coldate[2])){ //前三列都为空 跳过该条数据
                    continue;
                }
                //最末端添加一个行号
                coldate[colrowno] = String.valueOf(i+1);
                //加入到map中
                excelrowdate.add(coldate);
            }
            //返回
            return excelrowdate;
        } catch(Exception e) {
            log.error("excel文件数据解析错误");
            throw e;
        }
    }

    //判断小数 a 是否为整数
    public static boolean isLong(double a) {
        if(Math.floor(a) == a) {
            return true;
        } else {
            return false;
        }
    }

    public static void writeTxt (String msg, String filePath) throws Exception {
        if (StringUtils.isBlank(msg)) return;
        try (FileOutputStream fos = new FileOutputStream(filePath, true);
             OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
             BufferedWriter out = new BufferedWriter(osw)) {
            if (msg.length() > 0) {
                out.write(msg);
                out.flush();
            }
        }
    }
}
