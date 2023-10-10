package SDNL.TreeExpression;

public class Infix {
    KonstantaInfix karInFix = new KonstantaInfix(); //variable karInFix referensi dari kelas KonstantaInfix
    char ung[];                                     //variable array char ung
    StackTree opr;                                  //variable opr referensi dari keals StackTree
    StackTree opd;                                  //variable opd referensi dari keals StackTree

    //konstruktor infix dengan 1 parameter
    public Infix(char[] ung_in) {
        this.ung = ung_in;
    }

    //method valensi untuk mendapatkan angka dari paramter input
    public int valensi (char data_in) {
        if (data_in == '^') {
            return 3;
        } else if ((data_in == '*') || (data_in == '/')) {
            return 2;
        } else if ((data_in == '+') || (data_in == '-')) {
            return 1;
        } else if (data_in == '(') {
            return 0;
        } else {
            return -1;
        }
    }

    //method gabung untuk menggabungkan rightNode dan leftNode dari stack opr dan opd
    //sehingga terbentuk sebuah potongan node expression
    public TreeNode gabung() {
        TreeNode phn = opr.pop();
        phn.rightNode = opd.pop();
        phn.leftNode = opd.pop();
        return phn;
    }

    //method untuk membuat pohon expression
    public TreeNode buatPohon() {
        char kar;
        TreeNode treeKar;
        TreeNode cek;
        opr = new StackTree();      //variable opr/operator dari StackTree
        opd = new StackTree();      //variable opd/operand dari StackTree

        for (int i = 0; i < ung.length; i++) {
            kar = ung[i];
            karInFix.setData(kar);
            if (kar != ' ') {
                treeKar = new TreeNode(kar);
                if (kar == '(') {
                    opr.push(treeKar); // Push '(' ke stack operator
                } else if (kar == ')') {
                    cek = opr.pop();   // Pop operator dari stack operator
                    opr.push(cek);

                    while (cek.data != '(') {   //loop while ketika data dari cek tidak sama dengan '('
                        opd.push(gabung());     // Push hasil gabungan operand ke stack operand
                        cek = opr.pop();        // Pop operator dari stack operator
                        opr.push(cek);
                    }

                    opr.pop();                  // Pop tanda '(' dari stack operator
                } else if (karInFix.isOperator()) {
                    cek = opr.pop();            // Pop operator dari stack operator
                    opr.push(cek);

                    while((cek != null) && (valensi(kar) <= valensi(cek.data))) {
                        opd.push(gabung());     // Push hasil gabungan operand ke stack operand
                        cek = opr.pop();        // Pop operator dari stack operator
                        opr.push(cek);
                    }

                    opr.push(treeKar);          // Push operator ke stack operator
                } else if (karInFix.isOperand()) {
                    opd.push(treeKar);
                } else {
                    return null;                //jika if dan else tidak memenuhi, maka return null
                }
            }
        }

        cek = opr.pop();        // Pop operator dari stack operator
        opr.push(cek);

        while(cek != null) {
            opd.push(gabung());     // Push hasil gabungan operand ke stack operand

            cek = opr.pop();        // Pop operator dari stack operator
            opr.push(cek);
        }

        cek = opd.pop();        // Pop hasil akhir dari stack operand
        opr = null;             // set stack operator jadi null
        opd = null;             // set stack operand jadi null
        return cek;
    }
}

class KonstantaInfix {

    //char array operator
    char operator[] = {'+', '-', '*', '/', '^'};

    //char array operand
    char operand[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    //char  data
    private char data;

    //konstruktor KonstantaInfix
    public KonstantaInfix() {
    }

    //method untuk mengambil data
    public char getData() {
        return data;
    }

    //method untuk memasang data
    public void setData(char data) {
        this.data = data;
    }

    //konstruktor KonstantaInfix
    public KonstantaInfix(char data_in) {
        this.data = data_in;
    }

    //method untuk mengecek apakah data termasuk operator atau bukan
    public boolean isOperator() {
        for (int i = 0; i < operator.length; i++) { //perulangan untuk mengambil data dari operator
            if (data == operator[i]) {  //jika data sama dengan operator, return true
                return true;
            }
        }
        return false;                    //return false jika perulangan tidak ada yang benar
    }

    //method untuk mengecek apakah data termasuk operand atau bukan
    public boolean isOperand() {
        for (int i = 0; i < operand.length; i++) {  //perulangan untuk mengambil data dari operand
            if (data == operand[i]) {    //jika data sama dengan operator, return true
                return true;
            }
        }
        return false;                    //return false jika perulangan tidak ada yang bena
    }
}