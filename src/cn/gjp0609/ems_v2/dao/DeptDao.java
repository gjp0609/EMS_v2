package cn.gjp0609.ems_v2.dao;


import cn.gjp0609.ems_v2.entity.Dept;

import java.util.List;

/**
 * Created by gjp06 on 17.4.3.
 */
public interface DeptDao {
    /**
     * 增加新部门
     *
     * @param dept 要增加的部门对象
     * @return 受影响部门个数
     */
    public int addDept(Dept dept);

    /**
     * 删除部门信息
     *
     * @param dept 要删除的部门对象
     * @return 受影响部门个数
     */
    public int deleteDept(Dept dept);

    /**
     * 更新部门信息
     *
     * @param dept 要更新的部门对象
     * @return 受影响部门个数
     */
    public int updateDept(Dept dept);

    /**
     * @param id 部门 ID
     * @return 查得的部门对象
     */
    public Dept selectDeptById(Integer id);

    /**
     * 查询所有部门信息
     *
     * @return 存放所有部门对象的集合
     */
    public List<Dept> selectAllDept();

}
