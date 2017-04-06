package cn.gjp0609.ems_v2.action;

import cn.gjp0609.ems_v2.utils.SecurityUtils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * Created by gjp06 on 17.4.6.
 */
public class UtilsAction extends ActionSupport {
    public String getVCode() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse resp = ServletActionContext.getResponse();

        // 接收参数，得到申请验证码的标识以区分不同页面
        String name = req.getParameter("name");
        // 获取指定长度的随机码
        String vcode = SecurityUtils.getRandomCode(4);
        // 将有标识的随机码存入 session 作用域
        req.getSession().setAttribute(name + "VCode", vcode);
        // 用获取的随机码生成验证码图片
        BufferedImage img = SecurityUtils.getVerifiyImg(vcode, 40, 150);
        // 将图片输出到调用位置
        ImageIO.write(img, "png", resp.getOutputStream());
        // 不跳转页面
        return null;
    }
}
