import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  static int N;
  static int M;
  static boolean[] used;
  static Stack<Integer> stack;
  static StringBuilder sb;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = N;
    used = new boolean[N + 1];
    stack = new Stack<>();

    f(M);
  }

  static void f(int M) {
    if (M == 0) {
      sb = new StringBuilder();
      sb.append(stack.elementAt(0));
      for (int i = 1; i < N; i++) {
        sb.append(" ").append(stack.elementAt(i));
      }
      System.out.println(sb);
    }

    for (int i = 1; i <= N; i++) {
      if (!used[i]) {
        stack.push(i);
        used[i] = true;
        f(M - 1);
        used[i] = false;
        stack.pop();
      }
    }
  }
}

