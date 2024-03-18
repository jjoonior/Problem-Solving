import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int n = e - s;
      int sqrt = (int) Math.sqrt(n);

      if (n == sqrt * sqrt) {
        System.out.println(sqrt * 2 - 1);
      } else if (n <= sqrt * (sqrt + 1)) {
        System.out.println(sqrt * 2);
      } else {
        System.out.println(sqrt * 2 + 1);
      }
    }

  }
}

