import java.io.*;
import java.util.*;

public class Main {
  static int V,E, K;
  static ArrayList<Node>[] graph;
  static int[] d;
  static boolean[] visited;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(br.readLine());
    graph = new ArrayList[V + 1];
    for (int i = 1; i <= V; i++) {
      graph[i] = new ArrayList<>();
    }
    d = new int[V + 1];
    Arrays.fill(d, Integer.MAX_VALUE);
    visited = new boolean[V + 1];

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph[u].add(new Node(v, w));
    }

    d[K] = 0;

    PriorityQueue<Node> q = new PriorityQueue<>();
    q.offer(new Node(K, 0));

    while (!q.isEmpty()) {
      Node node = q.poll();

      if (visited[node.v]) {
        continue;
      }

      for (Node n : graph[node.v]) {
        if (d[n.v] > d[node.v] + n.w) {
          d[n.v] = d[node.v] + n.w;
          if (!visited[n.v]) {
            q.offer(new Node(n.v, d[n.v]));
          }
        }
      }
    }

    for (int i = 1; i <= V; i++) {
      System.out.println(d[i] == Integer.MAX_VALUE ? "INF" : d[i]);
    }
  }
}

class Node implements Comparable<Node> {
  int v;
  int w;

  Node(int v, int w) {
    this.v = v;
    this.w = w;
  }

  @Override
  public int compareTo(Node o) {
    return this.w - o.w;
  }
}
