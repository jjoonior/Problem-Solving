import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    List<int[][]> step = new ArrayList<>();

    int x = Integer.parseInt(st.nextToken());
    int[][] curr = new int[5][5];
    curr[x][0] = curr[0][x] = 2;
    step.add(curr);

    while (true) {
      x = Integer.parseInt(st.nextToken());
      if (x == 0) {
        break;
      }

      int[][] prev = step.get(step.size() - 1);
      curr = new int[5][5];

      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (prev[i][j] == 0) {
            continue;
          }

          int w = i == x ? 1 : i == 0 ? 2 : Math.abs(x - i) != 2 ? 3 : 4;
          curr[x][j] = curr[x][j] == 0 ? prev[i][j] + w : Math.min(curr[x][j], prev[i][j] + w);

          w = j == x ? 1 : j == 0 ? 2 : Math.abs(x - j) != 2 ? 3 : 4;
          curr[i][x] = curr[i][x] == 0 ? prev[i][j] + w : Math.min(curr[i][x], prev[i][j] + w);
          }
      }

      step.add(curr);
    }

    int min = Integer.MAX_VALUE;
    int[][] last = step.get(step.size() - 1);
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        min = last[i][j] != 0 ? Math.min(last[i][j], min) : min;
      }
    }

    System.out.println(min);
  }
}
