import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					char c = str.charAt(j);

					if (c == '*') {
						map[i][j] = -1;

						for (int k = -1; k <= 1; k++) {
							if (i + k < 0 || i + k >= N)
								continue;

							for (int l = -1; l <= 1; l++) {
								if (j + l < 0 || j + l >= N)
									continue;

								if (map[i + k][j + l] != -1) {
									map[i + k][j + l]++;
								}
							}
						}
					}
				}
			}

			int cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] == 0) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] != -1) {
						cnt++;
					}
				}
			}

			System.out.println("#" + t + " " + cnt);
		}
	}

	static void bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { y, x });
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int[] node = q.poll();

			for (int i = -1; i <= 1; i++) {
				if (node[0] + i < 0 || node[0] + i >= N)
					continue;

				for (int j = -1; j <= 1; j++) {
					if (node[1] + j < 0 || node[1] + j >= N)
						continue;

					if (!visited[node[0] + i][node[1] + j]) {
						visited[node[0] + i][node[1] + j] = true;
						if (map[node[0] + i][node[1] + j] == 0) {
							q.offer(new int[] { node[0] + i, node[1] + j });
						}
					}
				}
			}
		}
	}
}
