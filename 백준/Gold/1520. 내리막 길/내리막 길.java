import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static int[][] map;
  static int[][] dp;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, -1, 0, 1};

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    map = new int[M][N];
    dp = new int[M][N];
    for (int i = 0; i < M; i++) {
      Arrays.fill(dp[i], -1);
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(dfs(0, 0));
  }

  static int dfs(int x, int y) {
    if (x == N - 1 && y == M - 1) {
      return 1;
    }

    if (dp[y][x] != -1) {
      return dp[y][x];
    }

    dp[y][x] = 0;
    for (int i = 0; i < 4; i++) {
      int newX = x + dx[i];
      int newY = y + dy[i];

      if (newY >= 0 && newY < M && newX >= 0 && newX < N && map[y][x] > map[newY][newX]) {
        dp[y][x] += dfs(newX, newY);
      }
    }

    return dp[y][x];
  }
}