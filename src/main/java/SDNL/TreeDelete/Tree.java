package SDNL.TreeDelete;

public class Tree {
    private Node root;

    public Tree() {
        this.root = null;
    }

    public Tree(Node node) {
        this.root = node;
    }

    public void insertNode(int data) {
        Node newNode = new Node(data, null);
        if(root == null) {
            root = newNode;
            return;
        }

        Node curr = root;
        while (curr != null) {
            if (curr.getData() > newNode.getData()) {
                if (curr.getLeftNode() == null) {
                    curr.setLeftNode(newNode);
                    newNode.setParent(curr);
                    return;
                }
                curr = curr.getLeftNode();

            } else if (curr.getData() < newNode.getData()) {
                if (curr.getRightNode() == null) {
                    curr.setRightNode(newNode);
                    newNode.setParent(curr);
                    return;
                }
                curr = curr.getRightNode();
            }
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node find(int dataSearch) {
        return findHelper(dataSearch, root);
    }

    private Node findHelper(int dataSearch, Node node) {
        if (node == null || node.getData() == dataSearch) {
            return node;
        }

        if (node.getData() < dataSearch) {
            return findHelper(dataSearch, node.getRightNode());
        }

        return findHelper(dataSearch, node.getLeftNode());
    }

    public void preOrderTraversal() {
        Node pointer = root;
        preOrderHelper(pointer);
    }

    private void preOrderHelper(Node node) {
        System.out.print(node.getData() + " ");

        if (node.getLeftNode() != null) {
            preOrderHelper(node.getLeftNode());
        }

        if (node.getRightNode() != null) {
            preOrderHelper(node.getRightNode());
        }
    }

    public void inOrderTraversal() {
        Node pointer = root;
        inOrderHelper(pointer);
    }

    private void inOrderHelper(Node node) {
        if (node.getLeftNode() != null) {
            inOrderHelper(node.getLeftNode());
        }

        System.out.print(node.getData() + " ");

        if (node.getRightNode() != null) {
            inOrderHelper(node.getRightNode());
        }
    }

    public void posOrderTraversal() {
        Node pointer = root;
        posOrderHelper(pointer);
    }

    private void posOrderHelper(Node node) {

        if (node.getLeftNode() != null) {
            posOrderHelper(node.getLeftNode());
        }

        if (node.getRightNode() != null) {
            posOrderHelper(node.getRightNode());
        }

        System.out.print(node.getData() + " ");
    }

    //delete 0 anak
    public boolean delete (int key) {
        Node curr = root;
        while(curr != null) {
            if (curr.getData() != key) {
                if (curr.getData() > key) {
                    curr = curr.getLeftNode();
                } else {
                    curr = curr.getRightNode();
                }
            } else {
                curr.setLeftNode(null);
                return true;
            }
        }
        return false;
    }



}
