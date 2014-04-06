/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uninassau.provaColegiada.unidade.controller;

import br.edu.uninassau.provaColegiada.unidade.dao.UnidadeDAO;
import br.edu.uninassau.provaColegiada.unidade.Unidade;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Iedo
 */
@WebServlet("/unidade/adicionar")
public class UnidadeAdicionarController extends HttpServlet {
    public UnidadeAdicionarController(){
        //iniciar
    }
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher("/unidade/adicionar.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        UnidadeDAO dao = (UnidadeDAO) request.getAttribute("UnidadeDAO");
        Unidade unidade = convertToUnidade(request);
        
        try{
            dao.adicionar(unidade);
            request.getSession().setAttribute("usuario_msg","Unidade adicionada com sucesso!");
            response.sendRedirect("/unidade/listar");
        }catch(Exception err){
                request.setAttribute("unidade", unidade);
                doGet(request,response);
            }
        
    }
    
    protected Unidade convertToUnidade(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        
        Unidade unidade = new Unidade();
        unidade.setId(id);
        
        return unidade;
    }
    
}
