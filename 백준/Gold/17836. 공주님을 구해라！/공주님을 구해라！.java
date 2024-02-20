import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;
  static int T;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static boolean[][] visited;
  static int[][] map;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());
    visited = new boolean[N][M];
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{0, 0, 0});
    visited[0][0] = true;

    int min = Integer.MAX_VALUE;
    while (!q.isEmpty()) {
      int[] node = q.poll();

      if (node[0] == N - 1 && node[1] == M - 1) {
        min = Math.min(min, node[2]);
        break;
      }
      for (int i = 0; i < 4; i++) {
        int x = node[0] + dx[i];
        int y = node[1] + dy[i];

        if (x >= 0 && x < N && y >= 0 && y < M) {
          if (!visited[x][y] && map[x][y] == 0) {
            visited[x][y] = true;
            q.offer(new int[]{x, y, node[2] + 1});
          }
          if (!visited[x][y] && map[x][y] == 2) {
            visited[x][y] = true;
            min = Math.min(min, node[2] + 1 + (N - x - 1) + (M - y - 1));
          }
        }
      }
    }
    if (min > T) {
      System.out.println("Fail");
    } else {
      System.out.println(min);
    }  
  }
}
