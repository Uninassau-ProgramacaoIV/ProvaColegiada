package br.edu.uninassau.provaColegiada.aluno.dao;

import br.edu.uninassau.provaColegiada.aluno.Aluno;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author avld
 */
public class RamAlunoDAO implements AlunoDAO
{
    protected Map<Integer,Aluno> repositorio;
    protected int counter;
    
    public RamAlunoDAO()
    {
        repositorio = new HashMap<>();
        counter     = 1;
    }
    
    @Override
    public void adicionar( Aluno aluno ) throws Exception
    {
        aluno.setId( counter++ );
        repositorio.put( aluno.getId() , aluno );
    }

    @Override
    public void modificar( Aluno aluno ) throws Exception
    {
        //O aluno.getId() nao pode ser <= 0
        repositorio.put( aluno.getId() , aluno );
    }

    @Override
    public void excluir(int id) throws Exception
    {
        //O ID nao pode ser <= 0
        repositorio.remove( id );
    }

    @Override
    public Aluno get(int id) throws Exception
    {
        return repositorio.get( id );
    }

    @Override
    public List<Aluno> listar() throws Exception
    {
        return new ArrayList<>( repositorio.values() );
    }
}
