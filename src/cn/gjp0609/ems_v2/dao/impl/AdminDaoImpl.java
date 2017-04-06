package cn.gjp0609.ems_v2.dao.impl;

import cn.gjp0609.ems_v2.dao.AdminDao;
import cn.gjp0609.ems_v2.entity.Admin;
import cn.gjp0609.ems_v2.utils.CommonDao;
import cn.gjp0609.ems_v2.utils.CommonDaoImpl;

import java.util.List;

/**
 * Created by gjp06 on 17.4.3.
 */
public class AdminDaoImpl implements AdminDao {
    @Override
    public int addAdmin(Admin admin) {
        CommonDao<Admin> cd = new CommonDaoImpl<>();
        String sql = "INSERT INTO T_EMS_ADMIN VALUES (?,?,?)";
        return cd.updateData(sql, admin, admin.getName(), admin.getPassword(), admin.getSalt());
    }

    @Override
    public int deleteAdmin(Admin admin) {
        // todo
        return 0;
    }

    @Override
    public int updateAdmin(Admin admin) {
        return 0;
    }

    @Override
    public Admin selectAdminByName(String name) {
        CommonDao<Admin> cd = new CommonDaoImpl<>();
        String sql = "SELECT * FROM T_EMS_ADMIN WHERE NAME=?";
        List<Admin> admins = cd.queryData(sql, new AdminEncapsulation(), name);
        return admins == null ? null : admins.get(0);
    }
}
