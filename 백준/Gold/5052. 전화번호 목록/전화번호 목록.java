import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      List<String> list = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        list.add(br.readLine());
      }
      Collections.sort(list);

      boolean flag = false;
      for (int j = 0; j < n-1; j++) {
        if (list.get(j + 1).startsWith(list.get(j))) {
          flag = true;
          System.out.println("NO");
          break;
        }
      }
      if (!flag) {
        System.out.println("YES");
      }
    }
  }
}
