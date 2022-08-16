<%@ page import="com.shamel.crudapplication.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: c
  Date: 8/16/2022
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <%List<Product> products =(List<Product>)request.getAttribute("products");  %>
    <%for (Product product : products ) {%>
    <tr>
    <td><%= product.getId()%></td>
    <td><%= product.getName()%></td>
    <td><%= product.getPrice()%>$</td>

    </tr>
    <%}%>
</table>
<a href="index.jsp">Dashboard</a>

</body>

</html>
