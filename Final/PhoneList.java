package Final;

import java.util.*;

public class PhoneList {
  static class TrieNode {
    static final int MAX = 10;
    public TrieNode[] child;
    public int countWord;
    public TrieNode() {
      countWord = 0;
      child = new TrieNode[MAX];
    }
  }

  static class Trie {
    private TrieNode root;
    public Trie() {
      root = new TrieNode();
    }

    public boolean addWordAndCheckPrefix(String s) {
      int ch;
      TrieNode temp = root;
      for (Character character : s.toCharArray()) {
        ch = character - '0';
        if (temp.child[ch] == null) {
          TrieNode x = new TrieNode();
          temp.child[ch] = x;
        }
        temp = temp.child[ch];
        if (temp.countWord > 0)
          return true;
      }
      temp.countWord++;
      return false;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      String res = "YES";
      ArrayList<String> l = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        l.add(sc.next());
      }
      Collections.sort(l, Comparator.comparingInt(String::length));
      Trie trie = new Trie();
      for (String string : l) {
        boolean check = trie.addWordAndCheckPrefix(string);
        if (check) {
          res = "NO";
          break;
        }
      }
      System.out.println(res);
    }
    sc.close();
  }
}
