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

    for (int i = 0; i < V -1 ; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      graph[u].add(new Node(v, w));
      graph[v].add(new Node(u, w));
    }

    long[] ans = f(1);
    ans = f((int) ans[1]);

    System.out.println(ans[0]);
  }

  static long[] f(int node) {
    boolean[] visited = new boolean[V + 1];
    long[] sum = new long[V + 1];
    Queue<Integer> q = new LinkedList<>();
    q.offer(node);
    visited[node] = true;

    while (!q.isEmpty()) {
      int u = q.poll();

      for (Node n : graph[u] == null ? Collections.<Node>emptyList() : graph[u]) {
        if (!visited[n.v]) {
          visited[n.v] = true;
          sum[n.v] = sum[u] + n.w;
          q.offer(n.v);
        }
      }
    }

    long max = 0L;
    long idx = 0L;
    for (int i = 1; i <= V; i++) {
      if (sum[i] > max) {
        max = sum[i];
        idx = (long) i;
      }
    }
    return new long[]{max, idx};
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
