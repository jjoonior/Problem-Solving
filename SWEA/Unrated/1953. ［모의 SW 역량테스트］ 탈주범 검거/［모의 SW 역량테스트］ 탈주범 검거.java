import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean[][] visited = new boolean[N][M];
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] { R, C, 1 });
			visited[R][C] = true;

			int cnt = 0;
			while (!q.isEmpty()) {
				int[] e = q.poll();

				if (e[2] <= L)
					cnt++;

				int[] dy = { 1, -1, 0, 0 };
				int[] dx = { 0, 0, 1, -1 };

				int[] d = {};

				switch (map[e[0]][e[1]]) {
				case 1:
					d = new int[] { 0, 1, 2, 3 };
					break;
				case 2:
					d = new int[] { 0, 1 };
					break;
				case 3:
					d = new int[] { 2, 3 };
					break;
				case 4:
					d = new int[] { 1, 2 };
					break;
				case 5:
					d = new int[] { 0, 2 };
					break;
				case 6:
					d = new int[] { 0, 3 };
					break;
				case 7:
					d = new int[] { 1, 3 };
					break;
				}

				for (int i = 0; i < d.length; i++) {
					int ny = e[0] + dy[d[i]];
					int nx = e[1] + dx[d[i]];

					if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx])
						continue;

					if ((d[i] == 0 && (map[ny][nx] == 1 || map[ny][nx] == 2 || map[ny][nx] == 4 || map[ny][nx] == 7))
							|| (d[i] == 1
									&& (map[ny][nx] == 1 || map[ny][nx] == 2 || map[ny][nx] == 5 || map[ny][nx] == 6))
							|| (d[i] == 2
									&& (map[ny][nx] == 1 || map[ny][nx] == 3 || map[ny][nx] == 6 || map[ny][nx] == 7))
							|| (d[i] == 3 && (map[ny][nx] == 1 || map[ny][nx] == 3 || map[ny][nx] == 4
									|| map[ny][nx] == 5))) {
						visited[ny][nx] = true;
						q.offer(new int[] { ny, nx, e[2] + 1 });
					}
				}
			}

			System.out.println("#" + t + " " + cnt);
		}
	}
}
