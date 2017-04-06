package cn.gjp0609.ems_v2.entity;

/**
 * Created by gjp06 on 17.4.3.
 */
public class Admin {
    private String name;
    private String password;
    private String salt;

    public Admin(String name, String password, String salt) {
        this.name = name;
        this.password = password;
        this.salt = salt;
    }

    public Admin() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
