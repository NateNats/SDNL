package SDNL.UTS_225314097;

public class Tree <T extends Comparable<T>> {
    private Node<T> root;
    private int jumlahLeaves;

    public Tree(Node<T> node) {
        setRoot(node);
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
        Node<T> newNode = new Node<>(data);

        if (value < 0) {
            if (n.getLeft() != null) {
                insertPart(data, n.getLeft());
            } else {
                n.setLeft(newNode);
                newNode.setParent(n);
            }
        } else {
            if (n.getRight() != null) {
                insertPart(data, n.getRight());
            } else {
                n.setRight(newNode);
                newNode.setParent(n);
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
            return findHelper(dataSearch, n.getRight());
        }

        return findHelper(dataSearch, n.getLeft());
    }

    public void preOrderTraversal() {
        Node<T> pointer = root;
        preOrderHelper(pointer);
    }

    private void preOrderHelper(Node<T> node) {
        System.out.print(node.getData() + " ");

        if (node.getLeft() != null) {
            preOrderHelper(node.getLeft());
        }

        if (node.getRight() != null) {
            preOrderHelper(node.getRight());
        }
    }

    public void inOrderTraversal() {
        Node<T> pointer = root;
        inOrderHelper(pointer);
    }

    private void inOrderHelper(Node<T> node) {
        if (node.getLeft() != null) {
            inOrderHelper(node.getLeft());
        }

        System.out.print(node.getData() + " ");

        if (node.getRight() != null) {
            inOrderHelper(node.getRight());
        }

    }

    public void posOrderTraversal() {
        Node<T> pointer = root;
        posOrderHelper(pointer);
    }

    private void posOrderHelper(Node<T> node) {

        if (node.getLeft() != null) {
            posOrderHelper(node.getLeft());
        }

        if (node.getRight() != null) {
            posOrderHelper(node.getRight());
        }
        System.out.print(node.getData() + " ");
    }

    public void leaf() {
        jumlahLeaves = 0;
        leafHelper(root);

        System.out.printf("Jumlah leaves: %s\n", jumlahLeaves);

    }
    private void leafHelper(Node<T> node) {
        boolean isLeft, isRight;

        isLeft = node.getLeft() != null;

        isRight = node.getRight() != null;

        if (node.getRight() == null &&  node.getLeft() == null) {
            System.out.printf("leaf node dari %s adalah %s\n", node.getParent().getData(), node.getData());
            jumlahLeaves++;
        }

        if (isLeft) {
            leafHelper(node.getLeft());
        }

        if (isRight) {
            leafHelper(node.getRight());
        }
    }

    public void internalNode() {
        System.out.print("Node internal: ");
        internalNodeHelper(root);
        System.out.println();
    }

    private void internalNodeHelper(Node<T> node) {
        if (node.getLeft() != null || node.getRight() != null) {
            System.out.print(node.getData() + " ");
        }

        if (node.getLeft() != null) {
            internalNodeHelper(node.getLeft());
        }

        if (node.getRight() != null) {
            internalNodeHelper(node.getRight());
        }
    }

    public void print() {
        printTree(root, "-> ");
    }

    private void printTree(Node<T> root, String spaces) {
        if (root == null) return;
        System.out.println(spaces + root.getData());
        printTree(root.getRight(), "     " + spaces);
        printTree(root.getLeft(), "     " + spaces);
    }
}
