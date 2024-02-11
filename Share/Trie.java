package Share;

public class Trie {
  public static final int MAX = 26;
  private TrieNode root;
  public Trie() {
    root = new TrieNode();
  }

  public void addWord(String s) {
    int ch;
    TrieNode temp = root;
    for (Character character : s.toCharArray()) {
      ch = character - 'a';
      if (temp.child[ch] == null) {
        TrieNode x = new TrieNode();
        temp.child[ch] = x;
      }
      temp = temp.child[ch];
    }
    temp.countWord++;
  }

  public boolean addWordAndCheckPrefix(String s) {
    int ch;
    TrieNode temp = root;
    for (Character character : s.toCharArray()) {
      ch = character - 'a';
      if (temp.child[ch] == null) {
        TrieNode x = new TrieNode();
        temp.child[ch] = x;
      } else if (temp.countWord > 0)
        return true;
      temp = temp.child[ch];
    }
    temp.countWord++;
    return false;
  }
}
