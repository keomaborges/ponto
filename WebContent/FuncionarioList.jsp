<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sistema de Ponto</title>
</head>
<body>
    <center>
        <h1>Sistema de Ponto</h1>
        <h2>
            <a href="/new">Novo</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">Listar</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Funcionários</h2></caption>
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
                        <a href="/ponto?id=<c:out value='${funcionario.id}' />">Ponto</a>                
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>