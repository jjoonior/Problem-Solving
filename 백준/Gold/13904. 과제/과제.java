import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    Map<Integer, List<Integer>> map = new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int day = 0;
    int sum = 0;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      List<Integer> list = map.get(d);
      if (list == null) {
        list = new ArrayList<>();
        map.put(d, list);
      }
      list.add(w);

      day = Math.max(d, day);
    }

    for (int i = day; i >= 1; i--) {
      List<Integer> list = map.get(i);
      if (list != null) {
        pq.addAll(list);
      }

      if (!pq.isEmpty()) {
        sum += pq.poll();
      }
    }

    System.out.println(sum);
  }
}
