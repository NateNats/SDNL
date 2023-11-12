package SDNL.UndirectedGraph;

public class Graph {
    int maxVertex = 10;                                     //jumlah maksimal vertex
    Vertex[] vertexList;                                    //array vertex
    int[][] adjancencyMatrix;                               //array 2d untuk memasukan nilai pada edge
    int countVertex = 0;                                    //menghitung jumlah vertex yang masuk

    public Graph() {                                        //konstruktor kelas graph
        adjancencyMatrix = new int[maxVertex][maxVertex];   //set adjancency matrix
        vertexList = new Vertex[maxVertex];                 //set vertexList

        for (int i = 0; i < maxVertex; i++) {               //melakukan perulangan untuk memasukan nilai
            for (int j = 0; j < maxVertex; j++) {
                adjancencyMatrix[i][j] = 0;
            }
        }
    }

    public void addVertex(char value) {                     //method untuk memasukan vertex

        if (countVertex != maxVertex) {                     //jika vertex tidak penuh, maka tambahkan vertex
            Vertex vertex = new Vertex(value);

            vertexList[countVertex] = vertex;
            countVertex++;                                  //setelah ditambahkan, countVertex bertambah 1

        } else {                                            //jika vertex penuh, maka jalankan perintah print
            System.out.println("Graph is full");
        }
    }

    public void addEdge(int row, int column, int value) {   //method untuk menambahkan edge dengan 3 parameter
        adjancencyMatrix[row][column] = value;
        adjancencyMatrix[column][row] = value;
    }

    public void addEdge(char row, char column, int value) {   //method untuk menambahkan edge dengan 3 parameter
        int rowInt = index(row);                              //mencari letak char row menggunakan method index
        int columnInt = index(column);                        //mencari letak char column menggunakan method index

        if (rowInt != -1 && columnInt != -1) {
            adjancencyMatrix[rowInt][columnInt] = value;         //memasukan nilai pada edge
            adjancencyMatrix[columnInt][rowInt] = value;         //mirroring
        }
    }

    public int index(char value) {                         //method index dengan 1 parameter
        for (int i = 0; i < vertexList.length; i++) {       //for looping
            if (vertexList[i].getLabel() == value) {        //jika nilai pada indeks i sesuai dengan char value
                return i;                                   //maka kembalikan indeks
            }
        }

        return -1;                                          //jika tidak, maka kembalikan -1
    }

    void resetFlags() {
        for (Vertex vertex : vertexList) {
            if(vertex == null) {
                return;
            }

            vertex.setFlagVisited(false);
        }
    }

    public void showTable() {
        System.out.print("\t");

        for (int i = 0; i < countVertex; i++) {
            System.out.print(vertexList[i].getLabel() + "\t");
        }

        System.out.println();
        for (int i = 0; i < maxVertex; i++) {
            System.out.print(vertexList[i] != null ? vertexList[i].getLabel() + "\t" : "\t");

            for (int j = 0; j < maxVertex; j++) {
                System.out.print(adjancencyMatrix[i][j] + "\t");
            }

            System.out.println();
        }
    }


    public int findEdge(char first, char second) {
        int row = index(first);
        int column = index(second);

        return adjancencyMatrix[row][column];
    }

    public void show(){
        for (int i = 0; i < countVertex; i++) {
            System.out.println("Mengunjungi Vertex: " + vertexList[i].getLabel());
            for (int j = 0; j < maxVertex; j++) {
                if (i != j && vertexList[i] != null && vertexList[j] != null) {
                    if (adjancencyMatrix[i][j] != 0) {
                        System.out.println(vertexList[i].getLabel() + " terhubung ke " + vertexList[j].getLabel()
                                + " dengan beban " + adjancencyMatrix[i][j]);
                    }
                }
            }

            System.out.println();
        }
    }

    public void depthFirstSearch() {
        int seed = 0;

        StackGraph stack = new StackGraph();

        stack.push(vertexList[seed].getLabel());

        while(!stack.isEmpty()) {
            int helper = index(stack.pop());

            if (!vertexList[helper].isFlagVisited()) {
                System.out.print(vertexList[helper].getLabel() + " ");
                vertexList[helper].setFlagVisited(true);

                for (int i = countVertex; i >= 0; i--) {
                    if (adjancencyMatrix[helper][i] >= 1 && !vertexList[i].isFlagVisited()) {
                        stack.push(vertexList[i].getLabel());
                    }
                }
            }
        }

        resetFlags();
    }

    public void breathFirstSearch() {
        StringBuilder total = new StringBuilder();

        QueueGraph queue = new QueueGraph(vertexList.length);

        int count = 0;
        char value = vertexList[count].getLabel();
        vertexList[count].setFlagVisited(true);

        queue.enqueue(value);
        total.append(value).append(" ");

        while(!queue.isEmpty()) {
            int node = index(queue.dequeue());

            for (int i = 0; i < maxVertex; i++) {
                if (adjancencyMatrix[node][i] >= 1 && !vertexList[i].isFlagVisited()) {
                    value = vertexList[i].getLabel();
                    vertexList[i].setFlagVisited(true);
                    total.append(value).append(" ");
                    queue.enqueue(vertexList[i].getLabel());
                }
            }
        }

        System.out.println(total);

        resetFlags();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("\t");

        for (Vertex vertex : vertexList) {
            s.append(vertex != null ? vertex.getLabel() + "\t" : "\t");

        }
        s.append("\n");

        for (int i = 0; i < vertexList.length; i++) {
            s.append(vertexList[i] != null ? vertexList[i].getLabel() + "\t" : "\t");

            for (int j = 0; j < vertexList.length; j++) {
                s.append(adjancencyMatrix[i][j]).append("\t");
            }

            s.append("\n");
        }

        return s.toString();
    }
}
