import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(br.readLine());
    List<String> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      list.add(br.readLine());
    }

    Collections.sort(list);

    int cnt = 1;
    for (int i = 0; i < list.size() - 1; i++) {
      if (list.get(i + 1).startsWith(list.get(i))) {

        continue;
      }
      cnt++;
    }

    System.out.println(cnt);
  }
}
