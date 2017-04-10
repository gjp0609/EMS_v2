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

    List<Dept> depts = (List<Dept>) vs.peek();
//    List<Dept> deptss = (List<Dept>) request.getAttribute("depts");
//    pageContext.setAttribute("depts", depts);

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
//    session.setAttribute("dps", ds);

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
                    <a href="<s:url namespace="/admin" action="queryAllEmp_Admin"/>">Main</a>
                </h1>
            </div>
            <div id="navigation"></div>
        </div>
        <div id="content">
            <p id="whereami"></p>
            <h1> Welcome! </h1>
            <table class="table">
                <tr class="table_header">
                    <td>ID</td>
                    <td>Name</td>
                    <td>Sex</td>
                    <td>Birthday</td>
                    <td>salary</td>
                    <td>Dept Name</td>
                    <td>Operation</td>
                </tr>

                <s:iterator var="dept">
                    <s:iterator value="#dept.emps" var="emp">
                        <tr class="row1">
                            <td><s:property value="#emp.id"/></td>
                            <td><s:property value="#emp.name"/></td>
                            <td><s:property value="#emp.sex"/></td>
                            <td><s:property value="#emp.birthday"/></td>
                            <td><s:property value="#emp.salary"/></td>
                            <td>
                                <a href="<s:url namespace="/admin" action="getDeptInfo_Admin" >
                                    <s:param name="id" value="#emp.dept.id"/></s:url>">
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
                        </tr>
                    </s:iterator>
                </s:iterator>
            </table>
            <p>
                <a href="<s:url value="/addEmp.jsp" />"><input type="button" value="addEmp" title="点击添加用户"/></a>
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
