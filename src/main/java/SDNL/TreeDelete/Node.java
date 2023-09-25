package SDNL.TreeDelete;

public class Node {
    private int data;
    private Node leftNode, rightNode ,parent;

    public Node(int data, Node parent) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
        this.parent = parent;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void insert(int data) {
        if (this.getData() > data) {
            this.setLeftNode(new Node(data, this));
        } else {
            this.setRightNode(new Node(data, this));
        }
    }

//    public boolean hasLeft() {
//        return this.getLeftNode() != null;
//    }
//
//    public boolean hasRight() {
//        return this.getRightNode() != null;
//    }
}
