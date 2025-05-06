import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {

        String line;
        
        AVLTree tree = new AVLTree(); // Inicializando a árvore AVL

        // Processar as entradas
        while (!(line = EntradaTeclado.leString()).isEmpty()) {
            String[] parts = line.split(" ");
            String op = parts[0]; // 'i' ou 'd'
            String val = parts[1];   // Valor associado

            if (op.equals("i")) {
                tree.insert(val); // Inserir na árvore AVL
            } else if (op.equals("d")) {
                // Deletar da árvore AVL
            } else {
                System.out.println("Operação desconhecida: " + op);
            }
        }

        // Imprimir a representação da árvore no formato DOT
        System.out.println("Representação da árvore AVL:");
        System.out.println(tree.toString());
    }
}
