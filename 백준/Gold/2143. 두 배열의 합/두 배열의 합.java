import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());
    long[] A = new long[n + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      A[i] = A[i - 1] + Integer.parseInt(st.nextToken());
    }

    int m = Integer.parseInt(br.readLine());
    long[] B = new long[m + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= m; i++) {
      B[i] = B[i - 1] + Integer.parseInt(st.nextToken());
    }

    Map<Long, Integer> mapA = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        mapA.put(A[i] - A[j], mapA.getOrDefault(A[i] - A[j], 0) + 1);
      }
    }

    Map<Long, Integer> mapB = new HashMap<>();
    for (int i = 1; i <= m; i++) {
      for (int j = 0; j < i; j++) {
        mapB.put(B[i] - B[j], mapB.getOrDefault(B[i] - B[j], 0) + 1);
      }
    }

    long cnt = 0;
    for (Long key : mapA.keySet()) {
      if (mapB.containsKey(T - key)) {
        cnt += (long) mapA.get(key) * mapB.get(T - key);
      }
    }

    System.out.println(cnt);
  }
}
