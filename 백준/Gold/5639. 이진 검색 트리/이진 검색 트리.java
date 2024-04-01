import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());

    Node root = new Node(Integer.parseInt(br.readLine()));
    while (true) {
      String input = br.readLine();
      if (input == null || input.equals("")) {
        break;
      }

      int x = Integer.parseInt(input);
      if (root.x > x) {
        f(root, root.left, x);
      } else {
        f(root, root.right, x);
      }
    }
    postOrder(root);
  }

  static void f(Node parent, Node node, int x){
    if (node == null) {
      node = new Node(x);
      if (parent.x > x) {
        parent.left = node;
      } else {
        parent.right = node;
      }
      return;
    }

    if (node.x > x) {
      f(node, node.left, x);
    } else {
      f(node, node.right, x);
    }
  }

  static void postOrder(Node node){
    if (node == null) {
      return;
    }

    postOrder(node.left);
    postOrder(node.right);
    System.out.println(node.x);
  }
}

class Node {
  int x;
  Node left = null;
  Node right = null;

  Node(int x) {
    this.x = x;
  }
}