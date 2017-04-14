package cn.gjp0609.ems_v2.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门表实体类
 * ID * NAME
 * Created by gjp06 on 17.4.1.
 */
public class Dept {

    private Integer id;
    private String name;
    private List<Employee> emps = new ArrayList<>();

    public Dept() {
    }

    public Dept(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emps=" + emps.toString() +
                '}';
    }
}
