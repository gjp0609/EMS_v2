package cn.gjp0609.ems_v2.service.Impl;

import cn.gjp0609.ems_v2.dao.AdminDao;
import cn.gjp0609.ems_v2.entity.Admin;
import cn.gjp0609.ems_v2.service.AdminService;
import cn.gjp0609.ems_v2.utils.MyBatisUtils;
import cn.gjp0609.ems_v2.utils.SecurityUtils;

/**
 * admin
 * Created by gjp06 on 17.4.3.
 */
public class AdminServiceImpl implements AdminService {
    @Override
    public Admin login(String name, String password) {
        Admin admin = null;
        try {
            if (password == null || name == null) throw new RuntimeException("未接收到参数");
            AdminDao adminDao = MyBatisUtils.get(AdminDao.class);
            admin = adminDao.selectAdminByName(name);
            if (admin == null) throw new RuntimeException("admin 对象为空");
            String pwd = SecurityUtils.getMD5(password + admin.getSalt());
            if (!admin.getPassword().equals(pwd)) throw new RuntimeException("密码不正确");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public int signUp(Admin admin) {
        int result = 0;
        try {
            if (admin == null) throw new RuntimeException("接收到的 admin 对象为空");
            AdminDao ad = MyBatisUtils.get(AdminDao.class);
            Admin secAdmin = new Admin();
            String salt = SecurityUtils.getRandomCode(10);
            String pwd = SecurityUtils.getMD5(admin.getPassword() + salt);
            secAdmin.setName(admin.getName());
            secAdmin.setPassword(pwd);
            secAdmin.setSalt(salt);
            result = ad.addAdmin(secAdmin);
            if (result != 1) throw new RuntimeException("注册失败");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
