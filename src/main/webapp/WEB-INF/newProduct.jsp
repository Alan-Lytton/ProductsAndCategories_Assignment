<%--
  Created by IntelliJ IDEA.
  User: alanlytton
  Date: 1/12/23
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <title>Add New Product</title>
</head>
<body>
<div class="container d-flex flex-column">
  <h1 class="align-self-center">New Product</h1>
  <a href="/">Home</a>
  <span class="border-1 border border-dark mb-3 mt-3"></span>
  <form:form action="/product/new" method="post" modelAttribute="newProduct">
    <div class="container d-flex flex-column">
      <p class="text-danger"><form:errors path="name"/></p>
      <p>
        <form:label path="name" cssClass="me-3">Name: </form:label>
        <form:input path="name" cssClass="ms-4"/>
      </p>
    </div >
    <div class="container d-flex flex-column">
      <p class="text-danger"><form:errors path="price"/></p>
      <p>
        <div class="input-group">
          <form:label path="price">Price: </form:label>
          <span class="input-group-text ms-5">$</span>
          <form:input path="price" type="number" step=".01"/>
        </div>
      </p>
    </div>
    <div class="container d-flex flex-column">
      <p class="text-danger"><form:errors path="description"/></p>
      <p class="d-flex align-items-center">
        <form:label  path="description">Description: </form:label>
        <form:textarea path="description" cssClass="ms-2"></form:textarea>
      </p>
    </div >
    <input type="submit" value="Submit" class="mt-3 align-self-start btn btn-primary">
  </form:form>

</div>

  <script src="/webjars/jquery/jquery.min.js"></script>
  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
