/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.uninassau.provaColegiada.disciplina.controller;

import br.edu.uninassau.provaColegiada.disciplina.Disciplina;
import br.edu.uninassau.provaColegiada.disciplina.dao.DisciplinaDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */

@WebServlet( "/Disciplina/visualizar")
public class DisciplinaVisualizarController extends HttpServlet
{
    private Disciplina Disciplina;
    
    public DisciplinaVisualizarController()
    {
        // faz nada
    }
    
    @Override
    protected void doGet( HttpServletRequest request 
                        , HttpServletResponse response )
                            throws ServletException, IOException
    {
        DisciplinaDAO dao = (DisciplinaDAO) request.getAttribute( "DisciplinaDAO" ); // recupera o DAO
        int id   = Integer.parseInt( request.getParameter( "id" ) );        // recupera o campo 'id'
        
        
        try
        {
            validar( dao , id );
        }
        catch( Exception err )
        {
            request.getSession().setAttribute( "Disciplina_msg" , err.getMessage() );
            response.sendRedirect( "/Disciplina/listar" );
        }
        
        try
        {
             Disciplina = dao.get( id );
            request.setAttribute( "Disciplina", Disciplina );     // manda a lista para o JSP
            
            // Exibi a pagina para login
            RequestDispatcher rd = request.getRequestDispatcher( "/Disciplina/visualizar.jsp" );
            rd.forward( request , response );
        }
        catch( Exception err )
        {
            throw new ServletException( err );
        }
    }
    
    private void validar( DisciplinaDAO dao , int id ) throws Exception
    {
        if( id < 0 )
        {
            throw new Exception( "É obrigatório o ID da Disciplina ser maior do que zero." );
        }
        else if( dao.get( id ) != null )
        {
            throw new Exception( "a Disciplina não existe." );
        }
    }
}
