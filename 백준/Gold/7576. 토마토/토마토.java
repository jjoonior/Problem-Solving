import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int[][] map = new int[N][M];
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    boolean[][] visited = new boolean[N][M];
    Queue<int[]> q = new LinkedList<>();
    int total = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 1) {
          q.offer(new int[]{i, j, 0});
        }
        if (map[i][j] == 0) {
          total++;
        }
      }
    }

    int days = 0;
    while (!q.isEmpty()) {
      int[] node = q.poll();

      for (int k = 0; k < 4; k++) {
        int x = node[0] + dx[k];
        int y = node[1] + dy[k];
        days = node[2];

        if (x >= 0 && x < N && y >= 0 && y < M && !visited[x][y] && map[x][y] == 0) {
          visited[x][y] = true;
          total--;
          q.offer(new int[]{x, y, node[2] + 1});
        }
      }
    }
    if (total == 0) {
      System.out.println(days);
    } else {
      System.out.println(-1);
    }
  }
}
