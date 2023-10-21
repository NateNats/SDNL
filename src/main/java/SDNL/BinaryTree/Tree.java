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
        Node<T> newNode = new Node<>(data);

        if (value < 0) {
            if (n.getLeftNode() != null) {
                insertPart(data, n.getLeftNode());
            } else {
                n.setLeftNode(newNode);
                newNode.setParent(n);
            }
        } else {
            if (n.getRightNode() != null) {
                insertPart(data, n.getRightNode());
            } else {
                n.setRightNode(newNode);
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
            return findHelper(dataSearch, n.getRightNode());
        }

        return findHelper(dataSearch, n.getLeftNode());
    }

    public boolean delete(T value) {
        Node<T> node = find(value);

        if (node == null) {
            return false;
        }

        deleteHelper(value, node);
        return true;
    }

    private void deleteHelper(T key, Node<T> node) {
        Node<T> tempNode = null;
        Node<T> tempParent = null;

        if (node.getData().compareTo(key) > 0) {
            deleteHelper(key, node.getLeftNode());

        } else if (node.getData().compareTo(key) < 0) {
            deleteHelper(key, node.getRightNode());

        } else {
            tempParent = node.getParent();

            if (node.hasLeft() && node.hasRight()) {            //node 2
                int left = depthHelper(node.getLeftNode());
                int right = depthHelper(node.getRightNode());

                Node<T> curr;
                T val;

                if (left >= right) {
                    curr = getPredeccessor(node);

                    if (curr.hasRight()) {
                        val = curr.getRightNode().getData();
                    } else {
                        val = curr.getData();
                    }

                    node.setData(val);
                    deleteHelper(val, curr);

                } else {
                    curr = getSuccessor(node);

                    if (curr.hasLeft()) {
                        val = curr.getLeftNode().getData();
                    } else {
                        val = curr.getData();
                    }

                    node.setData(val);
                    deleteHelper(val, curr);
                }

            } else if (node.hasLeft()) {                        //node 1
                tempNode = node.getLeftNode();
                tempNode.setParent(tempParent);
                tempParent.setLeftNode(tempNode);

            } else if (node.hasRight()) {                       //node 1
                tempNode = node.getRightNode();
                tempNode.setParent(tempParent);
                tempParent.setRightNode(tempNode);

            } else {                                            //node 0
                if (tempParent.getData().compareTo(key) > 0) {
                     tempParent.setLeftNode(null);


                } else if (tempParent.getData().compareTo(key) < 0) {
                    tempParent.setRightNode(null);

                }

                node.setParent(null);

            }
        }
    }

    private Node<T> getPredeccessor(Node<T> node) {
        Node<T> curr = node;

        if (curr.getLeftNode().getRightNode() == null) {
            return curr.getLeftNode();
        }

        curr = curr.getLeftNode();

        while (curr.getRightNode() != null) {
            curr = curr.getRightNode();
        }

        return curr;
    }

    private Node<T> getSuccessor(Node<T> node) {
        Node<T> curr = node;

        if (curr.getRightNode().getLeftNode() == null) {
            return curr.getRightNode();
        }

        curr = curr.getRightNode();

        while (curr.getLeftNode() != null) {
            curr = curr.getLeftNode();
        }

        return curr;
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

    public void depth() {
        System.out.print("Depth tree: ");
        System.out.println(depthHelper(root));
    }

    private int depthHelper(Node<T> node) {
        if (node == null) return 0;

        int left = depthHelper(node.getLeftNode());
        int right = depthHelper(node.getRightNode());

        return Math.max(left, right) + 1;
    }

    public void print() {
        printTree(root, "-> ");
    }

    private void printTree(Node<T> root, String spaces) {
        if (root == null) return;

        System.out.println(spaces + root.getData());

        // print right child first to achieve the tree-like printing effect
        printTree(root.getRightNode(), "     " + spaces);

        // then print left child
        printTree(root.getLeftNode(), "     " + spaces);
    }

    public void detailNode(Node<T> node) {
        getDetailNode(node);
    }

    private void getDetailNode(Node<T> node) {
        if (node == null) return;

        if (node.getParent() == null) {
            System.out.println("Parent: ");
        } else {
            System.out.println("Parent: " + node.getParent().getData());
        }

        System.out.println("Node: " + node.getData());
        System.out.println("left: " + ((node.getLeftNode() == null) ? " " : node.getLeftNode().getData()));
        System.out.println("Right: " + ((node.getRightNode() == null) ? " " : node.getRightNode().getData()));
        System.out.println();
        getDetailNode(node.getLeftNode());
        getDetailNode(node.getRightNode());
    }

}
