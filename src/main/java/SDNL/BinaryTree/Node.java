package SDNL.BinaryTree;

public class Node <T extends Comparable<T>> implements Comparable<Node<T>> {
    private T data;
    private Node<T> leftNode;
    private Node<T> rightNode;
    private Node<T> parent;
    int height;

    public Node(T data) {
        this.data = data;
        leftNode = null;
        rightNode = null;
    }

    public Node() {}

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public boolean hasLeft() {
        return leftNode != null;
    }

    public boolean hasRight() {
        return rightNode != null;
    }

    public void insert(T value) {
        if (this.data == value) {
            return;
        }

        insertHelper(value, this);
    }

    private void insertHelper(T value, Node<T> node) {
        Node<T> newNode = new Node<>(value);

        if (node.getLeftNode() == null) {
            node.setLeftNode(newNode);
            newNode.setParent(node);
        } else {
            node.setRightNode(newNode);
            newNode.setParent(node);

        }
    }

    @Override
    public int compareTo(Node<T> o) {
        return this.getData().compareTo(o.getData());
    }
}
