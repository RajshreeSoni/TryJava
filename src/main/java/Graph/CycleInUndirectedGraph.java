package Graph;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.Iterator;

public class CycleInUndirectedGraph {

  public static void main(String args[])
  {
    // Create a graph given in the above diagram
    Graph g1 = new Graph(5);
    g1.addEdge(1, 0);
    g1.addEdge(0, 2);
    g1.addEdge(2, 1);
    g1.addEdge(0, 3);
    g1.addEdge(3, 4);
    if (isCyclic(4))
      System.out.println("Graph contains cycle");
    else
      System.out.println("Graph doesn't contains cycle");

    Graph g2 = new Graph(3);
    g2.addEdge(0, 1);
    g2.addEdge(1, 2);
    if (isCyclic(3))
      System.out.println("Graph contains cycle");
    else
      System.out.println("Graph doesn't contains cycle");
  }

  static boolean isCyclic(int V) {
    Boolean visited[] = new Boolean[V];

    for (int i = 0; i < V; i++)
      visited[i] = false;

    for (int i =0;i<V;i++) {
      if (!visited[i]) {
        if (isCyclicUtil(i, visited, -1)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean isCyclicUtil(int v, Boolean[] visited, int parent) {
    visited[v] = true;
    Iterator<Integer> i = Graph.adj[v].listIterator();
    while (i.hasNext()) {
      int n = i.next();
      if (!visited[n]) {
        if (isCyclicUtil(n, visited, v)) {
          return true;
        }
      }
      else if (n!=parent) {
        return true;
      }
    }
    return false;
  }
}
