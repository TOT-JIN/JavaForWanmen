<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Data Apllication Lab!!</title>
</head>
<body>
<H1>Welcome ${name}</H2>
<div>
Here is Products
<ol>
<c:forEach items="${products}" var="product">
   <li>${product.title}:${product.price}</li>
</c:forEach>
</ol>
</div>
</body>
</html>