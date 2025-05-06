import java.util.*;

public class BTree {
    protected Node root;

    public BTree(String[] heapVector) {
        this.root = buildFromHeap(heapVector, 0);
    }

    private Node buildFromHeap(String[] vec, int index) {
        if (index >= vec.length || vec[index] == null) {
            return null;
        }
        Node node = new Node(vec[index]);
        node.left = buildFromHeap(vec, 2 * index + 1);
        node.right = buildFromHeap(vec, 2 * index + 2);
        return node;
    }

    public List<String> toList() {
        List<String> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(node != null ? node.data : null);
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        // Remove trailing nulls
        for (int i = result.size() - 1; i >= 0; i--) {
            if (result.get(i) == null) {
                result.remove(i);
            } else {
                break;
            }
        }

        return result;
    }

    public String toString() {
        if (root == null) return "digraph {\n}";

        StringBuilder sb = new StringBuilder("digraph {\n");
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int index = current.index;

            if (node.left != null) {
                int leftIndex = 2 * index + 1;
                sb.append(String.format("\"%d %s\" -> \"%d %s\"\n", index, node.data, leftIndex, node.left.data));
                queue.add(new Pair(node.left, leftIndex));
            }
            if (node.right != null) {
                int rightIndex = 2 * index + 2;
                sb.append(String.format("\"%d %s\" -> \"%d %s\"\n", index, node.data, rightIndex, node.right.data));
                queue.add(new Pair(node.right, rightIndex));
            }
        }

        sb.append("}");
        return sb.toString();
    }

    private static class Pair {
        Node node;
        int index;

        Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}
