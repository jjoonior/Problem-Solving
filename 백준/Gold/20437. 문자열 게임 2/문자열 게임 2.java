import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      String str = br.readLine();
      int K = Integer.parseInt(br.readLine());
      Map<Character, ArrayList<Integer>> map = new HashMap<>();

      for (int j = 0; j < str.length(); j++) {
        if (map.containsKey(str.charAt(j))) {
          map.get(str.charAt(j)).add(j);
        } else {
          ArrayList<Integer> arr = new ArrayList<>();
          arr.add(j);
          map.put(str.charAt(j), arr);
        }
      }

      int min = Integer.MAX_VALUE;
      int max = -1;
      for (Character key : map.keySet()) {
        ArrayList<Integer> arr = map.get(key);
        if (arr.size() >= K) {

          for (int j = 0; j <= arr.size() - K; j++) {
            min = Math.min(min, arr.get(j + K - 1) - arr.get(j) + 1);
            max = Math.max(max, arr.get(j + K - 1) - arr.get(j) + 1);
          }
        }
      }

      if (max < 0) {
        System.out.println(-1);
      } else {
        System.out.println(min + " " + max);
      }
    }
  }
}
