package br.edu.uninassau.provaColegiada.usuario.dao;

import br.edu.uninassau.provaColegiada.DAO;
import br.edu.uninassau.provaColegiada.usuario.Usuario;
import java.util.List;

/**
 *
 * @author avld
 */
public interface UsuarioDAO extends DAO<Usuario>
{
    public List<Usuario> listar( int categoria ) throws Exception;
    public Usuario login( String email , String senha ) throws Exception;
}
