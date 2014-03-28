/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.uninassau.provaColegiada.disciplina.dao;

import br.edu.uninassau.provaColegiada.disciplina.Disciplina;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface DisciplinaDAO
{
    public void adicionar( Disciplina usuario ) throws Exception;
    public void modificar( Disciplina usuario ) throws Exception;
    public void excluir( int id ) throws Exception;
    public Disciplina get( int id ) throws Exception;
    
    public List<Disciplina> listar() throws Exception;
}
