<%--
  Created by IntelliJ IDEA.
  User: alanlytton
  Date: 1/12/23
  Time: 12:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <title>Add Category to Product</title>
</head>
<body>
<div class="container d-flex flex-column">
    <h1 class="align-self-center"><c:out value="${product.name}"/></h1>
    <a href="/">Home</a>
    <span class="border-1 border border-dark mb-3 mt-3"></span>
    <div class="container d-flex flex-column">
        <h2>Categories:</h2>
        <ul>
            <c:forEach var="category" items="${addedCategories}">
                <li><c:out value="${category.name}"/></li>
            </c:forEach>
        </ul>
    </div>
    <span class="border-1 border border-dark mb-3 mt-3"></span>
    <form:form action="/product/${product.id}" method="post" modelAttribute="addCategory">
        <div class="container d-flex flex-column">
            <p class="text-danger"><form:errors path="id"/></p>
            <p>
                <form:label path="id" cssClass="me-3">Add Category: </form:label>
                <form:select path="id" cssClass="ms-4">
                    <c:forEach var="category" items="${availableCategories}">
                        <form:option value="${category.id}" path="id">
                            <c:out value="${category.name}"/>
                        </form:option>
                    </c:forEach>
                </form:select>
            </p>
        </div>
        <input type="submit" value="Add" class="mt-3 align-self-start btn btn-primary">
    </form:form>
</div>

<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
