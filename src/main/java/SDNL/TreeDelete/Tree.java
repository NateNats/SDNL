package SDNL.TreeDelete;

public class Tree {
    private Node root;
    private int predeOrSucc;

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


    public Node getCurrent(int dataSearch) {                              //method find dengan parameter satu parameter yaitu dataSearch
        return getCurrentHelper(dataSearch, root);                        //memasukan parameter dataSearch dan root ke dalam method findHelper
                                                                    //lalu mengembalikan sebuah node yang akan dilepas
    }

    private Node getCurrentHelper(int dataSearch, Node node) {            //method findHelper bertipe Node dengan dua parameter, dataSearch dan node
        if (node == null || node.getData() == dataSearch) {         //mengecek apakah node == null atau node.getData() == dataSearch
            return node;                                            //jika ya, maka kembalikan node
        }

        if (node.getData() < dataSearch) {                          //jika node.getData() < dataSearch
            return getCurrentHelper(dataSearch, node.getRightNode());     //maka lakukan rekursif dengan parameter detaSearch dan node.getRightNode()
        }

        return getCurrentHelper(dataSearch, node.getLeftNode());          //mengembalikan node setelah melakukan method findHelper
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

    public boolean delete (int key) {               //delete dengan 1 parameter yaitu key (user input)
        Node node = getCurrent(key);                //METHOD GETCURRENT SAMA PERSIS SEPERTI FIND
        Node parent;                                //set parent menjadi null

        if (node == null || node.getData() != key) {    //cek node adalah null atau node.getData tidak sama key
            return false;
        } else {
            if (node.getLeftNode() == null && node.getRightNode() == null) { // 0 node
                parent = node.getParent();                                   //parent menjadi node.getParent()
                if (parent.getData() > key) {                                //jika data parent lebih besar dari key
                    parent.setLeftNode(null);                                //set kiri parent menjadi null
                }

                if (parent.getData() < key) {                              //jika data parent lebih besar kecil key
                    parent.setRightNode(null);                               //set kanan parent menjadi null
                }

            } else if (node.getRightNode() == null) { //1 node           ==>> jika ditemukan node kiri
                parent = node.getParent();                                   //parent menjadi node.getParent()
                parent.setRightNode(node.getLeftNode());                     //set kanan parent agar terhubung dengan node kiri
                node.getLeftNode().setParent(parent);                        //set parent node kiri menggunakan variabel parent

                return true;

            } else if (node.getLeftNode() == null) { // 1 node           ==>> jika ditemukan node kanan
                parent = node.getParent();                                    //parent menjadi node.getParent()
                node.getRightNode().setParent(parent);                        //set kiri parent agar terhubung dengan node kanan
                parent.setLeftNode(node.getRightNode());                      //set parent node kanan menggunakan variabel parent

                return true;
            } else if (node.getLeftNode() != null && node.getRightNode() != null){    //2 node

                if (this.isPredeOrSucc() == 1) {

                    Node predeNode = findPredeccessor(node);
                    if  (node.getParent() != null) {                            //kondisi ketika node memiliki parent atau mennghapus bukan node
                        if (predeNode.getLeftNode() == null) {
                            Node nodeParent = node.getParent();

                            predeNode.getParent().setRightNode(null);

                            predeNode.setParent(node.getParent());
                            node.setParent(null);

                            predeNode.setLeftNode(node.getLeftNode());
                            predeNode.setRightNode(node.getRightNode());

                            node.getLeftNode().setParent(predeNode);
                            node.getRightNode().setParent(predeNode);

                            nodeParent.setRightNode(predeNode);
                        } else {
                            //untuk predeNode leftNode
                            Node nodeParent = node.getParent();

                            predeNode.getParent().setRightNode(predeNode.getLeftNode());
                            predeNode.getLeftNode().setParent(predeNode.getParent());

                            predeNode.setParent(node.getParent());
                            node.setParent(null);

                            //  Lupa sama kodingan sendiri :(
                            predeNode.setLeftNode(node.getLeftNode());
                            predeNode.setRightNode(node.getRightNode());

                            node.getLeftNode().setParent(predeNode);
                            node.getRightNode().setParent(predeNode);

                            nodeParent.setRightNode(predeNode);
                        }
                    } else if (node.getParent() == null){               //kondisi ketika node tidak memiliki parent atau root
                        if (predeNode.getLeftNode() == null) { //==> prede root left null
                            Node nodeChildLeft = this.getRoot().getLeftNode();
                            Node nodeChildRight = this.getRoot().getRightNode();

                            predeNode.getParent().setRightNode(null);
                            this.setRoot(predeNode);
                            predeNode.setLeftNode(nodeChildLeft);
                            predeNode.setRightNode(nodeChildRight);
                            nodeChildLeft.setParent(predeNode);
                            nodeChildRight.setParent(predeNode);
                        } else {                                //==> prede root left not null
                            Node nodeChild = this.root.getLeftNode();

                            predeNode.getParent().setRightNode(predeNode.getLeftNode());
                            predeNode.getLeftNode().setParent(predeNode.getParent());

                            this.setRoot(predeNode);
                            predeNode.setLeftNode(nodeChild);
                            nodeChild.setParent(predeNode);
                        }
                    }
                } else if (this.isPredeOrSucc() == 2){

                    Node succNode = findSuccessor(node);
                    if (node.getParent() != null) {

                    } else if(node.getParent() == null){

                    }

                }

            }
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
        System.out.println();
        if (isLeft) {
            cetakBantu(node.getLeftNode());
        }

        if (isRight) {
            cetakBantu(node.getRightNode());
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
