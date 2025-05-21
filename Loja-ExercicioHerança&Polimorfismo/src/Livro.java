/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Amália Melo
 */
public class Livro extends Produto{
    private String titulo;
    private String primeiroAutor;
    private int ano;
    public Livro(String codigoBarras,int quantidade, String titulo, String primeiroAutor, String Editora, int Ano, int Edicao, int paginas, String idioma){
        super(codigoBarras, quantidade);
        this.titulo = titulo;
        this.primeiroAutor = primeiroAutor;
        this.ano = Ano;

    }
    @Override
    public String getDescricao() {
        return "Livro - Título: " + titulo + ", Autor: " + primeiroAutor + ", Ano: " + ano + ", Quantidade: " + getQuantidade();
    }
    
     // Método de fábrica para criar um Livro a partir de uma string
    public static Livro fromString(String[] partes) {
        String codigo = partes[2];
        String titulo = partes[3];
        String primeiroAutor = partes[4];
        String editora = partes[5];
        int ano = Integer.parseInt(partes[6]);
        int edicao = Integer.parseInt(partes[7]);
        int paginas = Integer.parseInt(partes[8]);
        String idioma = partes[9];

        return new Livro(codigo, 1, titulo, primeiroAutor, editora, ano, edicao, paginas, idioma);
    }
}
