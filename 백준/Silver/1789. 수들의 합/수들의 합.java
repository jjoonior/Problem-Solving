import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long S = Long.parseLong(br.readLine());
    for (long i = 1; i < 100000; i++) {
      if ((i + 1) * i / 2 > S) {
        System.out.println(i-1);
        break;
      }
    }
  }
}