package cn.gjp0609.ems_v2.dao.impl;


import cn.gjp0609.ems_v2.dao.DeptDao;
import cn.gjp0609.ems_v2.entity.Dept;
import cn.gjp0609.ems_v2.utils.CommonDao;
import cn.gjp0609.ems_v2.utils.CommonDaoImpl;

import java.util.List;

/**
 * Created by gjp06 on 17.4.3.
 */
public class DeptDaoImpl implements DeptDao {

    @Override
    public int addDept(Dept dept) {
        CommonDao<Dept> cd = new CommonDaoImpl<>();
        String sql = "INSERT INTO T_EMS_DEPARTMENT VALUES (?,?)";
        int result = cd.updateData(sql, dept, dept.getId(), dept.getName());
        return result;
    }

    @Override
    public int deleteDept(Dept dept) {
        // todo 删除部门，实现级联删除
        return 0;
    }

    @Override
    public int updateDept(Dept dept) {
        // todo 更新部门信息
        return 0;
    }

    @Override
    public Dept selectDeptById(Integer id) {
        CommonDao<Dept> cd = new CommonDaoImpl<>();
        String sql = "SELECT * FROM T_EMS_DEPARTMENT WHERE ID=?";
        List<Dept> depts = cd.queryData(sql, new DeptEncapsulation(), id);
        return depts == null ? null : depts.get(0);
    }

    @Override
    public List<Dept> selectAllDept() {
        CommonDao<Dept> cd = new CommonDaoImpl<>();
        String sql = "SELECT * FROM T_EMS_DEPARTMENT";
        return cd.queryData(sql, new DeptEncapsulation());
    }
}
