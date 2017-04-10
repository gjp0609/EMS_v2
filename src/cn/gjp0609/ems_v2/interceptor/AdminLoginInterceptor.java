package cn.gjp0609.ems_v2.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * Created by gjp06 on 17.4.10.
 */
public class AdminLoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        ValueStack vs = actionInvocation.getStack();
        actionInvocation.invoke();

        return null;
    }
}
