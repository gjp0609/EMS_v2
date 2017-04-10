package cn.gjp0609.ems_v2.action;

import cn.gjp0609.ems_v2.utils.SecurityUtils;
import org.apache.struts2.ServletActionContext;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Created by gjp06 on 17.4.6.
 */
public class UtilsAction extends BaseAction {
    // 接收参数，得到申请验证码的标识以区分不同页面
    private String name;

    public String getVCode() throws Exception {
        // 获取指定长度的随机码
        String vcode = SecurityUtils.getRandomCode(4);
        // 将有标识的随机码存入 session 作用域
        setSessionValue(name + "VCode", vcode);
        // 用获取的随机码生成验证码图片
        BufferedImage img = SecurityUtils.getVerifiyImg(vcode, 40, 150);
        // 将图片输出到调用位置
        ImageIO.write(img, "png", ServletActionContext.getResponse().getOutputStream());
        // 不跳转页面
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
