
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Category</title>
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
                    <li class="active"><a href="/admin/category">Category</a><span
                            class="sr-only">(current)</span></li>
                    <li><a href="/admin/description">Description</a></li>
                    <li><a href="/admin/production">Product</a></li>
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
                <form:form class="form-horizontal" action="/admin/category" method="POST" modelAttribute="category">
                    <custom:hiddenInputs excludeParams="nameCategory,model"/>
                    <div class="form-group">
                        <label class="col-sm-10 col-sm-offset-2">
                            <form:errors path="nameCategory"></form:errors>
                        </label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Category</label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="nameCategory" id="name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-10 col-sm-offset-2">
                            <form:errors path="model"></form:errors>
                        </label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Model</label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="model" id="name"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Save</button>
                            <a class="btn btn-primary" href="/admin/category/cancel<custom:allParams/>">Cancel</a>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 col-xs-3"><h3>Category</h3></div>
            <div class="col-md-3 col-xs-3"><h3>Model</h3></div>
            <div class="col-md-3 col-xs-3"><h3>Update</h3></div>
            <div class="col-md-3 col-xs-3"><h3>Delete</h3></div>
        </div>
        <c:forEach items="${categories.content}" var="category">
            <div class="row">
                <div class="col-md-3 col-xs-3">${category.nameCategory}</div>
                <div class="col-md-3 col-xs-3">${category.model}</div>
                <div class="col-md-3 col-xs-3"><a class="btn btn-warning" href="/admin/category/update/${category.id}<custom:allParams/>">update</a></div>
                <div class="col-md-3 col-xs-3"><a class="btn btn-danger" href="/admin/category/delete/${category.id}<custom:allParams/>">delete</a></div>
            </div>
        </c:forEach>

    </div>
    <div class="col-md-2 col-xs-12">
        <div class="row">
            <div class="col-md-6 col-xs-6 text-center">
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <custom:sort innerHtml="Category Name asc" paramValue="nameCategory"/>
                        <custom:sort innerHtml="Category Name desc" paramValue="nameCategory,desc"/>
                        <custom:sort innerHtml="Model asc" paramValue="model"/>
                        <custom:sort innerHtml="Model  desc" paramValue="model,desc"/>
                    </ul>
                </div>
            </div>
            <div class="col-md-6 col-xs-6 text-center">
                <custom:size posibleSizes="1,2,5,10" size="${categories.size}" />
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-12 col-xs-12 text-center">
        <custom:pageable page="${categories}" cell="<li></li>" container="<ul class='pagination'></ul>" />
    </div>
</div>
</body>
</html>