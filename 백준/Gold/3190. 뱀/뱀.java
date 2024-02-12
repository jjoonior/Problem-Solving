import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[][] map = new int[N + 2][N + 2];

    int K = Integer.parseInt(br.readLine());
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      map[y][x] = 1;
    }

    Queue<Turn> q = new LinkedList<>();
    int L = Integer.parseInt(br.readLine());
    for (int i = 0; i < L; i++) {
      st = new StringTokenizer(br.readLine());
      int X = Integer.parseInt(st.nextToken());
      char C = st.nextToken().charAt(0);
      q.add(new Turn(X, C));
    }

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int d = 0; // 우 하 좌 상 - 0 1 2 3
    int t = 1;
    Turn turn = q.peek();

    Deque<Body> s = new ArrayDeque<>();
    s.offer(new Body(1, 1));

    while (true) {
      Body head = s.peekLast();
      int x = head.x + dx[d];
      int y = head.y + dy[d];

      // 벽 or 자기자신의 몸인지 확인
      if (x < 1 || x > N || y < 1 || y > N || map[y][x] == 2) {
        break;
      }
      if (map[y][x] == 0) {
        Body tail = s.poll();
        map[tail.y][tail.x] = 0;
      }
      s.offer(new Body(x, y));
      map[y][x] = 2;

      if (!q.isEmpty() && t == turn.x) {
        if (turn.c == 'L') {
          d = (d + 3) % 4;
        } else if (turn.c == 'D') {
          d = (d + 1) % 4;
        }
        q.poll();
        turn = q.peek();
      }
      t++;
    }

    System.out.println(t);
  }
}

class Body{
  int x;
  int y;

  Body(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Turn {
  int x;
  char c;

  Turn(int x, char c) {
    this.x = x;
    this.c = c;
  }
}
