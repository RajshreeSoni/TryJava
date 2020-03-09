package Graph;

import java.util.Iterator;

public class DepthFirstSearch {


  public static void main(String args[]) {
    Graph g = new Graph(4);
    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(1,2);
    g.addEdge(2,0);
    g.addEdge(2,3);
    g.addEdge(3,3);

    boolean visited[] = new boolean[4];
    System.out.println("Following is Depth First Traversal "+
        "(starting from vertex 2)");

    for (int i=0;i<4;i++) {
      if (visited[i] == false) {
        DFS(2, visited);
      }
    }
  }

  static void DFS(int v, boolean visited[]) {
    visited[v] =true;
    System.out.print(v + "  ");
    Iterator<Integer> i = Graph.adj[v].listIterator();
    while (i.hasNext()) {
      int n = i.next();
      if (!visited[n]) {
        DFS(n, visited);
      }
    }
  }
}
