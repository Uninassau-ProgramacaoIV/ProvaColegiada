package br.edu.uninassau.provaColegiada.usuario;

import br.edu.uninassau.provaColegiada.usuario.dao.ArquivoUsuarioDAO;
import br.edu.uninassau.provaColegiada.usuario.dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Esta classe ira instanicar o DAO e repassara para os Servlets
 * 
 * @author avld
 */
@WebFilter( "/usuario/*" )
public class UsuarioFiltro implements Filter
{
    private UsuarioDAO dao;
    
    public UsuarioFiltro()
    {
        // faz nada
    }
    
    @Override
    public void init( FilterConfig filterConfig ) throws ServletException
    {
        try
        {
            // Troque o ArquivoUsuarioDAO por ArquivoUsuarioDAO e veja
            // que vai continuar a mesma coisa...
            dao = new ArquivoUsuarioDAO();
            
            // Caso nao exista nenhum usuario no sistema, criar o 'admin'
            // isso daqui nao e necessario para os outros modulos
            if( dao.listar().isEmpty() )
            {
                Usuario usario = new Usuario();
                usario.setNome( "Adminstrador" );
                usario.setLogin( "admin" );
                usario.setSenha( "admin" );
                usario.setCategoria( Usuario.CATEGORIA_ADMIN );
                
                dao.adicionar( null );
            }
        }
        catch( Exception err )
        {
            // Ocorreu um erro grave ao tentar inicializar o UsuarioDAO
            throw new ServletException( err );
        }
    }

    @Override
    public void doFilter( ServletRequest request 
                        , ServletResponse response 
                        , FilterChain chain ) 
                            throws IOException, ServletException
    {
        request.setAttribute( "UsuarioDAO" , dao );
        chain.doFilter( request , response );
    }

    @Override
    public void destroy()
    {
        dao = null;
    }
    
}
