import java.util.Scanner;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N;
    N = sc.nextInt();

    int cnt = 0;
    int a = 1;
    int b = 1;
    int sum = 1;

    while (a <= N) {
      if (sum == N) {
        cnt++;
        a++;
        sum += a - b;
        b++;
      } else if (sum < N) {
        a++;
        sum += a;
      } else {
        sum -= b;
        b++;
      }
    }

    System.out.println(cnt);
  }
}
