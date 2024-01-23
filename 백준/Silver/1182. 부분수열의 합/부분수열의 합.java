import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int cnt = 0;
  static int N;
  static int S;
  static int[] arr;
  static boolean[] used;
  static int sum = 0;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    arr = new int[N];
    used = new boolean[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= N; i++) {
      sum = 0;
      used = new boolean[N];
      f(i, 0);
    }

    System.out.println(cnt);
  }

  static void f(int M, int idx) {
    if (M == 0) {
      if (sum == S) {
        cnt++;
      }
      return;
    }

    for (int i = idx ; i < N; i++) {
      if (!used[i]) {
        used[i] = true;
        sum += arr[i];
        f(M - 1, i + 1);
        sum -= arr[i];
        used[i] = false;
      }
    }
  }
}

