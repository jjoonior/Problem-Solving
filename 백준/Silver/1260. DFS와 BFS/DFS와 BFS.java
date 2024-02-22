import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static boolean[][] map;
  static boolean[] visited;
  static ArrayList<Integer> used;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());
    map = new boolean[N + 1][N + 1];
    visited = new boolean[N + 1];
    used = new ArrayList<>();

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      map[s][e] = true;
      map[e][s] = true;
    }

    StringBuilder sb = new StringBuilder();

    used.add(V);
    visited[V] = true;
    dfs(V);
    for (int i : used) {
      sb.append(i).append(" ");
    }
    sb.append("\n");

    visited = new boolean[N + 1];
    used = new ArrayList<>();
    bfs(V);
    for (int i : used) {
      sb.append(i).append(" ");
    }
    System.out.println(sb);

  }

  static void dfs(int s) {
    for (int i = 1; i <= N; i++) {
      if (!visited[i] && map[s][i]) {
        visited[i] = true;
        if (!used.contains(i)) {
          used.add(i);
        }
        dfs(i);
      }
    }
  }

  static void bfs(int s) {
    Queue<Integer> q = new LinkedList<>();
    visited[s] = true;
    q.offer(s);

    while (!q.isEmpty()) {
      int x = q.poll();

      if (!used.contains(x)) {
        used.add(x);
      }

      for (int i = 1; i <= N; i++) {
        if (!visited[i] && map[x][i]) {
          visited[i] = true;
          q.offer(i);
        }
      }
    }
  }
}
