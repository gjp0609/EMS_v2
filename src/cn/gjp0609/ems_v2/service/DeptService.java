package cn.gjp0609.ems_v2.service;


import cn.gjp0609.ems_v2.entity.Dept;

import java.util.List;

/**
 * Created by gjp06 on 17.4.3.
 */
public interface DeptService {
    public List<Dept> queryAllDept();

    public Dept queryDeptById(Integer id);

    public void deleteDept(Dept dept);

    public void updateDept(Dept dept);

    public void addDept(Dept dept);
}
