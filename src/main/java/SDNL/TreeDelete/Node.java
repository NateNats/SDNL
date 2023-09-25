package SDNL.TreeDelete;

public class Node {
    private int data;                // Deklarasi variabel instance untuk menyimpan data
    private Node leftNode, rightNode, parent;  // Deklarasi variabel instance untuk node anak kiri, anak kanan, dan parent (induk)

    public Node(int data, Node parent) {  // Constructor untuk membuat objek Node baru dengan data dan parent yang diberikan
        this.data = data;             // Inisialisasi data node
        this.leftNode = null;         // Inisialisasi node anak kiri menjadi null
        this.rightNode = null;        // Inisialisasi node anak kanan menjadi null
        this.parent = parent;         // Inisialisasi parent node dengan node parent yang diberikan
    }

    public int getData() {            // Metode getter untuk mengambil data dari node
        return data;
    }

    public void setData(int data) {   // Metode setter untuk mengatur data node
        this.data = data;
    }

    public Node getLeftNode() {       // Metode getter untuk mendapatkan node anak kiri
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {   // Metode setter untuk mengatur node anak kiri
        this.leftNode = leftNode;
    }

    public Node getRightNode() {      // Metode getter untuk mendapatkan node anak kanan
        return rightNode;
    }

    public void setRightNode(Node rightNode) { // Metode setter untuk mengatur node anak kanan
        this.rightNode = rightNode;
    }

    public Node getParent() {         // Metode getter untuk mendapatkan node parent (induk)
        return parent;
    }

    public void setParent(Node parent) { // Metode setter untuk mengatur node parent (induk)
        this.parent = parent;
    }

    public void insert(int data) {    // Metode untuk memasukkan data baru ke dalam pohon
        if (this.getData() > data) {  // Jika data yang akan dimasukkan lebih kecil dari data node saat ini
            this.setLeftNode(new Node(data, this)); // Buat node baru sebagai anak kiri dengan dirinya sebagai parent
        } else {                     // Jika data yang akan dimasukkan lebih besar atau sama dengan data node saat ini
            this.setRightNode(new Node(data, this)); // Buat node baru sebagai anak kanan dengan dirinya sebagai parent
        }
    }

//        public boolean hasLeft() {
//        return this.getLeftNode() != null;
//    }
//
//    public boolean hasRight() {
//        return this.getRightNode() != null;
//    }

}