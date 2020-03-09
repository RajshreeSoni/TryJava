package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BreathFirstSearch {

  public static void main(String args[]) {
    Graph g = new Graph(4);
    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(1,2);
    g.addEdge(2,0);
    g.addEdge(2,3);
    g.addEdge(3,3);

    System.out.println("Following is Breadth First Traversal "+
        "(starting from vertex 2)");

    boolean visited[] = new boolean[4];
    BFS(2, visited);
  }

  static void BFS(int s, boolean[] visited) {
    LinkedList<Integer> queue = new LinkedList<Integer>();

    visited[s] = true;
    queue.add(s);

    while (queue.size() != 0) {
      s = queue.poll();
      System.out.print(s +" ");
      Iterator<Integer> i = Graph.adj[s].listIterator();
      while (i.hasNext()) {
        int n = i.next();
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }
}
