import java.io.*;
import java.util.*;

public class Main {
  static Map<Character, Node> tree;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    tree = new HashMap<>();
    tree.put('A', new Node('A'));

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char pv = st.nextToken().charAt(0);
      char lv = st.nextToken().charAt(0);
      char rv = st.nextToken().charAt(0);

      if (lv != '.') {
        Node leftNode = new Node(lv);
        tree.get(pv).l = leftNode;
        tree.put(lv, leftNode);
      }
      if (rv != '.') {
        Node rightNode = new Node(rv);
        tree.get(pv).r = rightNode;
        tree.put(rv, rightNode);
      }
    }

    preorder(tree.get('A'));
    System.out.println();

    inorder(tree.get('A'));
    System.out.println();

    postorder(tree.get('A'));
    System.out.println();

  }

  static void preorder(Node node) {
    if (node == null) {
      return;
    }

    System.out.printf("%c", node.v);
    preorder(node.l);
    preorder(node.r);
  }

  static void inorder(Node node) {
    if (node == null) {
      return;
    }

    inorder(node.l);
    System.out.printf("%c", node.v);
    inorder(node.r);
  }

  static void postorder(Node node) {
    if (node == null) {
      return;
    }

    postorder(node.l);
    postorder(node.r);
    System.out.printf("%c", node.v);
  }
}

class Node{
  char v;
  Node l;
  Node r;

  Node(char v) {
    this.v = v;
    this.l = null;
    this.r = null;
  }
}