import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[N];
    int[] B = new int[M];

    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    for (int i = 0; i < M; i++) {
      B[i] = sc.nextInt();
    }

    Arrays.sort(A);
    Arrays.sort(B);

    StringBuilder sb = new StringBuilder();
    int a = 0;
    int b = 0;

    while (a + b < N + M) {
      if (a == N) {
        sb.append(B[b]+ " ");
        b++;
        continue;
      }
      if (b == M) {
        sb.append(A[a] + " ");
        a++;
        continue;
      }

      if (A[a] < B[b]) {
        sb.append(A[a] + " ");
        a++;
      } else {
        sb.append(B[b]+ " ");
        b++;
      }
    }
    System.out.println(sb);
  }
}
