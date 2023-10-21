package SDNL.BinaryTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Tree<Integer> p = new Tree<>(new Node<>(42));
        Integer[] arr = {21, 38, 27, 71, 82, 55, 63, 6, 2, 40, 12};

        for (Integer a : arr) {
            p.insert(a);
        }

        while (true) {
            System.out.print("""

                    1. Hapus Node
                    2. Tambahkan Node
                    3. Pre-in-post order
                    4. Print
                    5. detail node
                    6. Depth
                    7. Exit
                    Input:\s""");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.print("Node: ");
                p.inOrderTraversal();
                System.out.print("\nNode yang akan dihapus: ");
                p.delete(input.nextInt());

            } else if (choice == 2) {
                System.out.print("\nmasukan nilai: ");
                p.insert(input.nextInt());

            }  else if (choice == 3){
                System.out.print("\nPre order: ");
                p.preOrderTraversal();
                System.out.println();

                System.out.print("In order: ");
                p.inOrderTraversal();
                System.out.println();

                System.out.print("Post order: ");
                p.posOrderTraversal();
                System.out.println();

            } else if (choice == 4) {
               p.print();

            } else if (choice == 5) {
                System.out.print("Node: ");
                p.detailNode(p.find(input.nextInt()));

            } else if (choice == 6) {
                p.depth();

            } else if (choice == 7) {
                break;

            }
        }
    }
}
