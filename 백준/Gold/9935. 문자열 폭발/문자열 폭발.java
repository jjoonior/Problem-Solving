import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());
    String a = br.readLine();
    String b = br.readLine();

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < a.length(); i++) {
      stack.push(a.charAt(i));

      if (a.charAt(i) == b.charAt(b.length() - 1) && stack.size() >= b.length()) {
        boolean flag = true;
        for (int j = 0; j < b.length(); j++) {
          if (stack.get(stack.size() - 1 - j) != b.charAt(b.length() - 1 - j)) {
            flag = false;
            break;
          }
        }
        if (flag) {
          for (int j = 0; j < b.length(); j++) {
            stack.pop();
          }
        }
      }
    }

    if (stack.isEmpty()) {
      System.out.println("FRULA");
    } else {
      StringBuilder sb = new StringBuilder();
      for (Character c : stack) {
        sb.append(c);
      }
      System.out.println(sb);
    }
  }
}
