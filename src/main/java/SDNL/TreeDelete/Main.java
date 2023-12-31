package SDNL.TreeDelete;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node node = new Node(42, null);
        Tree p = new Tree(node);

        int[] arr = {21, 38, 27, 71, 82, 55, 63, 6, 2, 40, 12};

        for (int j : arr) {
            p.insertNode(j);
        }

        while(true) {
            System.out.print("""
                    
                    1. Hapus nilai
                    2. Masukan nilai
                    3. Tampilkan tree secara Pre order, In order dan Post order
                    4. Cek detail node
                    5. Tampilkan pohon
                    6. Descendant
                    7. Leaf
                    8. Depth
                    9. Height
                    Input:\s""");
            int pilihan = sc.nextInt();

            if (pilihan == 1) {
                System.out.println("Menampilkan data secara in order: ");
                p.inOrderTraversal();
                System.out.print("\nMasukan nilai yang akan dihapus: ");
                int key = sc.nextInt();
                Node curr = p.search(key);
                if (curr.hasLeft() && curr.hasRight()) {
                    System.out.printf("Pada node %d, terdapat 2 anak, yaitu kiri: %d dan kanan: %d", key, curr.getLeftNode().getData(),
                            curr.getRightNode().getData());
                    System.out.print("\nGunakan predecessor (1) atau successor (2)?? ");
                    p.setPredeOrSucc(sc.nextInt());
                    System.out.println((p.delete(key) ? "Data berhasil dihapus" : "Data tidak berhasil di hapus"));
                } else {
                    System.out.println((p.delete(key) ? "Data berhasil dihapus" : "Data tidak berhasil di hapus"));
                }
            } else if (pilihan == 2) {
                System.out.print("Masukan nilai: ");
                p.insertNode(sc.nextInt());

            } else if (pilihan == 3){
                System.out.println("Menampilkan secara in order: ");
                p.inOrderTraversal();
                System.out.println("\nMenampilkan secara pre order: ");
                p.preOrderTraversal();
                System.out.println("\nMenampilkan secara post order: ");
                p.postOrderTraversal();
                System.out.println();

            } else if (pilihan == 4){
                p.preOrderTraversal();
                System.out.print("\nnode berapa? ");
                int masukan = sc.nextInt();
                Node n = p.search(masukan);
                p.cetakBantu(n);
//
//                p.cetak();

            } else if (pilihan == 5){
                p.printStructure();

            } else if (pilihan == 6){
                System.out.print("masukan nilai: ");
                p.descendant(sc.nextInt());
                System.out.println();

            } else if (pilihan == 7){
                p.leaf();
            } else if (pilihan == 8) {
                System.out.print("Masukan nilai: ");
                p.depth(sc.nextInt());
            } else if (pilihan == 9){
                System.out.print("Masukan nilai: ");
                p.height(sc.nextInt());
            } else {
                break;
            }
        }
    }
}
