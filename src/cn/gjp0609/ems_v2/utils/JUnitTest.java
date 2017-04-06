package cn.gjp0609.ems_v2.utils;


import cn.gjp0609.ems_v2.dao.DeptDao;
import cn.gjp0609.ems_v2.dao.EmpDao;
import cn.gjp0609.ems_v2.dao.impl.AdminDaoImpl;
import cn.gjp0609.ems_v2.dao.impl.DeptDaoImpl;
import cn.gjp0609.ems_v2.dao.impl.EmpDaoImpl;
import cn.gjp0609.ems_v2.dao.impl.EmpEncapsulation;
import cn.gjp0609.ems_v2.entity.Admin;
import cn.gjp0609.ems_v2.entity.Dept;
import cn.gjp0609.ems_v2.entity.Employee;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.List;

/**
 * 单元测试类
 * Created by gjp06 on 17.4.1.
 */
class JUnitTest {
    @Test
    void testJDBC() {
        Connection conn = JdbcUtils.getConnection();
        System.out.println(conn);
    }

    @Test
    void testCommomDao() {
        CommonDao<Employee> cd = new CommonDaoImpl<>();
        String sql = "SELECT E.*, D.NAME DEPT_NAME FROM T_EMS_EMPLOYEE E LEFT JOIN T_EMS_DEPARTMENT D ON E.DEPT_ID = D.ID";
        List<Employee> list = cd.queryData(sql, new EmpEncapsulation());
        for (Employee e : list) {
            System.out.println(e);
        }
        Employee e = list.get(0);
        e.setSex("F");
        new EmpDaoImpl().updateEmp(e);
        list = cd.queryData(sql, new EmpEncapsulation());
        for (Employee es : list) {
            System.out.println(es);
        }
    }

    @Test
    void testDate() {
        String date = "1993-5-7 18:34:34";
        System.out.println(DateUtils.getUtilDate(date));
        System.out.println(DateUtils.getSqlDate(new java.util.Date()));
        System.out.println(DateUtils.getDate(new java.util.Date(), "yyyy - MM - dd"));
    }

    @Test
    void testVcode() throws Exception {
        String code = SecurityUtils.getRandomCode(4);
        BufferedImage img = SecurityUtils.getVerifiyImg(code, 40, 90);
        System.out.println(code);
        ImageIO.write(img, "png", new FileOutputStream("src/a.png"));
    }

    /**
     * 根据部门 ID 查询部门信息，包括所有员工
     */
    @Test
    void testSelectDeptById() {
        DeptDao dd = new DeptDaoImpl();

        Dept dept = dd.selectDeptById(20);
        System.out.println(dept);
        List<Employee> emps = dept.getEmps();
        for (Employee e : emps) {
            System.out.println(e);
        }
    }

    @Test
    void testSelectEmpByDeptId() {
        EmpDao edi = new EmpDaoImpl();
        List<Employee> list = edi.selectEmpByDeptId(10);
        for (Employee e : list) {
            System.out.println(e);
        }
    }

    @Test
    void testSQL() {
        String sql = "select * from T_EMS_ADMIN";

        Admin admin = new AdminDaoImpl().selectAdminByName("me");
        System.out.println(admin.getPassword());
    }

    @Test
    void testMD() {
        String abc = "234242";
        String md5 = SecurityUtils.getMD5(abc);
        System.out.println(md5);
    }
}
