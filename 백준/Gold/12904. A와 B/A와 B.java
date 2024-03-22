import java.io.*;
import java.util.*;

public class Main {
  static int cnt = 0;
  static String b, reversedB;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String a = br.readLine();
    b = br.readLine();
    reversedB = new StringBuilder(b).reverse().toString();

    f(a, false);

    System.out.println(cnt);
  }

  static void f(String a, boolean reversed) {
    if (a.length() == b.length()) {
      if (!reversed) {
        if (Objects.equals(a, b)) {
          cnt++;
        }
      } else {
        if (Objects.equals(a, reversedB)) {
          cnt++;
        }
      }

      return;
    }

    if (!b.contains(a) && !reversedB.contains(a)) {
      return;
    }

    if (!reversed) {
      f(a + 'A', false);
      f('B' + a, true);
    } else {
      f(a + 'B', false);
      f('A' + a, true);
    }
  }
}