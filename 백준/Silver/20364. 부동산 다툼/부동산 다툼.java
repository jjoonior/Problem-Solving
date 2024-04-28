import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());

    boolean[] tree = new boolean[N + 1];
    for (int i = 0; i < Q; i++) {
      int x = Integer.parseInt(br.readLine());
      int n = x;
      boolean isBlocked = false;
      int block = 0;

      while (n > 0) {
        if (tree[n]) {
          isBlocked = true;
          block = n;
        }
        n /= 2;
      }

      if (isBlocked) {
        System.out.println(block);
      } else {
        tree[x] = true;
        System.out.println(0);
      }
    }
  }
}
