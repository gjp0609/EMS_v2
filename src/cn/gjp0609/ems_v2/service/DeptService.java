package cn.gjp0609.ems_v2.service;


import cn.gjp0609.ems_v2.entity.Dept;

import java.util.List;

/**
 * Created by gjp06 on 17.4.3.
 */
public interface DeptService {
    /**
     * 查询所有部门信息，包括所有员工
     *
     * @return 包含所有部门对象的集合
     */
    public List<Dept> queryAllDept();

    /**
     * 根据部门 ID 查询部门信息，包括所有员工
     *
     * @param id 部门 ID
     * @return 指定 ID 的部门对象
     */
    public Dept queryDeptById(Integer id);

    /**
     * 删除指定部门
     *
     * @param deptId 部门 ID
     */
    public int deleteDept(Integer deptId);

    public int updateDept(Dept dept);

    public int addDept(Dept dept);
}
