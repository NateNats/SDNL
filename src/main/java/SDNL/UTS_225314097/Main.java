package SDNL.UTS_225314097;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("NICOLAUS REVA S/225314097");
        Scanner input = new Scanner(System.in);

        Tree<Integer> p = new Tree<>(new Node<>(16));
        Integer[] arr = {82, 15, 25, 83, 63, 26, 37};

        for (Integer a : arr) {
            p.insert(a);
        }

        while (true) {
            System.out.print("""

                    1. Tambahkan Node
                    2. Pre-in-post order
                    3. Leaf
                    4. Internal Node
                    5. Print
                    Input:\s""");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.print("\nmasukan nilai: ");
                p.insert(input.nextInt());

            }  else if (choice == 2){
                System.out.print("\nPre order: ");
                p.preOrderTraversal();
                System.out.println();

                System.out.print("In order: ");
                p.inOrderTraversal();
                System.out.println();

                System.out.print("Post order: ");
                p.posOrderTraversal();
                System.out.println();

            } else if (choice == 3) {
               p.leaf();

            } else if (choice == 4) {
                p.internalNode();

            } else if (choice == 5){
                p.print();

            } else {
                break;
            }
        }
    }
}
