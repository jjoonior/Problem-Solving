import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(in.readLine());

    int[] A = new int[N];
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
      map.put(A[i], 0);
    }

    int max = 1;
    int a = 0;
    int b = 0;
    map.put(A[0], 1);

    while (a < N) {
      if (map.get(A[a]) > K) {
        map.put(A[b], map.get(A[b]) - 1);
        b++;
        continue;
      }

      max = Math.max(max, a - b + 1);
      a++;
      if (a < N) {
        map.put(A[a], map.get(A[a]) + 1);
      }
    }

    System.out.println(max);
  }
}