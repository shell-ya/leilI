package com.linkwin.web.controller.system;

import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.linkwin.basedata.domain.Product;
import com.linkwin.basedata.domain.ProductOrgan;
import com.linkwin.basedata.domain.Province;
import com.linkwin.basedata.domain.Warehouse;
import com.linkwin.basedata.mapper.DeptMapper;
import com.linkwin.basedata.mapper.ProvinceMapper;
import com.linkwin.basedata.service.IProductOrganService;
import com.linkwin.basedata.service.IProductService;
import com.linkwin.common.core.page.TableDataInfo;
import com.linkwin.common.core.text.Convert;
import com.linkwin.common.exception.ServiceException;
import com.linkwin.common.utils.poi.ExcelUtil;
import com.linkwin.framework.web.domain.server.Sys;
import com.linkwin.order.domain.BillOrder;
import com.linkwin.system.mapper.SysDeptMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.linkwin.common.annotation.Log;
import com.linkwin.common.constant.UserConstants;
import com.linkwin.common.core.controller.BaseController;
import com.linkwin.common.core.domain.AjaxResult;
import com.linkwin.common.core.domain.Ztree;
import com.linkwin.common.core.domain.entity.SysDept;
import com.linkwin.common.core.domain.entity.SysRole;
import com.linkwin.common.enums.BusinessType;
import com.linkwin.common.utils.StringUtils;
import com.linkwin.system.service.ISysDeptService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 部门信息
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/dept")
public class SysDeptController extends BaseController
{
    private String prefix = "system/dept";

    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private IProductService productDataService;

    @Autowired
    private IProductOrganService productOrganService;

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Autowired
    private ProvinceMapper provinceMapper;

     @GetMapping()
    public String dept()
    {
        return prefix + "/dept";
    }

     @PostMapping("/list")
    @ResponseBody
    public List<SysDept> list(SysDept dept)
    {
        List<SysDept> deptList = deptService.selectDeptProvinceList(dept);
        return deptList;
    }

    /**
     * 新增部门
     */
    @RequiresPermissions("system:dept:add")
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") Long parentId, ModelMap mmap)
    {
        Province province =new Province();
        province.setPcode("0");
        List<Province> provinces = provinceMapper.selectProvinceList(province);
        mmap.put("provinces",   provinces);
        if (!getSysUser().isAdmin())
        {
            parentId = getSysUser().getDeptId();
        }
        mmap.put("dept", deptService.selectDeptById(parentId));
        return prefix + "/add";
    }

    /**
     * 新增保存部门
     */
    @Log(title = "部门管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("system:dept:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated SysDept dept)
    {
        if (UserConstants.DEPT_NAME_NOT_UNIQUE.equals(deptService.checkDeptNameUnique(dept)))
        {
            return error("新增部门'" + dept.getDeptName() + "'失败，经销商名称已存在");
        }
        dept.setCreateBy(getLoginName());
        return toAjax(deptService.insertDept(dept));
    }

    /**
     * 修改部门
     */
    @RequiresPermissions("system:dept:edit")
    @GetMapping("/edit/{deptId}")
    public String edit(@PathVariable("deptId") Long deptId, ModelMap mmap)
    {
        deptService.checkDeptDataScope(deptId);
        SysDept dept = deptService.selectDeptById(deptId);
        Province province =new Province();
        province.setPcode("0");
        List<Province> provinces = provinceMapper.selectProvinceList(province);
        mmap.put("provinces",   provinces);
        if (StringUtils.isNotNull(dept) && 100L == deptId)
        {
            dept.setParentName("无");
        }
        mmap.put("dept", dept);
        return prefix + "/edit";
    }

