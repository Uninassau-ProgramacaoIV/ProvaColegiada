package br.edu.uninassau.provaColegiada.unidade.dao;

import br.edu.uninassau.provaColegiada.unidade.Unidade;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aluno
 */
public class RamUnidadeDAO implements UnidadeDAO
{
    private Map<Integer, Unidade> repositorio;
    private int counter;
    
    public RamUnidadeDAO()
    {
        repositorio = new HashMap<>();
        counter = 1;
    }

    @Override
    public void adicionar(Unidade unidade) throws Exception
    {
        unidade.setId( counter++ );
        repositorio.put( unidade.getId() , unidade );
    }

    @Override
    public void modificar(Unidade unidade) throws Exception
    {
        repositorio.put( unidade.getId() , unidade );
    }

    @Override
    public void excluir(int id) throws Exception
    {
        repositorio.remove( id );
    }

    @Override
    public Unidade get(int id) throws Exception
    {
      return repositorio.get( id );
    }

    @Override
    public List<Unidade> listar() throws Exception
    {
        return new ArrayList<>( repositorio.values() );
    }
    
}
