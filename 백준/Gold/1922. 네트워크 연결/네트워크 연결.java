import java.io.*;
import java.util.*;

public class Main {
  static int V, E;
  static List<Edge> edges = new ArrayList<>();
  static int[] parent;


  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());

    V = Integer.parseInt(br.readLine());
    E = Integer.parseInt(br.readLine());
    parent = new int[V + 1];


    for (int i = 0; i < E; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      edges.add(new Edge(u, v, w));
    }

    Collections.sort(edges);
    for (int i = 1; i <= V; i++) {
      parent[i] = i;
    }

    int cost = 0;
    int cnt = 0;
    for (Edge e : edges) {
      if (cnt >= V - 1) {
        break;
      }

      if (find(e.u) != find(e.v)) {
        cost += e.w;
        cnt++;
        union(e.u, e.v);
      }
    }

    System.out.println(cost);
  }

  static int find(int u) {
    if (parent[u] == u) {
      return u;
    }

    return parent[u] = find(parent[u]);
  }

  static void union(int u, int v) {
    int uRoot = find(u);
    int vRoot = find(v);

    if (uRoot != vRoot) {
      parent[uRoot] = vRoot;
    }
  }
}

class Edge implements Comparable<Edge> {
  int u;
  int v;
  int w;

  Edge(int u, int v, int w) {
    this.u = u;
    this.v = v;
    this.w = w;
  }

  @Override
  public int compareTo(Edge o) {
    return this.w - o.w;
  }
}