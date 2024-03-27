import java.io.*;
import java.util.*;

public class Main {
  static int R, C;
  static char[][] map;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static boolean[][] visited;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];
    visited = new boolean[R][C];
    Queue<Node> q = new LinkedList<>();
    Node S = null;

    for (int i = 0; i < R; i++) {
      String str = br.readLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = str.charAt(j);
        if (map[i][j] == 'S') {
          S = new Node(i, j, 0, true);
        }
        if (map[i][j] == '*') {
          q.offer(new Node(i, j, 0, false));
        }
      }
    }

    visited[S.y][S.x] = true;
    q.offer(S);

    int ans = 0;
    while (!q.isEmpty()) {
      Node node  = q.poll();
      for (int i = 0; i < 4; i++) {
        int y = node.y + dy[i];
        int x = node.x + dx[i];

        if (y < 0 || x < 0 || y >= R || x >= C || map[y][x] == 'X' || visited[y][x]) {
          continue;
        }

        if (map[y][x] == 'D') {
          if (node.S) {
            ans = node.len + 1;
            System.out.println(ans);
            return;
          }
        }

        if (map[y][x] == '.') {
          if (!node.S) {
            map[y][x] = '*';
          }
          visited[y][x] = true;
          q.offer(new Node(y, x, node.len + 1, node.S));
        }
      }
    }

    System.out.println("KAKTUS");
  }
}

class Node{
  int y;
  int x;
  int len;
  boolean S;

  Node(int y, int x, int len, boolean S) {
    this.y = y;
    this.x = x;
    this.len = len;
    this.S = S;
  }
}