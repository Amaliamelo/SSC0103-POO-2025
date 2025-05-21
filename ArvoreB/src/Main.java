import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        String line;
        AVLTree tree = new AVLTree(new ArrayList<>()); // Inicializando com lista vazia

        while ((line = EntradaTeclado.leString()) != null && !line.trim().isEmpty()) {
            String[] parts = line.trim().split("\\s+");
            if (parts.length != 2) {
                continue;
            }

            String op = parts[0];
            String val = parts[1];

            switch (op) {
                case "i":
                    tree.insert(val);
                    break;
                case "d":
                        tree.delete(val);  
                    break;
                default:
                    break;
            }
        }

        System.out.println(tree.toString());

    }
}
