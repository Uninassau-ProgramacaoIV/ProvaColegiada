package br.edu.uninassau.provaColegiada.usuario;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta classe representa um usuario salvo no banco de dados
 * 
 * @author avld
 */
@Entity
@Table( name = "usuarios", schema = "prova_colegiada" )
public class Usuario implements Serializable
{
    public final static int CATEGORIA_ADMIN     = 0;
    public final static int CATEGORIA_PROFESSOR = 1;

    @Id
    @GeneratedValue
    private int id;
    
    private String nome;
    private String login;
    private String senha;
    private int categoria;
    
    public Usuario()
    {
        // do nothing
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin( String login )
    {
        this.login = login;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome( String nome )
    {
        this.nome = nome;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha( String senha )
    {
        this.senha = senha;
    }

    public int getCategoria()
    {
        return categoria;
    }

    public void setCategoria( int categoria )
    {
        this.categoria = categoria;
    }
    
}
