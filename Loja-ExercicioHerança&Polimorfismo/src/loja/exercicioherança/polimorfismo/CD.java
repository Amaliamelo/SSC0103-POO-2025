/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loja.exercicioherança.polimorfismo;

/**
 *
 * @author Amália
 */
public class CD extends Produto{
    private String tituloAlbum;
    private String banda;
    private int trilhas;
    private String gravadora;
    private int ano;
    
    public CD(String codigoBarras, int quantidade, String tituloAlbum, String banda, int trilhas, String gravadora, int ano){
        super(codigoBarras, quantidade);
        this.tituloAlbum = tituloAlbum;
        this.banda = banda;
        this.trilhas = trilhas;
        this.gravadora = gravadora;
        this.ano = ano;
    }
    @Override
    public String getDescricao() {
        return "CD - Título: " + tituloAlbum + ", Banda: " + banda + ", Ano: " + ano + ", Quantidade: " + getQuantidade();
    }
    
     // Método de fábrica para criar um CD a partir de uma string
    public static CD fromString(String[] partes) {
        String codigo = partes[2];
        String tituloAlbum = partes[3];
        String banda = partes[4];
        int trilhas = Integer.parseInt(partes[5]);
        String gravadora = partes[6];
        int ano = Integer.parseInt(partes[7]);

        return new CD(codigo, 1, tituloAlbum, banda, trilhas, gravadora, ano);
    }
}
