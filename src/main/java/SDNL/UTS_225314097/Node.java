package SDNL.UTS_225314097;

public class Node <T extends Comparable<T>> implements Comparable<Node<T>> {
    private T data;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;
    int height;

    public Node(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
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
