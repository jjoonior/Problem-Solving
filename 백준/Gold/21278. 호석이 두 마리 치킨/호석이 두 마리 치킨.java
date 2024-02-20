import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;
  static Map<Integer, ArrayList<Integer>> map;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new HashMap<>();
    for (int i = 0; i < N; i++) {
      map.put(i, new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken()) - 1;
      int e = Integer.parseInt(st.nextToken()) - 1;
      map.get(s).add(e);
      map.get(e).add(s);
    }

    int[] answer = new int[2];
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        int[] visited = new int[N];

        Queue<Integer> q = new LinkedList<>();
        visited[i] = 1;
        visited[j] = 1;
        q.offer(i);
        q.offer(j);

        while (!q.isEmpty()) {
          int s = q.poll();

          for (Integer e : map.get(s)) {
            if (visited[e] == 0) {
              visited[e] = visited[s] + 1;
              q.offer(e);
            }
          }
        }

        int sum = 0;
        for (int k = 0; k < N; k++) {
          if (k == i || k == j) {
            continue;
          }
          sum += visited[k] - 1;
        }

        if (sum < min) {
          answer[0] = i;
          answer[1] = j;
          min = sum;
        }
      }
    }
    System.out.println((answer[0] + 1) + " " + (answer[1] + 1) + " " + min * 2);
  }
}
