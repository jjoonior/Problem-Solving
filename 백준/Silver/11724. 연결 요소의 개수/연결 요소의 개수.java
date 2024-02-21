import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    boolean[] visited = new boolean[N + 1];
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    for (int i = 1; i <= N; i++) {
      map.put(i, new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      map.get(u).add(v);
      map.get(v).add(u);
    }

    int cnt = 0;
    for (int i = 1; i <= N; i++) {
      if (visited[i]) {
        continue;
      }

      cnt++;
      Queue<Integer> q = new LinkedList<>();
      q.offer(i);

      while (!q.isEmpty()) {
        int idx = q.poll();

        ArrayList<Integer> list = map.get(idx);
        for (Integer x : list) {
          if (!visited[x]) {
            visited[x] = true;
            q.offer(x);
          }
        }
      }
    }
    System.out.println(cnt);
  }
}