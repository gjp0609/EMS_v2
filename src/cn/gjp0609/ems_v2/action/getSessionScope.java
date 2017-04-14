package cn.gjp0609.ems_v2.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 把对象存入 session 的 6 种方式
 * Created by gjp06 on 17.4.12.
 */
public class getSessionScope extends ActionSupport implements SessionAware {

    @Override
    public void setSession(Map<String, Object> map) {
        // 1. 实现 SessionAware 接口，在 setSession() 方法中存储内容
        map.put("obj1", new Object());
    }

    public void getSession() {
        // 2 先从 ActionContext 中得到 ValueStack, 再使用 setValue() 方法
        ActionContext.getContext().getValueStack().setValue("#session.obj2", new Object());
        ActionContext.getContext().getValueStack().getContext().put("#session.obj2", new Object());
        // 3
        ActionContext.getContext().getSession().put("obj3", new Object());
        // 4
        ActionContext.getContext().getContextMap().put("#session.obj4", new Object());
        // 5
        ServletActionContext.getRequest().getSession().setAttribute("obj5", new Object());
        // 6
        ((HttpSession) ActionContext.getContext().getValueStack().findValue("session")).setAttribute("obj6", new Object());

        HttpServletRequest request1 = ServletActionContext.getRequest();
        HttpServletResponse response1 = ServletActionContext.getResponse();
        HttpServletRequest request2 = (HttpServletRequest) ServletActionContext.getPageContext().getRequest();
        HttpServletResponse response2 = (HttpServletResponse) ServletActionContext.getPageContext().getResponse();

    }
}
