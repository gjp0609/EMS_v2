<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.4.4
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 添加员工</title>
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
                <h1 id="title"><a href="<s:url value="index.jsp"/>">&diamondsuit; 主页 &diamondsuit;</a></h1></div>
            <div id="navigation"></div>
        </div>
        <div id="content">
            <p id="whereami"></p>
            <h1>添加员工信息 </h1>
            <form action="<s:url namespace="/admin" action="addEmp_Admin"/>" method="post">
                <table cellpadding="0" cellspacing="0" border="1" class="form_table">
                    <tr>
                        <td valign="middle" align="right">姓名：</td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="employee.name" title="此处输入员工姓名"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">性别：</td>
                        <td valign="middle" align="left">
                            <s:radio style="display='inline'" list="%{ {'M','F'} }" name="employee.sex" value="M"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">出生日期：</td>
                        <td valign="middle" align="left">
                            <input type="date" class="inputgri" name="employee.birthday" title="此处输入员工生日"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">工资：</td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="employee.salary" title="此处输入员工工资"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">部门：</td>
                        <td valign="middle" align="left">
                            <select name="employee.dept.id" title="此处输入员工部门">
                                <s:iterator value="#session.depts" var="dept">
                                    <option value="<s:property value="#dept.key"/>">
                                        <s:property value="#dept.value"/>
                                    </option>
                                </s:iterator>
                            </select>
                        </td>
                    </tr>
                </table>
                <p><input type="submit" class="button" value="Confirm"/></p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            <a href="mailto:gjp0609@163.com">gjp0609@163.com</a>
        </div>
    </div>
</div>
<s:debug/>
</body>
</html>