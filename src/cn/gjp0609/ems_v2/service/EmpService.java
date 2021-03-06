package cn.gjp0609.ems_v2.service;


import cn.gjp0609.ems_v2.entity.Employee;

import java.util.List;

/**
 * 员工业务接口
 * Created by gjp06 on 17.4.1.
 */
public interface EmpService {

    public List<Employee> queryAllEmp();

    public Employee queryEmpById(Integer id);

    public void deleteEmp(Employee employee);

    public void updateEmp(Employee employee);

    public void addEmp(Employee employee);

}
