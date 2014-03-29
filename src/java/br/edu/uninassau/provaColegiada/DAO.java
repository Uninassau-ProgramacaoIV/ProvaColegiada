package br.edu.uninassau.provaColegiada;

import java.util.List;

/**
 * Esta classe é generica. Para saber mais, leia esse artigo:
 * http://www.tiexpert.net/programacao/java/generics.php
 * 
 * @author avld
 */
public interface DAO<T>
{
    public void adicionar( T t )throws Exception;
    public void modificar( T t )throws Exception;
    public T get( int id )throws Exception;
    public void excluir( int id )throws Exception;
    public List<T> listar() throws Exception;
}
