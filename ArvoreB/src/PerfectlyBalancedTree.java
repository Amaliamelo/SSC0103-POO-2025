import java.util.*;

public class PerfectlyBalancedTree extends BTree {

    public PerfectlyBalancedTree(BTree originalTree) {
        super(new ArrayList<>()); // Initialize an empty tree
        balance(originalTree);
    }

    private void balance(BTree originalTree) {
        // Get elements from the original tree
        List<String> elements = originalTree.toList();

        // Remove null values from the list
        elements.removeIf(Objects::isNull);

        // Sort the elements
        Collections.sort(elements);

        // Rebuild the balanced tree
        this.root = buildBalancedTree(elements, 0, elements.size() - 1);
    }

    private Node buildBalancedTree(List<String> elements, int start, int end) {
        if (start > end) {
            return null;
        }

        // Choose the middle element as the root
        int middle = (start + end) / 2;
        Node newNode = new Node(elements.get(middle));

        // Recursively build the left and right subtrees
        newNode.left = buildBalancedTree(elements, start, middle - 1);
        newNode.right = buildBalancedTree(elements, middle + 1, end);

        return newNode;
    }
}
