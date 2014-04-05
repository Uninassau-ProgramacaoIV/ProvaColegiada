/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.uninassau.provaColegiada.curso.controller;

import br.edu.uninassau.provaColegiada.curso.dao.CursoDAO;
import br.edu.uninassau.provaColegiada.curso.Curso;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
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
 * @author Eli Leite
 */
@WebServlet( "/curso/listar" )
public class CursoListarController extends HttpServlet
{
    
    
    public CursoListarController()
    {
        // corpo vazio
    }
 
    
    
    @Override
    protected void doGet( HttpServletRequest request 
                        , HttpServletResponse response )
                            throws ServletException, IOException
    {
        
    }     
            CursoDAO dao = (CursoDAO) request.getAttribute( "CursoDAO" ); // recupera o DAO
            {
}
        if( request.getSession().getAttribute( "curso_msg" ) != null )
        {
            String msg = (String) request.getSession().getAttribute( "curso_msg" );
            request.getSession().removeAttribute( "curso_msg" );
            
            request.setAttribute( "msg" , msg );
}
        
        try
        {
            List<Curso> lista = dao.listar();
            request.setAttribute( "lista" , lista );        // manda a lista para o JSP
            
            // Exibi a pagina para login
            RequestDispatcher rd = request.getRequestDispatcher( "/curso/listar.jsp" );
            rd.forward( request , response );
        }
        catch( Exception err )
        {
            throw new ServletException( err );
        }
    }

