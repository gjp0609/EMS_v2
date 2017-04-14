package cn.gjp0609.ems_v2.dao;


import cn.gjp0609.ems_v2.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by gjp06 on 17.3.31.
 */
public interface EmpDao {
    /**
     * 根据员工 ID 查询
     *
     * @param id 员工 ID
     * @return 查得的员工对象
     */
    public Employee selectEmpById(@Param("id") Integer id);

    /**
     * 根据部门 ID 查询员工
     *
     * @param dept_id 部门 ID
     * @return 存放该部门员工对象的集合
     */
    public List<Employee> selectEmpByDeptId(@Param("deptId") Integer deptId);

    /**
     * 查询所有员工信息
     *
     * @return 存放所有员工对象的集合
     */
    public List<Employee> selectAllEmp();

    /**
     * 更新员工信息
     *
     * @param employee 要更新的员工对象
     * @return 受影响员工个数
     */
    public int updateEmp(Employee employee);

    /**
     * 删除员工信息
     *
     * @param employee 要删除的员工对象
     * @return 受影响员工个数
     */
    public int deleteEmp(@Param("id") Integer id);

    /**
     * 根据部门 ID 删除员工
     * 用于在删除部门前调用，实现级联删除
     *
     * @param id 要删除的部门 ID
     * @return 受影响行数
     */
    public int deleteEmpByDeptId(@Param("deptId") Integer deptId);

    /**
     * 增加新员工
     *
     * @param employee 要增加的员工对象
     * @return 受影响员工个数
     */
    public int addEmp(Employee employee);

}
