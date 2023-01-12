<%--
  Created by IntelliJ IDEA.
  User: alanlytton
  Date: 1/12/23
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <title>Add New category</title>
</head>
<body>
<div class="container d-flex flex-column">
    <h1 class="align-self-center">New Category</h1>
    <a href="/">Home</a>
    <span class="border-1 border border-dark mb-3 mt-3"></span>
    <form:form action="/category/new" method="post" modelAttribute="newCategory">
        <div class="container d-flex flex-column">
            <p class="text-danger"><form:errors path="name"/></p>
            <p>
                <form:label path="name" cssClass="me-3">Category Name: </form:label>
                <form:input path="name" cssClass="ms-4"/>
            </p>
        </div>
        <input type="submit" value="Submit" class="mt-3 align-self-start btn btn-primary">
    </form:form>
</div>

<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
