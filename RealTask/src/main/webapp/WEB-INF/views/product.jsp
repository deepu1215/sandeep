<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Product Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Product
</h1>

<c:url var="addAction" value="/product/add" ></c:url>

<form:form action="${addAction}" commandName="product">
<table>
	<c:if test="${!empty product.prodName}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="prodName">
				<spring:message text="ProdName"/>
			</form:label>
		</td>
		<td>
			<form:input path="prodName" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="manufacturer">
				<spring:message text="Manufacturer"/>
			</form:label>
		</td>
		<td>
			<form:input path="manufacturer" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="prodPrice">
				<spring:message text="ProdPrice"/>
			</form:label>
		</td>
		<td>
			<form:input path="prodPrice" />
		</td> 
	</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty product.prodName}">
				<input type="submit"
					value="<spring:message text="Edit product"/>" />
			</c:if>
			<c:if test="${empty product.prodName}">
				<input type="submit"
					value="<spring:message text="Add product"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Products List</h3>
<c:if test="${!empty listProducts}">
	<table class="tg">
	<tr>
		<th width="80">Product ID</th>
		<th width="120">Product prodName</th>
		<th width="120">Product manufacturer</th>
		<th width="120">Product price</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listProducts}" var="product">
		<tr>
			<td>${product.id}</td>
			<td>${product.prodName}</td>
			<td>${product.manufacturer}</td>
			<td>${product.prodPrice}</td>
			<td><a href="<c:url value='/edit/${product.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/delete/${product.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
