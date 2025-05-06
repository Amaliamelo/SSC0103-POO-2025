public class Main {
    public static void main(String[] args) {
        String[] heap = {
            "jose", "joao", "maria", null, null, null, "mario", null, null, null, null, null, null, null, "pedro"
        };

        AVLTree arvore = new AVLTree(heap);
        System.out.println(arvore.toString());
    }
}
