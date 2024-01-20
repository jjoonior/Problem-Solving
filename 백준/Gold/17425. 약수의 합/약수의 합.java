import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());

    long[] f = new long[1000001];
    Arrays.fill(f, 1);

    for (int i = 2; i <= 1000000; i++) {
      for (int j = 1; j * i <= 1000000; j++) {
        f[i * j] += i;
      }
    }

    for (int i = 2; i <= 1000000; i++) {
      f[i] += f[i - 1];
    }

    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      sb.append(f[N]).append("\n");
    }
    System.out.println(sb);
  }
}

