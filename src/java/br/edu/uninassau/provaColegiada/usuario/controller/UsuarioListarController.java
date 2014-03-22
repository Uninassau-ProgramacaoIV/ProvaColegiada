package br.edu.uninassau.provaColegiada.usuario.controller;

import br.edu.uninassau.provaColegiada.usuario.Usuario;
import br.edu.uninassau.provaColegiada.usuario.dao.UsuarioDAO;
import java.io.IOException;
import java.util.List;
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
@WebServlet( "/usuario/listar" )
public class UsuarioListarController extends HttpServlet
{
    
    public UsuarioListarController()
    {
        // faz nada
    }
    
    @Override
    protected void doGet( HttpServletRequest request 
                        , HttpServletResponse response )
                            throws ServletException, IOException
    {
        UsuarioDAO dao = (UsuarioDAO) request.getAttribute( "UsuarioDAO" ); // recupera o DAO
        
        if( request.getSession().getAttribute( "usuario_msg" ) != null )
        {
            String msg = (String) request.getSession().getAttribute( "usuario_msg" );
            request.getSession().removeAttribute( "usuario_msg" );
            
            request.setAttribute( "msg" , msg );
        }
        
        try
        {
            List<Usuario> lista = dao.listar();
            request.setAttribute( "lista" , lista );        // manda a lista para o JSP
            
            // Exibi a pagina para login
            RequestDispatcher rd = request.getRequestDispatcher( "/usuario/listar.jsp" );
            rd.forward( request , response );
        }
        catch( Exception err )
        {
            throw new ServletException( err );
        }
    }
    
}
