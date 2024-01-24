import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  static int cnt = 0;
  static int N;
  static int[][] arr;
  static boolean[][] visited;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    visited = new boolean[N][N];

    f(0);

    System.out.println(cnt);
  }

  static void f(int M) {
    if (M == N) {
      cnt++;
      return;
    }

    for (int i = 0; i < N; i++) {
      boolean r = true;

      int y = M - 1;
      int x1 = i - 1;
      int x2 = i + 1;
      while (y >= 0) {
        if (visited[y][i] || (x1 >= 0 && visited[y][x1]) || (x2 < N && visited[y][x2])) {
          r = false;
          break;
        }
        y--;
        x1--;
        x2++;
      }

      if (r) {
        visited[M][i] = true;
        f(M + 1);
        visited[M][i] = false;
      }
    }
  }
}

