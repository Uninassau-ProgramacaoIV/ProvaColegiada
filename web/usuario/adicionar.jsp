<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario :: Cadastrar</title>
    </head>
    
    <body>
        <h1>Cadastrar um Usuário</h1>
        
        <div>
            <a href="${servletContext}/usuario/listar">Listar</a> 
            <a href="${servletContext}/usuario/adicionar">Adicionar</a> 
        </div>
        
        <form action="${servletContext}/usuario/adicionar" method="POST">
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
                    <option value="0">Adminstrador</option>
                    <option value="1">Professor</option>
                </select>
            </label> <br />
            
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
