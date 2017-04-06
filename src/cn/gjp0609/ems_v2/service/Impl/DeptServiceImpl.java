package cn.gjp0609.ems_v2.service.Impl;

import cn.gjp0609.ems_v2.dao.impl.DeptDaoImpl;
import cn.gjp0609.ems_v2.entity.Dept;
import cn.gjp0609.ems_v2.service.DeptService;

import java.util.List;

/**
 * Created by gjp06 on 17.4.3.
 */
public class DeptServiceImpl implements DeptService {
    @Override
    public List<Dept> queryAllDept() {
        return new DeptDaoImpl().selectAllDept();
    }

    @Override
    public Dept queryDeptById(Integer id) {
        return new DeptDaoImpl().selectDeptById(id);
    }

    @Override
    public void deleteDept(Dept dept) {
        // todo
    }

    @Override
    public void updateDept(Dept dept) {
        // todo
    }

    @Override
    public void addDept(Dept dept) {
        // todo
    }
}
