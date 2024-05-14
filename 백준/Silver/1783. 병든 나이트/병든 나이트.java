import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    if (n >= 3) {
      if (m >= 7) {
        System.out.println(m-2);
      } else if (m >= 5) {
        System.out.println(4);
      } else {
        System.out.println(m);
      }
    } else if (n == 2) {
      if (m >= 7) {
        System.out.println(4);
      } else {
        System.out.println((m + 1) / 2);
      }
    } else {
      System.out.println(1);
    }
  }
}
