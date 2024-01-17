import java.util.Scanner;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] arr = new int[N][N];

    for (int i = N - 1; i >= 0; i--) {
      for (int j = 0; j < N; j++) {
        arr[j][i] = sc.nextInt();
      }
    }

    int[] p = new int[N];
    int max = arr[0][0];
    int maxColumn = 0;
    int cnt = N;

    while (cnt > 0) {
      // p는 각 컬럼의 포인터
      // 각 컬럼의 포인터에 해당하는 값 중 최대값 찾기
      max = arr[0][p[0]];
      for (int i = 0; i < N; i++) {
        max = Math.max(max, arr[i][p[i]]);
        maxColumn = max == arr[i][p[i]] ? i : maxColumn;
      }
      // 해당 컬럼의 포인터는 1추가 후 과정 반봅
      p[maxColumn]++;
      cnt--;
    }

    System.out.println(max);
  }
}