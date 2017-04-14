package cn.gjp0609.ems_v2.utils;


import cn.gjp0609.ems_v2.dao.AdminDao;
import cn.gjp0609.ems_v2.dao.EmpDao;
import cn.gjp0609.ems_v2.entity.Admin;
import cn.gjp0609.ems_v2.entity.Employee;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.List;

/**
 * 单元测试类
 * Created by gjp06 on 17.4.1.
 */
class JUnitTest {


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


    @Test
    void testSelectEmpByDeptId() {
        EmpDao edi = MyBatisUtils.get(EmpDao.class);
        List<Employee> list = edi.selectEmpByDeptId(10);
        for (Employee e : list) {
            System.out.println(e);
        }
    }

    @Test
    void testSQL() {
        Admin admin = MyBatisUtils.get(AdminDao.class).selectAdminByName("me");
        System.out.println(admin.getPassword());
    }

    @Test
    void testMD() {
        String abc = "234242";
        String md5 = SecurityUtils.getMD5(abc);
        System.out.println(md5);
    }
}
