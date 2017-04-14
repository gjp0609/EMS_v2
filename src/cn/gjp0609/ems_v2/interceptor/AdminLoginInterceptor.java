package cn.gjp0609.ems_v2.interceptor;

import cn.gjp0609.ems_v2.entity.Admin;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * Created by gjp06 on 17.4.10.
 */
public class AdminLoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("过滤器开始");

        ValueStack vs = actionInvocation.getStack();
        Admin admin = (Admin) vs.findValue("#session.admin");
        if (admin != null) {
            System.out.println("过滤器invoke");
            actionInvocation.invoke();
            System.out.println("过滤器invoked");
        }
        System.out.println("过滤器ret");
        return "login";
    }
}
