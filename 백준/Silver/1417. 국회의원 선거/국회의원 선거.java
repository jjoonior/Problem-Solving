import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(br.readLine());
    int x = Integer.parseInt(br.readLine());
    int cnt = 0;

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 1; i < N; i++) {
      pq.offer(Integer.parseInt(br.readLine()));
    }

    while (!pq.isEmpty()) {
      int max = pq.poll();
      if (max < x) {
        break;
      }

      pq.offer(--max);
      x++;
      cnt++;
    }

    System.out.println(cnt);
  }
}