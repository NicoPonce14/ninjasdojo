<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Nuevo Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <div class="container">
		<h2>Nuevo Ninja</h2>
		<form:form action="/ninja/new" method="POST" modelAttribute="ninja">
            <div class="form-group">
				<form:label path="dojo">Dojo</form:label>
				<form:errors path="dojo" />
				<form:select class="form-control" path="dojo">
					<c:forEach items="${dojos}" var="per">
						<form:option value="${per.id}">
						${per.name}
						</form:option>
					</c:forEach>
				</form:select>
			</div>

			<div class="form-group">
				<form:label path="firstName">Nombre</form:label>
				<form:errors path="firstName" />
				<form:input class="form-control" path="firstName" />
			</div>
            <div class="form-group">
				<form:label path="lastName">Apellido</form:label>
				<form:errors path="lastName" />
				<form:input class="form-control" path="lastName" />
			</div>
            <div class="form-group">
				<form:label path="age">Edad</form:label>
				<form:errors path="age" />
				<form:input type="number" class="form-control" path="age" />
			</div>
			<button>Crear</button>
		</form:form>
	</div>

</body>
</html>