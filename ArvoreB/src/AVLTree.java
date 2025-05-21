import java.util.*;

public class AVLTree extends BTree {
    public List<String> heapVector;

    public AVLTree(List<String> heapVector) {
        super(new ArrayList<>()); // constrói a base sem nada
        this.heapVector = heapVector;

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

    public void delete(String value) {
        if (root != null) {
            root = root.delete(value);
        }
    }
    
}
