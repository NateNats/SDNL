package SDNL.UTS;

public class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(int data) {
        if (getRoot() == null) {
            setRoot(new Node(data));
        }

        Node newNode = new Node(data);
        Node curr = root;

        while(curr != null) {
            if (curr.getData() > data) {
                if (curr.getLeft() == null) {
                    curr.setLeft(newNode);
                    newNode.setParent(curr);
                    return;

                } else {
                    curr = curr.getLeft();
                }

            } else {
                if (curr.getRight() == null) {
                    curr.setRight(newNode);
                    newNode.setParent(curr);
                } else  {
                    curr = curr.getRight();
                }
            }
        }
    }

    public void preOrder() {
        preOrderHelper(root);
    }

    public void inOrder() {
        inOrderHelper(root);
    }

    public void postOrder() {
        postOrderHelper(root);
    }

    private void preOrderHelper(Node node) {
        System.out.print(node.getData() + " ");

        if (node.getLeft() != null) {
            preOrderHelper(node.getLeft());
        }

        if (node.getRight() != null) {
            preOrderHelper(node.getRight());
        }
    }

    private void inOrderHelper(Node node) {
        if (node.getLeft() != null) {
            inOrderHelper(node.getLeft());
        }

        System.out.print(node.getData() + " ");

        if (node.getRight() != null) {
            inOrderHelper(node.getRight());
        }
    }

    private void postOrderHelper(Node node) {
        if (node.getLeft() != null) {
            postOrderHelper(node.getLeft());
        }

        if (node.getRight() != null) {
            postOrderHelper(node.getRight());
        }

        System.out.print(node.getData() + " ");
    }
}
