import java.io.*;
import java.util.*;

public class Main {
  static Deque<Character> deque;
  static ArrayList<String> list;
  static int N;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      deque = new ArrayDeque<>();
      list = new ArrayList<>();
      N = Integer.parseInt(br.readLine());
      deque.add('1');
      f(2);
      Collections.sort(list);
      for (String str : list) {
        System.out.println(str);
      }
      System.out.println();
    }
  }

  static void f(int k) {
    if (k == N + 1) {
      StringBuilder sb = new StringBuilder();
      int sum = 0;
      int currentNum = 0;
      char operator = '+';

      for (char c : deque) {
        sb.append(c);

        if (c == ' ') {
          continue;
        }

        if (Character.isDigit(c)) {
          currentNum = currentNum * 10 + (c - '0');
        } else {
          if (operator == '+') {
            sum += currentNum;
          } else {
            sum -= currentNum;
          }

          operator = c;
          currentNum = 0;
        }
      }
      if (operator == '+') {
        sum += currentNum;
      } else {
        sum -= currentNum;
      }

      if (sum == 0) {
        list.add(sb.toString());
      }
      return;
    }

    deque.add('+');
    deque.add((char) (k + '0'));
    f(k + 1);
    deque.removeLast();
    deque.removeLast();

    deque.add('-');
    deque.add((char) (k + '0'));
    f(k + 1);
    deque.removeLast();
    deque.removeLast();

    deque.add(' ');
    deque.add((char) (k + '0'));
    f(k + 1);
    deque.removeLast();
    deque.removeLast();
  }
}