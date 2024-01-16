import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }

    Arrays.sort(A);

    int cnt = 0;
    int a = 0;
    int b = N - 1;

    while (a < b) {
      if (A[a] + A[b] == M) {
        cnt++;
        a++;
        b--;
      } else if (A[a] + A[b] < M) {
        a++;
      } else {
        b--;
      }
    }

    System.out.println(cnt);
  }
}