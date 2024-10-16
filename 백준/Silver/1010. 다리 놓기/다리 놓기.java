import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      int[][] dp = new int[N][M];
      for (int i = 0; i < M; i++) {
        dp[0][i] = i + 1;
      }
      for (int i = 1; i < N; i++) {
        for (int j = i; j < M; j++) {
          for (int k = 0; k < j; k++) {
            dp[i][j] += dp[i - 1][k];
          }
        }
      }

      System.out.println(dp[N - 1][M - 1]);

    }
  }
}