import java.io.*;
import java.util.*;

class Solution {
  static int N;
  static String cmd;
  static int[][] map;
  static Deque<Integer> deque;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      cmd = st.nextToken();

      map = new int[N][N];

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      for (int i = 0; i < N; i++) {
        deque = new LinkedList<>();

        for (int j = 0; j < N; j++) {
          switch (cmd) {
            case "left":
              f(i, j);
              break;
            case "right":
              f(i, N - 1 - j);
              break;
            case "up":
              f(j, i);
              break;
            case "down":
              f(N - 1 - j, i);
              break;
          }
        }

        for (int j = 0; j < N; j++) {
          switch (cmd) {
            case "left":
              a(i, j);
              break;
            case "right":
              a(i, N - 1 - j);
              break;
            case "up":
              a(j, i);
              break;
            case "down":
              a(N - 1 - j, i);
              break;
          }
        }
      }

      System.out.println("#" + t);
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          System.out.print(map[i][j] + " ");
        }
        System.out.println();
      }
    }
  }

  static void f(int y, int x) {
    if (map[y][x] == 0) {
      return;
    }

    if (deque.isEmpty()) {
      deque.offerLast(map[y][x]);
    } else {
      if (deque.peekLast() == map[y][x]) {
        deque.pollLast();
        deque.offerLast(map[y][x] * 2);
        deque.offerLast(1);
      } else {
        deque.offerLast(map[y][x]);
      }
    }
  }

  static void a(int y, int x) {
    if (!deque.isEmpty()) {
      map[y][x] = deque.pollFirst();
      if (!deque.isEmpty() && deque.peekFirst() == 1) {
        deque.pollFirst();
      }
    } else {
      map[y][x] = 0;
    }
  }
}
