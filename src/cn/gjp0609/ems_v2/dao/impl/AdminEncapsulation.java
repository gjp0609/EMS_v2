package cn.gjp0609.ems_v2.dao.impl;


import cn.gjp0609.ems_v2.entity.Admin;
import cn.gjp0609.ems_v2.utils.Encapsulation;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gjp06 on 17.4.3.
 */
public class AdminEncapsulation implements Encapsulation<Admin> {
    @Override
    public Admin encapsulate(ResultSet rs) {
        Admin admin = null;
        try {
            admin = new Admin();
            admin.setName(rs.getString("NAME"));
            admin.setPassword(rs.getString("PASSWORD"));
            admin.setSalt(rs.getString("SALT"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
