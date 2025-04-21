import java.io.*;
import java.util.*;

public class Main {

  static int N, M;
  static int[] arr;
  static Set<Integer> set;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[M];
    set = new HashSet<>();

    f(0, 1);

  }

  static void f(int cnt, int k) {
    if (cnt == M) {
      for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (!set.contains(i)) {
        arr[cnt] = i;
        set.add(arr[cnt]);
        f(cnt + 1, i + 1);
        set.remove(arr[cnt]);
      }
    }
  }
}
