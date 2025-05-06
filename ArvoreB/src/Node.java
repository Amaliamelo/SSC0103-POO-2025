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
        if (value.compareTo(data) <= 0) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
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
        Node temp = new Node(data);
        temp.left = left;
        temp.right = newRoot.left;

        data = newRoot.data;
        left = temp;
        right = newRoot.right;
    }

    private void rotateRight() {
        Node newRoot = left;
        Node temp = new Node(data);
        temp.right = right;
        temp.left = newRoot.right;

        data = newRoot.data;
        right = temp;
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
}
