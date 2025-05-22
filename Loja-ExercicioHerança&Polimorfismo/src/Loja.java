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
    
    public Loja() {
        this.produtos = new ArrayList<>();
    }
   
    public void inserirProduto(String[] entrada) {

    try {

        String tipo = entrada[1];
        String codigoBarras = entrada[2];

        if (tipo.equalsIgnoreCase("Livro")) {
             String titulo = entrada[3];
             String primeiroAutor = entrada[4];
             String editora = entrada[5];
             int quantidade = 1;
             int ano = Integer.parseInt(entrada[6]);
             int paginas = Integer.parseInt(entrada[8]);
             int edicao = Integer.parseInt(entrada[7]);

             String idioma = entrada[9];


             produtos.add(new Livro(codigoBarras, quantidade, titulo, primeiroAutor, editora, 
             		ano, edicao, paginas, idioma));
            

            System.out.println("Operação inserir " + tipo.toLowerCase() + ": " + codigoBarras);
            System.out.println("Operação realizada com sucesso");
            System.out.println();

        } else if (tipo.equalsIgnoreCase("CD")) {
        	String tituloAlbum = entrada[3];
            String banda = entrada[4];
            String gravadora = entrada[6];
            int quantidade = 1;
            int trilhas = Integer.parseInt(entrada[5]);
            int ano = Integer.parseInt(entrada[7]);
            

            produtos.add(new CD(codigoBarras, quantidade, tituloAlbum, 
            		banda,trilhas,gravadora,ano));
           

           System.out.println("Operação inserir " + tipo.toLowerCase() + ": " + codigoBarras);
           System.out.println("Operação realizada com sucesso");
           System.out.println();
        } else if (tipo.equalsIgnoreCase("DVD")) {
        	String tituloFilme = entrada[3];
            String diretor = entrada[4];
            String idioma = entrada[5];
            String genero = entrada[6];
            String nacionalidade = entrada[8];
            int quantidade = 1;
            int ano = Integer.parseInt(entrada[7]);
            
            
            produtos.add(new DVD(codigoBarras,quantidade,tituloFilme,
            		diretor, idioma, genero, ano, nacionalidade));
           

           System.out.println("Operação inserir " + tipo.toLowerCase() + ": " + codigoBarras);
           System.out.println("Operação realizada com sucesso");
           System.out.println();
        } else {
            System.out.println("Tipo de produto não reconhecido: " + tipo);
            return;
        }
   
    } catch (Exception e) {
        System.out.println("Erro ao processar entrada: " + e.getMessage());
    }
}
    
    public void adicionarProduto(String[] parts) {
        try {
        	int quantidade = Integer.parseInt(parts[2]);
            String codigoBarras = parts[1];
            
            for (Produto produto : produtos) {
                if (produto.getCodigoBarras().equals(codigoBarras)) {
                    produto.adicionarQuantidade(quantidade);
                    System.out.println("Operação de compra: " + codigoBarras);
                    System.out.println("Operação realizada com sucesso: " + codigoBarras);
                    System.out.println();
                            return;
                }
            }
            System.out.println("Operação de compra: " + codigoBarras);
            System.out.println("***Erro: Código inexistente:" + codigoBarras);
            System.out.println();

        } catch (Exception e) {
            System.out.println("Erro ao processar adição de produto: " + e.getMessage());
            System.out.println();
        }
       }
    
    public void venderProduto(String[] entrada) {
        try {
            String codigoBarras = entrada[1];
            int quantidade = Integer.parseInt(entrada[2]);

            boolean vendido = venderProduto(codigoBarras, quantidade);
           
        } catch (Exception e) {
            System.out.println("Erro ao processar venda: " + e.getMessage());
        }
    }
     public boolean venderProduto(String codigoBarras, int quantidade) {
    	    Produto produtoParaRemover = null;

    	 for (Produto produto : produtos) {
            if (produto.getCodigoBarras().equals(codigoBarras)) {
                if (produto.venderQuantidade(quantidade)) {
                	 System.out.println("Operação de venda: " + codigoBarras);
                     System.out.println("Operação realizada com sucesso: " + codigoBarras);
                     System.out.println();
                     
                     if (produto.isEsgotado()) {
                         produtoParaRemover = produto; // Marca o produto para remoção
                     }
                               return true;
                } else {
                	System.out.println("Operação de venda: " + codigoBarras);
                    System.out.println("***Erro: Estoque insuficiente: " + codigoBarras + " Quantidade: " + quantidade);
                    System.out.println();
                    return false;
                }
            }
        }
    	
    	 if (produtoParaRemover != null){
    	    produtos.remove(produtoParaRemover); // Remove o produto fora do loop
    	 }
        System.out.println("Operação de venda: " + codigoBarras);
        System.out.println("***Erro: Código inexistente: " + codigoBarras);
        System.out.println();

        return false;
    }

    public void procurarProdutoPorCodigo(String[] entrada) {
        try {
            String codigoBarras = entrada[1];
            System.out.println("Procurando: " + codigoBarras);
            Produto produto = procurarProdutoPorCodigo(codigoBarras);
            if (produto != null) {
                System.out.println("Encontrado:" + produto.getDescricao());
                System.out.println();

            } else {
            	System.out.println("Produto não encontrado: " + codigoBarras);
                System.out.println();
            }
        } catch (Exception e) {
            String codigoBarras = entrada[1];

            System.out.println("Produto não encontrado: " + codigoBarras);
            System.out.println();
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
            System.out.println("Procurando: " + nome);
            if (!encontrados.isEmpty()) {
                System.out.println("Encontrado:");
                for (Produto produto : encontrados) {
                    System.out.println(produto.getDescricao());
                }
            } else {
                System.out.println("Nenhum produto encontrado.");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Erro ao processar procura por nome: " + e.getMessage());
            System.out.println();
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
    
    public void calcularQuantidadeTotalPorTipo() {
        int totalLivros = 0;
        int totalCDs = 0;
        int totalDVDs = 0;

        for (Produto produto : produtos) {
            if (produto instanceof Livro) {
                totalLivros += produto.getQuantidade();
            } else if (produto instanceof CD) {
                totalCDs += produto.getQuantidade();
            } else if (produto instanceof DVD) {
                totalDVDs += produto.getQuantidade();
            }
        }

        System.out.println("Quantidade total de produtos na loja:");
        System.out.println("Livros: " + totalLivros);
        System.out.println("CDs: " + totalCDs);
        System.out.println("DVDs: " + totalDVDs);
        System.out.println();
    }
    
    public void sumarioDaLoja() {
        System.out.println("Operação de sumarização:");
        produtos.removeIf(Produto::isEsgotado); // Remove produtos esgotados

        for (Produto produto : produtos) {
            System.out.println(produto.getSumario());
        }
        calcularQuantidadeTotalPorTipo();

    }

}
