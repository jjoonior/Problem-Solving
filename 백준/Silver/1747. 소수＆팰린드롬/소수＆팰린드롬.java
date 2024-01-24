import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  static int N;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    boolean[] arr = new boolean[2000000];
    arr[1] = true;

    for (int i = 2; i < 2000000; i++) {
      if (!arr[i]) {
        for (int j = i * 2; j < 2000000; ) {
          arr[j] = true;
          j += i;
        }
      }
    }

    for (int i = N; i < 2000000; i++) {
      if (!arr[i]) {        
        boolean x = true;
        String str = Integer.toString(i);
        int len = str.length();
        for (int j = 0; j < len / 2; j++) {
          if (str.charAt(j) != str.charAt(len - j - 1)) {
            x = false;
          }
        }
        if (x) {
          System.out.println(i);
          return;
        }
      }
    }
  }

}

