import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());

    String input = br.readLine();

    SortedMap<Character, Integer> map = new TreeMap<>();
    int mc = 0;
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      int cnt = map.getOrDefault(c, 0) + 1;
      map.put(c, cnt);
      mc += cnt % 2 == 1 ? 1 : -1;
    }

    if (mc > 1) {
      System.out.println("I'm Sorry Hansoo");
      return;
    }

    StringBuilder h = new StringBuilder();
    StringBuilder t = new StringBuilder();
    char mid = ' ';

    for (char key : map.keySet()) {
      int cnt = map.get(key);
      if (cnt % 2 == 1) {
        mid = key;
      }

      for (int i = 0; i < cnt / 2; i++) {
        h.append(key);
        t.insert(0, key);
      }
    }

    if (mc == 1) {
      h.append(mid);
    }

    System.out.println(h.append(t));
  }
}