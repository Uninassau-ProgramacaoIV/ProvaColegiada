package br.edu.uninassau.provaColegiada.disciplina.dao;

import br.edu.uninassau.provaColegiada.disciplina.Disciplina;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aluno
 */
public class RamDisciplinaDAO implements DisciplinaDAO
{
    private Map<Integer, Disciplina> repositorio;
    private int counter;
    
    public RamDisciplinaDAO()
    {
        repositorio = new HashMap<>();
        counter = 1;
    }

    @Override
    public void adicionar(Disciplina disciplina) throws Exception
    {
        disciplina.setId( counter++ );
        repositorio.put( disciplina.getId() , disciplina );
    }

    @Override
    public void modificar(Disciplina disciplina) throws Exception
    {
        repositorio.put( disciplina.getId() , disciplina );
    }

    @Override
    public void excluir(int id) throws Exception
    {
        repositorio.remove( id );
    }

    @Override
    public Disciplina get(int id) throws Exception
    {
      return repositorio.get( id );
    }

    @Override
    public List<Disciplina> listar() throws Exception
    {
        return new ArrayList<>( repositorio.values() );
    }
    
}
