import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] dp = new int[201][201];

    for (int i = 0; i <= N; i++) {
      dp[i][1] = 1;
    }

    for (int i = 1; i <= K - 1; i++) {
      for (int j = 0; j <= N; j++) {
        for (int k = 0; k <= j; k++) {
          dp[j][i + 1] = (dp[j][i + 1] + dp[k][i]) % 1000000000;
        }
      }
    }

    System.out.println(dp[N][K]);
  }
}