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
</head>
<body>
<h2><c:out value="${msg}"></c:out></h2>
<c:if test="${prodBean.productId==0}">
<h2>Add New Product :</h2>
<form:form modelAttribute="prodBean" action="/SpringMvcApplication/save_product">
<form:hidden path="productId" />
Enter Product Name : <form:input path="name"/> <br><br>
Enter Product Price : <form:input path="price"/><br><br>
Enter Product Quantity : <form:input path="quantity"/><br><br>
<input type="submit" name="Save" value="Save Product"/>
</form:form><br>
<a href="/SpringMvcApplication"><button name="">Go To Home</button></a>

</c:if>
<c:if test="${prodBean.productId!=0}">
<h2>Update Product :</h2>
<form:form modelAttribute="prodBean" action="/SpringMvcApplication/save_updated_product">
<form:hidden path="productId" />
Enter Product Name : <form:input path="name"/> <br><br>
Enter Product Price : <form:input path="price"/><br><br>
Enter Product Quantity : <form:input path="quantity"/><br><br>
<input type="submit" name="Save" value="Update Product"/>
</form:form><br>
<c:if test="${productId!=0}">
<a href="/SpringMvcApplication/show_product_list"><button name="">Back To List</button></a>
</c:if>
</c:if>
</body>
</html>