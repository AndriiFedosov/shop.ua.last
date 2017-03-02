

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Description</title>
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
					<li class="active"><a href="/admin/description">Description</a><span
							class="sr-only">(current)</span></li>
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
				<form:form class="form-horizontal" action="/admin/description" method="POST" modelAttribute="description">
					<custom:hiddenInputs excludeParams="color,size,material"/>
					<div class="form-group">
						<label class="col-sm-10 col-sm-offset-2">
							<form:errors path="color"></form:errors>
						</label>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Color</label>
						<div class="col-sm-10">
							<form:input class="form-control" path="color" id="name"/>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-10 col-sm-offset-2">
							<form:errors path="size"></form:errors>
						</label>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Size</label>
						<div class="col-sm-10">
							<form:input class="form-control" path="size" id="name"/>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-10 col-sm-offset-2">
							<form:errors path="material"></form:errors>
						</label>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Material</label>
						<div class="col-sm-10">
							<form:input class="form-control" path="material" id="name"/>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Save</button>
							<a class="btn btn-primary" href="/admin/description/cancel<custom:allParams/>">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-xs-3"><h3>Color</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Size</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Material</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Update</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Deleted</h3></div>

		</div>
		<c:forEach items="${descriptions.content}" var="description">
			<div class="row">
				<div class="col-md-3 col-xs-3">${description.color}</div>
				<div class="col-md-3 col-xs-3">${description.size}</div>
				<div class="col-md-2 col-xs-2">${description.material}</div>
				<div class="col-md-2 col-xs-2"><a class="btn btn-warning" href="/admin/description/update/${description.id}<custom:allParams/>">update</a></div>
				<div class="col-md-2 col-xs-2"><a class="btn btn-danger" href="/admin/description/delete/${description.id}<custom:allParams/>">delete</a></div>
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
						<custom:sort innerHtml="Color asc" paramValue="color"/>
						<custom:sort innerHtml="Color desc" paramValue="color,desc"/>
						<custom:sort innerHtml="Size asc" paramValue="size"/>
						<custom:sort innerHtml="Size desc" paramValue="size,desc"/>
						<custom:sort innerHtml="Material asc" paramValue="material"/>
						<custom:sort innerHtml="Material desc" paramValue="material,desc"/>

					</ul>
				</div>
			</div>
			<div class="col-md-6 col-xs-6 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${descriptions.size}" />
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${descriptions}" cell="<li></li>" container="<ul class='pagination'></ul>" />
	</div>
</div>
</body>
</html>