/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Amália
 */
public class CD extends Produto{
    private String tituloAlbum;
    private String banda;
    private int ano;
    
    public CD(String codigoBarras, int quantidade, String tituloAlbum, String banda, int trilhas, String gravadora, int ano){
        super(codigoBarras, quantidade);
        this.tituloAlbum = tituloAlbum;
        this.banda = banda;
        this.ano = ano;
        this.trilhas = trilhas;
        this.gravadora = gravadora;
    }
    @Override
        		+ "Gravadora: " + gravadora + "\n" 
        		+ "Ano: " + ano +"\n" 
        		+ "trilhas:" + trilhas+"\n";
    }

	@Override
	public String getSumario() {
		return "CD \n"
	    		+ "Código: " + getCodigoBarras() + "\n"
	    		+ "Título: " + tituloAlbum + "\n"
	    		+ "Banda: " + banda + "\n" 
	    		+ "Gravadora: " + gravadora + "\n" 
	    		+ "Ano: " + ano +"\n" 
	    		+ "trilhas:" + trilhas +"\n"
				+"Quantidade: "+ getQuantidade() +"\n";
		}
	}
    
