<%--
  Created by IntelliJ IDEA.
  User: c
  Date: 8/16/2022
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
    <form method="post" action="./DeleteProduct">
        <input type="number" name="id">
        <input type="submit" value="delete">
    </form>
<br>
<p>${message}</p>
<a href="index.jsp">Dashboard</a> <a href="Products">View Products</a>

</body>
</html>
