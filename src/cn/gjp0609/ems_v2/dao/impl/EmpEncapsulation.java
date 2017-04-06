package cn.gjp0609.ems_v2.dao.impl;


import cn.gjp0609.ems_v2.entity.Dept;
import cn.gjp0609.ems_v2.entity.Employee;
import cn.gjp0609.ems_v2.utils.Encapsulation;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Integer id; * String name; * String sex; * Double salary; * Date birthqay; * Integer deptId; * Dept dept;
 * Created by gjp06 on 17.3.31.
 */
public class EmpEncapsulation implements Encapsulation<Employee> {
    @Override
    public Employee encapsulate(ResultSet rs) {
        Employee employee = new Employee();
        try {
            employee.setId(rs.getInt("ID"));
            employee.setName(rs.getString("NAME"));
            employee.setSex(rs.getString("SEX"));
            employee.setSalary(rs.getDouble("SALARY"));
            employee.setBirthday(rs.getDate("BIRTHDAY"));

            Dept dept = new Dept();
            dept.setId(rs.getInt("DEPT_ID"));
            dept.setName(rs.getString("DEPT_NAME"));
            employee.setDept(dept);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
