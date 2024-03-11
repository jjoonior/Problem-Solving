import java.io.*;
import java.util.*;

public class Main {
  static int N, M, d;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static boolean flag;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      graph[i] = new ArrayList<>();
    }


    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u].add(v);
      graph[v].add(u);
    }


    flag = false;

    for (int i = 0; i < N; i++) {
      visited = new boolean[N];
      visited[i] = true;
      d = 1;
      dfs(i);
    }

    System.out.println(flag ? 1 : 0);
  }

  static void dfs(int k){
    if (flag) {
      return;
    }

    ArrayList<Integer> list = graph[k];
    for (int x : list) {
      if (!visited[x]) {
        visited[x] = true;
        d++;
        if (d >= 5 || flag) {
          flag = true;
          return;
        }
        dfs(x);
        d--;
        visited[x] = false;
      }
    }
  }
}
