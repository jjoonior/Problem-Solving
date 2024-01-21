import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    int N = Integer.parseInt(br.readLine());
    long[] A = new long[N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      A[i] += A[i - 1] + Integer.parseInt(st.nextToken());
    }

    int M = Integer.parseInt(br.readLine());
    long[] B = new long[M + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= M; i++) {
      B[i] += B[i - 1] + Integer.parseInt(st.nextToken());
    }

    Map<Long, Integer> mapA = new HashMap<>();
    for (int i = 1; i <= N; i++) {
      for (int j = 0; j < i; j++) {
        mapA.put(A[i] - A[j], mapA.getOrDefault(A[i] - A[j], 0) + 1);
      }
    }

    Map<Long, Integer> mapB = new HashMap<>();
    for (int i = 1; i <= M; i++) {
      for (int j = 0; j < i; j++) {
        mapB.put(B[i] - B[j], mapB.getOrDefault(B[i] - B[j], 0) + 1);
      }
    }

    long cnt = 0;
    for (long key : mapA.keySet()) {
      if (mapB.containsKey(T - key)) {
        int a = mapA.get(key);
        int b = mapB.get(T - key);
        cnt += (long) a * b;
      }
    }

    System.out.println(cnt);
  }
}

