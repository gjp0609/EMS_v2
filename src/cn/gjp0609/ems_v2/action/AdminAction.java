package cn.gjp0609.ems_v2.action;

import cn.gjp0609.ems_v2.entity.Admin;
import cn.gjp0609.ems_v2.entity.Dept;
import cn.gjp0609.ems_v2.entity.Employee;
import cn.gjp0609.ems_v2.service.EmpService;
import cn.gjp0609.ems_v2.service.Impl.AdminServiceImpl;
import cn.gjp0609.ems_v2.service.Impl.DeptServiceImpl;
import cn.gjp0609.ems_v2.service.Impl.EmpServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import java.util.List;


/**
 * Action
 * Created by gjp06 on 17.4.6.
 */
public class AdminAction extends BaseAction {
    // 验证码
    private String vcode;
    // 管理员对象
    private Admin admin;
    // 员工对象，在增加及更新用户时使用
    private Employee employee;
    // 在删除用户、查询部门和员工信息时使用
    private Integer id;

    public String login() throws Exception {

        // 从 session 中取得生成的随机码
        String adminLoginVCode = (String) getSessionValue("adminLoginVCode");

        // 判断用户输入的验证码与得到的随机码是否一致
        if (vcode != null && !vcode.isEmpty() && vcode.equalsIgnoreCase(adminLoginVCode)) {
            // 调用管理员登陆业务进行登陆
            admin = new AdminServiceImpl().login(admin.getName(), admin.getPassword());
            // 判断管理员是否登陆成功
            if (admin != null) {
                // 销毁 session 中的验证码
                setSessionValue("", adminLoginVCode);
                // 把成功登陆的管理员对象存入 session 作用域
                setSessionValue("admin", admin);
                // 新建 cookie 对象
                Cookie ck = new Cookie("username", admin.getName());
                // 设置 cookie 存活时间，保证登录后 7 天内记住管理员登录名
                ck.setMaxAge(3600 * 24 * 7);
                // 设置 cookie 路径，让 index.jsp 可以取到此 cookie
                ck.setPath("/ems_v2");
                // 将 cookie 添加到浏览器
                ServletActionContext.getResponse().addCookie(ck);
                // 登陆成功则转发至查询用户页面（empList.jsp）
                return SUCCESS;
            }
        }
        // 登陆不成功则跳转至登陆页面
        return LOGIN;
    }

    /**
     * @return <i>login</i> 登录页面（index.jsp）<br />
     * <i>none</i> 注册页面（signUp.jsp）
     */
    public String register() throws Exception {
        // 从 session 中取出生成的随机码
        String adminSignUpVCode = (String) getSessionValue("adminSignUpVCode");
        // 判断用户输入的验证码与得到的随机码是否一致
        if (vcode != null && !vcode.isEmpty() && vcode.equalsIgnoreCase(adminSignUpVCode)) {
            // 调用 AdminService 插入管理员用户
            int result = new AdminServiceImpl().signUp(admin);
            // 判断是否注册成功
            if (result == 1) {
                // 转发至登陆页面
                return LOGIN;
            }
        }
        // 注册失败、验证码不匹配，跳转至注册页面
        return NONE;
    }

    /**
     * @return <i>success</i> -> empList.jsp
     */
    public String addEmp() throws Exception {
        employee.setDept(new DeptServiceImpl().queryDeptById(employee.getDept().getId()));
        // 调用 EmpService 将封装好的对象插入数据库
        new EmpServiceImpl().addEmp(employee);
        // 转发至查询用户页面
        return SUCCESS;
    }

    /**
     * @return <i>success</i> -> empList.jsp
     */
    public String deleteEmp() throws Exception {
        // 调用 EmpService 删除指定员工
        EmpService es = new EmpServiceImpl();
        es.deleteEmp(es.queryEmpById(id));
        // 无论是否成功都转发至查询界面
        return SUCCESS;
    }

    /**
     * @return <i>success</i> -> empList.jsp
     */
    public String updateEmp() throws Exception {
        employee.setDept(new DeptServiceImpl().queryDeptById(employee.getDept().getId()));
        new EmpServiceImpl().updateEmp(employee);
        return SUCCESS;
    }

    public String queryAllEmp() throws Exception {
        // 创建部门集合，存入所有部门；每个部门中有 employee 集合，存入所有该部门员工
        // 调用 DeptServiceImpl 获得部门集合
        List<Dept> depts = new DeptServiceImpl().queryAllDept();
        // 将部门集合存入 Root 区中
        pushValue(depts);
        // 跳转到查询所有员工页面
        return SUCCESS;
    }

    public String getDeptInfo() throws Exception {
        Dept dept = new DeptServiceImpl().queryDeptById(id);
        if (dept == null) {
            // 部门不存在则跳转至主查询界面
            return SUCCESS;
        } else {
            // 部门存在，将查得的部门对象存入 ROOT 区
            pushValue(dept);
            // 转发至查询部门信息界面
            return "dept";
        }
    }

    public String getEmpInfo() throws Exception {
        employee = new EmpServiceImpl().queryEmpById(id);
        // 将对象保存到 request 作用域中
        pushValue(employee);
        // 跳转至更新用户页面
        return "update";
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
