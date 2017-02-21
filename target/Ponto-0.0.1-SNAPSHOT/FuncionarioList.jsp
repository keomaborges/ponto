<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Funcionarios Application</title>
</head>
<body>
    <center>
        <h1>Funcionarios Management</h1>
        <h2>
            <a href="/new">Add New Funcionario</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Funcionarios</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Funcionarios</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nome</th>
            </tr>
            <c:forEach var="funcionario" items="${listFuncionario}">
                <tr>
                    <td><c:out value="${funcionario.id}" /></td>
                    <td><c:out value="${funcionario.nome}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${funcionario.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${funcionario.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>