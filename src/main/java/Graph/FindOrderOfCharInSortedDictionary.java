package Graph;

import java.util.Iterator;
import java.util.Stack;

public class FindOrderOfCharInSortedDictionary {

  public static void main(String args[])
  {
    // Create a graph given in the above diagram
    String[] words = {"caa", "aaa", "aab"};
    printOrder(words, 3);
  }

  static void topologicalSort(int V) {
    Stack<Integer> st = new Stack<Integer>();
    boolean visited[] = new boolean[V];
    for(int i=0;i<V;i++) {
      visited[i] = false;
    }
    for(int i =0;i<V;i++) {
      if (!visited[i]) {
        topologicalSortUtil(i,visited,st);
      }
    }
    while (!st.isEmpty()) {
      System.out.print((char)('a'+st.pop())+" ");
    }
  }

  private static void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> st) {
    visited[v] =true;
    Iterator<Integer> it = Graph.adj[v].listIterator();
    while (it.hasNext()) {
      int n = it.next();
      if (!visited[n]) {
        topologicalSortUtil(n, visited, st);
      }
    }
    st.push(v);
  }

  private static void printOrder(String[] words, int alpha) {
    Graph graph = new Graph(alpha);
    for (int i=0;i<words.length-1;i++) {
      String word1 = words[i];
      String word2 = words[i+1];
      for (int j=0;j<Math.min(word1.length(), word2.length()); j++) {
        if (word1.charAt(j) != word2.charAt(j)) {
          graph.addEdge(word1.charAt(j)-'a', word2.charAt(j)-'a');
          break;
        }
      }
    }
    topologicalSort(alpha);
  }
}
