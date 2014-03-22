package br.edu.uninassau.provaColegiada.usuario.dao;

import br.edu.uninassau.provaColegiada.usuario.Usuario;
import java.util.List;

/**
 *
 * @author avld
 */
public interface UsuarioDAO
{
    public void adicionar( Usuario usuario ) throws Exception;
    public void modificar( Usuario usuario ) throws Exception;
    public void excluir( int id ) throws Exception;
    public Usuario get( int id ) throws Exception;
    
    public List<Usuario> listar() throws Exception;
    public List<Usuario> listar( int categoria ) throws Exception;
    
    public Usuario login( String email , String senha ) throws Exception;
}
