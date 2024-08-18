import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int INF = 10000000;

    int[][] map = new int[V][V];

    for (int i = 0; i < V; i++) {
      Arrays.fill(map[i], INF);
      map[i][i] = 0;
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      map[a - 1][b - 1] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        for (int k = 0; k < V; k++) {
          map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
        }
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        if (i == j) continue;
        min = Math.min(min, map[i][j] + map[j][i]);
      }
    }

    System.out.println(min < INF ? min : -1);
  }
}