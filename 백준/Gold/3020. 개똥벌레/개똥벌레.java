import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());

    int[] b = new int[H + 1];
    int[] t = new int[H + 1];
    int[] sum = new int[H + 1];

    for (int i = 1; i <= N; i++) {
      int h = Integer.parseInt(br.readLine());
      if (i % 2 == 1) {
        b[h]++;
      } else {
        t[h]++;
      }
    }

    for (int i = H - 1; i >= 1; i--) {
      b[i] += b[i + 1];
      t[i] += t[i + 1];
    }

    for (int i = 1; i <= H; i++) {
      sum[i] = b[i] + t[H - i + 1];
    }

    int cnt = 0;
    int min = N + 1;
    for (int i = 1; i <= H; i++) {
      if (sum[i] == min) {
        cnt++;
      } else if (sum[i] < min) {
        cnt = 1;
        min = sum[i];
      }
    }

    System.out.println(min + " " + cnt);

  }
}