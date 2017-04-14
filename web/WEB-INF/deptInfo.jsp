<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.4.4
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门信息</title>
    <link rel="stylesheet" href="<s:url value="/css/style.css" />">
</head>
<%
    //在 pageContext 中存入当前时间
    pageContext.setAttribute("date", new Date());
//    System.out.println(ActionContext.getContext().getValueStack().peek());
%>
<body>
<%--<s:debug/>--%>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader"><p><s:date name="#attr.date" format="yyyy/MM/dd"/></p></div>
            <div id="topheader">
                <h1 id="title"><a href="<s:url value="login.jsp"/>">主页</a></h1>
            </div>
            <div id="navigation">
                <a href="<s:url namespace="/admin" action="queryAllEmp_Admin"/>">&curvearrowleft;返回</a>
                <span>当前登录：<s:property value="#session.admin.name"/></span>
            </div>
        </div>
        <div id="content">
            <p id="whereami"></p>
            <h1>
                部门编号：<s:property value="id"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                部门名称：<s:property value="name"/>
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>员工 ID</td>
                    <td>员工姓名</td>
                    <td>性别</td>
                    <td>出生日期</td>
                    <td>薪资</td>
                </tr>

                <s:iterator value="emps" var="emp">
                    <tr class="row1">
                        <td><s:property value="#emp.id"/></td>
                        <td><s:property value="#emp.name"/></td>
                        <td><s:property value="#emp.sex"/></td>
                        <td><s:property value="#emp.salary"/></td>
                        <td><s:date name="#emp.birthday" format="yyyy-MM-dd"/></td>
                    </tr>
                </s:iterator>
            </table>
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

