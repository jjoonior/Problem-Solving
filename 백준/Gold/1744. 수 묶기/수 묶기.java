import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    PriorityQueue<Integer> minQ = new PriorityQueue<>();
    PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < N; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x <= 0) {
        minQ.add(x);
      } else {
        maxQ.add(x);
      }
    }

    int sum = 0;

    while (maxQ.size() > 0) {
      if (maxQ.size() >= 2) {
        int a = maxQ.poll();
        int b = maxQ.poll();
        if (a == 1 || b == 1) {
          sum += a + b;
        } else {
          sum += a * b;
        }
      } else {
        sum += maxQ.poll();
      }
    }

    while (minQ.size() > 0) {
      if (minQ.size() >= 2) {
        sum += minQ.poll() * minQ.poll();
      } else {
        sum += minQ.poll();
      }
    }

    System.out.println(sum);
  }
}