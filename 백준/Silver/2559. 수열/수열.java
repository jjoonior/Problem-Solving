import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();

    int[] A = new int[N + 1];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }

    int max = 0;
    for (int i = 0; i < K; i++) {
      max += A[i];
    }
    int sum = max;
    int a = 1;
    int b = K;

    while (b < N) {
      sum += A[b++] - A[a++ - 1];
      max = Math.max(max, sum);
    }

    System.out.println(max);
  }
}