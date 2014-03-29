package br.edu.uninassau.provaColegiada.curso;

/**
 * Esta classe representa um curso no sistema.
 * 
 * @author avld
 */
public class Curso
{
    private int    id;
    private String nome;
    private int    maxPeriodo;
    private String coordenador;
    
    public Curso()
    {
        // faz nada
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMaxPeriodo() {
        return maxPeriodo;
    }

    public void setMaxPeriodo(int maxPeriodo) {
        this.maxPeriodo = maxPeriodo;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }
    
    
}
