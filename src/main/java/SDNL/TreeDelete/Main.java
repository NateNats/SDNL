package SDNL.TreeDelete;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node node = new Node(42, null);
        Tree p = new Tree(node);

        int[] arr = {21, 38, 27, 71, 82, 55, 63, 6, 2, 40, 12};

        for (int i = 0; i < arr.length; i++) {
            p.insertNode(arr[i]);
        }



        while(true) {
            System.out.println();
            System.out.print("""
                    1. Hapus nilai
                    2. Masukan nilai
                    3. Tampilkan tree
                    4. Cek detail node
                    5. Tampilkan pohon
                    Input:\s""");
            int pilihan = sc.nextInt();
            if (pilihan == 1) {
                System.out.println("Menampilkan data secara in order: ");
                p.inOrderTraversal();
                System.out.print("\nMasukan nilai yang akan dihapus: ");
                int key = sc.nextInt();
                Node curr = p.getCurrent(key);
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
                Node n = p.getCurrent(masukan);
                p.cetakBantu(n);

            } else if (pilihan == 5){
                p.printStructure();

            } else {
                break;
            }
        }
    }
}
