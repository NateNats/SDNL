package SDNL.BinaryTree;

public class Node <T extends Comparable<T>> implements Comparable<Node<T>> {
    private T data;
    private Node<T> leftNode;
    private Node<T> rightNode;
    private Node<T> parent;

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

    @Override
    public int compareTo(Node<T> o) {
        return this.getData().compareTo(o.getData());
    }
}
