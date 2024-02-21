import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] visited = new int[100001];
    Queue<Integer> q = new LinkedList<>();
    q.offer(N);
    visited[N] = 1;

    int cnt = 0;
    while (!q.isEmpty()) {
      int x = q.poll();

      if (x == K) {
        cnt++;
      }
      if (x - 1 >= 0 && (visited[x - 1] == 0 || visited[x] + 1 == visited[x - 1])) {
        q.offer(x - 1);
        visited[x - 1] = visited[x] + 1;
      }

      if (x + 1 <= 100000 && (visited[x + 1] == 0 || visited[x] + 1 == visited[x + 1])) {
        q.offer(x + 1);
        visited[x + 1] = visited[x] + 1;
      }

      if (x * 2 <= 100000 && (visited[x * 2] == 0 || visited[x] + 1 == visited[x * 2])) {
        q.offer(x * 2);
        visited[x * 2] = visited[x] + 1;
      }
    }

    System.out.println(visited[K] - 1);
    System.out.println(cnt);
  }
}
