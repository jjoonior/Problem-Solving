import java.io.*;
import java.util.*;

public class Main {

  static boolean flag;
  static int[][] map;
  static List<int[]> list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    map = new int[9][9];
    list = new ArrayList<>();

    for (int i = 0; i < 9; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());

        if (map[i][j] == 0) {
          list.add(new int[]{i, j});
        }
      }
    }

    f(0);

  }

  static void f(int k) {
    if (k == list.size()) {
      flag = true;
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          System.out.print(map[i][j] + " ");
        }
        System.out.println();
      }
      return;
    }

    int y = list.get(k)[0];
    int x = list.get(k)[1];

    for (int i = 1; i <= 9; i++) {
      map[y][x] = i;
      if (check(k)) {
        f(k + 1);
        if (flag) {
          return;
        }
      }
      map[y][x] = 0;
    }
  }

  static boolean check(int idx) {
    int y = list.get(idx)[0];
    int x = list.get(idx)[1];

    for (int i = 0; i < 9; i++) {
      if (y != i && map[y][x] == map[i][x]) {
        return false;
      }

      if (x != i && map[y][x] == map[y][i]) {
        return false;
      }
    }

    for (int i = y / 3 * 3; i < y / 3 * 3 + 3; i++) {
      for (int j = x / 3 * 3; j < x / 3 * 3 + 3; j++) {
        if (y != i && x != j && map[y][x] == map[i][j]) {
          return false;
        }
      }
    }

    return true;
  }
}
