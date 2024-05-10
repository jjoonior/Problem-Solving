import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    List<Node> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      list.add(new Node(x, y));
    }

    Collections.sort(list);

    int[] dp = new int[N];
    for (int i = 0; i < N; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (list.get(j).w < list.get(i).w) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
        }
      }
    }

    int max = 0;
    for (int i = 0; i < N; i++) {
      max = Math.max(max, dp[i] + 1);
    }

    System.out.println(N - max);
  }
}

class Node implements Comparable<Node> {
  int v;
  int w;

  Node(int v, int w) {
    this.v = v;
    this.w = w;
  }

  @Override
  public int compareTo(Node o) {
    return this.v - o.v;
  }
}
