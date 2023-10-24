package SDNL.UTS;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(new Node(16));
        int[] arr = {82, 15, 25, 83, 63, 26, 37};

        for (int a : arr) {
            tree.insert(a);
        }

        tree.preOrder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.postOrder();
    }
}