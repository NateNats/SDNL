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
            if (curr.getData() > data) {            //menentukan letak dari node yang akan masuk di sebelah kiri
                if (curr.getLeftNode() == null) {   //mengecek apakah value getLeftNode == null
                    curr.setLeftNode(newNode);      /* jika ya, maka curr akan menjadikan newNode sebagai node barunya */
                    newNode.setParent(curr);        /* dan menjadikan curr sebagai parentnya */
                    return;

                } else {                            //Jika getLeftNode tidak null, maka ubah curr menjadi curr.getLeftNode
                    curr = curr.getLeftNode();
                }


            } else {                                //menentukan letak dari node yang akan masuk di sebelah kanan
                if (curr.getRightNode() == null) {  //mengecek apakah value getRightNode == null
                    curr.setRightNode(newNode);     /* jika ya, maka curr akan menjadikan newNode sebagai node barunya */
                    newNode.setParent(curr);        /* dan menjadikan curr sebagai parentnya */
                    return;

                } else {
                    curr = curr.getRightNode(); //Jika getLeftNode tidak null, maka ubah curr menjadi curr.getRightNode
                }
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

    public boolean delete (int key) {
        Node node = find(key);
        Node parent = null;

        if (node == null || node.getData() != key) {
            return false;
        }

        if (node.getLeftNode() == null && node.getRightNode() == null) { // 0 node
            parent = node.getParent();
            if (parent.getData() > key) {
                parent.setLeftNode(null);

            } if (parent.getData() < key) {
                parent.setRightNode(null);

            }
        } else if (node.getRightNode() == null) { //1 node
            parent = node.getParent();
            parent.setRightNode(node.getLeftNode());
            node.getLeftNode().setParent(parent);
//            Node find = findPredeccessor(node.getLeftNode());
//
//            node.setData(find.getData());
//            find.getParent().setRightNode(null);
//            find.getParent().setLeftNode(null);

//            find.getParent().setRightNode(null);
//            find.setParent(null);
//            node.getParent().setRightNode(null);
//            node.getParent().setRightNode(find);
//            find.setLeftNode(node.getLeftNode());

//            node.getParent().setRightNode(find);
//            find.setParent(node.getParent());
//            find.setLeftNode(node.getLeftNode());

            return true;

        } else if (node.getLeftNode() == null) { // 1 node
            parent = node.getParent();
            node.getRightNode().setParent(parent);
            parent.setLeftNode(node.getRightNode());

//            Node find = findSuccessor(node.getRightNode());
//
//            node.setData(find.getData());
//            find.getParent().setRightNode(null);
//            find.getParent().setLeftNode(null);

//            find.getParent().setLeftNode(null);
//            find.setParent(null);
//            node.getParent().setLeftNode(null);
//            node.getParent().setLeftNode(find);
//            find.setLeftNode(node.getRightNode());

//            node.getParent().setLeftNode(find);
//            find.setParent(node.getParent());
//            find.setRightNode(node.getRightNode());

            return true;
        } else {
            System.out.println("Program akan dibentuk pada pertemuan berikutnya...");
        }

        return false;
    }

//    private void deleteZeroNode(int key, Node node) {
//        Node curr = node;
//
//        while(curr.getData() != key) {
//            if (curr.getData() > key) {
//                curr = curr.getLeftNode();
//            } else {
//                curr = curr.getRightNode();
//            }
//        }
//
//        if (curr.getParent().getData() > key) { // node for 0 child
//            curr.getParent().setLeftNode(null);
//        } else {
//            curr.getParent().setRightNode(null);
//        }
//    }

    private Node findPredeccessor(Node node) {
        Node curr = null;
        if (node.getRightNode() == null) {
            return node;
        } else {
            curr = node.getRightNode();
        }

        while (curr.getRightNode() != null) {
            curr = curr.getRightNode();
        }

        return curr;
    }

    private Node findSuccessor(Node node) {
        Node curr = null;
        if (node.getLeftNode() == null) {
            return node;
        } else {
            curr = node.getLeftNode();
        }

        while (curr.getLeftNode() != null) {
            curr = curr.getLeftNode();
        }

        return curr;
    }

    public void printStructureV1(Node curr, int depth) {
        if (curr == null) {
            return;
        }
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        if (depth != 0) {
            System.out.print("\u2514\u2500");
        }
        System.out.println(curr.getData());
        printStructureV1(curr.getLeftNode(), depth + 1);
        printStructureV1(curr.getRightNode(), depth + 1);
    }
}
