import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;
  static int[] arr;
  static int[] list;
  static StringBuilder sb;
  static Set<String> set;
  static boolean[] used;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N];
    list = new int[M];
    sb = new StringBuilder();
    set = new HashSet<>();
    used = new boolean[N];

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
      StringBuilder tmp = new StringBuilder();
      for (int x : list) {
        tmp.append(x).append(" ");
      }
      tmp.append("\n");
      if (!set.contains(tmp.toString())) {
        set.add(tmp.toString());
        sb.append(tmp);
      }
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!used[i]) {
        used[i] = true;
        list[len] = arr[i];
        f(i + 1, len + 1);
        used[i] = false;
      }
    }
  }
}
