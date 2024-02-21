import java.io.*;
import java.util.*;

public class Main {
  static int K;
  static int[] arr;
  static int[] list;
  static StringBuilder sb;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());
    sb = new StringBuilder();

    String input = br.readLine();
    while (!input.equals("0")) {
      StringTokenizer st = new StringTokenizer(input);
      K = Integer.parseInt(st.nextToken());
      arr = new int[K];
      list = new int[6];

      for (int i = 0; i < K; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(arr);
      f(0, 0);
      sb.append("\n");

      input = br.readLine();
    }

    System.out.println(sb);
  }

  static void f(int k, int len) {
    if (len == 6) {
      for (int x : list) {
        sb.append(x).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = k; i < K; i++) {
        list[len] = arr[i];
      f(i + 1, len + 1);
    }
  }
}