    /**
     * 修改保存部门
     */
    @Log(title = "部门管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:dept:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SysDept dept)
    {
        Long deptId = dept.getDeptId();
        deptService.checkDeptDataScope(deptId);
        if (UserConstants.DEPT_NAME_NOT_UNIQUE.equals(deptService.checkDeptNameUnique(dept)))
        {
            return error("修改部门'" + dept.getDeptName() + "'失败，经销商名称已存在");
        }
        else if (dept.getParentId().equals(deptId))
        {
            return error("修改部门'" + dept.getDeptName() + "'失败，上级部门不能是自己");
        }
        else if (StringUtils.equals(UserConstants.DEPT_DISABLE, dept.getStatus()) && deptService.selectNormalChildrenDeptById(deptId) > 0)
        {
            return AjaxResult.error("该部门包含未停用的子部门！");
        }
        dept.setUpdateBy(getLoginName());
        return toAjax(deptService.updateDept(dept));
    }

    /**
     * 删除
     */
    @Log(title = "部门管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("system:dept:remove")
    @GetMapping("/remove/{deptId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("deptId") Long deptId)
    {
        if (deptService.selectDeptCount(deptId) > 0)
        {
            return AjaxResult.warn("存在下级部门,不允许删除");
        }
        if (deptService.checkDeptExistUser(deptId))
        {
            return AjaxResult.warn("部门存在用户,不允许删除");
        }
        deptService.checkDeptDataScope(deptId);
        return toAjax(deptService.deleteDeptById(deptId));
    }

    /**
     * 校验经销商名称
     */
    @PostMapping("/checkDeptNameUnique")
    @ResponseBody
    public String checkDeptNameUnique(SysDept dept)
    {
        return deptService.checkDeptNameUnique(dept);
    }

    /**
     * 选择部门树
     * 
     * @param deptId 部门ID
     * @param excludeId 排除ID
     */
    @GetMapping(value = { "/selectDeptTree/{deptId}", "/selectDeptTree/{deptId}/{excludeId}" })
    public String selectDeptTree(@PathVariable("deptId") Long deptId,
            @PathVariable(value = "excludeId", required = false) String excludeId, ModelMap mmap)
    {
        mmap.put("dept", deptService.selectDeptById(deptId));
        mmap.put("excludeId", excludeId);
        return prefix + "/tree";
    }

    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = deptService.selectDeptTree(new SysDept());
        return ztrees;
    }

    /**
     * 加载部门列表树（排除下级）
     */
    @GetMapping("/treeData/{excludeId}")
    @ResponseBody
    public List<Ztree> treeDataExcludeChild(@PathVariable(value = "excludeId", required = false) Long excludeId)
    {
        SysDept dept = new SysDept();
        dept.setExcludeId(excludeId);
        List<Ztree> ztrees = deptService.selectDeptTreeExcludeChild(dept);
        return ztrees;
    }

    /**
     * 加载角色部门（数据权限）列表树
     */
    @GetMapping("/roleDeptTreeData")
    @ResponseBody
    public List<Ztree> deptTreeData(SysRole role)
    {
        List<Ztree> ztrees = deptService.roleDeptTreeData(role);
        return ztrees;
    }


    @GetMapping("/searchcityCodeList/{provinceCodeId}")
    @ResponseBody

    public Map<String, Object> searchcityCodeList(@PathVariable("provinceCodeId") String code, ModelMap mmap) {


        return privence(code);
    }

    public  Map<String, Object>  privence(String code){
        Map<String, Object> mapResult = new HashMap<>();
        try {
            Province province =new Province();
            province.setPcode(code);
            List<Province> provinces = provinceMapper.selectProvinceList(province);
            if (!provinces.isEmpty()) {

                mapResult.put("isSuccess", true);

                mapResult.put("provinceList", JSONObject.toJSON(provinces));
            }
        }
        catch (Exception ex) {
            mapResult.put("isSuccess", false);
            mapResult.put("errorMsg", "系统异常");
        }
        return mapResult;
    }

    @RequiresPermissions("system:dept:product")
    @GetMapping("/relevanceProduct/{id}")
    public String relevanceProduct(@PathVariable("id") Long id, ModelMap mmap)
    {

         mmap.put("organ",deptService.selectDeptById(id));;

        return prefix + "/productdata_selectadd";

    }

    /**
     * 查询系统机构列表
     */
//    @RequiresPermissions("system:organ:list")
    @PostMapping("/productlist")
    @ResponseBody
    public TableDataInfo productlist(Product productData)
    {
        startPage();
        List<Product> list = productDataService.selectProductDataByOrganCode(productData);
        return getDataTable(list);
    }



    /**
     * 选择产品
     */
    @GetMapping("/configProduct/{code}")
    public String configProduct(@PathVariable("code") Long id, ModelMap mmap)
    {
//         String a =code;
        mmap.put("organ", deptService.selectDeptById(id));
        return prefix + "/configProduct";
    }

    /**
     * 批量取消授权
     */
    @Log(title = "角色管理", businessType = BusinessType.GRANT)
    @PostMapping("/cancelAll")
    @ResponseBody
    public AjaxResult cancelAuthUserAll(String roleId, String ProductIds)
    {
        return toAjax(deptService.deleteAuthUsers(roleId, ProductIds));
    }


    /**
     * 查询系统机构列表
     */
//    @RequiresPermissions("system:organ:list")
    @PostMapping("/unallocatedList")
    @ResponseBody
    public TableDataInfo unallocatedList(SysDept sysOrgan)
    {

        startPage();
        List<Product> list = productDataService.selectUmProductDataByOrganCode( sysOrgan.getDeptId(),sysOrgan.getCityid(),sysOrgan.getDeptName());;
        return getDataTable(list);
    }


    /**
     * 批量选择用户授权
     */
    @Log(title = "角色管理", businessType = BusinessType.GRANT)
    @PostMapping("/saveOrganAndPd")
    @ResponseBody
    public AjaxResult saveOrganAndPd(@Param("organCode") String organCode, @Param("pdCodes") String pdCodes)
    {
        return toAjax(deptService.saveOrganAndPd(organCode,pdCodes));
    }

    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<SysDept> util = new ExcelUtil<SysDept>(SysDept.class);
        return util.importTemplateExcel("机构数据模板");
    }

    /**
     * 导入数据
     */
    @RequiresPermissions("system:dept:add")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        try {
            ExcelUtil<SysDept> util = new ExcelUtil<SysDept>(SysDept.class);
            List<SysDept> userList = util.importExcel(file.getInputStream());
            String message = importProduct(userList, updateSupport);
            return AjaxResult.success(message);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("导入失败:" + e.getMessage());
        }
    }
    /**
     * 导入用户数据
     *
     * @param SysDeptList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    public String importProduct(List<SysDept> SysDeptList, Boolean isUpdateSupport)
    {

        Map<String, SysDept> ProductMap1 = new LinkedHashMap<String, SysDept>();
        if (StringUtils.isNull(SysDeptList) || SysDeptList.size() == 0)
        {
            throw new ServiceException("导入机构数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (SysDept organBean : SysDeptList)
        {
            SysDept productselectBean = new SysDept();
            productselectBean.setDeptName(organBean.getDeptName());
            productselectBean.setDelFlag("0");
            List productList  = deptService.selectSysDeptListonlyName(productselectBean);
            try
            {
                String name = organBean.getDeptName().trim();
                if(name==null||"".equals(name)){
                    throw new Exception("机构名称不能为空");
                }

                // 验证是否存在这个用户
                boolean userFlag = false;
                if (productList.size()>0){
                    userFlag = true;
                }
                if (!userFlag)
                {
                    SysDept dedDept = new SysDept();
                    dedDept.setDeptName(organBean.getParentName());
                    List<SysDept> infolist = sysDeptMapper.selectSysDeptListonlyName(dedDept);
                    if(infolist.size()==0){
                        throw new ServiceException("上级部门不存在");
                     }
                    SysDept info = infolist.get(0);
                    // 如果父节点不为"正常"状态,则不允许新增子节点
                    if (!UserConstants.DEPT_NORMAL.equals(info.getStatus()))
                    {
                        throw new ServiceException("部门停用，不允许新增");
                    }
                     organBean.setParentId(info.getDeptId());
                     organBean.setDeptId(Long.parseLong(String.valueOf(deptMapper.selectdeptidDesc()+1)));
                     organBean.setDelFlag("0");
                    organBean.setStatus("0");
//                    Integer userId = ProductMap.size() + 1;

//                    if(organBean.getPid()==null||"".equals(organBean.getPid())){
//                        throw new Exception("上级机构编码不能为空");
//                    }else    if(organBean.getOrganLevel()==null||"".equals(organBean.getOrganLevel())){
//                        throw new Exception("机构级别不能为空");
//                    } else    if(organBean.getAddress()==null||"".equals(organBean.getAddress())){
//                        throw new Exception("详情地址不能为空");
//                    }else    if(organBean.getPhone()==null||"".equals(organBean.getPhone())){
//                        throw new Exception("手机号码不能为空");
//                    }else    if(organBean.getContactPerson()==null||"".equals(organBean.getContactPerson())){
//                        throw new Exception("联系人不能为空");
//                    }else    if(organBean.getPid().length()>15){
//                        throw new Exception("上级机构编码字段过长");
//                    }else    if(organBean.getSapcode().length()>15){
//                        throw new Exception("SAP编码字段过长");
//                    }else    if(organBean.getName().length()>50){
//                        throw new Exception("机构名称字段过长");
//                    }else    if(organBean.getAddress().length()>50){
//                        throw new Exception("详情地址字段过长");
//                    }else    if(organBean.getPhone().length()>15){
//                        throw new Exception("手机号字段过长");
//                    }else    if(organBean.getContactPerson().length()>15){
//                        throw new Exception("联系人字段过长");
//                    }else    if(organBean.getProvinceCode().length()>40){
//                        throw new Exception("省字段过长");
//                    }else    if(organBean.getCityCode().length()>40){
//                        throw new Exception("市字段过长");
//                    }else    if(organBean.getCountyCode().length()>40){
//                        throw new Exception("区/县字段过长");
//                    }

                    SysDept s = new SysDept();
                    s.setDeptId(organBean.getParentId());
                    s.setDelFlag("0");
                    List list  = deptService.selectDeptList(s);
                    if (list==null||list.isEmpty()){
                        throw new Exception("上级机构编码不存在");
                    }

                    String province =  organBean.getProvince();//省
                    String city =organBean.getCity();//市
                    String count = organBean.getCountry();//区
                    if(province==null||"".equals(province)){
                        throw new Exception("省不能为空");
                    }else{


                        String code=  provinceMapper.selectProvinceListByname(province,province+"省","1");
                        if(code ==null||"".equals(code)){
                            throw new Exception("省 字段不合法");
                        }else{
                            organBean.setProvince(code);
                        }
                    }
                    if(city==null||"".equals(city)){}else{
                        String code=  provinceMapper.selectProvinceListByname(city,city+"市","2");
                        if(code ==null||"".equals(code)){}else{
                            organBean.setCity(code);
                        }
                    }
                    if(count==null||"".equals(count)){}else{
                        String code=  provinceMapper.selectProvinceListByname(count,count+"区","3");
                        if(code ==null||"".equals(code)){}else{
                            organBean.setCountry(code);
                        }
                    }


                    if (StringUtils.isNotEmpty(organBean.getPdCode())){
                        Product product = productDataService.selectByPdCode(organBean.getPdCode());
                        ProductOrgan productOrgan=new ProductOrgan();
                        productOrgan.setPdCode(product.getCode());
                        productOrgan.setOrganCode(organBean.getCityid());
                        productOrganService.insertProductOrgan(productOrgan);
                    }
                    deptService.insertDept(organBean);
                    String relateProduct = organBean.getPdName();
                    String[] pronames =Convert.toStrArray("、", relateProduct);
                    for(String proname :pronames){
                        deptMapper.insertByPdname(organBean.getDeptId(),proname );
                    }

                    String a = organBean.getPdName();

                    successNum++;
                    successMsg.append("<br/>" + successNum + "、机构 " + organBean.getDeptName() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    deptService.updateDept(organBean);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、机构 " + organBean.getDeptName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、机构 " + organBean.getDeptName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                failureNum++;
                String msg = "<br/>" + failureNum + "、机构 " + organBean.getDeptName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，共 " + successNum + " 条导入成功，共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();

    }

    /**
     * 进入仓库页面
     */
        @RequiresPermissions("system:dept:warehouse")
    @GetMapping("/prefix/{userId}")
    public String prefix(@PathVariable("userId") String userId, ModelMap mmap)
    {


        startPage();
        Warehouse Warehouse = new Warehouse();
        Warehouse.setOrganCode(userId);
        List<Warehouse> list  = deptMapper.selectWarehouseList(Warehouse);
        // 获取用户所属的角色列表
        mmap.put("Warehouse", list);
        mmap.put("organid",userId);
        return "basedata/warehouse/warehouse";

//        return  ac.list(a);
    }


}
