package SDNL.TreeDelete;

public class Tree {
    private Node root;
    private int predeOrSucc;
    private int jumlahLeaves;
    private int jumlahInternal;

    public Tree() {
        this.root = null;
    }

    public Tree(Node node) {
        this.root = node;
    }

    public int isPredeOrSucc() {
        return predeOrSucc;
    }

    public void setPredeOrSucc(int predeOrSucc) {
        this.predeOrSucc = predeOrSucc;
    }

    public int getJumlahLeaves() {
        return jumlahLeaves;
    }

    public int getJumlahInternal() {
        return jumlahInternal;
    }

    public Node getRoot() {                         //method getRoot
        return root;
    }

    public void setRoot(Node root) {                //method setRoot
        this.root = root;
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


    public Node search(int dataSearch) {                              //method find dengan parameter satu parameter yaitu dataSearch
        return searchHelper(dataSearch, root);                        //memasukan parameter dataSearch dan root ke dalam method findHelper
                                                                    //lalu mengembalikan sebuah node yang akan dilepas
    }

    private Node searchHelper(int dataSearch, Node node) {            //method findHelper bertipe Node dengan dua parameter, dataSearch dan node
        if (node == null || node.getData() == dataSearch) {         //mengecek apakah node == null atau node.getData() == dataSearch
            return node;                                            //jika ya, maka kembalikan node
        }

        if (node.getData() < dataSearch) {                          //jika node.getData() < dataSearch
            return searchHelper(dataSearch, node.getRightNode());     //maka lakukan rekursif dengan parameter detaSearch dan node.getRightNode()
        }

        return searchHelper(dataSearch, node.getLeftNode());          //mengembalikan node setelah melakukan method findHelper
    }

    public void preOrderTraversal() {             //method pre order
        Node pointer = root;                      //node pointer menunjuk ke root
        preOrderHelper(pointer);                  //memasukan parameter pointer ke dalam method preOrderHelp
    }

    private void preOrderHelper(Node node) {    //preOrderHelp
        System.out.print(node.getData() + " "); //menampilkan nilai node

        if (node.getLeftNode() != null) {       //jika node memiliki kiri
            preOrderHelper(node.getLeftNode()); //rekursif preOrderhelper menggunakan kiri
        }

        if (node.getRightNode() != null) {      //jika node memiliki kanan
            preOrderHelper(node.getRightNode());//rekursif preOrderhelper menggunakan kanan
        }
    }

    public void inOrderTraversal() {            //method inOrder
        Node pointer = root;                    //node pointer menunjuk ke root
        inOrderHelper(pointer);                 //memasukan parameter pointer ke dalam method inOrderHelper
    }

    private void inOrderHelper(Node node) {     //inOrder
        if (node.getLeftNode() != null) {       //jika node memiliki kiri
            inOrderHelper(node.getLeftNode());  //rekursif inOrderHelper menggunakan kiri
        }

        System.out.print(node.getData() + " "); //menampilkan data node

        if (node.getRightNode() != null) {      //jika node memiliki kanan
            inOrderHelper(node.getRightNode()); //rekursif inOrderHelper menggunakan kanan
        }
    }

    public void postOrderTraversal() {          //postOrder
        Node pointer = root;                    //node pointer menunjuk ke root
        postOrderHelper(pointer);               //memasukan parameter pointer ke dalam method postOrderHelper
    }

    private void postOrderHelper(Node node) { //postOrderHelper

        if (node.getLeftNode() != null) {           //jika node memiliki kiri
            postOrderHelper(node.getLeftNode());    //rekursif postOrderHelper menggunakan kiri
        }

        if (node.getRightNode() != null) {          //jika node memiliki kanan
            postOrderHelper(node.getRightNode());   //rekursif postOrderHelper menggunakan kanan
        }

        System.out.print(node.getData() + " ");     //menampilkan nilai node
    }

    public boolean delete(int key) {
        Node deleteNode = search(key);

        if (deleteNode == null || deleteNode.getData() != key) {
            return false;
        }

        Node deleteParent = deleteNode.getParent();

        if (deleteNode.getRightNode() != null && deleteNode.getLeftNode() != null) {     //delete 2 node
            if (isPredeOrSucc() == 1) {                                                         //predeccessor

                Node predeNode = findPredeccessor(deleteNode);

                Node childLeft = deleteNode.getLeftNode();
                Node childRight = deleteNode.getRightNode();
                Node predeParent = predeNode.getParent();

                if (deleteNode.getParent() == null) {                                            //prede root
                    if (predeNode.getLeftNode() != null) {
                        predeNode.getLeftNode().setParent(predeParent);
                        predeParent.setRightNode(predeNode.getLeftNode());

                        predeNode.setParent(null);
                        predeParent.setRightNode(null);
                        this.setRoot(predeNode);
                        this.root.setLeftNode(childLeft);
                        childLeft.setParent(this.root);
                        this.root.setRightNode(childRight);
                        childRight.setParent(this.root);

                    } else if (predeNode.getLeftNode() == null) {
                        predeNode.setParent(null);
                        predeParent.setRightNode(null);
                        this.setRoot(predeNode);
                        this.root.setLeftNode(childLeft);
                        childLeft.setParent(this.root);
                        this.root.setRightNode(childRight);
                        childRight.setParent(this.root);
                    }

                } else if (deleteNode.getParent() != null) {                                     //prede non root

                    deleteNode.setLeftNode(null);
                    deleteNode.setRightNode(null);
                    deleteNode.setParent(null);
                    if (deleteParent.getData() > predeNode.getData()) {
                        deleteParent.setLeftNode(predeNode);
                    } else if (deleteParent.getData() < predeNode.getData()) {
                        deleteParent.setRightNode(predeNode);
                    }


                    if (predeNode.getLeftNode() != null && predeNode.getParent().getData() != deleteNode.getData()) {
                        predeParent.setRightNode(predeNode.getLeftNode());
                        predeNode.getLeftNode().setParent(predeParent);
                        predeNode.setParent(deleteParent);
                        predeNode.setLeftNode(childLeft);
                        childLeft.setParent(predeNode);
                        predeNode.setRightNode(childRight);
                        childRight.setParent(predeNode);
                        predeParent.setRightNode(null);

                        return true;

                    } else if (predeNode.getLeftNode() == null && predeNode.getParent().getData() != deleteNode.getData()) {
                        predeNode.setParent(deleteParent);
                        predeNode.setLeftNode(childLeft);
                        childLeft.setParent(predeNode);
                        predeNode.setRightNode(childRight);
                        childRight.setParent(predeNode);
                        predeParent.setRightNode(null);

                        return true;
                    }

                    if (deleteNode.getRightNode() == null) {
                        childLeft.setParent(deleteParent);
                        deleteParent.setLeftNode(childLeft);
                        childRight.setParent(childLeft);
                        childLeft.setRightNode(childRight);
                        return true;
                    }

                }


            } else if (isPredeOrSucc() == 2) {                                                  //successor
                Node succNode = findSuccessor(deleteNode);

                Node childLeft = deleteNode.getLeftNode();
                Node childRight = deleteNode.getRightNode();
                Node succParent = succNode.getParent();

                if (deleteNode.getParent() == null) {                                             //succ root
                    if (succNode.getRightNode() != null) {
                        succNode.getRightNode().setParent(succParent);
                        succParent.setLeftNode(succNode.getRightNode());

                        succNode.setParent(null);
                        succNode.setRightNode(null);
                        this.setRoot(succNode);
                        this.root.setLeftNode(childLeft);
                        childLeft.setParent(this.root);
                        this.root.setRightNode(childRight);
                        childRight.setParent(this.root);

                    } else if (succNode.getRightNode() == null) {
                        succNode.setParent(null);
                        succParent.setLeftNode(null);
                        this.setRoot(succNode);
                        this.root.setLeftNode(childLeft);
                        childLeft.setParent(this.root);
                        this.root.setRightNode(childRight);
                        childRight.setParent(this.root);

                    }

                } else if (succNode.getParent() != null) {                                      //succ not root
                    deleteNode.setLeftNode(null);
                    deleteNode.setRightNode(null);
                    deleteNode.setParent(null);
                    if (deleteParent.getData() > succNode.getData()) {
                        deleteParent.setLeftNode(succNode);
                    } else if (deleteParent.getData() < succNode.getData()) {
                        deleteParent.setRightNode(succNode);
                    }

                    if (succNode.getRightNode() != null && succNode.getParent().getData() != deleteNode.getData()) {
                        succParent.setLeftNode(succNode.getRightNode());
                        succNode.getRightNode().setParent(succParent);
                        succNode.setParent(deleteParent);
                        succNode.setLeftNode(childLeft);
                        childLeft.setParent(succNode);
                        succNode.setRightNode(childRight);
                        childRight.setParent(succNode);
                        succParent.setLeftNode(null);
                        return true;

                    } else if (succNode.getRightNode() == null && succNode.getParent().getData() != deleteNode.getData()) {
                        succNode.setLeftNode(childLeft);
                        childLeft.setParent(succNode);
                        succNode.setRightNode(childRight);
                        childRight.setParent(succNode);
                        succParent.setLeftNode(null);

                        succNode.setParent(deleteParent);
                        succNode.setLeftNode(childLeft);
                        childLeft.setParent(succNode);
                        succNode.setRightNode(childRight);
                        childRight.setParent(succNode);
                        succParent.setLeftNode(null);

                        return true;
                    }

                    if (deleteNode.getLeftNode() == null) {
                        childRight.setParent(deleteParent);
                        deleteParent.setRightNode(childRight);
                        childLeft.setParent(childRight);
                        childRight.setLeftNode(childLeft);

                        return true;
                    }
                }
            }

        } else if (deleteNode.getRightNode() == null && deleteNode.getLeftNode() == null) { //delete 0 node

            if (deleteParent.getData() > key) {
                deleteParent.setLeftNode(null);
            } else if (deleteParent.getData() < key) {
                deleteParent.setRightNode(null);
            }

            deleteNode.setParent(null);

        } else if (deleteNode.getRightNode() == null) {                        //delete 1 node left
            Node child = deleteNode.getLeftNode();

            deleteNode.setParent(null);
            deleteNode.setLeftNode(null);
            child.setParent(deleteParent);
            deleteParent.setLeftNode(child);

        } else if (deleteNode.getLeftNode() == null) {                         //delete 1 node right
            Node child = deleteNode.getRightNode();

            deleteNode.setParent(null);
            deleteNode.setRightNode(null);
            child.setParent(deleteParent);
            deleteParent.setLeftNode(child);

        }
        return true;
    }

    private Node findPredeccessor(Node node) {
        Node curr = node;

        if (curr.getLeftNode().getRightNode() == null) {
            return curr.getLeftNode();
        }

        curr = curr.getLeftNode();

        while (curr.getRightNode() != null) {
            curr = curr.getRightNode();
        }

        return curr;
    }

    private Node findSuccessor(Node node) {
        Node curr = node;

        if (curr.getRightNode().getLeftNode() == null) {
            return curr.getRightNode();
        }

        curr = curr.getRightNode();

        while(curr.getLeftNode() != null) {
            curr = curr.getLeftNode();
        }

        return curr;
    }

    public void cetak() {
        Node node = root;
        cetakBantu(node);
    }

    public void cetakBantu(Node node) {
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

        if ((node.getRightNode() != null) || (node.getLeftNode() != null) || (node.getRightNode() != null && node.getLeftNode() != null)) {
            jumlahInternal++;
        }

        System.out.println();

        if (isLeft) {
            cetakBantu(node.getLeftNode());
        }

        if (isRight) {
            cetakBantu(node.getRightNode());
        }
    }

    public void leaf() {
        jumlahLeaves = 0;
        leafHelper(root);
        System.out.printf("Jumlah leaves: %s\n", jumlahLeaves);

    }
    private void leafHelper(Node node) {
        boolean isLeft, isRight;

        isLeft = node.getLeftNode() != null;

        isRight = node.getRightNode() != null;

        if (node.getRightNode() == null &&  node.getLeftNode() == null) {
            System.out.printf("leaf node dari %d adalah %d\n", node.getParent().getData(), node.getData());
            jumlahLeaves++;
        }

        if (isLeft) {
            leafHelper(node.getLeftNode());
        }

        if (isRight) {
            leafHelper(node.getRightNode());
        }
    }

    public void height(int value) {     //prefix
        int count = 1;
        int hasil = heightHelper(root, value, count);

        System.out.println(hasil != -1 ? ("node " + value + " berada di height: " + hasil) : ("node " + value + " tidak ditemukan"));

    }

    private int heightHelper(Node node, int value, int height) {
        if (node == null) {
            return -1;
        }

        if (node.getData() == value) {
            return height;
        }

        int leftHeight = heightHelper(node.getLeftNode(), value, height+1);

        if (leftHeight != -1) {
            return leftHeight;
        }

        return heightHelper(node.getRightNode(), value, height+1);
    }

    public void depth(int value) {
        int ketemu = depthHelper(root, value, 0);
        System.out.println("Depth dari node " + value + " adalah " + ketemu);
    }

    private int depthHelper(Node node, int data, int depth) {
        if (node == null) {
            return -1;
        }

        if (node.getData() == data) {
            return depth;
        }

        int leftDepth = depthHelper(node.getLeftNode(), data, depth+1);

        if (leftDepth != -1) {
            return leftDepth;
        }

        return depthHelper(node.getRightNode(), data, depth+1);
    }


    public void descendant(int value) {
        Node current = search(value);
        if (current == null) {
            return;
        }
        System.out.printf("Node %d: ", current.getData());
        descendantHelper(current);
    }

    private void descendantHelper(Node node) { //belum selesai
        boolean isLeft = false, isRight = false;

        if (node.getLeftNode() != null) {
            System.out.print(node.getLeftNode().getData());
            System.out.print(" ");

            if (node.getLeftNode().getLeftNode() != null || node.getLeftNode().getRightNode() != null) {
                isLeft = true;
            }
        }

        if (node.getRightNode() != null) {

            System.out.print(node.getRightNode().getData());
            System.out.print(" ");
            if (node.getRightNode().getLeftNode() != null || node.getRightNode().getRightNode() != null) {
                isRight = true;
            }
        }

        if (isLeft) {
            descendantHelper(node.getLeftNode());
        }

        if (isRight) {
            descendantHelper(node.getRightNode());
        }
    }

    public void printStructure() {
        printStructureV2("", root, false);
    }

    // SRC  : https://stackoverflow.com/a/42449385/17299516
    // NOTE : On the first recursion, some-why the previous prefix printed a '|' when n is a left leaf.
    public void printStructureV2(String prefix, Node curr, boolean isLeft) {
        if (curr != null) {
            System.out.println(prefix + ("└─") + curr.getData());
            printStructureV2(prefix + ( (isLeft && curr.getRightNode() != null) ? "│   " : "    "), curr.getLeftNode(), true);
            printStructureV2(prefix + (isLeft ? "│   " : "    "), curr.getRightNode(), false);
        }
    }
}
