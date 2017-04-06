package cn.gjp0609.ems_v2.service.Impl;

import cn.gjp0609.ems_v2.dao.impl.EmpDaoImpl;
import cn.gjp0609.ems_v2.entity.Employee;
import cn.gjp0609.ems_v2.service.EmpService;
import cn.gjp0609.ems_v2.utils.TransactionUtils;

import java.util.List;

/**
 * Created by gjp06 on 17.4.1.
 */
public class EmpServiceImpl implements EmpService {
    @Override
    public List<Employee> queryAllEmp() {
        return new EmpDaoImpl().selectAllEmp();
    }

    @Override
    public Employee queryEmpById(Integer id) {
        return new EmpDaoImpl().selectEmpById(id);
    }

    @Override
    public void deleteEmp(Employee employee) {
        try {
            int result = new EmpDaoImpl().deleteEmp(employee);
            if (result != 1) throw new RuntimeException("删除失败");
            else TransactionUtils.commit();
        } catch (Exception e) {
            TransactionUtils.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmp(Employee employee) {
        try {
            int result = new EmpDaoImpl().updateEmp(employee);
            if (result != 1) throw new RuntimeException("更新失败");
            TransactionUtils.commit();
        } catch (Exception e) {
            TransactionUtils.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void addEmp(Employee employee) {
        try {
            int result = new EmpDaoImpl().addEmp(employee);
            if (result != 1) throw new RuntimeException("添加失败");
            TransactionUtils.commit();
        } catch (Exception e) {
            TransactionUtils.rollback();
            e.printStackTrace();
        }
    }
}
