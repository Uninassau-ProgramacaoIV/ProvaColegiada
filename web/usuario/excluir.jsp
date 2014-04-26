<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario :: Excluir</title>
    </head>
    
    <body>
        <h1>Excluir um Usuário</h1>
        
        <div>
            <a href="${servletContext}/usuario/listar">Listar</a> 
            <a href="${servletContext}/usuario/adicionar">Adicionar</a> 
            <a href="${servletContext}/usuario/modificar?id=${usuario.id}">Modificar</a> 
            <a href="${servletContext}/usuario/visualizar?id=${usuario.id}">Visualizar</a> 
            <a href="${servletContext}/usuario/excluir?id=${usuario.id}">Excluir</a>
        </div>
        
        <p>você deseja excluir o usuario ${nome}?</p>
        <a href="${ServletContext}/usuario/deletar/usuario=${usuarioid}&acao=sim">SIM</a>
         | 
        <a href="${ServletContext}/usuario/listar">NÃO</a>
    </body>
</html>




<!-- é necessário ter esse aqui?! -->