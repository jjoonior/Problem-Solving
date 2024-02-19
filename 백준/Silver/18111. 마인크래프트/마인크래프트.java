import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int[][] arr = new int[N][M];

    int cnt = B;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        cnt += arr[i][j];
      }
    }
    int maxHigh = cnt / (N * M);
    int minHigh = maxHigh;
    int minTime = Integer.MAX_VALUE;
    for (int high = maxHigh; high >= 0 ; high--) {
      int time = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          time += high - arr[i][j] >= 0 ? high - arr[i][j] : (arr[i][j] - high) * 2;
        }
      }
      if (time < minTime) {
        minTime = time;
        minHigh = high;
      }
    }
    System.out.println(minTime + " " + minHigh);
  }
}
