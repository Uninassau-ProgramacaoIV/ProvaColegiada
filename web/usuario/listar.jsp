<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuário :: Listar</title>
    </head>
    <body>
        <h1>Listar todos os Usuário</h1>
        <a href="${servletContext}/usuario/adicionar">adicionar</a> <br/>
        
        <table style="width: 100%; border: 1px solid black;">
            <tr>
                <td>ID</td>
                <td>Nome</td>
                <td>Login</td>
                <td>Categoria</td>
                <td>Ações</td>
            </tr>
        
        <c:forEach items="${lista}" var="usuario">
            <tr>
                <td>${usuario.id}</td>
                <td>${usuario.nome}</td>
                <td>${usuario.login}</td>
                <td>
                    <c:choose>
                        <c:when test="${usuario.categoria eq 0}">
                            Administrador
                        </c:when>
                        <c:when test="${usuario.categoria eq 1}">
                            Professor
                        </c:when>
                    </c:choose>
                </td>
                <td>
                    <a href="${servletContext}/usuario/modificar?id=${usuario.id}">Modificar</a> 
                    <a href="${servletContext}/usuario/visualizar?id=${usuario.id}">Visualizar</a> 
                    <a href="${servletContext}/usuario/excluir?id=${usuario.id}">Excluir</a>
                </td>
            </tr>
        </c:forEach>
        </table>
        
        <c:if test="${lista.isEmpty()}">
            <div style="text-align: center;">
                Não foi encontrado nenhum usuário.
            </div>
        </c:if>
        
        <c:if test="${not empty msg}">
            <div>
                MENSAGEM: ${msg}
            </div>
        </c:if>
        
    </body>
</html>
