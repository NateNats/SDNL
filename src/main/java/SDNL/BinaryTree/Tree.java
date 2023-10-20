package SDNL.BinaryTree;

public class Tree <T extends Comparable<T>> {
    private Node<T> root;

    public Tree(Node<T> node) {
        if (root == null) {
            setRoot(node);
        }
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public void insert(T data) {
        insertPart(data, root);
    }

    private void insertPart(T data, Node<T> n) {
        if (getRoot() == null) {
            setRoot(new Node<>(data));
            return;
        }

        int value = data.compareTo(n.getData());

        if (value < 0) {
            if (n.getLeftNode() != null) {
                insertPart(data, n.getLeftNode());
            } else {
                n.setLeftNode(new Node<>(data));
            }
        } else {
            if (n.getRightNode() != null) {
                insertPart(data, n.getRightNode());
            } else {
                n.setRightNode(new Node<>(data));
            }
        }
    }

    public Node<T> find(T dataSearch) {
        return findHelper(dataSearch, root);
    }

    private Node<T> findHelper(T dataSearch, Node<T> n) {
        if (n == null || n.getData() == dataSearch) {
            return n;
        }

        if (n.getData().compareTo(dataSearch) < 0) {
            return findHelper(dataSearch, n.getRightNode());
        }

        return findHelper(dataSearch, n.getLeftNode());
    }


    public void preOrderTraversal() {
        Node<T> pointer = root;
        preOrderHelper(pointer);
    }

    private void preOrderHelper(Node<T> node) {
        System.out.print(node.getData() + " ");

        if (node.getLeftNode() != null) {
            preOrderHelper(node.getLeftNode());
        }

        if (node.getRightNode() != null) {
            preOrderHelper(node.getRightNode());
        }
    }

    public void inOrderTraversal() {
        Node<T> pointer = root;
        inOrderHelper(pointer);
    }

    private void inOrderHelper(Node<T> node) {
        if (node.getLeftNode() != null) {
            inOrderHelper(node.getLeftNode());
        }

        System.out.print(node.getData() + " ");

        if (node.getRightNode() != null) {
            inOrderHelper(node.getRightNode());
        }

    }

    public void posOrderTraversal() {
        Node<T> pointer = root;
        posOrderHelper(pointer);
    }

    private void posOrderHelper(Node<T> node) {

        if (node.getLeftNode() != null) {
            posOrderHelper(node.getLeftNode());
        }

        if (node.getRightNode() != null) {
            posOrderHelper(node.getRightNode());
        }
        System.out.print(node.getData() + " ");
    }

}
