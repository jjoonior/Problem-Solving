import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int d = sc.nextInt();
    int k = sc.nextInt();
    int c = sc.nextInt();

    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }
    Map<Integer, Integer> map = new HashMap<>();
    map.put(c, 1);

    for (int i = N - k; i < N; i++) {
      map.put(arr[i], map.containsKey(arr[i]) ? map.get(arr[i]) + 1 : 1);
    }

    int max = map.size();
    for (int i = 0; i < N; i++) {
      map.put(arr[i], map.containsKey(arr[i]) ? map.get(arr[i]) + 1 : 1);

      int idx = i - k >= 0 ? i - k : i - k + N;
      if (map.get(arr[idx]) == 1) {
        map.remove(arr[idx]);
      } else {
        map.put(arr[idx], map.get(arr[idx]) - 1);
      }

      max = Math.max(max, map.size());
    }

    System.out.println(max);
  }
}