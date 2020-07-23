<%@ page import="com.servlet.BookServlet" %><%--
  Created by IntelliJ IDEA.
  User: joo
  Date: 2020-07-21
  Time: 오전 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>책 등록</title>
  </head>
  <body>
  <form action="BookServlet" method="post">
    <table width="500" align="center" border="1">
      <tr hieght="50" align="center">
        <td width="150" align="center" colspan="2"><h2 align="center">서적 등록</h2></td>
      </tr>
      <tr hieght="50" align="center">
        <td width="150" align="center">서적명</td>
        <td width="150" align="center"><input type="text" name="Bname" size="30"></td>
      </tr>
      <tr hieght="50" align="center">
        <td width="150" align="center">서적 위치</td>
        <td width="150" align="center"><input type="text" name="Bloc" size="30"></td>
      </tr>
      <tr hieght="50" align="center">
        <td width="150" align="center"><input type="submit" value="등록"></td>
        <td width="150" align="center"><a href="Delete.jsp">서적삭제로 이동</td>
      </tr>
    </table>
  </form>
  </body>
</html>
