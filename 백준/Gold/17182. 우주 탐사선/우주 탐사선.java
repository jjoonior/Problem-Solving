import java.io.*;
import java.util.*;

public class Main {
  static Set<Integer> set = new HashSet<>();
  static int N, K, min;
  static int[][] map;
  static List<Integer>[][] list;
  static List<Integer> path;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new int[N][N];
    list = new List[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        list[i][j] = new ArrayList<>();
      }
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int k = 0; k < N; k++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (map[i][j] > map[i][k] + map[k][j]) {
            map[i][j] = map[i][k] + map[k][j];
            list[i][j].clear();
            list[i][j].addAll(list[i][k]);
            list[i][j].add(k);
            list[i][j].addAll(list[k][j]);
          }
        }
      }
    }

    path = new ArrayList<>();
    path.add(K);
    min =20001;
    f(K, 0);

    System.out.println(min);
  }

  static void f(int k, int sum) {
    boolean flag = true;
    for (int i = 0; i < N; i++) {
      if (!path.contains(i)) {
        flag = false;
        break;
      }
    }

    if (flag) {
      min = Math.min(min, sum);
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!path.contains(i)) {
        path.addAll(list[k][i]);
        path.add(i);
        f(i, sum + map[k][i]);
        for (int j = 0; j <= list[k][i].size(); j++) {
          path.remove(path.size() - 1);
        }
      }
    }
  }
}