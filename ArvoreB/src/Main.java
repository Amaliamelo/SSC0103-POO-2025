import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        String line;
        AVLTree tree = new AVLTree(new ArrayList<>()); // Inicializando com lista vazia
        
        BTree  Btree = new BTree(new ArrayList<>());
        


        
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
                    Btree.insert(val);
                    break;
                case "d":
                        tree.delete(val);  
                        Btree.delete(val);
                    break;
                default:
                    break;
            }
        }
        
        ArvorePerfeitamenteBalanceada arvoreBalanceada = new ArvorePerfeitamenteBalanceada(Btree);
        System.out.println(arvoreBalanceada.toString());
        System.out.println();


        System.out.println(Btree.toString());
        System.out.println();

        System.out.println(tree.toString());
        System.out.println();



    }
}
