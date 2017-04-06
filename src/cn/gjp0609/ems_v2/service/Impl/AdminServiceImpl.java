package cn.gjp0609.ems_v2.service.Impl;

import cn.gjp0609.ems_v2.dao.AdminDao;
import cn.gjp0609.ems_v2.dao.impl.AdminDaoImpl;
import cn.gjp0609.ems_v2.entity.Admin;
import cn.gjp0609.ems_v2.service.AdminService;
import cn.gjp0609.ems_v2.utils.SecurityUtils;
import cn.gjp0609.ems_v2.utils.TransactionUtils;

/**
 * Created by gjp06 on 17.4.3.
 */
public class AdminServiceImpl implements AdminService {
    @Override
    public Admin login(String name, String password) {
        AdminDao ad = new AdminDaoImpl();
        if (password != null && name != null) {
            Admin admin = ad.selectAdminByName(name);
            String pwd = SecurityUtils.getMD5(password + admin.getSalt());
            if (admin.getPassword().equals(pwd)) return admin;
        }
        return null;
    }

    @Override
    public int signUp(Admin admin) {
        AdminDao ad = new AdminDaoImpl();
        Admin secAdmin = new Admin();
        String salt = SecurityUtils.getRandomCode(10);
        String pwd = SecurityUtils.getMD5(admin.getPassword() + salt);
        secAdmin.setName(admin.getName());
        secAdmin.setPassword(pwd);
        secAdmin.setSalt(salt);
        int result = 0;
        try {
            result = ad.addAdmin(secAdmin);
            if (result != 1) throw new RuntimeException("注册失败");
            TransactionUtils.commit();
        } catch (Exception e) {
            TransactionUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
