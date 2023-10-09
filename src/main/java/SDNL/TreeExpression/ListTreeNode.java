package SDNL.TreeExpression;

public class ListTreeNode {
    TreeNode data;         // variable data dari kelas TreeNode
    ListTreeNode nextNode; // variable nextNode dari kelas ListTreeNode

    // Konstruktor ListTreeNode
    ListTreeNode(TreeNode TreeNode) {
        this(TreeNode, null);
    }

    // Konstruktor ListTreeNode
    ListTreeNode(TreeNode TreeNode, ListTreeNode node) {
        data = TreeNode;
        nextNode = node;
    }

    // Method untuk mendapatkan data TreeNode dari node
    TreeNode getTreeNode() {
        return data;
    }

    // Method untuk mendapatkan node berikutnya
    ListTreeNode getNext() {
        return nextNode;
    }
}


class ListTree {
    private ListTreeNode firstNode; //variable firstNode referensi dari listTreeNode
    private ListTreeNode lastNode;  //variable lastNode referensi dari listTreeNode

    private String name;            //variabl name bertipe String

    //konstruktor LisTree
    public ListTree() {
        this("list");
    }

    //konstruktor LisTree
    public ListTree(String listName) {
        this.name = listName;
        firstNode = lastNode = null;
    }

    //method untuk mendapatkan firstNode
    public ListTreeNode getFirstNode() {
        return firstNode;
    }

    //method untuk mendapatkan lastNode
    public ListTreeNode getLastNode() {
        return lastNode;
    }

    //method untuk melakukan insert data dari depan list
    public void insertAtFront(TreeNode insertItem) {
        if (isEmpty()) {                                                //jika isEmpty bernilai true, maka deklarasikan
            firstNode = lastNode = new ListTreeNode(insertItem);        //firstnode dan lastNode menjadi listTreeNode dengan parameter insertItem

        } else {
            firstNode = new ListTreeNode(insertItem, firstNode);        //jika tidak, maka deklarasikan
                                                                        //firstnode  menjadi listTreeNode dengan parameter insertItem
        }
    }

    //method untuk melakukan insert data dari belakang list
    public void insertAtBack(TreeNode insertItem) {
        if (isEmpty()) {                                                 //jika isEmpty bernilai true, maka deklarasikan
            firstNode = lastNode = new ListTreeNode(insertItem);        //firstnode dan lastNode menjadi listTreeNode dengan parameter insertItem

        } else {
            lastNode = new ListTreeNode(insertItem, firstNode);         //jika tidak, maka deklarasikan
                                                                        //lastNode menjadi listTreeNode dengan parameter insertItem
        }
    }

    //method untuk menghapus TreeNode pada listTree dari depan
    public TreeNode removeFromFront() {
        if (isEmpty()) {                            //jika method isEmpty bernilai true, maka return null
            return null;
        }

        TreeNode removeItem = firstNode.data;        // removeItem referensi dari kelas TreeNode
                                                    //yang mengakses data dari firstNode

        if (firstNode == lastNode) {                //jika firstNode dan lastNode sama, maka set keduanya jadi null
            firstNode = lastNode = null;
        } else {
            firstNode = firstNode.nextNode;         //firstNode menjadi nextNode
        }

        return removeItem;                          //mengembalikan removeItem dari method ini
    }

    //method untuk menghapus TreeNode pada listTree dari belakang
    public TreeNode removeFromBack() {
        if (isEmpty()) {                            //jika method isEmpty bernilai true, maka return null
            return null;
        }

        TreeNode removeItem = lastNode.data;        // removeItem referensi dari kelas TreeNode
                                                    //yang mengakses data dari lastNode

        if (firstNode == lastNode) {                //jika firstNode dan lastNode sama, maka set keduanya jadi null
            firstNode = lastNode = null;
        } else {                                    //jika tidak, jalankan codingan berikut ini
            ListTreeNode current = firstNode;       //current referensi dari kelas listTreeNode
                                                    //yang mengakses firstNode

            while(current.nextNode != lastNode) {   //selama current nextNode tidak sama lastNode
                current = current.nextNode;         //ubah current menjadi nextNode
            }

            lastNode = current;                     //lastNode menjadi current
            current.nextNode = null;                //set nextNode dari current menjadi null
        }

        return removeItem;                          //mengembalikan removeItem dari method ini
    }

    //method untuk mengecek apakah listTree kosong atau tidak
    public boolean isEmpty() {
        if (firstNode == null) {    //jika firstNode kosong, maka return true
            return true;
        } else {                    //jika tidak, maka return false
            return false;
        }
    }

    //method untuk menampilkan hasil dari listTree
    public void print() {
        if (isEmpty()) {
            System.out.println("Empty " + name);
            return;
        }
        System.out.print("The " + name + " is: ");
        ListTreeNode current = firstNode;

        while(current != null) {
            System.out.print(current.data.toString() + " ");
            current = current.nextNode;
        }

        System.out.println("\n");
    }
}
