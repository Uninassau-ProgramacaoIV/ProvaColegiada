package br.edu.uninassau.provaColegiada.turma;

import br.edu.uninassau.provaColegiada.turma.dao.RamTurmaDAO;
import br.edu.uninassau.provaColegiada.turma.dao.TurmaDAO;
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
@WebFilter( "/turma/*" )
public class TurmaFiltro implements Filter
{
    private TurmaDAO dao;
    
    public TurmaFiltro()
    {
        // faz nada
    }
    
    @Override
    public void init( FilterConfig filterConfig ) throws ServletException
    {
        dao = new RamTurmaDAO();
    }

    @Override
    public void doFilter(ServletRequest request
                        , ServletResponse response
                        , FilterChain chain) 
                            throws IOException, ServletException
    {
        request.setAttribute( "TurmaDAO" , dao );
        chain.doFilter( request , response );
    }

    @Override
    public void destroy()
    {
        dao = null;
    }
    
}
