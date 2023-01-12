<%--
  Created by IntelliJ IDEA.
  User: alanlytton
  Date: 1/12/23
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <title>Dashboard</title>
</head>
<body>
<div class="container d-flex flex-column">
    <h1 class="align-self-center">Home Page</h1>
    <a href="/product/new" class="mb-3">Add new Product</a>
    <a href="/category/new" class="mb-3">Add new Category</a>
    <span class="border border-1"></span>
    <table class="table mt-3">
        <thead>
        <tr>
            <th>Products</th>
            <th>Categories</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <ul>
                    <c:forEach var="product" items="${products}">
                        <li class="mb-2"><a href="/product/${product.id}"><c:out value="${product.name}"/></a></li>
                    </c:forEach>
                </ul>
            </td>
            <td>
                <ul>
                    <c:forEach var="category" items="${categories}">
                        <li class="mb-2"><a href="/category/${category.id}"><c:out value="${category.name}"/></a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        </tbody>
    </table>

</div>

<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
