package cn.gjp0609.ems_v2.service.Impl;

import cn.gjp0609.ems_v2.dao.DeptDao;
import cn.gjp0609.ems_v2.entity.Dept;
import cn.gjp0609.ems_v2.service.DeptService;
import cn.gjp0609.ems_v2.utils.MyBatisUtils;

import java.util.List;

/**
 * Created by gjp06 on 17.4.3.
 */
public class DeptServiceImpl implements DeptService {
    @Override
    public List<Dept> queryAllDept() {
        List<Dept> depts = null;
        try {
            DeptDao deptDao = MyBatisUtils.get(DeptDao.class);
            depts = deptDao.selectAllDept();
            if (depts == null) throw new RuntimeException("未查询到任何部门");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return depts;
    }

    @Override
    public Dept queryDeptById(Integer id) {
        Dept dept = null;
        try {
            if (id == null) throw new RuntimeException("未收到部门 ID");
            DeptDao deptDao = MyBatisUtils.get(DeptDao.class);
            dept = deptDao.selectDeptById(id);
            if (dept == null) throw new RuntimeException("未查询到该部门");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return dept;
    }

    @Override
    public int deleteDept(Integer deptId) {
        int result = 0;
        try {
            if (deptId == null) throw new RuntimeException("未收到要删除的部门对象");
            DeptDao deptDao = MyBatisUtils.get(DeptDao.class);
            result = deptDao.deleteDept(deptId);
            if (result != 1) throw new RuntimeException("删除部门失败");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateDept(Dept dept) {
        int result = 0;
        try {
            if (dept == null) throw new RuntimeException("未收到要更新的部门对象");
            DeptDao deptDao = MyBatisUtils.get(DeptDao.class);
            result = deptDao.updateDept(dept);
            if (result != 1) throw new RuntimeException("更新部门失败");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int addDept(Dept dept) {
        int result = 0;
        try {
            if (dept == null) throw new RuntimeException("未收到要添加的部门对象");
            DeptDao deptDao = MyBatisUtils.get(DeptDao.class);
            result = deptDao.addDept(dept);
            if (result != 1) throw new RuntimeException("添加部门失败");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
