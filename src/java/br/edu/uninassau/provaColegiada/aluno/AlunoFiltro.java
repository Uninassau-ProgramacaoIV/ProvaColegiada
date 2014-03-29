package br.edu.uninassau.provaColegiada.aluno;

import br.edu.uninassau.provaColegiada.aluno.dao.AlunoDAO;
import br.edu.uninassau.provaColegiada.aluno.dao.RamAlunoDAO;
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
@WebFilter( "/aluno/*" )
public class AlunoFiltro implements Filter
{
    private AlunoDAO dao;
    
    public AlunoFiltro()
    {
        // faz nada
    }
    
    @Override
    public void init( FilterConfig filterConfig ) throws ServletException
    {
        dao = new RamAlunoDAO();
    }

    @Override
    public void doFilter(ServletRequest request
                        , ServletResponse response
                        , FilterChain chain) 
                            throws IOException, ServletException
    {
        request.setAttribute( "AlunoDAO" , dao );
        chain.doFilter( request , response );
    }

    @Override
    public void destroy()
    {
        dao = null;
    }
    
}
