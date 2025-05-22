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
    private String editora;
    private String primeiroAutor;
    private int ano;
    private int edicao;
    private int paginas;
    private String idioma;

    public Livro(String codigoBarras,int quantidade, String titulo, 
    		String primeiroAutor, String Editora, int Ano, int Edicao, int paginas, String idioma){
        super(codigoBarras, quantidade);
        this.titulo = titulo;
        this.primeiroAutor = primeiroAutor;
        this.ano = Ano;
        this.edicao = Edicao;
        this.paginas = paginas;
        this.idioma = idioma;
        this.editora = Editora;

    }
    @Override
    public String getDescricao() {
        return "Livro \n"
        		+ "Código: " + getCodigoBarras() + "\n"
        		+ "Título: " + titulo + "\n"
        		+ "Autor: " + primeiroAutor + "\n" 
        		+ "Editora: " + editora + "\n" 
        		+ "Edição: " + edicao + "\n" + 
        		"Ano: " + ano +"\n" 
        		+"Páginas:" + paginas + "\n"
        		+"Idioma:" + idioma+ "\n";
        }
    
    @Override
    public String getSumario() {
        return "Livro \n"
        		+ "Código: " + getCodigoBarras() + "\n"
        		+ "Título: " + titulo + "\n"
        		+ "Autor: " + primeiroAutor + "\n" 
        		+ "Editora: " + editora + "\n" 
        		+ "Edição: " + edicao + "\n" + 
        		"Ano: " + ano +"\n" 
        		+"Páginas:" + paginas + "\n"
        		+"Idioma:" + idioma + "\n"
        		+ "Quantidade: "+ getQuantidade() +"\n";
        }
    
    
    
}
