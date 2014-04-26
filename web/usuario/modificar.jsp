<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario :: Modificar</title>
    </head>
    
    <body>
        <h1>Modificar um Usuário</h1>
        
        <div>
            <a href="${servletContext}/usuario/listar">Listar</a> 
            <a href="${servletContext}/usuario/adicionar">Adicionar</a> 
            <a href="${servletContext}/usuario/modificar?id=${usuario.id}">Modificar</a> 
            <a href="${servletContext}/usuario/visualizar?id=${usuario.id}">Visualizar</a> 
            <a href="${servletContext}/usuario/excluir?id=${usuario.id}">Excluir</a>
        </div>
        
        <form action="${servletContext}/usuario/modificar" method="POST">
            <label>
                ID: <input type="text" name="id" value="${usuario.id}" width="100" disabled="true" />
            </label> <br />
            
            <label>
                Nome: <input type="text" name="nome" value="${usuario.nome}" width="100" />
            </label> <br />
            
            <label>
                <!-- nunca mostre a senha do usuario! -->
                Senha: <input type="password" name="senha" value="${usuario.senha}" width="100" />
            </label> <br />
            
            <label>
                Login: <input type="text" name="login" value="${usuario.login}" width="100" />
            </label> <br />
            
            <label>
                Categoria: 
                <select name="categoria">
                    <option value="0" 
                            <c:if test="${usuario.categoria eq 0}">selected="true"</c:if> 
                            >Adminstrador</option>
                    <option value="1"
                            <c:if test="${usuario.categoria eq 1}">selected="true"</c:if> 
                            >Professor</option>
                </select>
            </label> <br />
            
            <input type="submit" value="Modificar" />
        </form>
    </body>
</html>
