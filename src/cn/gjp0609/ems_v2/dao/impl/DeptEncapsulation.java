package cn.gjp0609.ems_v2.dao.impl;

import cn.gjp0609.ems_v2.dao.EmpDao;
import cn.gjp0609.ems_v2.entity.Dept;
import cn.gjp0609.ems_v2.entity.Employee;
import cn.gjp0609.ems_v2.utils.Encapsulation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gjp06 on 17.4.3.
 */
public class DeptEncapsulation implements Encapsulation<Dept> {
    @Override
    public Dept encapsulate(ResultSet rs) {
        Dept dept = null;
        try {
            int id = rs.getInt("ID");
            EmpDao empDao = new EmpDaoImpl();
            List<Employee> employees = empDao.selectEmpByDeptId(id);
            String name = rs.getString("NAME");

            dept = new Dept();
            dept.setId(id);
            dept.setName(name);
            dept.setEmps(employees);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }
}
