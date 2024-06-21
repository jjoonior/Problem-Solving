import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int[] arr = new int[N + 1];
    int total = 0;
    int sum = 0;
    int cnt = 0;
    int min = N;

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      total += arr[i];
      sum += arr[i];
      cnt++;
      while (sum >= S) {
        min = Math.min(min, cnt);
        cnt--;
        sum -= arr[i - cnt];
      }
    }

    System.out.println(total < S ? 0 : min);
  }
}