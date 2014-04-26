
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author labcst3
 */
public class Estoque {
    public static void main(String[]args){
       Produto[]produtos;
       Scanner entrada = new Scanner(System.in);
        String nome;
        double preco;
        int qtd,opcao;
        int codigo;
        
       
       
       
        System.out.println("Informe a quantidade de produtos: ");
        qtd = entrada.nextInt();
        produtos = new Produto[qtd];
        
        for(int i= 0;i < produtos.length;i++){
            
            System.out.println("Digite o codigo do produto "+(i+1));
            codigo = entrada.nextInt();
            entrada.nextLine();
            
            System.out.println("Digite o nome do produto "+(i+1));
            nome = entrada.nextLine();
            
            
            System.out.println("Digite o preço do produto "+(i+1));
            preco = entrada.nextDouble();
            entrada.nextLine();
            
            System.out.println("Digite o quantidade do produto "+(i+1));
            qtd = entrada.nextInt();
            entrada.nextLine();
            
            Produto p1 = new Produto (nome, preco, qtd, codigo);
            produtos[i] = p1;
        }
        
        System.out.println("Digite 1-Listar, 2-ordenar,3-consultar");
        opcao = entrada.nextInt();
        
        switch(opcao){
            case 1:
       for (Produto produto : produtos) {
           System.out.println(produto.getCodigo());
           System.out.println(produto.getNome());
           System.out.println(produto.getQtd());
           System.out.println(produto.getPreco());
       }
                break;
      }
        
   }
    
}
