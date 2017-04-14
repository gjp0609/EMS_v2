package cn.gjp0609.ems_v2.service.Impl;

import cn.gjp0609.ems_v2.dao.EmpDao;
import cn.gjp0609.ems_v2.entity.Employee;
import cn.gjp0609.ems_v2.service.EmpService;
import cn.gjp0609.ems_v2.utils.MyBatisUtils;

import java.util.List;

/**
 * Created by gjp06 on 17.4.1.
 */
public class EmpServiceImpl implements EmpService {
    @Override
    public List<Employee> queryAllEmp() {
        List<Employee> list = null;
        try {
            EmpDao empDao = MyBatisUtils.get(EmpDao.class);
            list = empDao.selectAllEmp();
            if (list == null) throw new RuntimeException("查询无任何员工");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Employee queryEmpById(Integer id) {
        Employee employee = null;
        try {
            if (id == null) throw new RuntimeException("未收到员工 ID");
            EmpDao empDao = MyBatisUtils.get(EmpDao.class);
            employee = empDao.selectEmpById(id);
            if (employee == null) throw new RuntimeException("未找到此员工");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return employee;
    }


    @Override
    public int deleteEmp(Integer id) {
        int result = 0;
        try {
            if (id == null) throw new RuntimeException("未收到要删除的员工 ID");
            EmpDao empDao = MyBatisUtils.get(EmpDao.class);
            result = empDao.deleteEmp(id);
            if (result != 1) throw new RuntimeException("删除员工失败");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateEmp(Employee employee) {
        int result = 0;
        try {
            if (employee == null) throw new RuntimeException("未收到参数");
            EmpDao empDao = MyBatisUtils.get(EmpDao.class);
            result = empDao.updateEmp(employee);
            if (result != 1) throw new RuntimeException("更新员工失败");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int addEmp(Employee employee) {
        int result = 0;
        try {
            if (employee == null) throw new RuntimeException("未收到要添加的员工");
            EmpDao empDao = MyBatisUtils.get(EmpDao.class);
            result = empDao.addEmp(employee);
            if (result != 1) throw new RuntimeException("添加员工失败");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
