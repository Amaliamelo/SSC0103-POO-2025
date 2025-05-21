/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


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
        String codigoBarras = entrada[2];

        if (tipo.equalsIgnoreCase("Livro")) {
        } else if (tipo.equalsIgnoreCase("CD")) {
        } else if (tipo.equalsIgnoreCase("DVD")) {
        } else {
            System.out.println("Tipo de produto não reconhecido: " + tipo);
            return;
        }

        adicionarProduto(entrada);
        System.out.println("Operação inserir " + tipo.toLowerCase() + ": " + codigoBarras);
        System.out.println("Operação realizada com sucesso");
   
    } catch (Exception e) {
        System.out.println("Erro ao processar entrada: " + e.getMessage());
    }
}
    public void adicionarProduto(String[] parts) {
        try {
            String codigoBarras = parts[1];
            int quantidade = Integer.parseInt(parts[2]);

            for (Produto produto : produtos) {
                if (produto.getCodigoBarras().equals(codigoBarras)) {
                    produto.adicionarQuantidade(quantidade);
                    System.out.println("Operação de compra: " + codigoBarras);
                    System.out.println("Operação realizada com sucesso: " + codigoBarras);
                            return;
                }
            }

            System.out.println("Produto com código de barras " + codigoBarras + " não encontrado para adicionar quantidade.");
        } catch (Exception e) {
            System.out.println("Erro ao processar adição de produto: " + e.getMessage());
        }
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
                	 System.out.println("Operação de venda: " + codigoBarras);
                     System.out.println("Operação realizada com sucesso: " + codigoBarras);
                               return true;
                } else {
                	System.out.println("Operação de venda: " + codigoBarras);
                    System.out.println("***Erro: Estoque insuficiente: " + codigoBarras + " Quantidade: " + quantidade);
                             return false;
                }
            }
        }
        System.out.println("Operação de venda: " + codigoBarras);
        System.out.println("***Erro: Código inexistente: " + codigoBarras);
        return false;
    }

    public void procurarProdutoPorCodigo(String[] entrada) {
        try {
            String codigoBarras = entrada[1];
            System.out.println("Procurando: " + codigoBarras);

            Produto produto = procurarProdutoPorCodigo(codigoBarras);
            if (produto != null) {
                System.out.println("Encontrado:\n" + produto.getDescricao());
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (Exception e) {
            String codigoBarras = entrada[1];

            System.out.println("Produto não encontrado: " + codigoBarras);
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
