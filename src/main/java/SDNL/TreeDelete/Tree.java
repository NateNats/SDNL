package SDNL.TreeDelete;

public class Tree {
    private TreeNode root;

    public Tree() {}

    public Tree(TreeNode node) {
        
    }

    public void insert(int data) {}

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode find(int dataSearch) {
        return findHelper(dataSearch, root);
    }

    private TreeNode findHelper(int dataSearch, TreeNode node) {
        if (node == null || node.getData() == dataSearch) {
            return node;
        }

        if (node.getData() < dataSearch) {
            return findHelper(dataSearch, node.getRightNode());
        }

        return findHelper(dataSearch, node.getLeftNode());
    }

    public void preOrderTraversal() {
        TreeNode pointer = root;
        preOrderHelper(pointer);
    }

    private void preOrderHelper(TreeNode node) {
        System.out.print(node.getData() + " ");

        if (node.getLeftNode() != null) {
            preOrderHelper(node.getLeftNode());
        }

        if (node.getRightNode() != null) {
            preOrderHelper(node.getRightNode());
        }
    }

    public void inOrderTraversal() {
        TreeNode pointer = root;
        inOrderHelper(pointer);
    }

    private void inOrderHelper(TreeNode node) {
        if (node.getLeftNode() != null) {
            inOrderHelper(node.getLeftNode());
        }

        System.out.print(node.getData() + " ");

        if (node.getRightNode() != null) {
            inOrderHelper(node.getRightNode());
        }
    }

    public void posOrderTraversal() {
        TreeNode pointer = root;
        posOrderHelper(pointer);
    }

    private void posOrderHelper(TreeNode node) {

        if (node.getLeftNode() != null) {
            posOrderHelper(node.getLeftNode());
        }

        if (node.getRightNode() != null) {
            posOrderHelper(node.getRightNode());
        }

        System.out.print(node.getData() + " ");
    }



}
