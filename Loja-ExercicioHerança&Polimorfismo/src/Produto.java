

/**
 *
 * @author Amalia Melo
 */
public abstract class Produto {
    private String codigoBarras;
    private int quantidade;
    
    
    public Produto(String codigoBarras, int quantidade){
        this.codigoBarras = codigoBarras;
        this.quantidade = quantidade;
    }
    
    public String getCodigoBarras() {
        return codigoBarras;
        
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public boolean venderQuantidade(int quantidade) {

        if (this.quantidade >= quantidade) {

            this.quantidade -= quantidade;
            return true;
        }
        return false;
    }
    
    public boolean isEsgotado() {
        return this.quantidade == 0;
    }


    public abstract String getDescricao();
	public abstract String getSumario();

}
