package cn.gjp0609.ems_v2.entity;

import java.util.Date;

/**
 * 员工表实体类
 * ID * NAME * SEX * SALARY * BIRTHDAY * DEPT_ID
 * Created by gjp06 on 17.3.31.
 */
public class Employee {
    private Integer id;
    private String name;
    private String sex;
    private Double salary;
    private Date birthday;
    private Dept dept;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{ " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                ", dept='" + dept.getName() +
                "' }";
    }

    public Employee(Integer id, String name, String sex, Double salary, Date birthday, Dept dept) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.salary = salary;
        this.birthday = birthday;
        this.dept = dept;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
