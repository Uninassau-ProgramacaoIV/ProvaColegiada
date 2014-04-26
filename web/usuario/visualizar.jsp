<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuário :: Visualizar</title>
    </head>
    <body>
        <h1>Visualizar do Usuário</h1>
        
        <div>
            <a href="${servletContext}/usuario/listar">Listar</a> 
            <a href="${servletContext}/usuario/adicionar">Adicionar</a> 
            <a href="${servletContext}/usuario/modificar?id=${usuario.id}">Modificar</a> 
            <a href="${servletContext}/usuario/visualizar?id=${usuario.id}">Visualizar</a> 
            <a href="${servletContext}/usuario/excluir?id=${usuario.id}">Excluir</a>
        </div>
        
        <div>
            ID: ${usuario.id}
        </div>
            
        <div>
            Nome: ${usuario.nome}
        </div>

        <div>
            <!-- nunca mostre a senha do usuario! -->
            Senha: ${usuario.senha}
        </div>

        <div>
            Login: ${usuario.login}
        </div>

        <div>
            Categoria: 
            <c:choose>
                <c:when test="${usuario.categoria eq 0}">
                    Administrador
                </c:when>
                <c:when test="${usuario.categoria eq 1}">
                    Professor
                </c:when>
            </c:choose>
        </div>
    </body>
</html>
