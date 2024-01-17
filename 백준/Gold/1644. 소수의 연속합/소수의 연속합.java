import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    boolean[] a = new boolean[N + 1];
    int[] b = new int[N + 1];
    int idx = 0;

    for (int i = 2; i <= N; i++) {
      if (!a[i]) {
        b[idx++] = i;
        for (int j = i * 2; j <= N; ) {
          a[j] = true;
          j += i;
        }
      }
    }

    int x = 0;
    int y = 0;
    int sum = b[0];
    int cnt = 0;

    while (x < N && b[x] > 0) {
      if (sum > N) {
        sum -= b[y++];
      } else {
        if (sum == N) {
          cnt++;
        }
        sum += b[++x];
      }
    }

    System.out.println(cnt);
  }
}