package SDNL.TreeExpression;

public class Main {
    public static void main(String[] args) {
        char[] insert = {'(', 'A', '+', 'B', ')', '*', 'C', '+', 'D'};

        Infix fix = new Infix(insert);

        fix.buatPohon();
    }
}
