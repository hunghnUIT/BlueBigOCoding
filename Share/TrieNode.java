package Share;

public class TrieNode {
  static final int MAX = 26;
  public TrieNode[] child;
  public int countWord;
  public TrieNode() {
    countWord = 0;
    child = new TrieNode[MAX];
  }
}
