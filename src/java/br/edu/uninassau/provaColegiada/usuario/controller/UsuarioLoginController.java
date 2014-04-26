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
@WebServlet( "/usuario/login" )
public class UsuarioLoginController extends HttpServlet
{
    
    public UsuarioLoginController()
    {
        // faz nada
    }
    
    @Override
    protected void doGet( HttpServletRequest request 
                        , HttpServletResponse response )
                            throws ServletException, IOException
    {
        // Verifica se já existe alguem logado
        if( request.getSession() != null )
        {
            response.sendRedirect( "/index" );
        }
        
        // Exibi a pagina para login
        RequestDispatcher rd = request.getRequestDispatcher( "/usuario/login.jsp" );
        rd.forward( request , response );
    }
    
    @Override
    protected void doPost( HttpServletRequest request 
                        , HttpServletResponse response )
                            throws ServletException, IOException
    {
        UsuarioDAO dao = (UsuarioDAO) request.getAttribute( "UsuarioDAO" ); // recupera o DAO
        String login   = request.getParameter( "login" );   // recupera o campo 'login'
        String senha   = request.getParameter( "senha" );   // recupera o campo 'senha'
        
        try
        {
            validar( login , senha );
        }
        catch( Exception err )
        {
            request.setAttribute( "msg" , err.getMessage() );
            doGet( request , response );
            
            return ;
        }
        
        try
        {
            Usuario usuario = dao.login( login , senha );
            
            if( usuario != null )
            {
                request.getSession( true );
                response.sendRedirect( "/ProvaColegiada/index" );
            }
            else
            {
                request.setAttribute( "msg" , "Usuario ou senha está incorreto." );
                doGet( request , response );
            }
        }
        catch( Exception err )
        {
            throw new ServletException( err );
        }
    }
    
    private void validar( String login , String senha ) throws Exception
    {
        if( login == null
                ? true
                : login.trim().isEmpty() )
        {
            throw new Exception( "É obrigatório ter o campo 'login' preenchido." );
        }
        else if( senha == null
                ? true
                : senha.trim().isEmpty() )
        {
            throw new Exception( "É obrigatório ter o campo 'senha' preenchido." );
        }
    }
    
}
