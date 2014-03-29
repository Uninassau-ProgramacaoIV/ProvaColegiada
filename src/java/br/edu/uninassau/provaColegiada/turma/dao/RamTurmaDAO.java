package br.edu.uninassau.provaColegiada.turma.dao;

import br.edu.uninassau.provaColegiada.turma.Turma;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aluno
 */
public class RamTurmaDAO implements TurmaDAO
{
    private Map<Integer, Turma> repositorio;
    private int counter;
    
    public RamTurmaDAO()
    {
        repositorio = new HashMap<>();
        counter = 1;
    }

    @Override
    public void adicionar(Turma turma) throws Exception
    {
        turma.setId( counter++ );
        repositorio.put( turma.getId() , turma );
    }

    @Override
    public void modificar(Turma turma) throws Exception
    {
        repositorio.put( turma.getId() , turma );
    }

    @Override
    public void excluir(int id) throws Exception
    {
        repositorio.remove( id );
    }

    @Override
    public Turma get(int id) throws Exception
    {
      return repositorio.get( id );
    }

    @Override
    public List<Turma> listar() throws Exception
    {
        return new ArrayList<>( repositorio.values() );
    }
    
}
