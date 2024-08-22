import java.io.*;
import java.util.*;

public class Main {
  static int R, C, max;
  static char[][] map;
  static boolean flag;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    max = 0;

    map = new char[R][C];

    for (int i = 0; i < R; i++) {
      String input = br.readLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = input.charAt(j);
      }
    }

    for (int i = 0; i < R; i++) {
      flag = false;
      f(i, 0);
    }

    System.out.println(max);
  }

  static void f(int y, int x) {
    if (x == C - 1) {
      max++;
      flag = true;
      return;
    }

    for (int i = -1; i <= 1; i++) {
      if (y + i < 0 || y + i >= R || map[y + i][x + 1] == 'x') continue;

      map[y + i][x + 1] = 'x';
      f(y + i, x + 1);
      if (flag) return;
    }
  }
}