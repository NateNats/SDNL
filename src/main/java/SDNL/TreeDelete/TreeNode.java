package SDNL.TreeDelete;

public class TreeNode {
    private int data;
    private TreeNode leftNode;
    private TreeNode rightNode;
    private TreeNode parent;

    public TreeNode(int data, TreeNode parent) {
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

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
