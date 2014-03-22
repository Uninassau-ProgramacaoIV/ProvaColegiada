package br.edu.uninassau.provaColegiada.usuario;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author avld
 */
@WebFilter( "/*" )
public class SessionFiltro implements Filter
{

    public SessionFiltro()
    {
        // faz nada
    }
    
    @Override
    public void init( FilterConfig filterConfig ) throws ServletException
    {
        // faz nada
    }

    @Override
    public void doFilter( ServletRequest request 
                        , ServletResponse response 
                        , FilterChain chain ) 
                            throws IOException, ServletException
    {
        if ( request instanceof HttpServletRequest )
        {
            HttpServletRequest httpRequest   = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            
            validarRequesicao( httpRequest , httpResponse );
        }
        
        chain.doFilter( request , response );
    }

    private void validarRequesicao( HttpServletRequest request
                                  , HttpServletResponse response ) 
                                        throws IOException, ServletException
    {    
        String url          = request.getRequestURL().toString();
        HttpSession session = request.getSession();

        if( session == null 
                && !url.endsWith( "/login" ) )
        {
            response.sendRedirect( "/usuario/login" );
        }
    }
    
    @Override
    public void destroy()
    {
        // faz nada
    }
    
}
