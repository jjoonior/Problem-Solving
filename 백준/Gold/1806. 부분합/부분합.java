import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());

    int[] arr = new int[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
    }

    int min = N + 1;
    int a = 1;
    int b = 1;
    while (a <= N) {
      if (arr[a] - arr[b - 1] >= S) {
        if (a == b) {
          System.out.println(1);
          return;
        }
        min = Math.min(min, a - b + 1);
        b++;
      } else {
        a++;
      }
    }
    System.out.println(min == N + 1 ? 0 : min);
  }
}