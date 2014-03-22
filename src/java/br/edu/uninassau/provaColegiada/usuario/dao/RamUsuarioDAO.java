package br.edu.uninassau.provaColegiada.usuario.dao;

import br.edu.uninassau.provaColegiada.usuario.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author avld
 */
public class RamUsuarioDAO implements UsuarioDAO
{
    protected Map<Integer,Usuario> repositorio;
    protected int counter;
    
    public RamUsuarioDAO()
    {
        repositorio = new HashMap<>();
        counter     = 1;
    }
    
    @Override
    public void adicionar( Usuario usuario ) throws Exception
    {
        usuario.setId( counter++ );
        repositorio.put( usuario.getId() , usuario );
    }

    @Override
    public void modificar( Usuario usuario ) throws Exception
    {
        //O usuario.getId() nao pode ser <= 0
        repositorio.put( usuario.getId() , usuario );
    }

    @Override
    public void excluir(int id) throws Exception
    {
        //O ID nao pode ser <= 0
        repositorio.remove( id );
    }

    @Override
    public Usuario get(int id) throws Exception
    {
        return repositorio.get( id );
    }

    @Override
    public List<Usuario> listar() throws Exception
    {
        return new ArrayList<>( repositorio.values() );
    }

    @Override
    public List<Usuario> listar(int categoria) throws Exception
    {
        // Lista de usuario da mesma categoria
        List<Usuario> l = new ArrayList<>();
        
        // Vare todos os usuario
        for( Usuario usu : repositorio.values() )
        {
            // Seleciona apenas os usuario da mesma categoria
            if( usu.getCategoria() == categoria ) 
            {
                l.add( usu );
            }
        }
        
        return l;
    }

    @Override
    public Usuario login( String login , String senha ) throws Exception
    {
        // Ira procurar em todos os usuarios cadastrado o login e senha
        for( Usuario usu : repositorio.values() )
        {
            if( login.equals( usu.getLogin() )
                    && senha.equals( usu.getSenha() ) )
            {
                // encontrou um usuario
                return usu;
            }
        }
        
        // nao encontrou nenhum usuario com o login e a senha
        return null;
    }

}
