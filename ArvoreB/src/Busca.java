// Busca.java
abstract class Busca extends ArvoreB {

    private Noh raiz;

    public Busca(Noh raiz) {
        this.raiz = raiz;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    // Método recursivo para buscar um valor na árvore
    private boolean buscarRecursivo(Noh raiz, int valor) {
        if (raiz == null) {
            return false;
        }

        if (valor == raiz.valor) {
            return true;
        }

        return valor < raiz.valor
            ? buscarRecursivo(raiz.esquerda, valor)
            : buscarRecursivo(raiz.direita, valor);
    }
}
