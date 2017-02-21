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
        <c:if test="${funcionario != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${funcionario == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${funcionario != null}">
                        Editar Funcionario
                    </c:if>
                    <c:if test="${funcionario == null}">
                        Novo Funcionario
                    </c:if>
                </h2>
            </caption>
                <c:if test="${funcionario != null}">
                    <input type="hidden" name="id" value="<c:out value='${funcionario.id}' />" />
                </c:if>           
            <tr>
                <th>Nome: </th>
                <td>
                    <input type="text" name="nome" size="45"
                            value="<c:out value='${funcionario.nome}' />"
                        />
                </td>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Salvar" />
                </td>
            </tr>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>