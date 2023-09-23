package SDNL.TreeDelete;

public class Main {
    public static void main(String[] args) {
        Node node = new Node(42, null);
        Tree pohon = new Tree(node);
        int[] arr = {21, 38, 27, 71, 82, 55, 63, 6, 2, 40, 12};
        for (int i = 0; i < arr.length; i++) {
            pohon.insertNode(arr[i]);
        }
        pohon.inOrderTraversal();
    }
}
