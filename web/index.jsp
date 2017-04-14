<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.4.13
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String url = response.encodeRedirectURL(request.getContextPath() + "/commons/welcome.action");
    response.sendRedirect(url);
%>

<%--<s:action name="welcome" namespace="/"/>--%>
</body>
</html>
