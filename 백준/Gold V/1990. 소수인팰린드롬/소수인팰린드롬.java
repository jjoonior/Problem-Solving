import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    boolean[] A = new boolean[100000001];

    for (int i = 2; i <= 100000000; i++) {
      if (!A[i]) {
        for (int j = i * 2; j <= 100000000;) {
          A[j] = true;
          j += i;
        }
      }
    }

    for (int i = a; i <= b; i++) {
      if (!A[i]) {
        String str = Integer.toString(i);
        boolean flag = true;
        for (int j = 0; j < str.length() / 2; j++) {
          if (str.charAt(j) != str.charAt(str.length() - j - 1)) {
            flag = false;
          }
        }
        if (flag) {
          System.out.println(i);
        }
      }
    }
    System.out.println(-1);
  }
}
