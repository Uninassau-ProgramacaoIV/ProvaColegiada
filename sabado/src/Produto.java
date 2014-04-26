/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author labcst3
 */
public class Produto {
    private String nome;
    private double preco;
    private int qtd;
    private int codigo;
    
    
   public Produto(String nome, double preco, int quantidade, int codigo){
       this.codigo = codigo;
       this.nome = nome;
       this.preco = preco;
       this.qtd = quantidade;
       
   }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the quantidade
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQtd(int quantidade) {
        this.qtd = quantidade;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
}

