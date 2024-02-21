import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;
  static int[] arr;
  static int[] list;
  static StringBuilder sb;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N];
    list = new int[M];
    sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    f(0, 0);
    System.out.println(sb);
  }

  static void f(int k, int len) {
    if (len == M) {
      for (int x : list) {
        sb.append(x).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = k; i < N; i++) {
        list[len] = arr[i];
        f(i, len + 1);
    }
  }
}
