<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update Product</title>
</head>
<body>
<form method="post" action="./UpdateProduct.do">
  <label>Id</label>
  <input type="number" name="id" required>
  <label>Name</label>
  <input type="text" name="name" required>
  <label>Price</label>
  <input type="number" name="price" required>

  <input type="submit" value="Update">
</form>
<br>
<p>${message}</p>
<a href="index.jsp">Dashboard</a> <a href="Products.do">View Products</a>

</body>
</html>
