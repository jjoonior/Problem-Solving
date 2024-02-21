import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());
    int[][] map = new int[N][N];
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int days = 0;
    while (true) {
      boolean isMove = false;
      int team = 0;
      Map<Integer, ArrayList<int[]>> teamList = new HashMap<>();
      Map<Integer, Integer> sum = new HashMap<>();
      boolean[][] visited = new boolean[N][N];

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (visited[i][j]) {
            continue;
          }

          team++;
          Queue<int[]> q = new LinkedList<>();
          q.offer(new int[]{i, j});
          visited[i][j] = true;

          ArrayList<int[]> list = new ArrayList<>();
          list.add(new int[]{i, j});
          teamList.put(team, list);

          sum.put(team, map[i][j]);

          while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int k = 0; k < 4; k++) {
              int x = node[0] + dx[k];
              int y = node[1] + dy[k];

              if (x >= 0 && x < N && y >= 0 && y < N && !visited[x][y]) {
                int gap = Math.abs(map[x][y] - map[node[0]][node[1]]);
                if (gap >= L && gap <= R) {
                  visited[x][y] = true;
                  teamList.get(team).add(new int[]{x, y});
                  sum.put(team, sum.get(team) + map[x][y]);
                  isMove = true;
                  q.offer(new int[]{x, y});
                }
              }
            }
          }
        }
      }

      if (!isMove) {
        break;
      }

      for (Integer key : teamList.keySet()) {
        int s = sum.get(key);
        ArrayList<int[]> list = teamList.get(key);

        for (int[] node : list) {
          map[node[0]][node[1]] = s / list.size();
        }
      }

      days++;
    }
    System.out.println(days);
  }
}
