import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());


    for (int i = 0; i < 5; i++) {
      String input = br.readLine();
      for (int j = 0; j < 5; j++) {
        map[i][j] = input.charAt(j);
      }
    }

    f(0, 0);

    System.out.println(ans);
  }

  static int ans;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};
  static char[][] map = new char[5][5];
  static boolean[] visited;
  static int[] arr = new int[7];

  static void f(int k, int d) {
    if (d == 7) {
      int sCnt = 0;
      for (int i = 0; i < 7; i++) {
        int x = arr[i] / 5;
        int y = arr[i] % 5;
        sCnt += map[x][y] == 'S' ? 1 : 0;
      }
      if (sCnt >= 4) {
//        for (int i = 0; i < 7; i++) {
//          System.out.printf("%d ", arr[i]);
//        }
//        System.out.println();
        bfs();
      }
      return;
    }

    for (int i = k; i < 25; i++) {
      arr[d] = i;
      f(i + 1, d + 1);
    }
  }

  static void bfs(){
    Queue<Integer> q = new LinkedList<>();
    q.offer(arr[0]);
    visited = new boolean[25];
    visited[arr[0]] = true;
    int cnt = 1;

    while (!q.isEmpty()) {
      int idx = q.poll();

      for (int i = 0; i < 4; i++) {
        int x = idx / 5 + dx[i];
        int y = idx % 5 + dy[i];
        int xy = x * 5 + y;

        if (x < 0 || x >= 5 || y < 0 || y >= 5) {
          continue;
        }

        for (int j = 0; j < 7; j++) {
          if (arr[j] == xy && !visited[xy]) {
            cnt++;
            visited[xy] = true;
            q.offer(xy);
          }
        }
      }
    }

    if (cnt == 7) {
      ans++;
    }
  }
}