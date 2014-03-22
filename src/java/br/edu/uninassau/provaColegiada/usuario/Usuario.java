package br.edu.uninassau.provaColegiada.usuario;

/**
 * Esta classe representa um usuario salvo no banco de dados
 * 
 * @author avld
 */
public class Usuario
{
    public final static int CATEGORIA_ADMIN     = 0;
    public final static int CATEGORIA_PROFESSOR = 1;
    
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
