<%--
  Created by IntelliJ IDEA.
  User: joo
  Date: 2020-07-21
  Time: 오전 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>등록 삭제</title>
</head>
<body>
<form action="DeleteServlet" method="post">
    <table width="500" align="center" border="1">
        <tr hieght="50" align="center">
            <td width="150" align="center" colspan="2"><h2 align="center">서적 삭제</h2></td>
        </tr>
        <tr hieght="50" align="center">
            <td width="150" align="center">서적 아이디</td>
            <td width="150" align="center"><input type="number" name="BId" size="30"></td>
        </tr>
        <tr hieght="50" align="center">
            <td width="150" align="center" colspan="2"><input type="submit" value="삭제"></td>
        </tr>
    </table>
</form>
</body>
</html>
