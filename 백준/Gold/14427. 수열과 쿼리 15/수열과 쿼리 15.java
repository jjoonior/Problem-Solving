import java.io.*;
import java.util.*;

public class Main {
  static int[] arr;
  static Node[] tree;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(br.readLine());
    arr = new int[N + 1];
    tree = new Node[N * 4];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    init(1, 1, N);

    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      if (Integer.parseInt(st.nextToken()) == 1) {
        int x = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        update(1, x, v, 1, N);
      } else {
        System.out.println(tree[1].idx);
      }
    }
  }

  static Node init(int node, int start, int end) {
    if (start == end) {
      return tree[node] = new Node(arr[start], start);
    }

    Node left = init(node * 2, start, (start + end) / 2);
    Node right = init(node * 2 + 1, (start + end) / 2 + 1, end);

    return tree[node] = left.v <= right.v ? left : right;
  }

  static Node update(int node, int x, int v, int start, int end) {
    if (start == end) {
      arr[x] = v;
      tree[node].v = v;
      return tree[node];
    }

    if (x <= (start + end) / 2) {
      Node left = update(node * 2, x, v, start, (start + end) / 2);
      Node right = tree[node * 2 + 1];
      return tree[node] = left.v <= right.v ? left : right;
    } else {
      Node left = tree[node * 2];
      Node right = update(node * 2 + 1, x, v, (start + end) / 2 + 1, end);
      return tree[node] = left.v <= right.v ? left : right;
    }
  }

}

class Node implements Comparable<Node>{
  int v;
  int idx;

  Node(int v, int idx) {
    this.v = v;
    this.idx = idx;
  }

  @Override
  public int compareTo(Node o) {
    return this.v - o.v;
  }
}
