import java.io.*;
import java.util.*;

public class Main {
  static int V;
  static ArrayList<Node>[] graph;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());

    V = Integer.parseInt(br.readLine());
    graph = new ArrayList[V + 1];

    for (int i = 1; i <= V; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < V; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());

      while (true) {
        int v = Integer.parseInt(st.nextToken());
        if (v == -1) {
          break;
        }
        int w = Integer.parseInt(st.nextToken());
        graph[u].add(new Node(v, w));
      }
    }

    int[] ans = f(1);
    ans = f(ans[1]);

    System.out.println(ans[0]);

  }

  static int[] f(int node) {
    boolean[] visited = new boolean[V + 1];
    int[] sum = new int[V + 1];
    Queue<Integer> q = new LinkedList<>();
    q.offer(node);
    visited[node] = true;

    while (!q.isEmpty()) {
      int u = q.poll();

      for (Node n : graph[u]) {
        if (!visited[n.v]) {
          visited[n.v] = true;
          sum[n.v] = sum[u] + n.w;
          q.offer(n.v);
        }
      }
    }

    int max = 0;
    int idx = 0;
    for (int i = 1; i <= V; i++) {
      if (sum[i] > max) {
        max = sum[i];
        idx = i;
      }
    }
    return new int[]{max, idx};
  }
}

class Node implements Comparable<Node>{
  int v;
  int w;

  Node(int v, int w) {
    this.v = v;
    this.w = w;
  }

  @Override
  public int compareTo(Node o) {
    return this.v - o.v;
  }
}
