package cn.gjp0609.ems_v2.action;

import cn.gjp0609.ems_v2.entity.Admin;
import cn.gjp0609.ems_v2.entity.Dept;
import cn.gjp0609.ems_v2.entity.Employee;
import cn.gjp0609.ems_v2.service.AdminService;
import cn.gjp0609.ems_v2.service.EmpService;
import cn.gjp0609.ems_v2.service.Impl.AdminServiceImpl;
import cn.gjp0609.ems_v2.service.Impl.DeptServiceImpl;
import cn.gjp0609.ems_v2.service.Impl.EmpServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static org.apache.struts2.ServletActionContext.getRequest;

/**
 * Action
 * Created by gjp06 on 17.4.6.
 */
public class AdminAction extends ActionSupport {
    private HttpSession session = getRequest().getSession();
    private HttpServletResponse response = ServletActionContext.getResponse();
    private HttpServletRequest request = getRequest();

    private Employee employee;
    private String name;
    private String pwd;
    private String vcode;
    private Integer id;


    public String login() throws Exception {

        // 从 session 中取得生成的随机码
        String adminLoginvcode = (String) session.getAttribute("adminLoginVCode");
        // 判断用户输入的验证码与得到的随机码是否一致
        if (vcode != null && !vcode.isEmpty() && vcode.equalsIgnoreCase(adminLoginvcode)) {
            AdminService as = new AdminServiceImpl();
            // 调用管理员登陆业务进行登陆
            Admin admin = as.login(name, pwd);
            if (admin != null) {
                // 销毁 session 中的验证码
                session.removeAttribute("adminLoginvcode");
                // 把成功登陆的管理员对象存入 session 作用域
                session.setAttribute("admin", admin);
                // 新建 cookie 对象
                Cookie ck = new Cookie("username", name);
                // 设置 cookie 存活时间，保证登录后 7 天内记住管理员登录名
                ck.setMaxAge(3600 * 24 * 7);
                // 设置 cookie 路径，让 index.jsp 可以取到此 cookie
                ck.setPath("/ems_v2");
                // 将 cookie 添加到浏览器
                response.addCookie(ck);
                // 登陆成功则转发至查询用户页面
                return SUCCESS;
            }
        }
        // 验证码验证不成功则跳转至登陆页面
        return LOGIN;
    }

    /**
     * @return <b>LOGIN</b> 登录页面（index.jsp）<br />
     * <b>NONE</b> 注册页面（signUp.jsp）
     */
    public String register() throws Exception {
        String adminSignUpVCode = (String) session.getAttribute("adminLoginVCode");
        if (vcode != null && !vcode.isEmpty() && vcode.equalsIgnoreCase(adminSignUpVCode)) {
            // 封装 admin 对象
            Admin admin = new Admin();
            admin.setName(name);
            admin.setPassword(pwd);
            // 调用 AdminService 插入管理员用户
            AdminService as = new AdminServiceImpl();
            int result = as.signUp(admin);
            // 判断是否注册成功
            if (result == 1) {
                // 注册成功，把 admin 对象存入 session 作用域
                session.setAttribute("admin", admin);
                // 转发至登陆页面
                return LOGIN;
            }
        }
        // 注册失败、验证码不匹配，跳转至注册页面
        return NONE;
    }

    public String addEmp() throws Exception {
        employee.setDept(new DeptServiceImpl().queryDeptById(employee.getDept().getId()));
        // 调用 EmpService 将封装好的对象插入数据库
        EmpService es = new EmpServiceImpl();
        es.addEmp(employee);
        // 转发至查询用户页面
        return SUCCESS;
    }

    public String deleteEmp() throws Exception {
        // 接收参数
        Integer id = Integer.valueOf(request.getParameter("id"));
        // 调用 EmpService 删除指定员工
        EmpService es = new EmpServiceImpl();
        es.deleteEmp(es.queryEmpById(id));
        // 无论是否成功都转发至查询界面
        return SUCCESS;
    }

    public String updateEmp() throws Exception {
        employee.setDept(new DeptServiceImpl().queryDeptById(employee.getDept().getId()));
        EmpService es = new EmpServiceImpl();
        es.updateEmp(employee);
        return SUCCESS;
    }

    public String queryAllEmp() throws Exception {
        // 创建部门集合，存入所有部门；每个部门中有 employee 集合，存入所有该部门员工
        // 调用 DeptServiceImpl 获得部门集合
        List<Dept> depts = new DeptServiceImpl().queryAllDept();
        // 将部门集合存入 request 作用域中
        request.setAttribute("depts", depts);
        // 跳转到查询所有员工页面
        return SUCCESS;
    }

    public String getDeptInfo() throws Exception {
        Dept dept = new DeptServiceImpl().queryDeptById(id);
        if (dept == null) {
            // 部门不存在则跳转至主查询界面
            return SUCCESS;
        } else {
            // 部门存在，将查得的部门对象存入 request 作用域
            request.setAttribute("dept", dept);
            // 转发至查询部门信息界面
            return "dept";
        }
    }

    public String getEmpInfo() throws Exception {
        Employee employee = new EmpServiceImpl().queryEmpById(id);
        // 将对象保存到 request 作用域中
        request.setAttribute("employee", employee);
        // 跳转至更新用户页面
        return "update";
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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
}
