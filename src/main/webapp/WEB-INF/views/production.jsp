<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Production</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="row">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li><a href="/admin/person">Person</a></li>
                    <li><a href="/admin/category">Category</a></li>
                    <li><a href="/admin/description">Description</a></li>
                    <li class="active"><a href="/admin/production">Product</a>
                        <span class="sr-only">(current)</span></li>
                    <li><a href="/admin/basket">Basket</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="row">
    <div class="col-md-3 col-xs-12"></div>
    <div class="col-md-7 col-xs-12">
        <div class="row">
            <div class="col-md-12 col-xs-12">
                <form:form class="form-horizontal" action="/admin/production" method="POST" modelAttribute="production">
                    <div class="form-group">
                        <label for="category" class="col-sm-2 control-label">Category</label>
                        <div class="col-sm-10">
                            <form:select path="category" class="form-control" items="${categories}" itemLabel="presentation" itemValue="id" id="category"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="description" class="col-sm-2 control-label">Description</label>
                        <div class="col-sm-10">
                            <form:select path="description" class="form-control" items="${descriptions}" itemLabel="presentation" itemValue="id" id="description"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Price</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" path="price" id="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Deleted</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" path="is_deleted" id="name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Save</button>
                            <a class="btn btn-primary" href="/admin/production/cancel">Cancel</a>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2 col-xs-2"><h3>Category</h3></div>
            <div class="col-md-2 col-xs-2"><h3>Price</h3></div>
            <div class="col-md-2 col-xs-2"><h3>Description</h3></div>
            <div class="col-md-2 col-xs-2"><h3>Deleted</h3></div>
            <div class="col-md-2 col-xs-2"><h3>Update</h3></div>
            <div class="col-md-2 col-xs-2"><h3>Delete</h3></div>
        </div>
        <c:forEach items="${productions}" var="product">
            <div class="row">
                <div class="col-md-2 col-xs-2">${product.category.presentation} </div>
                <div class="col-md-2 col-xs-2">${product.price}</div>
                <div class="col-md-2 col-xs-2">${product.description.presentation}</div>
                <div class="col-md-2 col-xs-2">${product.is_deleted}</div>
                <div class="col-md-2 col-xs-2"><a class="btn btn-warning" href="/admin/production/update/${production.id}">update</a></div>
                <div class="col-md-2 col-xs-2"><a class="btn btn-danger" href="/admin/production/delete/${production.id}">delete</a></div>
            </div>
        </c:forEach>
    </div>
    <div class="col-md-2 col-xs-12"></div>
</div>
</body>
</html>