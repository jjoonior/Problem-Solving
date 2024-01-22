import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringBuilder answer = new StringBuilder();
    String s;
//    StringTokenizer st = new StringTokenizer(br.readLine());
    while ((s = br.readLine()) != null) {
      int N = Integer.parseInt(s);
      int cnt = 1;
      long one = 1;

      while (one % N != 0) {
        one = (one * 10 + 1) % N;
        cnt++;
      }
      System.out.println(cnt);
//      answer.append(cnt).append("\n");
    }


//    System.out.println(answer);
  }
}

