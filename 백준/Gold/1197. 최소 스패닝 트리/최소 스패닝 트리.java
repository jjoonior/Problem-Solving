import java.io.*;
import java.util.*;

public class Main {
  static int V, E;
  static boolean[] visited;
  static List<Edge>[] graph;


  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    visited = new boolean[V + 1];
    graph = new List[V + 1];
    for (int i = 1; i <= V; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      graph[u].add(new Edge(v, w));
      graph[v].add(new Edge(u, w));
    }

    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.offer(new Edge(1, 0));

    int cost = 0;
    while (!pq.isEmpty()) {
      Edge e = pq.poll();
      if (!visited[e.v]) {
        visited[e.v] = true;
        cost += e.w;
        for (Edge edge : graph[e.v]) {
          if (!visited[edge.v]) {
            pq.offer(edge);
          }
        }
      }
    }

    System.out.println(cost);
  }

}

class Edge implements Comparable<Edge> {
  int v;
  int w;

  Edge(int v, int w) {
    this.v = v;
    this.w = w;
  }

  @Override
  public int compareTo(Edge o) {
    return this.w - o.w;
  }
}