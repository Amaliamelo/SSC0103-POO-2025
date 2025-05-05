
abstract class Inserir extends ArvoreB{

    private Noh raiz;

    public Inserir() {
        this.raiz = null;
    }

    @Override
    public void Inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }   

    // Método recursivo para inserir um valor na árvore
    private Noh inserirRecursivo(Noh raiz, int valor) {
        if (raiz == null) {
            raiz = new Noh(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.esquerda = inserirRecursivo(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = inserirRecursivo(raiz.direita, valor);
        }

        return raiz;
    }

    // Método para retornar a raiz
    public Noh getRaiz() {
        return raiz;
    }
}
