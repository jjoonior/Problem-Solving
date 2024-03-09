import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static ArrayList<Node>[] graph;
  static int[] d;
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

    d = new int[N + 1];
    Arrays.fill(d, Integer.MAX_VALUE);

    visited = new boolean[N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u].add(new Node(v, 1));
      graph[v].add(new Node(u, 1));
    }


    d[1] = 0;

    PriorityQueue<Node> q = new PriorityQueue<>();
    q.offer(new Node(1, 0));

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

    int max = 0;
    int maxIdx = 0;
    int cnt = 0;

    for (int i = 2; i <= N; i++) {
      if (max < d[i] && d[i] != Integer.MAX_VALUE) {
        max = d[i];
        maxIdx = i;
        cnt = 1;
      } else if (max == d[i]) {
        cnt++;
      }
    }

    System.out.printf("%d %d %d", maxIdx, max, cnt);
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
