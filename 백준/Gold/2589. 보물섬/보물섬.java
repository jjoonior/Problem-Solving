import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    char[][] map = new char[N][M];
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = str.charAt(j);
      }
    }

    int max = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 'W') {
          continue;
        }
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j, 0});
        visited[i][j] = true;

        while (!q.isEmpty()) {
          int[] node = q.poll();
          max = Math.max(max, node[2]);

          for (int k = 0; k < 4; k++) {
            int x = node[0] + dx[k];
            int y = node[1] + dy[k];

            if (x >= 0 && x < N && y >= 0 && y < M && !visited[x][y] && map[x][y] == 'L') {
              visited[x][y] = true;
              q.offer(new int[]{x, y, node[2] + 1});
            }
          }
        }
      }
    }
    System.out.println(max);
  }
}
