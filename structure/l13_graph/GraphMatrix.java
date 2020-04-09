package l13_graph;

import java.util.*;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-31 20:30
 */

class demo {
    public static void main(String[] args) {
        String[] group = {"A", "B", "C", "D", "E"};
        GraphMatrix gm = new GraphMatrix(group);
        gm.addEdge(0, 1, 1);
        gm.addEdge(0, 2, 1);
        gm.addEdge(1, 2, 1);
        gm.addEdge(1, 3, 1);
        gm.addEdge(1, 4, 1);
        gm.showGraph();
        gm.dfs();
        gm.bfs();

        String[] vertex = {"A", "B", "C", "D", "E", "F", "G", "H"};
        GraphMatrix graph = new GraphMatrix(vertex);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(3, 7, 1);
        graph.addEdge(4, 7, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(2, 6, 1);
        graph.addEdge(5, 6, 1);
        graph.showGraph();
        graph.dfs();//A->B->D->H->E->C->F->G->
        graph.bfs();//A->B->C->D->E->F->G->H->

    }
}

public class GraphMatrix {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;

    public GraphMatrix(int n) {
        vertexList = new ArrayList<String>(n);
        edges = new int[n][n];
        numOfEdges = 0;
    }

    public GraphMatrix(String[] s) {
        vertexList = new ArrayList<String>(s.length);
        Collections.addAll(vertexList, s);
        edges = new int[s.length][s.length];
    }

    public void showGraph() {
        System.out.print("\t");
        for (String s : vertexList)
            System.out.print(s + "\t");
        System.out.println();
        for (int i = 0; i < vertexList.size(); i++) {
            System.out.print(vertexList.get(i) + "\t");
            for (int val : edges[i])
                System.out.print(val + "\t");
            System.out.println();
        }
    }

    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        System.out.print("DFS:");
        dfs0(0);
        System.out.println();
    }

    private void dfs0(int index) {
        if (isVisited[index])
            return;
        System.out.print(getValueByIndex(index) + "->");
        isVisited[index] = true;
        for (int i = 0; i < edges[index].length; i++) {
            if (edges[index][i] != 0)
                dfs0(i);
        }
//        //没有上面用1个for循环简洁
//        int idx2 = -1;
//        while ((idx2 = getNextIdx(index, idx2))!=-1)
//            dfs0(idx2);
    }
    public void bfs(){
        isVisited = new boolean[vertexList.size()];
        System.out.print("BFS:");
        bfs0(0);

    }
    public void bfs0(int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        isVisited[i]=true;
        System.out.print(vertexList.get(i)+"->");
        while(!queue.isEmpty()){
            Integer temp = queue.poll();
            for (int j = 0; j < getNumOfVertex(); j++) {
                if(edges[temp][j]!=0&&!isVisited[j]){
                    queue.add(j);
                    System.out.print(vertexList.get(j)+"->");
                    isVisited[j]=true;
                }
            }
        }
    }
    private int getNextIdx(int v1, int v2) {
        int[] arr = edges[v1];
        for (int i = v2 + 1; i < edges[v1].length; i++) {
            if (edges[v1][i] > 0)
                return i;
        }
        return -1;
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public void insertVertex(String s) {
        vertexList.add(s);
    }

    public void addEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
