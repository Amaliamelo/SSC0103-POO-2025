/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Amália 
 */
public class DVD extends Produto{
    private String tituloFilme;
    private String diretor;
    private int ano;
    
    public DVD(String codigoBarras, int quantidade,  String tituloFilme, String diretor, String idioma, String genero, int ano, String nacionalidade){
        super(codigoBarras, quantidade);
        this.tituloFilme = tituloFilme;
        this.diretor = diretor;
        this.ano = ano;

    }
    
    @Override
    public String getDescricao() {
    	return "DVD \n"
        		+ "Código: " + getCodigoBarras() + "\n"
        		+ "Título: " + tituloFilme + "\n"
        		+ "Diretor: " + diretor + "\n" 
        		+ "Gênero: " + genero + "\n" 
        		+ "Ano: " + ano +"\n" 
        		+ "Nacionalidade:" + nacionalidade + "\n"
        		+"Idioma:" + idioma;   
    	}
    
    @Override
    public String getSumario() {
    	return "DVD \n"
        		+ "Código: " + getCodigoBarras() + "\n"
        		+ "Título: " + tituloFilme + "\n"
        		+ "Diretor: " + diretor + "\n" 
        		+ "Gênero: " + genero + "\n" 
        		+ "Ano: " + ano +"\n" 
        		+ "Nacionalidade:" + nacionalidade + "\n"
        		+"Idioma:" + idioma + "\n"
        		+ "Quantidade: "+ getQuantidade() +"\n";
    	}
    
    
}
