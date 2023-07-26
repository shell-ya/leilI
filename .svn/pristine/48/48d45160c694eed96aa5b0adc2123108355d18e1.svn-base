package com.linkwin.system.service;

import java.util.List;
import com.linkwin.common.core.domain.Ztree;
import com.linkwin.common.core.domain.entity.SysDept;
import com.linkwin.common.core.domain.entity.SysRole;
import org.apache.ibatis.annotations.Param;

/**
 * 部门管理 服务层
 * 
 * @author ruoyi
 */
public interface ISysDeptService
{
    /**
     * 查询部门管理数据
     * 
     * @param dept 部门信息
     * @return 部门信息集合
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * 查询部门管理树
     * 
     * @param dept 部门信息
     * @return 所有部门信息
     */
    public List<Ztree> selectDeptTree(SysDept dept);

    /**
     * 查询部门管理树（排除下级）
     * 
     * @param dept 部门信息
     * @return 所有部门信息
     */
    public List<Ztree> selectDeptTreeExcludeChild(SysDept dept);

    /**
     * 根据角色ID查询菜单
     *
     * @param role 角色对象
     * @return 菜单列表
     */
    public List<Ztree> roleDeptTreeData(SysRole role);

    /**
     * 查询部门人数
     * 
     * @param parentId 父部门ID
     * @return 结果
     */
    public int selectDeptCount(Long parentId);

    /**
     * 查询部门是否存在用户
     * 
     * @param deptId 部门ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkDeptExistUser(Long deptId);

    /**
     * 删除部门管理信息
     * 
     * @param deptId 部门ID
     * @return 结果
     */
    public int deleteDeptById(Long deptId);

    /**
     * 新增保存部门信息
     * 
     * @param dept 部门信息
     * @return 结果
     */
    public int insertDept(SysDept dept);

    /**
     * 修改保存部门信息
     * 
     * @param dept 部门信息
     * @return 结果
     */
    public int updateDept(SysDept dept);

    /**
     * 根据部门ID查询信息
     * 
     * @param deptId 部门ID
     * @return 部门信息
     */
    public SysDept selectDeptById(Long deptId);

    /**
     * 根据ID查询所有子部门（正常状态）
     * 
     * @param deptId 部门ID
     * @return 子部门数
     */
    public int selectNormalChildrenDeptById(Long deptId);

    /**
     * 校验经销商名称是否唯一
     * 
     * @param dept 部门信息
     * @return 结果
     */
    public String checkDeptNameUnique(SysDept dept);

    /**
     * 校验部门是否有数据权限
     * 
     * @param deptId 部门id
     */
    public void checkDeptDataScope(Long deptId);

    /**
     * 根据条码查询机构信息 出库单据的收货机构
     * @param code
     * @return
     * @Author qipeng.zheng
     * @Date 2022/6/15
     */
    SysDept selectOrganByCode(String code);
    public List<SysDept> selectDeptProvinceList(SysDept dept);

    public int deleteAuthUsers(String roleId, String userIds);

    int saveOrganAndPd(String organCode,String pdCodes);


    public List<SysDept> selectSysDeptListonlyName(SysDept dept);

    /**
     * 查询代理区域是否存在该县区级别的代理
     * @param deptId
     * @param agentArea
     * @return
     * @Author qipeng.zheng
     * @Date 220921
     */
    SysDept selectCountry(Long deptId, String agentArea);

    List<Long> selectDeptId(Long id);



}
