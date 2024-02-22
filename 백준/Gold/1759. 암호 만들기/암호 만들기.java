import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;
  static char[] arr;
  static char[] list;
  static boolean[] used;
  static int[] cnt;
  static StringBuilder sb;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    arr = new char[N];
    list = new char[M];
    used = new boolean[N];
    cnt = new int[2];
    sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = st.nextToken().charAt(0);
    }

    Arrays.sort(arr);
    f(0, 0);

    System.out.println(sb);
  }

  static void f(int k, int len) {
    if (len == M) {
      for (char x : list) {
        sb.append(x);
      }
      sb.append("\n");
      return;
    }

    for (int i = k; i < N; i++) {
      if (!used[i]) {
        if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
          if (cnt[0] >= M - 2) {
            continue;
          }
          used[i] = true;
          cnt[0]++;
          list[len] = arr[i];
          f(i + 1, len + 1);
          cnt[0]--;
          used[i] = false;
        } else {
          if (cnt[1] >= M - 1) {
            continue;
          }
          used[i] = true;
          cnt[1]++;
          list[len] = arr[i];
          f(i + 1, len + 1);
          cnt[1]--;
          used[i] = false;
        }
      }
    }
  }
}
