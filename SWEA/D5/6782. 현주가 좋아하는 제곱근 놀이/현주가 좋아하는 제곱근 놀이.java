import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long N = Long.parseLong(st.nextToken());
      long cnt = 0;

      while (N != 2) {
        if (Math.sqrt(N) % 1 == 0) {
          cnt++;
          N = (int) Math.sqrt(N);
        } else {
          long a = (long) Math.pow(((int) Math.floor(Math.sqrt(N))) + 1, 2);
          cnt += a - N;
          N = a;
        }
      }

      sb.append("#").append(t).append(" ").append(cnt).append("\n");
    }
    System.out.println(sb);
  }
}
