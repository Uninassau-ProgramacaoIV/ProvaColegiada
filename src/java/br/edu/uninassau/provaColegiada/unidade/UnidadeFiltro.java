package br.edu.uninassau.provaColegiada.unidade;

import br.edu.uninassau.provaColegiada.unidade.dao.RamUnidadeDAO;
import br.edu.uninassau.provaColegiada.unidade.dao.UnidadeDAO;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author avld
 */
@WebFilter( "/unidade/*" )
public class UnidadeFiltro implements Filter
{
    private UnidadeDAO dao;
    
    public UnidadeFiltro()
    {
        // faz nada
    }
    
    @Override
    public void init( FilterConfig filterConfig ) throws ServletException
    {
        dao = new RamUnidadeDAO();
    }

    @Override
    public void doFilter(ServletRequest request
                        , ServletResponse response
                        , FilterChain chain) 
                            throws IOException, ServletException
    {
        request.setAttribute( "UnidadeDAO" , dao );
        chain.doFilter( request , response );
    }

    @Override
    public void destroy()
    {
        dao = null;
    }
    
}
