<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.4.4
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新员工信息</title>
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
            <div id="rightheader"><p><s:date name="#attr.date" format="yyyy/MM/dd"/></p></div>
            <div id="topheader">
                <h1 id="title"><a href="<s:url value="index.jsp"/>">Main</a></h1>
            </div>
            <div id="navigation"></div>
        </div>
        <div id="content">
            <p id="whereami"></p>
            <h1> 更新员工信息 </h1>
            <form action="<s:url namespace="/admin" action="update_Admin" />" method="post">
                <table cellpadding="0" cellspacing="0" border="0" class="form_table">
                    <tr>
                        <td valign="middle" align="right">id:</td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="employee.id"
                                   value="<s:property value="id" />" title="员工 ID 不能修改" readonly/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">name:</td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="employee.name"
                                   value="<s:property value="name" />" title="员工姓名"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">sex:</td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="employee.sex"
                                   value="<s:property value="sex" />" title="员工性别"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">salary:</td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="employee.salary"
                                   value="<s:property value="salary" />" title="员工薪资"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">birthday:</td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="employee.birthday"
                                   value="<s:property value="birthday" />" title="员工生日"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">dept id:</td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="employee.dept.id"
                                   value="<s:property value="dept.id" />" title="员工所在部门"/>
                        </td>
                    </tr>
                </table>
                <p><input type="submit" value="确认"/></p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg"><a href="mailto:gjp0609@163.com">gjp0609@163.com</a></div>
    </div>
</div>
<%--<s:debug/>--%>
</body>

