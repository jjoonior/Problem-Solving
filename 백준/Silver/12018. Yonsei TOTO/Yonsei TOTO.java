import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int p = Integer.parseInt(st.nextToken());
      int l = Integer.parseInt(st.nextToken());

      int[] arr = new int[p];
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < p; j++) {
        arr[j] = Integer.parseInt(st.nextToken());
      }

      if (p < l) {
        pq.offer(1);
        continue;
      }

      Arrays.sort(arr);
      pq.offer(arr[p - l]);
    }

    int cnt = 0;
    while (!pq.isEmpty()) {
      int p = pq.poll();
      if (m >= p) {
        m -= p;
        cnt++;
      } else {
        break;
      }
    }

    System.out.println(cnt);
  }
}
