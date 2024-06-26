import java.io.*;
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

    int sum = 0;
    for (int i = 0; i < N; i++) {
      if (sum + 1 < arr[i]) {
        break;
      }
      sum += arr[i];
    }
    
    System.out.println(sum + 1);
  }
}
