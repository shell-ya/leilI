package com.linkwin.web.controller.basedata;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.linkwin.common.config.RuoYiConfig;
import com.linkwin.common.exception.ServiceException;
import com.linkwin.common.utils.MessageUtils;
import com.linkwin.common.utils.StringUtils;
import com.linkwin.common.utils.file.FileUploadUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.linkwin.common.annotation.Log;
import com.linkwin.common.enums.BusinessType;
import com.linkwin.basedata.domain.Product;
import com.linkwin.basedata.service.IProductService;
import com.linkwin.common.core.controller.BaseController;
import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.common.utils.poi.ExcelUtil;
import com.linkwin.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 产品信息Controller
 * 
 * @author dingyuming
 * @date 2022-05-10
 */
@Controller
@RequestMapping("/basedata/product")
public class ProductController extends BaseController
{
    private String prefix = "basedata/product";
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IProductService productService;

    @RequiresPermissions("basedata:product:view")
    @GetMapping()
    public String product()
    {
        return prefix + "/product";
    }

    /**
     * 查询产品信息列表
     */
     @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Product product)
    {
        startPage();
        List<Product> list = productService.selectProductList(product);
        return getDataTable(list);
    }

    /**
     * 导出产品信息列表
     */
    @RequiresPermissions("basedata:product:export")
    @Log(title = "产品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Product product)
    {
        List<Product> list = productService.selectProductList(product);
        ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
        return util.exportExcel(list, "产品信息数据");
    }

    /**
     * 新增产品信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产品信息
     */
    @RequiresPermissions("basedata:product:add")
    @Log(title = "产品信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Product product)throws Exception
    {

        return toAjax(productService.insertProduct(product));
    }

    /**
     * 修改产品信息
     */
    @RequiresPermissions("basedata:product:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Product product = productService.selectProductById(id);
        mmap.put("product", product);
        mmap.put("img",product.getLogo());
        return prefix + "/edit";
    }

    /**
     * 修改保存产品信息
     */
    @RequiresPermissions("basedata:product:edit")
    @Log(title = "产品信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Product product)
    {
        return toAjax(productService.updateProduct(product));
    }

    /**
     * 删除产品信息
     */
    @RequiresPermissions("basedata:product:remove")
    @Log(title = "产品信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(productService.deleteProductByIds(ids));
    }

    /**
     * 修改头像
     */

    @GetMapping("/avatar/{id}")
    public String avatar(@PathVariable("id") Long id, ModelMap mmap)
    {
        Product product = productService.selectProductById(id);
        mmap.put("product", product);
        mmap.put("ids" ,product.getId());
        return prefix + "/avatar";

    }

    @GetMapping("/avatarExplain/{id}")
    public String avatarExplain(@PathVariable("id") Long id, ModelMap mmap)
    {
        Product product = productService.selectProductById(id);
        mmap.put("product", product);
        mmap.put("ids" ,product.getId());
        return prefix + "/avatarExplain";

    }

    @GetMapping("/avatarreport/{id}")
    public String avatarreport(@PathVariable("id") Long id, ModelMap mmap)
    {
        Product product = productService.selectProductById(id);
        mmap.put("product", product);
        mmap.put("ids" ,product.getId());
        return prefix + "/avatarReport";

    }

    /**
     * 修改产品信息
     */
    @RequiresPermissions("basedata:product:edit")
    @GetMapping("/editimg/{id}")
    public String editimg(@PathVariable("id") Long id, ModelMap mmap)
    {
        Product product = productService.selectProductById(id);
        mmap.put("product", product);
        mmap.put("img",product.getLogo());
        return prefix + "/imgedit";
    }


    /**
     * 保存头像
     */
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PostMapping("/updateAvatarReport/{id}")
    @ResponseBody
    public AjaxResult updateAvatarReport(@RequestParam("avatarfile") MultipartFile file ,@PathVariable("id") Long id)
    {
        Product product = productService.selectProductById(id);
        try
        {
            if (!file.isEmpty())
            {
                String avatar = FileUploadUtils.upload(RuoYiConfig.getAvatarPath(), file);
                product.setReport(avatar);
                if (productService.updateProduct(product) > 0)
                {

                    return success();
                }
            }
            return error();
        }
        catch (Exception e)
        {
            log.error("修改图片失败！", e);
            return error(e.getMessage());
        }
    }

    /**
     * 保存头像
     */
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PostMapping("/updateAvatarExplain/{id}")
    @ResponseBody
    public AjaxResult updateAvatarExplain(@RequestParam("avatarfile") MultipartFile file ,@PathVariable("id") Long id)
    {
        Product product = productService.selectProductById(id);
        try
        {
            if (!file.isEmpty())
            {
                String avatar = FileUploadUtils.upload(RuoYiConfig.getAvatarPath(), file);
                product.setExplainimg(avatar);
                if (productService.updateProduct(product) > 0)
                {

                return success();
                }
            }
            return error();
        }
        catch (Exception e)
        {
            log.error("修改图片失败！", e);
            return error(e.getMessage());
        }
    }


    /**
     * 保存产品解释
     */
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PostMapping("/updateAvatar/{id}")
    @ResponseBody
    public AjaxResult updateAvatar(@RequestParam("avatarfile") MultipartFile file ,@PathVariable("id") Long id)
    {
        Product product = productService.selectProductById(id);
        try
        {
            if (!file.isEmpty())
            {
                String avatar = FileUploadUtils.upload(RuoYiConfig.getAvatarPath(), file);
                product.setLogo(avatar);
                if (productService.updateProduct(product) > 0)
                {

                    return success();
                }
            }
            return error();
        }
        catch (Exception e)
        {
            log.error("修改logo失败！", e);
            return error(e.getMessage());
        }
    }
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
        return util.importTemplateExcel("产品数据模板");
    }
    /**
     * 导入数据
     */
    @RequiresPermissions("basedata:product:add")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        try {
            ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
            List<Product> userList = util.importExcel(file.getInputStream());
            String message = importProduct(userList, updateSupport);
            return AjaxResult.success(message);
        }catch (Exception e){
            e.printStackTrace();
//            return AjaxResult.error("导入失败:"+e.getMessage());
            return AjaxResult.error(MessageUtils.message("error.msg.importfailed") +e.getMessage());
        }
    }

    /**
     * 导入用户数据
     *
     * @param ProductList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    public String importProduct(List<Product> ProductList, Boolean isUpdateSupport) {

        Map<String, Product> ProductMap1 = new LinkedHashMap<String, Product>();
        if (StringUtils.isNull(ProductList) || ProductList.size() == 0) {
//            throw new ServiceException("导入产品数据不能为空！");
            throw new ServiceException(MessageUtils.message("error.msg.importnotempty"));
        }
        int successNum = 0;
        int failureNum = 0;
        int i=0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Product productBean : ProductList) {
            i++;
            String strDateFormat = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
            try {
                // 验证是否存在这个用户
                Product newp = new Product();
                if (productBean.getName() != null && !"".equals(productBean.getName())) {
                    newp.setName(productBean.getName());
                }else{
//                    throw new Exception(productBean.getName() + "名称不能为空");
                    throw new Exception(productBean.getName() + MessageUtils.message("error.msg.namenotempty"));
                }
                List productList = productService.selectProductListonlyName(newp);
                boolean userFlag = false;
                if (productList.size() > 0) {
                    userFlag = true;
                }
                if (!userFlag) {



//                    if (productBean.getValidPeriod() == null || "".equals(productBean.getValidPeriod())) {
//                        throw new Exception(productBean.getName() + "有效期(月)不能为空");
//                    }else if(productBean.getRbuType() == null || "".equals(productBean.getRbuType())) {
//                        throw new Exception(productBean.getName() + "产品类别不能为空");
//                    }else if(productBean.getSpec() == null || "".equals(productBean.getSpec())) {
//                        throw new Exception(productBean.getName() + "规格不能为空");
//                    }else if(productBean.getUnit() == null || "".equals(productBean.getUnit())) {
//                        throw new Exception(productBean.getName() + "最小单位不能为空");
//                    }else if(productBean.getNetWeight() == null || "".equals(productBean.getNetWeight())) {
//                        throw new Exception(productBean.getName() + "最小单位转化系数不能为空");
//                    }else if(productBean.getCartonConvRate() == null || "".equals(productBean.getCartonConvRate())) {
//                        throw new Exception(productBean.getName() + "箱/小包装转化率不能为空");
//                    }else if(productBean.getPestName() == null || "".equals(productBean.getPestName())) {
//                        throw new Exception(productBean.getName() + "农药名称不能为空");
//                    }else if(productBean.getPestRegCertNumber() == null || "".equals(productBean.getPestRegCertNumber())) {
//                        throw new Exception(productBean.getName() + "农药登记证号不能为空");
//                    }else if(productBean.getPestRegCertSuffix() == null || "".equals(productBean.getPestRegCertSuffix())) {
//                        throw new Exception(productBean.getName() + "农药登记证号后6位不能为空");
//                    }else if(productBean.getPestRegCertHolderName() == null || "".equals(productBean.getPestRegCertHolderName())) {
//                        throw new Exception(productBean.getName() + " 农药登记证持有人名称不能为空");
//                    }else if(productBean.getPestRegistExpireDate() == null || "".equals(productBean.getPestRegistExpireDate())) {
//                        throw new Exception(productBean.getName() + " 农药登记证到期日不能为空");
//                    }else if(productBean.getProduceType() == null || "".equals(productBean.getProduceType())) {
//                        throw new Exception(productBean.getName() + " 生产类型不能为空");
//                    }else if(productBean.getProduceFactory() == null || "".equals(productBean.getProduceFactory())) {
//                        throw new Exception(productBean.getName() + " 生产厂家不能为空");
//                    }else if(productBean.getProduceLicense() == null || "".equals(productBean.getProduceLicense())) {
//                        throw new Exception(productBean.getName() + " 生产许可证不能为空");
//                    }else if(productBean.getProduceLicenseExpiredate() == null || "".equals(productBean.getProduceLicenseExpiredate())) {
//                        throw new Exception(productBean.getName() + " 生产许可证到期日(年-月-日)不能为空");
//                    }else if(productBean.getPackmark() == null || "".equals(productBean.getPackmark())) {
//                        throw new Exception(productBean.getName() + " 是否强制为见包装不能为空");
//                    }
//                    if (productBean.getValidPeriod().toString().length()>10) {
//                        throw new Exception(productBean.getName() + "有效期(月)超长");
//                    }else if(productBean.getRbuType().length()>10) {
//                        throw new Exception(productBean.getName() + "产品类别超长");
//                    }else if(productBean.getSpec().length()>10) {
//                        throw new Exception(productBean.getName() + "规格超长");
//                    }else if(productBean.getUnit().length()>2) {
//                        throw new Exception(productBean.getName() + "最小单位超长");
//                    }else if(productBean.getNetWeight().toString().length()>10) {
//                        throw new Exception(productBean.getName() + "最小单位转化系数超长");
//                    }else if(productBean.getCartonConvRate().toString().length()>10) {
//                        throw new Exception(productBean.getName() + "箱/小包装转化率超长");
//                    }else if(productBean.getPestName().length()>50) {
//                        throw new Exception(productBean.getName() + "农药名称超长");
//                    }else if(productBean.getPestRegCertNumber().length()>20) {
//                        throw new Exception(productBean.getName() + "农药登记证号超长");
//                    }else if(productBean.getPestRegCertSuffix().length()!=6) {
//                        throw new Exception(productBean.getName() + "农药登记证号后6位必须为6位");
//                    }else if(productBean.getPestRegCertHolderName().length()>30) {
//                        throw new Exception(productBean.getName() + " 农药登记证持有人名称不能超长");
//                    }else if(productBean.getPestRegistExpireDate().length()>50) {
//                        throw new Exception(productBean.getName() + " 农药登记证到期日不能超长");
//                    }else if(productBean.getProduceType().length()>30) {
//                        throw new Exception(productBean.getName() + " 生产类型不能超长");
//                    }else if(productBean.getProduceFactory().length()>20) {
//                        throw new Exception(productBean.getName() + " 生产厂家不能超长");
//                    }else if(productBean.getProduceLicense().length()>20) {
//                        throw new Exception(productBean.getName() + " 生产许可证不能超长");
//                    }else if(productBean.getProduceLicenseExpiredate().length()>50) {
//                        throw new Exception(productBean.getName() + " 生产许可证到期日(年-月-日)超长");
//                    }else if(productBean.getPackmark().toString().length()>10) {
//                        throw new Exception(productBean.getName() + " 是否强制为见包装不能超长");
//                    }
//                    if(productBean.getPackageMinUnit()!=null&&!"".equals(productBean.getPackageMinUnit())&&productBean.getPackageMinUnit().length()>2){
//                        throw new Exception(productBean.getName() + " 最小包装单位不能超长");
//                    }else     if(productBean.getContentVolume()!=null&&!"".equals(productBean.getContentVolume())&&productBean.getContentVolume().length()>20) {
//                        throw new Exception(productBean.getName() + " 含量不能超长");
//                    }else     if(productBean.getActiveIngredients()!=null&&!"".equals(productBean.getActiveIngredients())&&productBean.getActiveIngredients().length()>20) {
//                        throw new Exception(productBean.getName() + " 有效成分不能超长");
//                    }else     if(productBean.getDosageForm()!=null&&!"".equals(productBean.getDosageForm())&&productBean.getDosageForm().length()>20) {
//                        throw new Exception(productBean.getName() + " 剂型不能超长");
//                    }else     if(productBean.getProductExplain()!=null&&!"".equals(productBean.getProductExplain())&&productBean.getProductExplain().length()>100) {
//                        throw new Exception(productBean.getName() + " 产品说明不能超长");
//                    }else     if(productBean.getProductCloudid()!=null&&!"".equals(productBean.getProductCloudid())&&productBean.getProductCloudid().length()>40) {
//                        throw new Exception(productBean.getName() + " 防伪编码不能超长");
//                    }
                    productService.insertProduct(productBean);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、产品 " + productBean.getName() + " 导入成功");
                } else if (isUpdateSupport) {
                    productService.updateProduct(productBean);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、产品 " + productBean.getName() + " 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、产品 " + productBean.getName() + " 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                log.error("num="+i+"---------------failNum="+failureNum);
                String msg = "<br/>" + failureNum + "、产品 " + productBean.getName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉 ，共 " + successNum + " 条导入成功，共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

}
