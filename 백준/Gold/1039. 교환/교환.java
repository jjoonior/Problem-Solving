import java.io.*;
import java.util.*;

public class Main {
  static boolean flag = false;
  static char[] chars;
  static String ans = "";

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    String N = st.nextToken();
    int K = Integer.parseInt(st.nextToken());

    Set<Character> set = new HashSet<>();

    chars = new char[N.length()];
    int zeroCont = 0;
    for (int i = 0; i < N.length(); i++) {
      chars[i] = N.charAt(i);
      if (set.contains(chars[i])) {
        flag = true;
      } else {
        set.add(chars[i]);
      }
      zeroCont += chars[i] == '0' ? 1 : 0;
    }

    if (N.length() == 1 || (zeroCont == 1 && N.length() == 2)) {
      System.out.println(-1);
      return;
    }

    bfs(chars, K, 0);

    System.out.println(ans);
  }

  static void bfs(char[] chars, int k, int idx) {
    if (k == 0 || idx == chars.length - 1) {
      if (k > 0) {
        if (!flag && k % 2 == 1) {
          char tmp = chars[chars.length - 1];
          chars[chars.length - 1] = chars[chars.length - 2];
          chars[chars.length - 2] = tmp;
        }
      }

      String str = new String(chars);
      ans = str.compareTo(ans)> 0 ? str : ans;
      return;
    }

    List<Integer> maxList = new ArrayList<>();
    maxList.add(idx + 1);

    for (int i = idx + 1; i < chars.length; i++) {
      if (chars[i] > chars[maxList.get(0)]) {
        maxList.clear();
        maxList.add(i);
      } else if (chars[i] == chars[maxList.get(0)]) {
        if (!maxList.contains(i)) {
          maxList.add(i);
        }
      }
    }

    for (int i = 0; i < maxList.size(); i++) {
      int maxIdx = maxList.get(i);
      char[] newChars = chars.clone();

      if (newChars[maxIdx] > newChars[idx]) {
        char tmp = newChars[maxIdx];
        newChars[maxIdx] = newChars[idx];
        newChars[idx] = tmp;
        bfs(newChars, k - 1, idx + 1);
      } else {
        bfs(newChars, k, idx + 1);
      }
    }
  }
}
