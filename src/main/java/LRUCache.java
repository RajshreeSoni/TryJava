import java.util.HashMap;

public class LRUCache {

  static class Node {
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
  Node head;
  Node tail;
  HashMap<Integer, Node> map = null;
  int cap = 0;

  public LRUCache(int cap) {
    this.cap = cap;
    this.map = new HashMap<Integer, Node>();
  }

  public int get(int key) {
    if(map.get(key) == null) {
      return -1;
    }

    Node t = map.get(key);

    removeNode(t);
    offerNode(t);
    return t.value;
  }

  public void put(int key, int value) {

    if (map.containsKey(key)) {
      Node t= map.get(key);
      t.value = value;
      removeNode(t);
      offerNode(t);
    } else {
      if (map.size() >= cap) {
        map.remove(head.key);
        removeNode(head);
      }
      Node node = new Node(key, value);
      offerNode(node);
      map.put(key, node);
    }
  }
  private void removeNode(Node t) {
    if (t.prev != null) {
      t.prev.next = t.next;
    } else {
      head = t.next;
    }
    if (t.next!= null) {
      t.next.prev = t.prev;
    } else {
      tail = t.prev;
    }
  }

  private void offerNode(Node t) {
    if(tail != null) {
      tail.next = t;
    }

    t.prev = tail;
    t.next = null;
    tail = t;
    if (head == null) {
      head = tail;
    }
  }
}
