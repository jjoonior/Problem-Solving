import java.util.*;

class Solution {
  boolean[][] isVisited;
  int[] dx = {1, -1, 0, 0};
  int[] dy = {0, 0, 1, -1};
  public int solution(int[][] maps) {
    int answer = 0;
    int n = maps.length;
    int m = maps[0].length;
    isVisited = new boolean[n][m];
    Queue<P> q = new LinkedList<>();

    q.add(new P(0, 0, 1));

    while (!q.isEmpty()){
      P p = q.poll();
      if (isVisited[p.x][p.y]){
        continue;
      }
      isVisited[p.x][p.y] = true;
      if (p.x == n - 1 && p.y == m - 1) {
        answer = p.len;
        break;
      }
      for (int i = 0; i < 4; i++) {
        int x = p.x + dx[i];
        int y = p.y + dy[i];
        if (x >= 0 && x < n && y >= 0 && y < m) {
          if (!isVisited[x][y] && maps[x][y] == 1) {
            q.add(new P(x, y, p.len + 1));
          }
        }
      }
    }
    if (!isVisited[n - 1][m - 1]) {
      return -1;
    }
    return answer;
  }

  class P {
    int x;
    int y;
    int len;
    P(int x, int y, int len) {
      this.x = x;
      this.y = y;
      this.len = len;
    }
  }
}