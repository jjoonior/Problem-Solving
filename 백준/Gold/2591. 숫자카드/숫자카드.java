import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < input.length(); i++) {
      if (i < input.length() - 1 && input.charAt(i + 1) == '0') {
        list.add(Integer.parseInt(input.substring(i, i + 2)));
        i++;
      } else {
        list.add(Integer.parseInt(input.substring(i, i + 1)));
      }
    }

    int[] dp = new int[list.size()];

    dp[0] = 1;
    if (list.get(1) > 9) {
      dp[1] = 1;
    }else {
      if (list.get(0) > 9) {
        dp[1] = 1;
      }else {
        if (list.get(0) * 10 + list.get(1) > 34) {
          dp[1] = 1;
        } else {
          dp[1] = 2;
        }
      }
    }

    for (int i = 2; i < list.size(); i++) {
      if (list.get((i)) > 9) {
        dp[i] = dp[i - 1];
      } else {
        if (list.get(i - 1) > 9) {
          dp[i] = dp[i - 1];
        }else {
          if (list.get(i - 1) * 10 + list.get(i) > 34) {
            dp[i] = dp[i - 1];
          } else {
            dp[i] = dp[i - 2] + dp[i - 1];
          }
        }
      }
    }

    System.out.println(dp[list.size() - 1]);
  }
}
