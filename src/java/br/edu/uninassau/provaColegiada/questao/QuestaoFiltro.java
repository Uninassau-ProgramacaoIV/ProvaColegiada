package br.edu.uninassau.provaColegiada.questao;

import br.edu.uninassau.provaColegiada.questao.dao.QuestaoDAO;
import br.edu.uninassau.provaColegiada.questao.dao.RamQuestaoDAO;
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
@WebFilter( "/questao/*" )
public class QuestaoFiltro implements Filter
{
    private QuestaoDAO dao;
    
    public QuestaoFiltro()
    {
        // faz nada
    }
    
    @Override
    public void init( FilterConfig filterConfig ) throws ServletException
    {
        dao = new RamQuestaoDAO();
    }

    @Override
    public void doFilter(ServletRequest request
                        , ServletResponse response
                        , FilterChain chain) 
                            throws IOException, ServletException
    {
        request.setAttribute( "QuestaoDAO" , dao );
        chain.doFilter( request , response );
    }

    @Override
    public void destroy()
    {
        dao = null;
    }
    
}
