import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    ArrayList<Integer> arrayList = new ArrayList<>();

    arrayList.add(arr[0]);

    for (int i = 1; i < N; i++) {
      if (arrayList.get(arrayList.size() - 1) < arr[i]) {
        arrayList.add(arr[i]);
      } else {
        int l = 0;
        int r = arrayList.size() - 1;
        while (l < r) {
          int m = (l + r) / 2;

          if (arrayList.get(m) > arr[i]) {
            r = m;
          } else if (arrayList.get(m) == arr[i]) {
            l = m;
            break;
          } else {
            l = m + 1;
          }
        }

        arrayList.set(l, arr[i]);
      }
    }
    System.out.println(arrayList.size());
  }
}