import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[] start = new int[2];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					start[0] = i;
					start[1] = j;
					map[i][j] = 0;
				} else if (map[i][j] > 0) {
					cnt++;
				}
			}
		}

		int time = 0;
		int size = 2;
		int remain = 2;
		int checkCnt = cnt + 1;
		while (cnt > 0 && --checkCnt == cnt) {
			boolean[][] visited = new boolean[N][N];
			PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
				if (a[2] == b[2]) {
					if (a[0] == b[0]) {
						return a[1] - b[1];
					}
					return a[0] - b[0];
				}
				return a[2] - b[2];
			});
			q.offer(new int[] { start[0], start[1], 0 });
			visited[start[0]][start[1]] = true;

			int[] dy = { -1, 0, 0, 1 };
			int[] dx = { 0, -1, 1, 0 };

			while (!q.isEmpty()) {
				int[] now = q.poll();

				if (map[now[0]][now[1]] > 0 && map[now[0]][now[1]] < size) {
					map[now[0]][now[1]] = 0;
					start[0] = now[0];
					start[1] = now[1];
					time += now[2];
					cnt--;
					if (--remain == 0)
						remain = ++size;

					break;
				}

				for (int i = 0; i < 4; i++) {
					int y = now[0] + dy[i];
					int x = now[1] + dx[i];

					if (y < 0 || y >= N || x < 0 || x >= N || visited[y][x] || map[y][x] > size)
						continue;

					visited[y][x] = true;
					q.offer(new int[] { y, x, now[2] + 1 });
				}
			}
		}

		System.out.println(time);
	}
}
