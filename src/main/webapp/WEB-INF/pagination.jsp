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
    <title></title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <div id="ninjas">
        <h1>Ninjas</h1>
        
        
        <c:forEach begin="1" end="${totalPages}" var="index">
            <a href="/pag/${index}">${index}</a>
        </c:forEach>
        <table class="table">
            <thead>
                <th>First Name</th>
                <th>Last Name</th>
            </thead>
            <tbody>
                
                <c:forEach var="ninja" items="${ninjas.content}">                 
                <tr>
                    <td><c:out value="${ninja.id}"></c:out></td>
                    <td><c:out value="${ninja.firstName}"></c:out></td>
                    <td><c:out value="${ninja.lastName}"></c:out></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    
</body>
</html>