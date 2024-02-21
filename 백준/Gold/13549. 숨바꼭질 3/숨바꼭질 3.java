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

    while (!q.isEmpty()) {
      int x = q.poll();

      if (x * 2 <= 100000 && visited[x * 2] == 0) {
        q.offer(x * 2);
        visited[x * 2] = visited[x];
      }
      
      if (x - 1 >= 0 && visited[x - 1] == 0) {
        q.offer(x - 1);
        visited[x - 1] = visited[x] + 1;
      }

      if (x + 1 <= 100000 && visited[x + 1] == 0 ) {
        q.offer(x + 1);
        visited[x + 1] = visited[x] + 1;
      }
    }

    System.out.println(visited[K] - 1);
  }
}
