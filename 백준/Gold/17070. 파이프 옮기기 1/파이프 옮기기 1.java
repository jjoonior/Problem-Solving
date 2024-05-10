import java.io.*;
import java.util.*;

public class Main {
  static int[][] map;
  static int[][][] dp;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    map = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dp = new int[3][N + 1][N + 1];
    dp[0][1][2] = 1;

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (map[i][j] != 1) {
          dp[0][i][j] += dp[0][i][j - 1] + dp[1][i][j - 1];
          if (map[i - 1][j] != 1 && map[i][j - 1] != 1) {
            dp[1][i][j] += dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1];
          }
          dp[2][i][j] += dp[1][i - 1][j] + dp[2][i - 1][j];
        }
      }
    }
    
    System.out.println(dp[0][N][N] + dp[1][N][N] + dp[2][N][N]);
  }
}
