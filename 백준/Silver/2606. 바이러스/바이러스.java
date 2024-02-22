import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static boolean[][] map;
  static boolean[] visited;
  static ArrayList<Integer> used;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    map = new boolean[N + 1][N + 1];
    visited = new boolean[N + 1];
    used = new ArrayList<>();

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      map[s][e] = true;
      map[e][s] = true;
    }

    visited = new boolean[N + 1];
    used = new ArrayList<>();
    bfs(1);

    System.out.println(used.size() - 1);
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

