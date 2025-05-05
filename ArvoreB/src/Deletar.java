/**
 * @author usp
 */
abstract class Deletar extends ArvoreB {

    private Noh raiz;

    public Deletar(Noh raiz){
        this.raiz = raiz;
    }

    public void deletar(int valor) {
        raiz = deletarRecursivo(raiz, valor);
    }

    // Método recursivo para deletar um valor da árvore
    private Noh deletarRecursivo(Noh raiz, int valor) {
        if (raiz == null) {
            return raiz;
        }

        // Se o valor a ser deletado é menor que o valor da raiz, então está na subárvore esquerda
        if (valor < raiz.valor) {
            raiz.esquerda = deletarRecursivo(raiz.esquerda, valor);
        }
        // Se o valor a ser deletado é maior que o valor da raiz, então está na subárvore direita
        else if (valor > raiz.valor) {
            raiz.direita = deletarRecursivo(raiz.direita, valor);
        }
        // Caso o valor a ser deletado seja o valor da raiz
        else {
            // Nó com apenas um filho ou nenhum filho
            if (raiz.esquerda == null) {
                return raiz.direita;
            } else if (raiz.direita == null) {
                return raiz.esquerda;
            }

            // Nó com dois filhos: obtenha o sucessor in-order (mínimo na subárvore direita)
            raiz.valor = valorMinimo(raiz.direita);

            // Delete o sucessor in-order
            raiz.direita = deletarRecursivo(raiz.direita, raiz.valor);
        }

        return raiz;
    }

    // Método para encontrar o valor mínimo em uma árvore
    private int valorMinimo(Noh raiz) {
        int valorMinimo = raiz.valor;
        while (raiz.esquerda != null) {
            valorMinimo = raiz.esquerda.valor;
            raiz = raiz.esquerda;
        }
        return valorMinimo;
    }
}

