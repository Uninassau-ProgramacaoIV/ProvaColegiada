package br.edu.uninassau.provaColegiada.questao.dao;

import br.edu.uninassau.provaColegiada.questao.Questao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aluno
 */
public class RamQuestaoDAO implements QuestaoDAO
{
    private Map<Integer, Questao> repositorio;
    private int counter;
    
    public RamQuestaoDAO()
    {
        repositorio = new HashMap<>();
        counter = 1;
    }

    @Override
    public void adicionar(Questao questao) throws Exception
    {
        questao.setId( counter++ );
        repositorio.put( questao.getId() , questao );
    }

    @Override
    public void modificar(Questao questao) throws Exception
    {
        repositorio.put( questao.getId() , questao );
    }

    @Override
    public void excluir(int id) throws Exception
    {
        repositorio.remove( id );
    }

    @Override
    public Questao get(int id) throws Exception
    {
      return repositorio.get( id );
    }

    @Override
    public List<Questao> listar() throws Exception
    {
        return new ArrayList<>( repositorio.values() );
    }
    
}
