package br.edu.uninassau.provaColegiada;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * TODO: isso daqui deve ser usado depois!
 * 
 * @author avld
 */
@WebFilter( "/*" )
public class ServletContextFiltro implements Filter
{
    private String servletContext;
    
    public ServletContextFiltro()
    {
        // faz nada
    }
    
    @Override
    public void init( FilterConfig filterConfig ) throws ServletException
    {
        // do nothing
    }

    @Override
    public void doFilter( ServletRequest request 
                        , ServletResponse response 
                        , FilterChain chain ) 
                            throws IOException, ServletException
    {
        servletContext = "/ProvaColegiada";
        request.setAttribute( "servletContext" , servletContext );
        
        chain.doFilter( request , response );
    }
    
    @Override
    public void destroy()
    {
        // faz nada
    }
    
}
