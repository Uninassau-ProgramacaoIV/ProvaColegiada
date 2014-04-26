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
@WebServlet( "/usuario/visualizar" )
public class UsuarioVisualizarController extends HttpServlet
{
    
    public UsuarioVisualizarController()
    {
        // faz nada
    }
    
    @Override
    protected void doGet( HttpServletRequest request 
                        , HttpServletResponse response )
                            throws ServletException, IOException
    {
        UsuarioDAO dao = (UsuarioDAO) request.getAttribute( "UsuarioDAO" ); // recupera o DAO
        int id   = Integer.parseInt( request.getParameter( "id" ) );        // recupera o campo 'id'
        String context = (String) request.getAttribute( "servletContext" );
        
        try
        {
            validar( dao , id );
        }
        catch( Exception err )
        {
            request.getSession().setAttribute( "usuario_msg" , err.getMessage() );
            response.sendRedirect( context + "/usuario/listar" );
            
            return ;
        }
        
        try
        {
            Usuario usuario = dao.get( id );
            request.setAttribute( "usuario" , usuario );        // manda a lista para o JSP
            
            // Exibi a pagina para login
            RequestDispatcher rd = request.getRequestDispatcher( "/usuario/visualizar.jsp" );
            rd.forward( request , response );
        }
        catch( Exception err )
        {
            throw new ServletException( err );
        }
    }
    
    private void validar( UsuarioDAO dao , int id ) throws Exception
    {
        if( id < 0 )
        {
            throw new Exception( "É obrigatório o ID do usuario ser maior do que zero." );
        }
        else if( dao.get( id ) == null )
        {
            throw new Exception( "O usuário não existe." );
        }
    }
}
