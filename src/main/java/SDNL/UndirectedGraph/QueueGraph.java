package SDNL.UndirectedGraph;

public class QueueGraph {
    private char[] element;
    private int front;
    private int rear;
    QueueGraph(){
        int front = 0;
        int rear = 0;
    }

    QueueGraph(int ukuran){
        this();
        element = new char[ukuran];
    }

    public boolean enqueue (char data){
        if (rear < element.length) {
            element[rear] = data;
            rear++;
            return true;
        } else {
            return false;
        }
    }

    public char dequeue(){
        if (rear != front){
            char dataKeluar = element[front];
            for (int i = 1; i < size(); i++){
                char temp = element[i];
                element[i-1] = temp;
            }
            rear--;
            return dataKeluar;

        } else {
            return 0;
        }
    }

    public int size(){
        return rear;
    }

    public boolean isFull(){
        if (rear == element.length){
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty(){
        if (rear == 0){
            return true;
        } else {
            return false;
        }
    }
//
//    void display(){
//        System.out.println("ukuran: " + size());
//        System.out.println("rear: " + rear );
//        System.out.println("is Empty: " + isEmpty());
//        System.out.println("is Full: " + isFull());
//        System.out.print("Data: ");
//        for (int i = 0; i < size();i++){
//            System.out.print(element[i]);
//
//            if (i < size()-1){
//                System.out.print(", ");
//            }
//        }
//        System.out.println("\n");
//    }
}