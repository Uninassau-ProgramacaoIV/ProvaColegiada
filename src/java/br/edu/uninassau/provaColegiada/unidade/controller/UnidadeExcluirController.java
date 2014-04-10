/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uninassau.provaColegiada.unidade.controller;

import br.edu.uninassau.provaColegiada.unidade.dao.UnidadeDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Iedo
 */
@WebServlet( "/unidade/excluir")
public class UnidadeExcluirController extends HttpServlet {
    
    public UnidadeExcluirController(){
        
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        UnidadeDAO dao = (UnidadeDAO) request.getAttribute("UnidadeDAO");
        int id = Integer.parseInt("id");
        
        try{
            dao.excluir(id);
            request.getSession().setAttribute("unidade_msg","Unidade Excluida com sucesso!");
            response.sendRedirect("/unidade/listar");
        }catch (Exception err){
            
            throw new ServletException(err);
        }
    }
    
    private void validar(UnidadeDAO dao, int id) throws Exception{
        
        if (id <= 0){
            
            throw new Exception ("ID deve ser maior que zero");
            
        }else if ( dao.get(id)!= null ){
            
            throw new Exception ("Unidade não existente");
            
        }
    }
}
