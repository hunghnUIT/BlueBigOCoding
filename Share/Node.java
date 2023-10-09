package Share;

public class Node implements Comparable<Node> {
  public Integer id;
  public Integer dist;
  public Node(Integer id, Integer dist) {
    this.id = id;
    this.dist = dist;
  }

  @Override
  public int compareTo(Node other) {
    return this.dist.compareTo(other.dist);
  }
}