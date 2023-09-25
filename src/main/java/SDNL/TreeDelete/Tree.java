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
                    curr = curr.getRightNode();     //Jika getLeftNode tidak null, maka ubah curr menjadi curr.getRightNode
                }
            }
        }
    }

    public Node getRoot() {                         //method getRoot
        return root;
    }

    public void setRoot(Node root) {                //method setRoot
        this.root = root;
    }

    public Node find(int dataSearch) {                              //method find dengan parameter satu parameter yaitu dataSearch
        return findHelper(dataSearch, root);                        //memasukan parameter dataSearch dan root ke dalam method findHelper
                                                                    //lalu mengembalikan sebuah node yang akan dilepas
    }

    private Node findHelper(int dataSearch, Node node) {            //method findHelper bertipe Node dengan dua parameter, dataSearch dan node
        if (node == null || node.getData() == dataSearch) {         //mengecek apakah node == null atau node.getData() == dataSearch
            return node;                                            //jika ya, maka kembalikan node
        }

        if (node.getData() < dataSearch) {                          //jika node.getData() < dataSearch
            return findHelper(dataSearch, node.getRightNode());     //maka lakukan rekursif dengan parameter detaSearch dan node.getRightNode()
        }

        return findHelper(dataSearch, node.getLeftNode());          //mengembalikan node setelah melakukan method findHelper
    }

    public void preOrderTraversal() {             //method pre order
        Node pointer = root;                      //
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
        } else {
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

                return true;

            } else if (node.getLeftNode() == null) { // 1 node
                parent = node.getParent();
                node.getRightNode().setParent(parent);
                parent.setLeftNode(node.getRightNode());

                return true;
            } else {    //2 node

            }
        }

        return false;
    }

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

    public void cetak() {             //method pre order
        Node node = root;                      //
        cetakBantu(node);
    }

    private void cetakBantu(Node node) {
        boolean isLeft, isRight;

        System.out.println("nilai node: " + node.getData());
        System.out.println("Nilai Parent: " + ((node.getParent() == null ? "tidak ada" : node.getParent().getData())));

        if (node.getLeftNode() == null) {
            isLeft = false;
        } else {
            System.out.println("Nilai kiri: " + node.getLeftNode().getData());
            isLeft = true;
        }

        if (node.getRightNode() == null) {
            isRight = false;
        } else {
            System.out.println("Nilai kanan: " +  node.getRightNode().getData());
            isRight = true;
        }
        System.out.println();
        if (isLeft) {
            cetakBantu(node.getLeftNode());
        }

        if (isRight) {
            cetakBantu(node.getRightNode());
        }

    }
}
