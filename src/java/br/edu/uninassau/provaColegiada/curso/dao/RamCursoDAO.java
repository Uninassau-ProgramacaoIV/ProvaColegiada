package br.edu.uninassau.provaColegiada.curso.dao;

import br.edu.uninassau.provaColegiada.curso.Curso;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author avld
 */
public class RamCursoDAO implements CursoDAO
{
    protected Map<Integer,Curso> repositorio;
    protected int counter;
    
    public RamCursoDAO()
    {
        repositorio = new HashMap<>();
        counter     = 1;
    }
    
    @Override
    public void adicionar( Curso curso ) throws Exception
    {
        curso.setId( counter++ );
        repositorio.put( curso.getId() , curso );
    }

    @Override
    public void modificar( Curso curso ) throws Exception
    {
        //O curso.getId() nao pode ser <= 0
        repositorio.put( curso.getId() , curso );
    }

    @Override
    public void excluir(int id) throws Exception
    {
        //O ID nao pode ser <= 0
        repositorio.remove( id );
    }

    @Override
    public Curso get(int id) throws Exception
    {
        return repositorio.get( id );
    }

    @Override
    public List<Curso> listar() throws Exception
    {
        return new ArrayList<>( repositorio.values() );
    }
}
