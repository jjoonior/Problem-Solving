import java.io.*;
import java.util.*;

public class Main {
  static Queue<Integer> q = new LinkedList<>();
  static List<Integer>[] lists;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i < Math.pow(2, n); i++) {
      q.offer(Integer.parseInt(st.nextToken()));
    }

    Node root = new Node(n);
    root.insert();

    inOrder(root);

    lists = new List[n + 1];
    for (int i = 1; i <= n; i++) {
      lists[i] = new ArrayList<>();
    }

    preOrder(root);

    for (int i = n; i >= 1; i--) {
      for (int x : lists[i]) {
        System.out.printf("%d ",x);
      }
      System.out.println();
    }
  }

  static void inOrder(Node node){
    if (node == null) {
      return;
    }

    inOrder(node.left);
    node.x = q.poll();
    inOrder(node.right);
  }

  static void preOrder(Node node){
    if (node == null) {
      return;
    }

    lists[node.depth].add(node.x);
    preOrder(node.left);
    preOrder(node.right);
  }
}

class Node{
  int x;
  int depth;
  Node left = null;
  Node right = null;

  Node(int depth){
    this.depth = depth;
  }

  void insert(){
    if (this.depth > 1) {
      this.left = new Node(this.depth - 1);
      this.right = new Node(this.depth - 1);
      this.left.insert();
      this.right.insert();
    }
  }

}