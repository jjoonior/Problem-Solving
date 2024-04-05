import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    boolean[] visited = new boolean[n + 1];
    int[] p = new int[n + 1];
    Map<Integer,List<Integer>> map = new HashMap<>();

    for (int i = 1; i <= n; i++) {
      map.put(i, new ArrayList<>());
    }

    for (int i = 0; i < n-1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      map.get(u).add(v);
      map.get(v).add(u);
    }

    Queue<Integer> q = new LinkedList<>();
    q.offer(1);
    while (!q.isEmpty()) {
      int x = q.poll();

      for (int k: map.get(x)){
        if (!visited[k]) {
          p[k] = x;
          visited[k] = true;
          q.offer(k);
        }
      }
    }

    for (int i = 2; i <= n; i++) {
      System.out.println(p[i]);
    }
  }
}
