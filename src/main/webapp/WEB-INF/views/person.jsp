<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Person</title>
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
					<li class="active"><a href="/admin/person">Person</a>
						<span class="sr-only">(current)</span></li>
					<li ><a href="/admin/category">Category</a></li>
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
				<form:form class="form-horizontal" action="/admin/person" method="POST" modelAttribute="person">
					<custom:hiddenInputs excludeParams="email,passwordUser,role"/>
					<div class="form-group">
						<label class="col-sm-10 col-sm-offset-2">
							<form:errors path="email"></form:errors>
						</label>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-10">
							<form:input class="form-control" path="email" id="name"/>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-10 col-sm-offset-2">
							<form:errors path="passwordUser"></form:errors>
						</label>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<form:input class="form-control" path="passwordUser" id="name"/>
						</div>
					</div>


					<div class="form-group">
						<label class="col-sm-10 col-sm-offset-2">
							<form:errors path="role"></form:errors>
						</label>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Role</label>
						<div class="col-sm-10">
					<form:input class="form-control" path="role" id="name"/>
			</div>
		</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Deleted</label>
						<div class="col-sm-10">
							<form:input class="form-control" path="is_deleted" id="name"/>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Save</button>
							<a class="btn btn-primary" href="/admin/person/cancel<custom:allParams/>">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-xs-4"><h3>Email</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Password</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Role</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Deleted</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Options</h3></div>

		</div>
		<c:forEach items="${persons.content}" var="person">
			<div class="row">
				<div class="col-md-4 col-xs-4">${person.email}</div>
				<div class="col-md-2 col-xs-2">${person.passwordUser}</div>
				<div class="col-md-2 col-xs-2">${person.role}</div>
				<div class="col-md-2 col-xs-2">${person.is_deleted}</div>
				<div class="col-md-1 col-xs-1"><a class="btn btn-warning" href="/admin/person/update/${person.id}<custom:allParams/>">update</a></div>
				<div class="col-md-1 col-xs-1"><a class="btn btn-danger" href="/admin/person/delete/${person.id}<custom:allParams/>">delete</a></div>
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
						<custom:sort innerHtml="Email asc" paramValue="email"/>
						<custom:sort innerHtml="Email desc" paramValue="email,desc"/>
					</ul>
				</div>
			</div>
			<div class="col-md-6 col-xs-6 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${persons.size}" />
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${persons}" cell="<li></li>" container="<ul class='pagination'></ul>" />
	</div>
</div>
</body>
</html>