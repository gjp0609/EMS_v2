<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.4.3
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员注册</title>
    <link rel="stylesheet" href="<s:url value="/css/style.css" />">
</head>
<%
    //在 pageContext 中存入当前时间
    pageContext.setAttribute("date", new Date());
%>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p><s:date name="#attr.date" format="yyyy/MM/dd"/></p>
            </div>
            <div id="topheader">
                <h1 id="title"><a href="<s:url value="index.jsp"/>">Main</a></h1>
            </div>
            <div id="navigation"></div>
        </div>
        <div id="content">
            <p id="whereami"></p>
            <h1> 管理员注册 </h1>
            <form action="<s:url namespace="/admin" action="register_Admin" />" method="post">
                <table cellpadding="0" cellspacing="0" border="0" class="form_table">
                    <tr>
                        <td valign="middle" align="right">用户名:</td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name" title="此处输入用户名"/>
                        </td>
                    </tr>

                    <tr>
                        <td valign="middle" align="right">密码:</td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="pwd" title="此处输入密码"/>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td><img name="adminSignUp" src="<s:url namespace="/admin" action="getVCode">
                                <s:param name="name">adminSignUp</s:param></s:url>"/>"/>
                        </td>
                    </tr>

                    <tr>
                        <td valign="middle" align="right">验证码:</td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="vcode" title="此处输入验证码"/>
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
