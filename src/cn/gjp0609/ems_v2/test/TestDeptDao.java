package cn.gjp0609.ems_v2.test;

import cn.gjp0609.ems_v2.dao.DeptDao;
import cn.gjp0609.ems_v2.dao.EmpDao;
import cn.gjp0609.ems_v2.entity.Dept;
import cn.gjp0609.ems_v2.entity.Employee;
import cn.gjp0609.ems_v2.utils.MyBatisUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * TestDeptDao
 * Created by gjp06 on 17.4.13.
 */
class TestDeptDao {
    private DeptDao deptDao = MyBatisUtils.get(DeptDao.class);

    // 根据部门 ID 查询部门信息，包括所有员工
    @Test
    void testSelectDeptById() {
        Dept dept = deptDao.selectDeptById(20);
        List<Employee> emps = dept.getEmps();
        for (Employee e : emps) {
            System.out.println(e);
        }
    }

    // 查询所有部门信息，包括所有员工
    @Test
    void testSelectAllDept() {
        List<Dept> depts = deptDao.selectAllDept();
        for (Dept dept : depts) {
            for (Employee e : dept.getEmps()) {
                System.out.println(e);
            }
        }
    }

    // 插入新部门
    @Test
    void testAddDept() {
        Dept dept = new Dept(40, "采购部");
        int i = deptDao.addDept(dept);
        System.out.println(i);
        MyBatisUtils.commit();
    }

    // 修改部门信息
    @Test
    void testUpdateDept() {
        int i = deptDao.updateDept(new Dept(30, "业务部"));
        System.out.println(i);
        MyBatisUtils.commit();
    }

    // 删除部门
    @Test
    void testDeleteDept() {
        EmpDao empDao = MyBatisUtils.get(EmpDao.class);
        int i = empDao.deleteEmpByDeptId(30);
        int i1 = deptDao.deleteDept(30);
        System.out.println(i + " " + i1);
    }
}
