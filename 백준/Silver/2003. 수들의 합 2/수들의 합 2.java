import java.util.Scanner;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    int[] A = new int[N + 1];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }

    int cnt = 0;
    int sum = A[0];
    int a = 0;
    int b = 0;

    while (a < N) {
      if (sum == M) {
        cnt++;
        a++;
        sum += A[a] - A[b];
        b++;
      } else if (sum < M) {
        a++;
        sum += A[a];
      } else {
        sum -= A[b];
        b++;
      }
    }

    System.out.println(cnt);
  }
}