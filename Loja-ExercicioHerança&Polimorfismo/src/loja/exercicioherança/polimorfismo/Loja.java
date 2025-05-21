/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package loja.exercicioherança.polimorfismo;
import java.util.ArrayList;

/**
 *
 * @author Amália
 */
public class Loja {
    private ArrayList<Produto> produtos;
    
    public Loja(){
        produtos = new ArrayList<>();
     
    }
    public void inserirProduto(String[] entrada) {
    try {
        String tipo = entrada[1];

        Produto produto = null;
        if (tipo.equalsIgnoreCase("Livro")) {
            produto = Livro.fromString(entrada);
        } else if (tipo.equalsIgnoreCase("CD")) {
            produto = CD.fromString(entrada);
        } else if (tipo.equalsIgnoreCase("DVD")) {
            produto = DVD.fromString(entrada);
        } else {
            System.out.println("Tipo de produto não reconhecido: " + tipo);
            return;
        }

        adicionarProduto(produto);
    } catch (Exception e) {
        System.out.println("Erro ao processar entrada: " + e.getMessage());
    }
}
    public void adicionarProduto(Produto novoProduto) {
        for (Produto produto : produtos) {
            if (produto.getCodigoBarras().equals(novoProduto.getCodigoBarras())) {
                produto.adicionarQuantidade(novoProduto.getQuantidade());
                System.out.println("Quantidade adicionada ao produto existente: " + produto.getDescricao());
                return;
            }
        }
        produtos.add(novoProduto);
        System.out.println("Novo produto adicionado: " + novoProduto.getDescricao());
    }
    
    public void venderProduto(String[] entrada) {
        try {
            String codigoBarras = entrada[1];
            int quantidade = Integer.parseInt(entrada[2]);

            boolean vendido = venderProduto(codigoBarras, quantidade);
            if (!vendido) {
                System.out.println("Falha ao realizar a venda.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao processar venda: " + e.getMessage());
        }
    }
     public boolean venderProduto(String codigoBarras, int quantidade) {
        for (Produto produto : produtos) {
            if (produto.getCodigoBarras().equals(codigoBarras)) {
                if (produto.venderQuantidade(quantidade)) {
                    System.out.println("Venda realizada: " + quantidade + " unidade(s) de " + produto.getDescricao());
                    return true;
                } else {
                    System.out.println("Estoque insuficiente para realizar a venda.");
                    return false;
                }
            }
        }
        System.out.println("Produto não encontrado.");
        return false;
    }

    public void procurarProdutoPorCodigo(String[] entrada) {
        try {
            String codigoBarras = entrada[1];
            Produto produto = procurarProdutoPorCodigo(codigoBarras);
            if (produto != null) {
                System.out.println("Produto encontrado: " + produto.getDescricao());
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao processar procura por código: " + e.getMessage());
        }
    }
    public Produto procurarProdutoPorCodigo(String codigoBarras) {
        for (Produto produto : produtos) {
            if (produto.getCodigoBarras().equals(codigoBarras)) {
                return produto;
            }
        }
        return null;
    }

    public void procurarProdutosPorNome(String[] entrada) {
        try {
            String nome = entrada[1];
            ArrayList<Produto> encontrados = procurarProdutosPorNome(nome);
            if (!encontrados.isEmpty()) {
                System.out.println("Produtos encontrados:");
                for (Produto produto : encontrados) {
                    System.out.println(produto.getDescricao());
                }
            } else {
                System.out.println("Nenhum produto encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao processar procura por nome: " + e.getMessage());
        }
    }
    public ArrayList<Produto> procurarProdutosPorNome(String nome) {
        ArrayList<Produto> encontrados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getDescricao().toLowerCase().contains(nome.toLowerCase())) {
                encontrados.add(produto);
            }
        }
        return encontrados;
    }

    public void sumarioDaLoja() {
        System.out.println("Sumário da Loja:");
        for (Produto produto : produtos) {
            System.out.println(produto.getDescricao());
        }
    }

}
