package cn.gjp0609.ems_v2.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * Created by gjp06 on 17.4.10.
 */
public class BaseAction extends ActionSupport {
    private ValueStack vs;

    BaseAction() {
        this.vs = ActionContext.getContext().getValueStack();
    }

    public void setSessionValue(String key, Object value) {
        vs.setValue("#session." + key, value);
    }

    public Object getSessionValue(String key) {
        return vs.findValue("#session." + key);
    }

    public void setApplicationValue(String key, Object value) {
        vs.setValue("#application." + key, value);
    }

    public Object getApplicationValue(String key) {
        return vs.findValue("#application." + key);
    }
    
}
