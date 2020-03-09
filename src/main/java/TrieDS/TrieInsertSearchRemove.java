package TrieDS;

import java.util.LinkedList;

public class TrieInsertSearchRemove {

  static class TrieNode {
    char content;
    boolean isEnd;
    int count;
    LinkedList<TrieNode> childList;

    public TrieNode(char c) {
      childList = new LinkedList<TrieNode>();
      isEnd = false;
      content = c;
      count=0;
    }

    public TrieNode subNode(char c) {
      if (childList!=null) {
        for(TrieNode node:childList) {
          if (node.content == c) {
            return node;
          }
        }
      }
      return null;
    }

    static class Trie {
      static private TrieNode root;
      public Trie() {
        root = new TrieNode(' ');
      }

      public void insert(String word) {
        if (search(word)) {
          return;
        }

        TrieNode current = root;
        for (char ch:word.toCharArray()) {
          TrieNode child = current.subNode(ch);
          if (child!=null) {
            current = child;
          } else {
            current.childList.add(new TrieNode(ch));
            current = current.subNode(ch);
          }
          current.count++;
        }
        current.isEnd = true;
      }

      public static boolean search(String word) {
        TrieNode current = root;
        for (char ch:word.toCharArray()) {
          if (current.subNode(ch) == null){
            return false;
          } else {
            current = current.subNode(ch);
          }
        }
        if (current.isEnd) {
          return true;
        }
        return false;
      }

      public static String getMatchingPrefix(String word) {
        String result = "";
        int level, prevMatch =0;
        TrieNode current = root;
        for (level = 0;level<word.length();level++) {
          char ch = word.charAt(level);
          if (current.subNode(ch) != null){
            result += ch;
            current = current.subNode(ch);
            if (current.isEnd) {
              prevMatch = level+1;
            }
          } else {
            break;
          }
        }
        if (!current.isEnd) {
          return result.substring(0,prevMatch);
        }
        return result;
      }


      static public void remove(String word) {
        if (search(word) == false) {
          return;
        }
        TrieNode current = root;
        for (char ch:word.toCharArray()) {
          TrieNode child = current.subNode(ch);
          if(child.count==0) {
            current.childList.remove(child);
          } else {
            child.count--;
            current = child;
          }
        }
        current.isEnd = false;
      }
    }

    public static void main(String args[]) {
      Trie t = new Trie();
      t.insert("are");
      t.insert("area");
      t.insert("base");
      t.insert("cat");
      t.insert("cater");
      t.insert("basement");
      System.out.println(Trie.search("are"));
      Trie.remove("are");
      System.out.println(Trie.search("are"));
      String input = "caterer";
      System.out.print(input + ":   ");
      System.out.println(Trie.getMatchingPrefix(input));
    }
  }
}
