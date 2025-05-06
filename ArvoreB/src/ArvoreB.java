/**
 * @author usp
 */
abstract class ArvoreB {
    // Esta classe pode ser estendida para adicionar funcionalidades gerais para árvores.
    public abstract void Inserir(String valor);
    public abstract boolean Busca(int v);
    public abstract boolean Deletar(String valor);
    public abstract int len();
    public abstract String toString();
    
    private int len;

    public ArvoreB(int len) {
        this.len = len;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }


}
    

