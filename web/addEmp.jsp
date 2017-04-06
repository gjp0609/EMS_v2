<%@ page import="java.util.Date" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.4.4
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add Emp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="css/style.css"/>
</head>
<%
    Date currectDate = new Date();
    Map<Integer, String> ds = (Map<Integer, String>) session.getAttribute("ds");
    pageContext.setAttribute("ds", ds);
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
                add Emp info:
            </h1>
            <form action="<c:url context="${pageContext.request.contextPath}"
                value="/admin/addEmp_Admin.action"/>" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            name:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="employee.name"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            sex:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="employee.sex" maxlength="1"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            birthday:
                        </td>
                        <td valign="middle" align="left">
                            <input type="date" class="inputgri" name="employee.birthday"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            salary:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="employee.salary"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            dept id:
                        </td>
                        <td valign="middle" align="left">
                            <select name="employee.dept.id">
                                <c:forEach var="dept" items="${ds}">
                                    <option value="${dept.key}"> ${dept.value} </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>

                </table>
                <p>
                    <input type="submit" class="button" value="Confirm"/>
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
</html>