import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(br.readLine());
    List<Integer> f = new ArrayList<>();
    f.add(0);
    f.add(1);
    f.add(2);
    while (true){
      if (f.get(f.size() - 1) + f.get(f.size() - 2) <= 1000000000) {
        f.add(f.get(f.size() - 1) + f.get(f.size() - 2));
      } else {
        break;
      }
    }

    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < N; i++) {
      int n = Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();
      int idx = f.size() - 1;
      while (n > 0) {
        if (n >= f.get(idx)) {
          sb.insert(0, f.get(idx) + " ");
          n -= f.get(idx);
        }
        idx--;
      }
      ans.append(sb.append("\n"));
    }
    
    System.out.println(ans);
  }
}
