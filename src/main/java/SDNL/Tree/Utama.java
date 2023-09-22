/* Nama: Nicolaus Reva S
*  NIM: 225314097
*  Kelas: SDNL DP
* */

package SDNL.Tree;

import java.util.Scanner;

class TreeNode {
    private int data;
    private TreeNode leftNode;
    private TreeNode rightNode;
    private TreeNode parent;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public void insert (int data) {
        if (parent == null) {
            
        }
    }
}

class Tree {
    private TreeNode root;

    public Tree(TreeNode node) {
        if (root == null) {
            setRoot(node);
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void insert(int data) {
        insertPart(data, root);
    }

    public void insertPart(int data, TreeNode node) {
        if (root == null) {
            setRoot(new TreeNode(data));
            return;
        }

        if (node.getData() > data) {
            if (node.getLeftNode() == null) {
                node.setLeftNode(new TreeNode(data));
                return;
            }
            insertPart(data, node.getLeftNode());
        }

        if (node.getData() < data) {
            if (node.getRightNode() == null) {
                node.setRightNode(new TreeNode(data));
                return;
            }
            insertPart(data, node.getRightNode());
        }
    }

    public TreeNode find(int dataSearch) {
        return findHelper(dataSearch, root);
    }

    private TreeNode findHelper(int dataSearch, TreeNode node) {
        if (node == null || node.getData() == dataSearch) {
            return node;
        }

        if (node.getData() < dataSearch) {
            return findHelper(dataSearch, node.getRightNode());
        }

        return findHelper(dataSearch, node.getLeftNode());
    }


    public void preOrderTraversal() {
        TreeNode pointer = root;
        preOrderHelper(pointer);
    }

    private void preOrderHelper(TreeNode node) {
        System.out.print(node.getData() + " ");

        if (node.getLeftNode() != null) {
            preOrderHelper(node.getLeftNode());
        }

        if (node.getRightNode() != null) {
            preOrderHelper(node.getRightNode());
        }
    }

    public void inOrderTraversal() {
        TreeNode pointer = root;
        inOrderHelper(pointer);
    }

    private void inOrderHelper(TreeNode node) {
        if (node.getLeftNode() != null) {
            inOrderHelper(node.getLeftNode());
        }

        System.out.print(node.getData() + " ");

        if (node.getRightNode() != null) {
            inOrderHelper(node.getRightNode());
        }

    }

    public void posOrderTraversal() {
        TreeNode pointer = root;
        posOrderHelper(pointer);
    }

    private void posOrderHelper(TreeNode node) {

        if (node.getLeftNode() != null) {
            posOrderHelper(node.getLeftNode());
        }

        if (node.getRightNode() != null) {
            posOrderHelper(node.getRightNode());
        }

        System.out.print(node.getData() + " ");

    }
}

public class Utama {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree pohon = new Tree(new TreeNode(42));
        int[] arr = {21, 38, 27, 71, 82, 55, 63, 6, 2, 40, 12};
        for (int i = 0; i < arr.length; i++) {
            pohon.insert(arr[i]);
        }

        System.out.print("Mencetak pre Order: ");
        pohon.preOrderTraversal();
        System.out.print("\nmencetak in Order: ");
        pohon.inOrderTraversal();
        System.out.print("\nMencetak post Order: ");
        pohon.posOrderTraversal();

        while(true) {
            System.out.print("\nNilai yang akan dicari: ");
            int valuekey = sc.nextInt();
            System.out.println((pohon.find(valuekey) == null) ? "Nilai " + valuekey + "  tidak ditemukan" : "Nilai " + valuekey + " ditemukan");
        }

    }
}

