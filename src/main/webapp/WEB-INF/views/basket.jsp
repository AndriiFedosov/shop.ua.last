<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Basket</title>
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
                    <li><a href="/admin/production">Product</a></li>
                    <li class="active"><a href="/admin/basket">Basket</a>
                        <span class="sr-only">(current)</span></li>
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
                <form:form class="form-horizontal" action="/admin/basket" method="POST" modelAttribute="basket">
                    <div class="form-group">
                        <label for="person" class="col-sm-2 control-label">Person</label>
                        <div class="col-sm-10">
                            <form:select path="person" class="form-control" items="${persons}" itemLabel="email" itemValue="id" id="person"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="production" class="col-sm-2 control-label">Production</label>
                        <div class="col-sm-10">
                            <form:select path="production" class="form-control" items="${productions}" itemLabel="presentation" itemValue="id" id="production"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Dataship</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" path="dataship" id="name"/>
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
                            <a class="btn btn-primary" href="/admin/basket/cancel">Cancel</a>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2 col-xs-2"><h3>Person</h3></div>
            <div class="col-md-2 col-xs-2"><h3>Production</h3></div>
            <div class="col-md-2 col-xs-2"><h3>Dataship</h3></div>
            <div class="col-md-2 col-xs-2"><h3>Deleted</h3></div>
            <div class="col-md-2 col-xs-2"><h3>Update</h3></div>
            <div class="col-md-2 col-xs-2"><h3>Delete</h3></div>
        </div>
        <c:forEach items="${baskets}" var="basket">
            <div class="row">
                <div class="col-md-2 col-xs-2">${basket.person.email} </div>
                <div class="col-md-2 col-xs-2">${basket.production.presentation}</div>
                <div class="col-md-2 col-xs-2">${basket.dataship}</div>
                <div class="col-md-2 col-xs-2">${basket.is_deleted}</div>
                <div class="col-md-2 col-xs-2"><a class="btn btn-warning" href="/admin/basket/update/${basket.id}">update</a></div>
                <div class="col-md-2 col-xs-2"><a class="btn btn-danger" href="/admin/basket/delete/${basket.id}">delete</a></div>
            </div>
        </c:forEach>
    </div>
    <div class="col-md-2 col-xs-12"></div>
</div>
</body>
</html>