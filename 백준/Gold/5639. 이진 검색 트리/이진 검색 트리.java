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
      root.insert(x);
    }
    postOrder(root);
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

  void insert(int x){
    if (this.x > x) {
      if (this.left == null) {
        this.left = new Node(x);
      } else {
        this.left.insert(x);
      }
    } else {
      if (this.right == null) {
        this.right = new Node(x);
      } else {
        this.right.insert(x);
      }
    }
  }
}