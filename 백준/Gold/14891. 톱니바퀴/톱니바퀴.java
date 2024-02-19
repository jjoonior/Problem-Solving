import java.io.*;
import java.util.*;

public class Main {
  static ArrayList<Integer>[] x = new ArrayList[4];

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    for (int i = 0; i < 4; i++) {
      x[i] = new ArrayList<>();
      String str = br.readLine();
      for (int j = 0; j < 8; j++) {
        x[i].add(Character.getNumericValue(str.charAt(j)));
      }
    }


    int K = Integer.parseInt(br.readLine());
    for (int i = 0; i < K; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int xi = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());

      f(xi - 1, xi - 1, d == 1);
    }

    int sum = 0;
    for (int i = 0; i < 4; i++) {
      sum += x[i].get(0) == 1 ? Math.pow(2, i) : 0;
    }
    System.out.println(sum);
  }

  static void f(int origin, int i, boolean turn) {
    if (origin == i) {
      if (i + 1 < 4 && x[i].get(2) != x[i + 1].get(6)) {
        f(origin, i + 1, !turn);
      }
      if (i - 1 >= 0 && x[i].get(6) != x[i - 1].get(2)) {
        f(origin, i - 1, !turn);
      }

    } else {
      if (i > origin && i + 1 < 4 && x[i].get(2) != x[i + 1].get(6)) {
        f(origin, i + 1, !turn);
      }
      if (i < origin && i - 1 >= 0 && x[i].get(6) != x[i - 1].get(2)) {
        f(origin, i - 1, !turn);
      }
    }

    if (turn) {
      x[i].add(0, x[i].remove(7));
    } else {
      x[i].add(x[i].remove(0));
    }
  }
}
