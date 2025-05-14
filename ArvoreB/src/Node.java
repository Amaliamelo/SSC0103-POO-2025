public class Node {
    String data;
    Node left;
    Node right;

    public Node(String data) {
        this.data = data;
    }

    public int depth() {
        int leftDepth = (left != null) ? left.depth() : 0;
        int rightDepth = (right != null) ? right.depth() : 0;
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public int balanceFactor() {
        int leftDepth = (left != null) ? left.depth() : 0;
        int rightDepth = (right != null) ? right.depth() : 0;
        return leftDepth - rightDepth;
    }

    public void insert(String value) {
        if (value.compareTo(data) < 0) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else if (value.compareTo(data) > 0) {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
        rebalance();
    }

    private void rotateLeft() {
        Node newRoot = right;
        Node oldLeft = left;
        String oldData = data;

        // Atualiza dados e filhos
        data = newRoot.data;
        left = new Node(oldData);
        left.left = oldLeft;
        left.right = newRoot.left;
        right = newRoot.right;
    }

    private void rotateRight() {
        Node newRoot = left;
        Node oldRight = right;
        String oldData = data;

        data = newRoot.data;
        right = new Node(oldData);
        right.right = oldRight;
        right.left = newRoot.right;
        left = newRoot.left;
    }

    private void rotateLeftRight() {
        if (left != null) {
            left.rotateLeft();
        }
        rotateRight();
    }

    private void rotateRightLeft() {
        if (right != null) {
            right.rotateRight();
        }
        rotateLeft();
    }

    private void rebalance() {
        int balance = balanceFactor();
        if (balance > 1) {
            if (left != null && left.balanceFactor() < 0) {
                rotateLeftRight();
            } else {
                rotateRight();
            }
        } else if (balance < -1) {
            if (right != null && right.balanceFactor() > 0) {
                rotateRightLeft();
            } else {
                rotateLeft();
            }
        }
    }

    private Node findMin() {
        return (left == null) ? this : left.findMin();
    }

    public Node delete(String value) {
        if (value.compareTo(data) < 0) {
            if (left != null) {
                left = left.delete(value);
            }
        } else if (value.compareTo(data) > 0) {
            if (right != null) {
                right = right.delete(value);
            }
        } else {
            // Nó encontrado
            if (left == null) return right;
            if (right == null) return left;

            Node successor = right.findMin();
            this.data = successor.data;
            right = right.delete(successor.data);
        }

        rebalance();
        return this;
    }
}
