import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;
  static int[] arr;
  static ArrayList<Integer> list;
  static boolean[] used;
  static StringBuilder sb;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N];
    list = new ArrayList<>();
    used = new boolean[N];
    sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    f(0);
    System.out.println(sb);
  }

  static void f(int len) {
    if (len == M) {
      for (int x : list) {
        sb.append(x).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!used[i]) {
        used[i] = true;
        list.add(arr[i]);
        f(len + 1);
        list.remove(list.size() - 1);
        used[i] = false;
      }
    }
  }
}
