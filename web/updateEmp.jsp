<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cn.gjp0609.ems_v2.entity.Employee" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.4.4
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update Emp</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>"/>
</head>
    <%
    Date currectDate = new Date();
    Employee employee = (Employee) request.getAttribute("employee");
    pageContext.setAttribute("emp", employee);
%>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    <fmt:formatDate value="<%=currectDate%>" pattern="yyyy/MM/dd"/>
                    <br/>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="<c:url context="${pageContext.request.contextPath}" value="/empList.jsp"/>">Main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                update Emp info:
            </h1>
            <form action="<c:url context="${pageContext.request.contextPath}"
                value="/admin/update_Admin.action"/>" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            id:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="employee.id" value="${emp.id}" readonly/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            name:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="employee.name" value="${emp.name}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            sex:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="employee.sex" value="${emp.sex}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            salary:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="employee.salary" value="${emp.salary}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            birthday:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="employee.birthday" value="${emp.birthday}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            dept id:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="employee.dept.id" value="${emp.dept.id}"/>
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" value="Confirm"/>
                </p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            <a href="mailto:gjp0609@163.com">gjp0609@163.com</a>
        </div>
    </div>
</div>
</body>

