package SDNL.BinaryTree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> p = new Tree<>(new Node<>(10));
        p.insert(20);
        p.insert(5);
        p.inOrderTraversal();
    }
}
