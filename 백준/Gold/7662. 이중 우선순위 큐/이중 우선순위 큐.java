import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
      HashMap<Integer, Integer> cntMap = new HashMap<>();

      int k = Integer.parseInt(br.readLine());

      for (int j = 0; j < k; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String x = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        if (x.equals("I")) {
          minHeap.add(n);
          maxHeap.add(n);
          cntMap.put(n, cntMap.getOrDefault(n, 0) + 1);
        } else if (x.equals("D")) {
          if (cntMap.isEmpty()) {
            continue;
          }
          int key = n == 1 ? maxHeap.poll() : minHeap.poll();

          while (!cntMap.containsKey(key)) {
            key = n == 1 ? maxHeap.poll() : minHeap.poll();
          }

          if (cntMap.get(key) == 1) {
            cntMap.remove(key);
          } else {
            cntMap.put(key, cntMap.get(key) - 1);
          }
        }
      }
      if (cntMap.isEmpty()) {
        System.out.println("EMPTY");
      } else {
        System.out.println(Collections.max(cntMap.keySet()) + " " + Collections.min(cntMap.keySet()));
      }
    }
  }
}