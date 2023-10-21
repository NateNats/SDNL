package SDNL.TreeDelete;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        String input = "1 fish 2 fish red fish blue fish";
        Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
        System.out.println(s.nextInt());
        System.out.println(s.nextInt());
        System.out.println(s.next());
        System.out.println(s.next());
        s.close();

//        Node m = new Node (20, null);
//        Node n = new Node(10, m);
//        n.insert(8);
//        n.insert(12);
//
//        System.out.println(n.getParent().getData());
//        System.out.println(n.getData());
//        System.out.println(n.getLeftNode().getData());
//        System.out.println(n.getRightNode().getData());
    }
}
