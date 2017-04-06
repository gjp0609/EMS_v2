<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="cn.gjp0609.ems_v2.entity.Dept" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.4.4
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<html>
<head>
    <title>emplist</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url context='${pageContext.request.contextPath}' value='/css/style.css'/>"/>
</head>
<%
    Date currectDate = new Date();

    Dept dept = (Dept) request.getAttribute("dept");
    pageContext.setAttribute("dept", dept);
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
                dept id: ${dept.id} &nbsp;&nbsp;&nbsp;&nbsp;
                dept name: ${dept.name}
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>ID</td>
                    <td>Name</td>
                    <td>Sex</td>
                    <td>Birthday</td>
                    <td>salary</td>
                    <td>Operation</td>
                </tr>


                <c:forEach var="emp" items="${dept.emps}">
                    <tr class="row1">
                        <td>${emp.id}</td>
                        <td>${emp.name}</td>
                        <td>${emp.sex}</td>
                        <td>${emp.salary}</td>
                        <td>${emp.birthday}</td>
                        <td>
                                <%-- 删除及更新员工 --%>
                            <a href="<c:url context="${pageContext.request.contextPath}"
                                    value="/admin/deleteEmp_Admin.action?id=${emp.id}" />">delete</a>&nbsp;
                            <a href="<c:url context="${pageContext.request.contextPath}"
                                    value="/admin/getEmpInfo_Admin.action?id=${emp.id}" />">update</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <p>
                <input type="button" class="button" value="Add Employee"
                       onclick="location='<c:url context="${pageContext.request.contextPath}" value="/addEmp.jsp"/>'"/>
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            <a href="mailto:gjp0609@163.com">gjp0609@163.com</a>
        </div>
    </div>
</div>
</body>
</html>
</body>
</html>
