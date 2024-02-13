import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      int a = 0;
      int b = N - 1;

      while (a < b) {
        if (a == i) {
          a++;
          continue;
        }
        if (b == i) {
          b--;
          continue;
        }

        int sum = arr[a] + arr[b];

        if (sum == arr[i]) {
          cnt++;
          break;
        }

        if (sum < arr[i]) {
          a++;
        }

        if (sum > arr[i]) {
          b--;
        }
      }
    }
    System.out.println(cnt);
  }
}
