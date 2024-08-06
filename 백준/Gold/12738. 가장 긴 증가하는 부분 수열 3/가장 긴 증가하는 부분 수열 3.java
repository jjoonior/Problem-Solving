import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> LIS = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int e = Integer.parseInt(st.nextToken());

			if (LIS.isEmpty() || e > LIS.get(LIS.size() - 1)) {
				LIS.add(e);
			} else {
				search(0, LIS.size() - 1, e);
			}
		}

		System.out.println(LIS.size());
	}

	static void search(int s, int e, int k) {
        if (s == e) {
          if (k < LIS.get(s)) {
            LIS.set(s, k);
          }
          return;
        }
		
		int m = (s + e) / 2;

		if (k > LIS.get(m)) {
			search(m + 1, e, k);
		} else {
			search(s, m, k);
		}
	}
}
