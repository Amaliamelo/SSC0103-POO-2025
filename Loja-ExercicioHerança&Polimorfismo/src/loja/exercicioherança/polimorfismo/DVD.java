/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loja.exercicioherança.polimorfismo;

/**
 *
 * @author Amália 
 */
public class DVD extends Produto{
    private String tituloFilme;
    private String diretor;
    private String idioma;
    private String genero;
    private int ano;
    private String nacionalidade;
    
    
    public DVD(String codigoBarras, int quantidade,  String tituloFilme, String diretor, String idioma, String genero, int ano, String nacionalidade){
        super(codigoBarras, quantidade);
        this.tituloFilme = tituloFilme;
        this.diretor = diretor;
        this.idioma = idioma;
        this.genero = genero;
        this.ano = ano;
        this.nacionalidade = nacionalidade;

    }
    
    @Override
    public String getDescricao() {
        return "DVD - Título: " + tituloFilme + ", Diretor: " + diretor + ", Ano: " + ano + ", Quantidade: " + getQuantidade();
    }
    
    public static DVD fromString(String[] partes) {
        String codigo = partes[2];
        String tituloFilme = partes[3];
        String diretor = partes[4];
        String idioma = partes[5];
        String genero = partes[6];
        int ano = Integer.parseInt(partes[7]);
        String nacionalidade = partes[8];

        return new DVD(codigo, 1, tituloFilme, diretor, idioma, genero, ano, nacionalidade);
    }
}
