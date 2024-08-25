import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static List<Node>[] nodes;
  static List<Integer>[] path;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    nodes = new List[N + 1];
    for (int i = 0; i < N + 1; i++) {
      nodes[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      nodes[u].add(new Node(v, w));
//      nodes[v].add(new Node(u, w));
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    int S = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    path = new List[N + 1];
    for (int i = 0; i < N + 1; i++) {
      path[i] = new ArrayList<>();
    }
    System.out.println(dijkstra(S, E));
    System.out.println(path[E].size());
    for (int i = 0; i < path[E].size(); i++) {
      System.out.print(path[E].get(i) + " ");
    }
  }

  static int dijkstra(int S, int E) {
    boolean[] visited = new boolean[N + 1];
    int[] d = new int[N + 1];
    Arrays.fill(d, Integer.MAX_VALUE);
    d[S] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(S, 0));
    path[S].add(S);

    while (!pq.isEmpty()) {
      Node node = pq.poll();

      if (visited[node.v]) continue;

      visited[node.v] = true;

      for (Node n : nodes[node.v]) {
        if (visited[n.v]) continue;

        if (d[n.v] > d[node.v] + n.w) {
          path[n.v].clear();
          path[n.v].addAll(path[node.v]);
          path[n.v].add(n.v);
        }
        d[n.v] = Math.min(d[n.v], d[node.v] + n.w);
        pq.add(new Node(n.v, d[n.v]));
      }
    }

    return d[E];
  }
}

class Node implements Comparable<Node> {
  int v;
  int w;

  public Node(int v, int w) {
    this.v = v;
    this.w = w;
  }

  @Override
  public int compareTo(Node o) {
    return this.w - o.w;
  }
}