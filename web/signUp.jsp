<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.4.3
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signUp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<%
    Date currectDate = new Date();
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
                    <a href="<c:url context="${pageContext.request.contextPath}" value="/index.jsp"/>">Main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                注册管理员
            </h1>
            <form action="<c:url context='${pageContext.request.contextPath}' value='/admin/register_Admin.action'/>"
                  method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            用户名:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name"/>
                        </td>
                    </tr>

                    <tr>
                        <td valign="middle" align="right">
                            密码:
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="pwd"/>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td><img name="adminSignUp"
                                 src="<c:url context="${pageContext.request.contextPath}"
                                    value="/admin/getVCode.action?name=adminSignUp"/>"/>
                        </td>
                    </tr>

                    <tr>
                        <td valign="middle" align="right">
                            验证码:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="vcode"/>
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" value="Submit &raquo;"/>
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
