package cn.gjp0609.ems_v2.dao.impl;

import cn.gjp0609.ems_v2.dao.EmpDao;
import cn.gjp0609.ems_v2.entity.Employee;
import cn.gjp0609.ems_v2.utils.CommonDao;
import cn.gjp0609.ems_v2.utils.CommonDaoImpl;
import cn.gjp0609.ems_v2.utils.DateUtils;
import cn.gjp0609.ems_v2.utils.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gjp06 on 17.3.31.
 */
public class EmpDaoImpl implements EmpDao {
    @Override
    public Employee selectEmpById(Integer id) {
        CommonDao<Employee> cd = new CommonDaoImpl<>();
        String sql = "SELECT E.*, D.NAME DEPT_NAME FROM T_EMS_EMPLOYEE E " +
                "LEFT JOIN T_EMS_DEPARTMENT D ON E.DEPT_ID = D.ID WHERE E.ID = ?";
        List<Employee> list = cd.queryData(sql, new EmpEncapsulation(), id);
        return list == null ? null : list.get(0);
    }

    @Override
    public List<Employee> selectEmpByDeptId(Integer dept_id) {
        CommonDao<Employee> cd = new CommonDaoImpl<>();
        String sql = "SELECT E.*, D.NAME DEPT_NAME FROM T_EMS_EMPLOYEE E " +
                "LEFT JOIN T_EMS_DEPARTMENT D ON E.DEPT_ID = D.ID WHERE DEPT_ID=?";
        return cd.queryData(sql, new EmpEncapsulation(), dept_id);
    }

    @Override
    public List<Employee> selectAllEmp() {
        CommonDao<Employee> cd = new CommonDaoImpl<>();
        String sql = "SELECT E.*, D.NAME DEPT_NAME FROM T_EMS_EMPLOYEE E " +
                "LEFT JOIN T_EMS_DEPARTMENT D ON E.DEPT_ID = D.ID";
        return cd.queryData(sql, new EmpEncapsulation());
    }

    @Override
    public int updateEmp(Employee e) {
        CommonDao<Employee> cd = new CommonDaoImpl<>();
        String sql = "UPDATE T_EMS_EMPLOYEE SET " +
                "NAME=?,SEX=?,SALARY=?,BIRTHDAY=?,DEPT_ID=? WHERE ID=?";
        return cd.updateData(sql, e, e.getName(), e.getSex(), e.getSalary(),
                DateUtils.getSqlDate(e.getBirthday()), e.getDept().getId(), e.getId());
    }

    @Override
    public int deleteEmp(Employee e) {
        CommonDao<Employee> cd = new CommonDaoImpl<>();
        String sql = "DELETE FROM T_EMS_EMPLOYEE WHERE ID=?";
        return cd.updateData(sql, e, e.getId());
    }

    @Override
    public int addEmp(Employee e) {
        CommonDao<Employee> cd = new CommonDaoImpl<>();
        String sql = "INSERT INTO T_EMS_EMPLOYEE VALUES (T_EMS_SEQ.nextval,?,?,?,?,?)";
        int result = cd.updateData(sql, e, e.getName(), e.getSex(), e.getSalary(),
                DateUtils.getSqlDate(e.getBirthday()), e.getDept().getId());

        // 查询创建出用户的 ID 并
        sql = "SELECT T_EMS_SEQ.currval FROM dual";
        try {
            ResultSet rs = JdbcUtils.getConnection().prepareStatement(sql).executeQuery();
            if (rs.next()) e.setId(rs.getInt(1));
            rs.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return result;
    }
}
