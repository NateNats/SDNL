package SDNL.TreeExpression;

public class TreeNode {
    TreeNode leftNode;
    char data;
    TreeNode rightNode;

    public TreeNode(char nodeData) {
        this.data = nodeData;
    }

    public void insert(char insertValue) {
        if (insertValue < data) {
            if (leftNode == null) {
                leftNode = new TreeNode(insertValue);
            } else {
                leftNode.insert(insertValue);
            }

        } else if (insertValue > data) {
            if (rightNode == null) {
                rightNode = new TreeNode(insertValue);
            } else {
                rightNode.insert(insertValue);
            }
        }
    }
}



class Tree {
    private TreeNode root;

    public Tree() {
        root = null;
    }

    public void setRootTree(TreeNode treeNode) {
        root = treeNode;
    }

    public void insertNode (char insertValue) {
        if (root == null) {
            root = new TreeNode(insertValue);
        } else {
            root.insert(insertValue);
        }
    }

    public void preOrderTraversal() {

    }

    private void preOrderHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrderHelper(node.leftNode);
        preOrderHelper(node.rightNode);
    }
}
