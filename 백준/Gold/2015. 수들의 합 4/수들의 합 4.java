import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] A = new int[N + 1];
    long cnt=0;

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      A[i] += A[i-1] + Integer.parseInt(st.nextToken());
      if (A[i] == K) {
        cnt++;
      }
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    for(int i=1;i<=N;i++){
      cnt += map.getOrDefault(A[i] - K, 0);
      map.put(A[i], map.getOrDefault(A[i], 0) + 1);
    }

    System.out.println(cnt);
  }
}

