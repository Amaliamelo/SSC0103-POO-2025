public class AVLTree extends BTree {
	   public AVLTree() {
	        super(new String[0]); // Inicializa a árvore com um vetor vazio
	    }
	
	public AVLTree(String[] heapVector) {
        super(new String[0]);
        for (String val : heapVector) {
            if (val != null) {
                insert(val);
            }
        }
    }

    public void insert(String value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.insert(value);
        }
    }
}
