<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.3.31
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>"/>
</head>

<%

    Date currectDate = new Date();
    Cookie ccc = null;
    Cookie[] cks = request.getCookies();
    if (cks == null || cks.length < 1) {
    } else {
        for (Cookie ck : cks) {
            if (ck.getName().equals("username"))
                ccc = ck;
        }
    }
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
                login
            </h1>
            <form action="<c:url context="${pageContext.request.contextPath}"
                value="/admin/login_Admin.action"/>" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            username:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name"
                                   value="<%=ccc != null ? ccc.getValue() : ""%>"/>
                        </td>
                    </tr>

                    <tr>
                        <td valign="middle" align="right">
                            password:
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="pwd"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">

                        </td>
                        <td valign="middle" align="left">
                            <img src="<c:url value='/admin/getVCode.action?name=adminLogin'/>">
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            verify code:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="vcode"/>
                        </td>
                    </tr>
                    <tr>
                        <td><a href="<c:url context="${pageContext.request.contextPath}" value="/signUp.jsp"/>">
                            <input type="button" value="SignUp"/>
                        </a></td>
                        <td><input type="submit" value="Submit &raquo;"/></td>
                    </tr>
                </table>
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