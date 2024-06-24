import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    String[] arrA = new String[N];
    String[] arrB = new String[M];

    for (int i = 0; i < N; i++) {
      arrA[i] = br.readLine();
    }
    for (int i = 0; i < M; i++) {
      arrB[i] = br.readLine();
    }

    Arrays.sort(arrA);
    Arrays.sort(arrB);

    int cnt = 0;

    int idxA = 0;
    int idxB = 0;

    while (idxA < N && idxB < M) {
      if (arrA[idxA].compareTo(arrB[idxB]) < 0) {
        idxA++;
        continue;
      }
      if (arrA[idxA].startsWith(arrB[idxB])) {
        cnt++;
      }
      idxB++;
    }

    System.out.println(cnt);
  }
}