package cn.gjp0609.ems_v2.test;

import cn.gjp0609.ems_v2.dao.EmpDao;
import cn.gjp0609.ems_v2.entity.Dept;
import cn.gjp0609.ems_v2.entity.Employee;
import cn.gjp0609.ems_v2.utils.MyBatisUtils;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

/**
 * TestEmpDao
 * Created by gjp06 on 17.4.13.
 */
class TestEmpDao {
    private EmpDao empDao = MyBatisUtils.get(EmpDao.class);

    // 查询所有员工
    @Test
    void testSelectAllEmp() {
        List<Employee> employees = empDao.selectAllEmp();
        for (Employee e : employees)
            System.out.println(e);
        MyBatisUtils.commit();
    }

    // 根据员工 ID 查询
    @Test
    void testSelectEmpById() {
        Employee employee = empDao.selectEmpById(100081);
        System.out.println(employee);
        MyBatisUtils.commit();
    }

    // 根据员工 ID 查询
    @Test
    void testSelectEmpByDeptId() {
        List<Employee> employees = empDao.selectEmpByDeptId(20);
        for (Employee e : employees) {
            System.out.println(e);
        }
        MyBatisUtils.commit();
    }

    // 删除员工
    @Test
    void testDeleteEmp() {
        int i = empDao.deleteEmp(100081);
        System.out.println(i);
        MyBatisUtils.commit();
    }

    // add
    @Test
    void testAddEmp() {
        // (Integer id, String name, String sex, Double salary, Date birthday, Dept dept)
        
        int i = empDao.addEmp(new Employee(null, "源氏", "M", 4300d, new Date(), new Dept(10, null)));
        System.out.println(i);
    }

}


