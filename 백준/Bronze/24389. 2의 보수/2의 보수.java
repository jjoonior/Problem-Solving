import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(br.readLine());
    String b = Integer.toBinaryString(a ^ (~a + 1));

    int cnt = 0;
    for (int i = 0; i < b.length(); i++) {
      if (b.charAt(i) == '1') {
        cnt++;
      }
    }

    System.out.println(cnt);
  }
}
