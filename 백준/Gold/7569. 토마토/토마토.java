import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());
    int[][][] map = new int[H][N][M];
    int[] dx = {1, 0, -1, 0, 0, 0};
    int[] dy = {0, 1, 0, -1, 0, 0};
    int[] dh = {0, 0, 0, 0, 1, -1};

    boolean[][][] visited = new boolean[H][N][M];
    Queue<int[]> q = new LinkedList<>();
    int total = 0;


    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < M; k++) {
          map[i][j][k] = Integer.parseInt(st.nextToken());
          if (map[i][j][k] == 1) {
            q.offer(new int[]{i, j, k, 0});
          }
          if (map[i][j][k] == 0) {
            total++;
          }
        }
      }
    }

    int days = 0;
    while (!q.isEmpty()) {
      int[] node = q.poll();

      for (int k = 0; k < 6; k++) {
        int h = node[0] + dh[k];
        int x = node[1] + dx[k];
        int y = node[2] + dy[k];
        days = node[3];

        if (h >= 0 && h < H && x >= 0 && x < N && y >= 0 && y < M && !visited[h][x][y] && map[h][x][y] == 0) {
          visited[h][x][y] = true;
          total--;
          q.offer(new int[]{h, x, y, node[3] + 1});
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