package br.edu.uninassau.provaColegiada.usuario.dao;

import br.edu.uninassau.provaColegiada.usuario.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author avld
 */
public class JpaUsuarioDAO implements UsuarioDAO
{
    private EntityManagerFactory factory;
    
    public JpaUsuarioDAO()
    {
        factory = Persistence.createEntityManagerFactory( "aplicacao" );
    }

    @Override
    public void adicionar( Usuario usuario ) throws Exception
    {
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();    
        manager.persist( usuario );
        manager.getTransaction().commit();

        manager.close();
    }

    @Override
    public void modificar( Usuario usuario ) throws Exception
    {
        EntityManager manager = factory.createEntityManager();
        
        manager.getTransaction().begin();    
        manager.merge( usuario );
        manager.getTransaction().commit();

        manager.close();
    }

    @Override
    public void excluir( int id ) throws Exception
    {
        EntityManager manager = factory.createEntityManager();

        // primeiro pega o usuario, depois deleta ele!
        Usuario usuario = manager.find( Usuario.class , id );
        
        manager.getTransaction().begin();    
        manager.remove( usuario );
        manager.getTransaction().commit();

        manager.close();
    }

    @Override
    public Usuario get( int id ) throws Exception
    {
        EntityManager manager = factory.createEntityManager();
        Usuario usuario = manager.find( Usuario.class , id );
        manager.close();

        return usuario;
    }

    @Override
    public List<Usuario> listar() throws Exception
    {
        EntityManager manager = factory.createEntityManager();

        String sql = "SELECT * FROM usuario";
        Query query = manager.createNativeQuery( sql , Usuario.class );

        List<Usuario> lista = query.getResultList();

        manager.close();

        return lista;
    }

    @Override
    public List<Usuario> listar( int categoria ) throws Exception
    {
        EntityManager manager = factory.createEntityManager();

        String sql = "SELECT * FROM usuario WHERE categoria = ?";
        Query query = manager.createNativeQuery( sql , Usuario.class );
        query.setParameter( 1 , categoria );

        List<Usuario> lista = query.getResultList();

        manager.close();

        return lista;
    }

    @Override
    public Usuario login( String email , String senha ) throws Exception
    {
        EntityManager manager = factory.createEntityManager();

        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        Query query = manager.createNativeQuery( sql , Usuario.class );
        query.setParameter( 1 , email );
        query.setParameter( 2 , senha );

        List<Usuario> lista = query.getResultList();

        manager.close();

        if( lista.isEmpty() )
        {
            return null;
        }
        else
        {
            return lista.get( 0 );
        }
    }
    
    
    
}
