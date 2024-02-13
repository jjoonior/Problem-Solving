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

    int a = 0;
    int b = N - 1;

    Arrays.sort(arr);

    int min = Math.abs(arr[a] + arr[b]);
    int minA = a;
    int minB = b;


    while (a < b) {
      int x = arr[a] + arr[b];
      if (x == 0) {
        System.out.println(arr[a] + " " + arr[b]);
        return;
      }

      if (min > Math.abs(x)) {
        min = Math.abs(x);
        minA = a;
        minB = b;
      }
      if (x < 0) {
        a++;
      } else {
        b--;
      }
    }
    System.out.println(arr[minA] + " " + arr[minB]);
  }
}
