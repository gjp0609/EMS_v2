package cn.gjp0609.ems_v2.service;


import cn.gjp0609.ems_v2.entity.Admin;

/**
 * Created by gjp06 on 17.4.3.
 */
public interface AdminService {
    public Admin login(String name, String password);

    public int signUp(Admin admin);
}
