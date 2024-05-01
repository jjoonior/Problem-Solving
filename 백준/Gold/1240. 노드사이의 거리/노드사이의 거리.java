import java.io.*;
import java.util.*;

public class Main {
  static int N, M, s, e;
  static ArrayList<Node>[] graph;
  static boolean[] visited;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    graph = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      graph[u].add(new Node(v, w));
      graph[v].add(new Node(u, w));
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      s = Integer.parseInt(st.nextToken());
      e = Integer.parseInt(st.nextToken());

      visited = new boolean[N + 1];
      visited[s] = true;
      dfs(s, 0);
    }
  }

  static void dfs(int node, int d) {
    if (node == e) {
      System.out.println(d);
      return;
    }

    for (Node n : graph[node]) {
      if (!visited[n.v]) {
        visited[n.v] = true;
        dfs(n.v, d + n.w);
      }
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
    return this.v - o.v;
  }
}