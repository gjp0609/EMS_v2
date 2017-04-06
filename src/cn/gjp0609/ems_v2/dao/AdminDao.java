package cn.gjp0609.ems_v2.dao;


import cn.gjp0609.ems_v2.entity.Admin;

/**
 * Created by gjp06 on 17.4.3.
 */
public interface AdminDao {

    public int addAdmin(Admin admin);

    public int deleteAdmin(Admin admin);

    public int updateAdmin(Admin admin);

    public Admin selectAdminByName(String name);
}
