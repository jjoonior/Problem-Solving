import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = -1;
			for (int i = N + 1; i >= 4; i--) {
				boolean flag = false;
				for (int j = 2; j <= i - 2; j++) {
					if (f(j, i - j)) {
						max = i * 2 - 4;
						flag = true;
						break;
					}
				}
				if (flag)
					break;
			}

			System.out.println("#" + t + " " + max);
		}
	}

	static boolean f(int a, int b) {
		for (int i = 0; i <= N - (a + b - 1); i++) {
			for (int j = a - 1; j <= N - b; j++) {

				int y = i;
				int x = j;
				Set<Integer> set = new HashSet<>();
				boolean flag = false;

				int[] dy = { 1, 1, -1, -1 };
				int[] dx = { 1, -1, -1, 1 };
				for (int d = 0; d < 4; d++) {
					int l = d % 2 == 0 ? b - 1 : a - 1;

					for (int k = 0; k < l; k++) {
						y += dy[d];
						x += dx[d];
						if (set.contains(map[y][x])) {
							flag = true;
							break;
						}
						set.add(map[y][x]);
					}
					if (flag)
						break;
				}
				if (!flag) {
					return true;
				}
			}
		}

		return false;
	}
}
