import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static String x;
  static StringBuilder y;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    x = br.readLine();
    y = new StringBuilder(x);

    int cnt = 0;

    do {
      cnt++;
      f();
    } while (!y.toString().equals(x));

    N %= cnt;
    while (N > 0) {
      f();
      N--;
    }

    System.out.println(y);
  }

  static void f() {
    int a = y.length() % 2 == 0 ? 3 : 2;
    for (int i = y.length() - a; i >= 1; i--) {
      char c = y.charAt(i);
      y.deleteCharAt(i);
      y.insert(y.length(), c);
      i--;
    }
  }
}
