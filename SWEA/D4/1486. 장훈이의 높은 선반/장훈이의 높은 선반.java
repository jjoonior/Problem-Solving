import java.io.*;
import java.util.*;

public class Solution {
	static int N, B, min, sum;
	static int[] H;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			H = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}

			list = new ArrayList<>();
			min = Integer.MAX_VALUE;
            sum = 0;
            
			f(0);

			System.out.println("#" + t + " " + min);
		}
	}

	static void f(int k) {
		if (k == N) {
			if (sum >= B) {
				min = Math.min(sum-B, min);
			}
			return;
		}

		sum += H[k];
		list.add(H[k]);
		f(k + 1);
		
		sum-=H[k];
		list.remove(list.size()-1);
		f(k + 1);
	}
}
