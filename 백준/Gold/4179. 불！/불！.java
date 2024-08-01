import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    char[][] map = new char[R + 2][C + 2];
    for (char[] m : map) {
      Arrays.fill(m, '#');
    }
    int[] s = new int[2];
    List<int[]> fireList = new ArrayList<>();

    for (int i = 1; i <= R; i++) {
      String str = br.readLine();
      for (int j = 1; j <= C; j++) {
        map[i][j] = str.charAt(j - 1);

        if (map[i][j] == 'J') {
          s[0] = i;
          s[1] = j;
        }

        if (map[i][j] == 'F') {
          fireList.add(new int[]{i, j});
        }
      }
    }

    int[] dy = {1, 0, -1, 0};
    int[] dx = {0, 1, 0, -1};
    int cnt = 0;

    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{s[0], s[1], 0});


    while (!q.isEmpty()) {
      cnt++;
      while (!q.isEmpty()) {
        if (q.peek()[2] >= cnt) {
          break;
        }

        int[] cur = q.poll();

        if (map[cur[0]][cur[1]] == 'F') {
          continue;
        }

        if (cur[0] == 1 || cur[1] == 1 || cur[0] == R || cur[1] == C) {
          System.out.println(cur[2] + 1);
          return;
        }

        for (int i = 0; i < 4; i++) {
          int y = cur[0] + dy[i];
          int x = cur[1] + dx[i];

          if (y < 1 || y > R || x < 1 || x > C || map[y][x] != '.') {
            continue;
          }
          map[y][x] = 'J';
          q.offer(new int[]{y, x, cur[2] + 1});
        }
      }

      int size = fireList.size();
      for (int i = 0; i < size; i++) {
        for (int j = 0; j < 4; j++) {
          int y = fireList.get(0)[0] + dy[j];
          int x = fireList.get(0)[1] + dx[j];

          if (y < 1 || y > R || x < 1 || x > C || map[y][x] == '#' || map[y][x] == 'F') {
            continue;
          }

          map[y][x] = 'F';
          fireList.add(new int[]{y, x});
        }
        fireList.remove(0);
      }
    }
    System.out.println("IMPOSSIBLE");
  }
}