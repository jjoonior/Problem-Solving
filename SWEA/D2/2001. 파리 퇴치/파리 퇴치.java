import java.io.*;
import java.util.*;
class Solution
{
	static int N, M, max;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N + 1][N + 1];
			max = 0;

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					int e = Integer.parseInt(st.nextToken());
					arr[i][j] = e + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
				}
			}

			for (int i = M; i <= N; i++) {
				for (int j = M; j <= N; j++) {
					int sum = arr[i][j] - arr[i - M][j] - arr[i][j - M] + arr[i - M][j - M];
					max = Math.max(max, sum);
				}
			}

			System.out.println("#" + t + " " + max);
		}
	}
}