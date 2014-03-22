package br.edu.uninassau.provaColegiada.usuario.controller;

import br.edu.uninassau.provaColegiada.usuario.Usuario;
import br.edu.uninassau.provaColegiada.usuario.dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author avld
 */
@WebServlet( "/usuario/modificar" )
public class UsuarioModificarController extends HttpServlet
{
    
    public UsuarioModificarController()
    {
        // faz nada
    }
    
    @Override
    protected void doGet( HttpServletRequest request 
                        , HttpServletResponse response )
                            throws ServletException, IOException
    {
        // Exibi a pagina para login
        RequestDispatcher rd = request.getRequestDispatcher( "/usuario/modificar.jsp" );
        rd.forward( request , response );
    }
    
    @Override
    protected void doPost( HttpServletRequest request 
                        , HttpServletResponse response )
                            throws ServletException, IOException
    {
        UsuarioDAO dao = (UsuarioDAO) request.getAttribute( "UsuarioDAO" ); // recupera o DAO
        Usuario usuario = convertToUsuario( request );
        
        try
        {
            validar( dao , usuario );
            
            dao.modificar( usuario );
            request.getSession().setAttribute( "usuario_msg" 
                                             , "Usuario modificado com sucesso." );
            response.sendRedirect( "/usuario/listar" );
        }
        catch( Exception err )
        {
            request.setAttribute( "usuario" , usuario );
            doGet( request , response );
        }
    }
    
    private Usuario convertToUsuario( HttpServletRequest request )
    {
        int id         = Integer.parseInt( request.getParameter( "id" ) );
        String nome    = request.getParameter( "nome"  );   // recupera o campo 'nome'
        String login   = request.getParameter( "login" );   // recupera o campo 'login'
        String senha   = request.getParameter( "senha" );   // recupera o campo 'senha'
        int categoria  = Integer.parseInt( request.getParameter( "categoria" ) );
        
        Usuario usuario = new Usuario();
        usuario.setId( id );
        usuario.setNome( nome );
        usuario.setLogin( login );
        usuario.setSenha( senha );
        usuario.setCategoria( categoria );
        
        return usuario;
    }
    
    private void validar( UsuarioDAO dao , Usuario usuario ) throws Exception
    {
        Usuario usuRep = dao.get( usuario.getId() );
        
        if( usuario.getId() <= 0 )
        {
            throw new Exception( "O ID do usuario deve ser maior do que zero." );
        }
        else if( usuRep == null )
        {
            throw new Exception( "O usuario não existe." );
        }
        else if( usuario.getNome() == null 
                ? true 
                : usuario.getNome().length() < 3 )
        {
            throw new Exception( "O nome do usuario deve ser maior do que 3 letras." );
        }
        else if( usuario.getLogin() == null 
                ? true 
                : usuario.getLogin().length() < 3 )
        {
            throw new Exception( "O login do usuario deve ser maior do que 3 letras." );
        }
        else if( usuario.getSenha() == null 
                ? true 
                : usuario.getSenha().length() < 3 )
        {
            throw new Exception( "A senha do usuario deve ser maior do que 3 letras." );
        }
        else if( usuario.getCategoria() < 0 || usuario.getCategoria() > 1 )
        {
            throw new Exception( "O valor da categoria é invalido." );
        }
        else if( usuRep.getLogin().equals( usuario.getLogin() ) 
                ? false
                : dao.login( usuario.getLogin() , usuario.getSenha() ) != null )
        {
            throw new Exception( "Já existe um usuario com esse login e senha." );
        }
    }
    
}
