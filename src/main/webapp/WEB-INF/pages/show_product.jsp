<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
      <%@ page isELIgnored = "false" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product Entry page:</title>
<style>
table, th, td {
  border: 2px solid black;
  border-collapse: collapse;
  text-align: center;
  margin: inherit;
}
</style>
</head>
<body>
<h2><c:out value="${msg}"></c:out></h2>
<h2>Product List :</h2>
<table>
<tr>
<th>Product Id</th>
<th>Product Name</th>
<th>Product Price</th>
<th>Product Quantity</th>
<th>Product Update/Delete</th>
</tr>
<tbody>
<c:forEach var="product" items="${productList}">
<tr>
<td>${product.productId} </td>
<td>${product.name}</td>
<td>${product.price}</td>
<td>${product.quantity}</td>
<td><a href="/SpringMvcApplication/edit_product/${product.productId}"><input type="button" value="Edit"></a>  | <a href="/SpringMvcApplication/delete_product/${product.productId}"><input type="button" value="Delete"/></a></td>
</tr>

</c:forEach>
</tbody>
</table><br>
<a href="/SpringMvcApplication"><button name="">Go To Home</button></a>

</body>
</html>