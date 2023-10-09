package SDNL.TreeExpression;

public class TreeNode {
    TreeNode leftNode;                              //deklarasi variable leftNode bertipe TreeNode
    char data;                                      //deklarasi variable data bertipe char
    TreeNode rightNode;                             //deklarasi variable rightNode bertipe TreeNode

    public TreeNode(char nodeData) {                //constructor TreeNode berparameter char
        this.data = nodeData;
    }

    public void insert(char insertValue) {              //insert method
        if (insertValue < data) {                       //jika insertValue kurang dari data Treenode,
                                                        //maka jalankan if else berikut ini
            if (leftNode == null) {                     //jika leftnode null, maka bikin treeNode dengan insertvalue sebagai data baru
                leftNode = new TreeNode(insertValue);
            } else {                                    //jika tidak, maka masukan nilai insertvalue ke leftNode
                leftNode.insert(insertValue);
            }

        } else if (insertValue > data) {                //jika insertvalue lebih dari data,
                                                        //maka jalankan if else berikut ini
            if (rightNode == null) {                    //jika rightNode kosong, maka bikin treeNode dengan insertvalye sebgagai data baru
                rightNode = new TreeNode(insertValue);
            } else {
                rightNode.insert(insertValue);          //jika tidak, maka masukan nilai insertvalue ke rightNode
            }
        }
    }
}

class Tree {
    private TreeNode root;

    // Konstruktor untuk kelas Tree
    public Tree() {
        root = null;
    }

    // Metode untuk mengatur akar pohon (root)
    public void setRootTree(TreeNode treeNode) {
        root = treeNode;
    }

    // Metode untuk memasukkan node baru ke dalam pohon
    public void insertNode(char insertValue) {
        if (root == null) {
            root = new TreeNode(insertValue);
        } else {
            root.insert(insertValue);
        }
    }

    // Metode untuk melakukan pre-order pada pohon
    public void preOrderTraversal() {
        preOrderHelper(root);
    }

    // Metode rekursif yang digunakan dalam rekursif pre-order
    private void preOrderHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " "); // Mencetak data node
        preOrderHelper(node.leftNode);     // rekursif ke node kiri
        preOrderHelper(node.rightNode);    // rekursif ke node kanan
    }

    // Metode untuk melakukan in-order pada pohon
    public void inOrderTraversal() {
        inOrderHelper(root);
    }

    // Metode rekursif yang digunakan dalam rekursif in-order
    private void inOrderHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderHelper(node.leftNode);      // rekursif ke node kiri
        System.out.print(node.data + " "); // Mencetak data node
        inOrderHelper(node.rightNode);     // rekursif ke node kanan
    }

    // Metode untuk melakukan post-order pada pohon
    public void postOrderTraversal() {
        postOrderHelper(root);
    }

    // Metode rekursif yang digunakan dalam rekursif post-order
    private void postOrderHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrderHelper(node.leftNode);    // rekursif ke node kiri
        postOrderHelper(node.rightNode);   // rekursif ke node kanan
        System.out.print(node.data + " "); // Mencetak data node
    }

}
