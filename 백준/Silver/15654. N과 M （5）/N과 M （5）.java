import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;
  static int[] arr;
  static ArrayList<Integer> list;
  static boolean[] used;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N];
    list = new ArrayList<>();
    used = new boolean[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    f(0);

  }

  static void f(int len) {
    if (len == M) {
      System.out.println(list.toString().substring(1, list.toString().length() - 1).replace(",", ""));
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
