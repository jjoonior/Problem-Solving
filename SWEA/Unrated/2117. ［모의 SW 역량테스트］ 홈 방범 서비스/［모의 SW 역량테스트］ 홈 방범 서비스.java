import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, max;
	static int[][] map;
	static List<int[]> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			list = new ArrayList<>();
			max = 0;
            
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						list.add(new int[] { i, j });
				}
			}

			for (int k = 1; k <= 2*N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						int cnt = 0;
						for (int[] p : list) {
							int len = Math.abs(i - p[0]) + Math.abs(j - p[1]);
							if (len < k) {
								cnt++;
							}
						}
						if (k * k + (k - 1) * (k - 1) <= M * cnt) {
							max = Math.max(cnt, max);
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
}
