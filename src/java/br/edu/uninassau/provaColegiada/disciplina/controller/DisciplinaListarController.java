package br.edu.uninassau.provaColegiada.disciplina.controller;

import br.edu.uninassau.provaColegiada.disciplina.Disciplina;
import br.edu.uninassau.provaColegiada.disciplina.dao.DisciplinaDAO;
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
 * @author Ramon Italo
 */
@WebServlet( "/disciplina/listar" )
public class DisciplinaListarController extends HttpServlet
{
    
    public DisciplinaListarController()
    {
        // faz nada
    }
    @Override
    protected void doGet( HttpServletRequest request 
                        , HttpServletResponse response )
                            throws ServletException, IOException
    {
        DisciplinaDAO dao = (DisciplinaDAO) request.getAttribute( "DisciplinaDAO" ); // recupera o DAO
        
        if( request.getSession().getAttribute( "Disciplina_msg" ) != null )
        {
            String msg = (String) request.getSession().getAttribute( "Disciplina_msg" );
            request.getSession().removeAttribute( "Disciplina_msg" );
            
            request.setAttribute( "msg" , msg );
        }
        
        try
        {
            List<Disciplina> lista = dao.listar();
            request.setAttribute( "lista" , lista );        // manda a lista para o JSP
            
            // Exibi a pagina para login
            RequestDispatcher rd = request.getRequestDispatcher( "/Disciplina/listar.jsp" );
            rd.forward( request , response );
        }
        catch( Exception err )
        {
            throw new ServletException( err );
        }
    }
    
}
