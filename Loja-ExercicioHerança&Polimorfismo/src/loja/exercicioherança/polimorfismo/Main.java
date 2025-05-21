/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loja.exercicioherança.polimorfismo;

/**
 *
 * @author usp
 */
public class Main {
    public static void main(String[] args) {
        String line;
        Loja loja = new Loja();

        while ((line = EntradaTeclado.leString())!= null && !line.trim().isEmpty()) {
            String[] parts = line.trim().split("\\s+");
            if (parts.length != 2) {
                continue;
            }

            String op = parts[0];
            String tipo = parts[1];

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
                    loja.procurarProdutoPorCodigo(parts);
                    loja.procurarProdutosPorNome(parts);
                    break;
                case "S":
                    System.out.println("\nSumário da loja:");
                    loja.sumarioDaLoja();                    
                default:
                    break;
            }
        }
    }
}
