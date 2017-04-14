<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.4.4
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="cn.gjp0609.ems_v2.entity.Dept" %>
<%@ page import="java.util.*" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="com.opensymphony.xwork2.util.ValueStack" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>emplist</title>
    <link rel="stylesheet" href="<s:url value="/css/style.css" />">
</head>
<%
    pageContext.setAttribute("date", new Date());

    ActionContext cxt = ActionContext.getContext();
    ValueStack vs = cxt.getValueStack();
    List<Dept> depts = (List<Dept>) vs.findValue("depts");

    // 把查询到的部门 ID 与部门名称以 Map 的方式存储在 session 中
    Map<Integer, String> ds = new HashMap<>();
    if (depts == null || depts.size() < 1) {
        System.out.println("None");
    } else {
        for (Dept d : depts) {
            ds.put(d.getId(), d.getName());
        }
    }
    vs.setValue("#session.depts", ds);

%>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p><s:date name="#attr.date" format="yyyy/MM/dd"/></p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="<s:url namespace="/admin" action="queryAllEmp_Admin"/>">主页</a>
                </h1>
            </div>
            <div id="navigation"><span>当前登录：<s:property value="#session.admin.name"/></span></div>
        </div>
        <div id="content">
            <p id="whereami">
            <h1>所有员工</h1></p>
            <table class="table">
                <tr class="table_header">
                    <td>员工 ID</td>
                    <td>员工姓名</td>
                    <td>性别</td>
                    <td>出生日期</td>
                    <td>薪资</td>
                    <td>所在部门</td>
                    <td>操作</td>
                </tr>

                <%--<s:iterator var="dept" value="depts">--%>
                <%--<s:iterator value="#dept.emps" var="emp" step="2">--%>
                <s:iterator var="emp" value="employees">
                    <%--<s:property/>--%>
                    <tr class="row1">
                        <td><s:property value="#emp.id"/></td>
                        <td><s:property value="#emp.name"/></td>
                        <td><s:property value="#emp.sex"/></td>
                        <td><s:date name="birthday" format="yyyy-MM-dd"/></td>
                        <td><s:property value="#emp.salary"/></td>
                        <td align="center">
                            <a href="<s:url namespace="/admin" action="getDeptInfo_Admin" >
                                    <s:param name="deptId" value="#emp.dept.id"/></s:url>">
                                <s:property value="#emp.dept.name"/></a>
                        </td>
                        <td>

                            <a href="<s:url namespace="/admin" action="deleteEmp_Admin"  >
                                    <s:param name="id" value="#emp.id"/>
                                    </s:url>">delete
                            </a>
                            <a href="<s:url namespace="/admin" action="getEmpInfo_Admin" >
                                    <s:param name="id" value="#emp.id"/>
                                    </s:url>">update
                            </a>
                        </td>
                        <input type="ch"/>
                    </tr>
                </s:iterator>
                <%--</s:iterator>--%>
                <%--</s:iterator>--%>
            </table>
            <p>
                <a href="<s:url  namespace="/commons" action="addEmp" />">
                    <input type="button" value="添加用户" title="点击添加用户"/></a>
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            <a href="mailto:gjp0609@163.com">gjp0609@163.com</a>
        </div>
    </div>
</div>

<%--<s:debug/>--%>

</body>
</html>
