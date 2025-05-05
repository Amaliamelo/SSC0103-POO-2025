/**
 * @author usp
 */
public class Noh {
    int valor;
    Noh esquerda, direita;

    public Noh(int valor) {
        this.valor = valor;
        this.esquerda = this.direita = null;
    }
}
