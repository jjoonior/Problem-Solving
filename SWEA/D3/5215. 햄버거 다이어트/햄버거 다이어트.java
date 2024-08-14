import java.io.*;
import java.util.*;
class Solution
{
	static int N, L, max;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N+1][2];
			max = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			f(0, 0, 0);

			System.out.println("#" + t + " " + max);
		}
	}

	static void f(int n, int sumT, int sumK) {
		if (n == N+1) {
			if (sumK <= L) {
				max = Math.max(max, sumT);
			}
			return;
		}

		for (int i = n; i <= N; i++) {
			f(i + 1, sumT + arr[i][0], sumK + arr[i][1]);
		}
	}
}