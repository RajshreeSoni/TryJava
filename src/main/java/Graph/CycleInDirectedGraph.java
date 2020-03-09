package Graph;

import java.util.Iterator;

public class CycleInDirectedGraph {

  public static void main(String[] args)
  {
    Graph graph = new Graph(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);

    if(isCyclic(4))
      System.out.println("Graph contains cycle");
    else
      System.out.println("Graph doesn't "
          + "contain cycle");
  }

  static boolean isCyclic(int V) {
    boolean[] visited = new boolean[V];
    boolean[] recStack = new boolean[V];

    for (int i=0;i<V;i++) {
      if(isCyclicUtil(i, visited, recStack)) {
        return true;
      }
    }
    return false;
  }

  static boolean isCyclicUtil(int i, boolean[] visited,  boolean[] recStack) {
    if (recStack[i]) {
      return true;
    }
    if (visited[i]) {
      return false;
    }

    visited[i] = true;
    recStack[i] = true;

    Iterator<Integer> children = Graph.adj[i].listIterator();
    while(children.hasNext()) {
      int child = children.next();
      if (isCyclicUtil(child, visited, recStack)) {
        return true;
      }
    }
    recStack[i] = false;
    return false;
  }
}
