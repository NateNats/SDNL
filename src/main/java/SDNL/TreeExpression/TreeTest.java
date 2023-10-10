package SDNL.TreeExpression;

public class TreeTest {
    public static void main(String[] args) {
//        String s1 = "(A+B)";                                        //mendeklarasikan variable String s1 dengan value (A+B)
//        String s1 = "(A+B)*((B-C)+D)";
        String s1 = "(A+B*C)^((P+Q)*R)";
        char[] notasi = new char[s1.length()];                      //mendeklarasikan array char notasi dengan panjang sesuai dengan string s1
        s1.getChars(0, s1.length(), notasi, 0);    //mengambil character dari string s1, mulai dari index sampai akhir,
                                                                    //lalu memasukan ke array notasi mulai dari index 0

        Tree tree = new Tree();                                     //deklarasi objek tree bertipe Tree
        Infix infix = new Infix(notasi);                            //deklarasi objek infix bertipe Infix berparameter notasi

        tree.setRootTree(infix.buatPohon());                        //tree memanggil method setRootTree dengan parameter infix.buatPohon

        System.out.print("\nInfix: ");
        tree.inOrderTraversal();                                    //memanggil method inOrderTraversal dari tree
        System.out.print("\nPrefix: ");
        tree.preOrderTraversal();                                    //memanggil method preOrderTraversal dari tree
        System.out.print("\nPostfix: ");
        tree.postOrderTraversal();                                    //memanggil method postOrderTraversal dari tree


    }
}
