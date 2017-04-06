package cn.gjp0609.ems_v2.dao;


import cn.gjp0609.ems_v2.entity.Employee;

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
    public Employee selectEmpById(Integer id);

    public List<Employee> selectEmpByDeptId(Integer dept_id);

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
    public int deleteEmp(Employee employee);

    /**
     * 增加新员工
     *
     * @param employee 要增加的员工对象
     * @return 受影响员工个数
     */
    public int addEmp(Employee employee);

}
