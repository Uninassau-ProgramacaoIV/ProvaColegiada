package br.edu.uninassau.provaColegiada.disciplina;

import br.edu.uninassau.provaColegiada.disciplina.dao.DisciplinaDAO;
import br.edu.uninassau.provaColegiada.disciplina.dao.RamDisciplinaDAO;
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
@WebFilter( "/disciplina/*" )
public class DisciplinaFiltro implements Filter
{
    private DisciplinaDAO dao;
    
    public DisciplinaFiltro()
    {
        // faz nada
    }
    
    @Override
    public void init( FilterConfig filterConfig ) throws ServletException
    {
        dao = new RamDisciplinaDAO();
    }

    @Override
    public void doFilter(ServletRequest request
                        , ServletResponse response
                        , FilterChain chain) 
                            throws IOException, ServletException
    {
        request.setAttribute( "DisciplinaDAO" , dao );
        chain.doFilter( request , response );
    }

    @Override
    public void destroy()
    {
        dao = null;
    }
    
}
