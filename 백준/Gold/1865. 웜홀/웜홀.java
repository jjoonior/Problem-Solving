import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;
  static int W;
  static ArrayList<Edge> list;

  static boolean BellmanFord() {
    int[] d = new int[N + 1];
    boolean flag = false;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < list.size(); j++) {
        Edge edge = list.get(j);

        if (d[edge.w] > d[edge.v] + edge.cost) {
          d[edge.w] = d[edge.v] + edge.cost;
          flag = true;

          if (i == N - 1) {
            return true;
          }
        }
      }

      if (!flag) {
        break;
      }
    }

    return false;
  }

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int TC = Integer.parseInt(br.readLine());

    for (int i = 0; i < TC; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      W = Integer.parseInt(st.nextToken());

      list = new ArrayList<>();

      for (int j = 0; j < M + W; j++) {
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());

        if (j < M) {
          list.add(new Edge(v, w, cost));
          list.add(new Edge(w, v, cost));
        } else {
          list.add(new Edge(v, w, -cost));
        }
      }
      System.out.println(BellmanFord() ? "YES" : "NO");
    }
  }
}

class Edge {
  int v;
  int w;
  int cost;

  Edge(int v, int w, int cost) {
    this.v = v;
    this.w = w;
    this.cost = cost;
  }
}