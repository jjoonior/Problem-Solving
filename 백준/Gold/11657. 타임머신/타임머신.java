import java.io.*;
import java.util.*;

public class Main {
  static ArrayList<Edge> graph;

  static void BellmanFord(int n, int m, int start) {
    long[] dist = new long[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < m; j++) {
        Edge edge = graph.get(j);

        if (dist[edge.v] != Integer.MAX_VALUE && dist[edge.w] > dist[edge.v] + edge.cost) {
          dist[edge.w] = dist[edge.v] + edge.cost;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      Edge edge = graph.get(i);

      if (dist[edge.v] != Integer.MAX_VALUE && dist[edge.w] > dist[edge.v] + edge.cost) {
        System.out.println(-1);
        return;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 2; i < dist.length; i++) {
      if (dist[i] == Integer.MAX_VALUE) {
        sb.append(-1).append("\n");
      } else {
        sb.append(dist[i]).append("\n");
      }
    }
    System.out.println(sb);
  }

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    graph = new ArrayList<>();


    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      graph.add(new Edge(a, b, c));
    }

    BellmanFord(N, M, 1);
  }
}

class Edge {
  int v;
  int w;
  int cost;

  Edge(int v, int w, int cost) {
    this.v = v;
    this.w = w;
    this.cost = cost;
  }
}

