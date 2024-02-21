import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      pq.add(Integer.parseInt(br.readLine()));
    }

    int sum = 0;

    while (pq.size() > 1) {
      int s = pq.poll() + pq.poll();
      sum += s;
      pq.add(s);
    }
    
    System.out.println(sum);
  }
}