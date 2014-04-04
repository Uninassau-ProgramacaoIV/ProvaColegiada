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
@WebServlet( "/usuario/adicionar" )
public class DisciplinaAdicionarController extends HttpServlet
{
    
    public DisciplinaAdicionarController()
    {
        // faz nada
    }
    
    @Override
    protected void doGet( HttpServletRequest request 
                        , HttpServletResponse response )
                            throws ServletException, IOException
    {
        // Exibi a pagina para login
        RequestDispatcher rd = request.getRequestDispatcher( "/diciplina/adicionar.jsp" );
        rd.forward( request , response );
    }
    
    @Override
    protected void doPost( HttpServletRequest request 
                        , HttpServletResponse response )
                            throws ServletException, IOException
    {
        DisciplinaDAO dao = (DisciplinaDAO) request.getAttribute( "DisciplinaDAO" ); // recupera o DAO
        Disciplina disciplina = convertToDisciplina( request );
        
        try
        {
            validar( dao , disciplina );
            
            dao.adicionar( disciplina );
            request.getSession().setAttribute( "usuario_msg" 
                                             , "Usuario salvo com sucesso." );
            response.sendRedirect( "/usuario/listar" );
        }
        catch( Exception err )
        {
            request.setAttribute( "disciplina" , disciplina );
            doGet( request , response );
        }
    }
    
    private Disciplina convertToUsuario( HttpServletRequest request )
    {
        String id    = request.getParameter( "id"  );   // recupera o campo 'id'
        String nome   = request.getParameter( "nome" );   // recupera o campo 'nome'
        
        
        
        Disciplina disciplina = new Disciplina();
        disciplina.setId( id );
        disciplina.setNome( nome );
        
        
        return disciplina;
    }
    
    private void validar( DisciplinaDAO dao , Disciplina disciplina ) throws Exception
    {
        if( disciplina.getId() == 0 
                ? true 
                : disciplina.getId() < 3 )
        {
            throw new Exception( "O id da disciplina deve ter 3 digitos." );
        }
        else if( disciplina.getNome() == null 
                ? true 
                : disciplina.getNome().length() < 3 )
        {
            throw new Exception( "O nome da disciplina deve ser maior do que 3 letras." );
        }
         
    }
}
