/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.IOException;

/**
 *
 * @author usp
 */
public class Main {

    public static void main(String[] args)  throws IOException {
        String line;
        Loja loja = new Loja();

        while ((line = EntradaTeclado.leString()) != null && !line.trim().isEmpty()) {
            String[] parts = line.trim().split(",");
            
            String op = parts[0];

            switch (op) {
                case "I":
                    loja.inserirProduto(parts);
                    break;
                case "A":
                    loja.adicionarProduto(parts);
                    break;
                case "V":
                    loja.venderProduto(parts);
                    break;
                case "P":
                	try {
                        // Tenta converter parts[1] para um número inteiro
                        Integer.parseInt(parts[1]);
                        // Se não lançar exceção, é um código de barras
                        loja.procurarProdutoPorCodigo(parts);
                    } catch (NumberFormatException e) {
                        // Se lançar exceção, é um nome
                        loja.procurarProdutosPorNome(parts);
                    }
                    break;
                case "S":
                    loja.sumarioDaLoja();                    
                default:
                    break;
            }
        }
    }
}

/*
 * I,Livro,8535283528,Introdução ao teste de software,Marcio Delamaro,GEN LTC,2017,2,448,PT-BR
I,Livro,8535226346,Introdução ao teste de software,Marcio Delamaro,ELSEVIER,2005,1,394,PT-BR
I,Livro,8522104999,Introdução á teoria da computação,Michael Sipser,Cengage Learning,2005,1,612,PT-BR
I,CD,8579715172,COLECAO MILTON NASCIMENTO,Milton Nascimento,10,Abril,2022
I,CD,093624684725,Ray Of Light,Madona,6,Rimo,2010
I,DVD,7899307921551,Tinker Bell E O Monstro Da Terra Do Nunca,John Doe,PT-BR,Animação,2003,Estadunidense
A,8535226346,10
A,8535283528,66
A,8535226346,33
P,8522104999
A,8522104999,22
A,8579715172,0
P,093624684725
A,093624684725,10
A,7899307921551,15
V,8579715172,1
A,8535226346,11
A,1234567890,2
V,1234567789,2
V,8535226346,11
P,1234567890
P,Introdução ao teste de software
V,093624684725,10
S
I,DVD,7899307921551,Tinker Bell E O Monstro Da Terra Do Nunca,John Doe,PT-BR,Animação,2003,Estadunidense
*/
