package Graph;

import java.util.LinkedList;

public class Graph {

  public static int V;
  public static LinkedList<Integer> adj[];

  public Graph(int v) {
    this.V = v;
    adj = new LinkedList[v];
    for(int i = 0;i<v;i++){
      adj[i] = new LinkedList<Integer>();
    }
  }

  public void addEdge(int v,int w) {
    adj[v].add(w);
  }

  public void printGraph(Graph graph) {
    for (int v=0;v<graph.V;v++) {
      System.out.println("Adjacency list of vertex "+ v);
      for (int i:graph.adj[v]) {
        System.out.print(" -> "+ i);
      }
      System.out.println();
    }
  }
}
