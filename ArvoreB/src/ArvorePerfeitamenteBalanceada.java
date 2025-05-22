import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class ArvorePerfeitamenteBalanceada extends BTree {

	public ArvorePerfeitamenteBalanceada(BTree arvoreOriginal) {
        super(new ArrayList<>()); // Inicializa a árvore vazia
        balancear(arvoreOriginal);
    }

    private void balancear(BTree arvoreOriginal) {
    	// Obter os elementos da árvore original
        List<String> elementos = arvoreOriginal.toList();

        // Remover valores nulos da lista
        elementos.removeIf(Objects::isNull);

        // Ordenar os elementos
        Collections.sort(elementos);

        // Reconstruir a árvore balanceada
        this.root = construirArvoreBalanceada(elementos, 0, elementos.size() - 1);
    }

    private Node construirArvoreBalanceada(List<String> elementos, int inicio, int fim) {
        if (inicio > fim) {
            return null;
        }

        // Escolher o elemento do meio como raiz
        int meio = (inicio + fim) / 2;
        Node novoNo = new Node(elementos.get(meio));

        // Construir recursivamente a subárvore esquerda e direita
        novoNo.left = construirArvoreBalanceada(elementos, inicio, meio - 1);
        novoNo.right = construirArvoreBalanceada(elementos, meio + 1, fim);

        return novoNo;
    }
}
