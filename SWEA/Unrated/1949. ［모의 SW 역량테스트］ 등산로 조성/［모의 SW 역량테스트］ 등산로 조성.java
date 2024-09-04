import java.io.*;
import java.util.*;

public class Solution {
	static int N, K, max;
	static int[][] map;
	static boolean[][] visited;
	static List<int[]> list;
	static int[] dy = { 1, -1, 0, 0 }, dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			visited = new boolean[N][N];
			list = new ArrayList<>();
			list.add(new int[] { 0, 0, 0 });
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (list.get(0)[2] < map[i][j]) {
						list.clear();
						list.add(new int[] { i, j, map[i][j] });
					} else if (list.get(0)[2] == map[i][j]) {
						list.add(new int[] { i, j, map[i][j] });
					}
				}
			}

			max = 0;
			
			for (int[] top : list) {
				visited[top[0]][top[1]] = true;
				dfs(top[0], top[1], false, 1);
				visited[top[0]][top[1]] = false;
			}

			System.out.println("#" + t + " " + max);
		}
	}

	static void dfs(int y, int x, boolean used, int len) {
		max = Math.max(max, len);
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx])
				continue;

			if (map[y][x] > map[ny][nx]) {
				visited[ny][nx] = true;
				dfs(ny, nx, used, len + 1);
				visited[ny][nx] = false;
			} else {
				if (!used) {
					for (int j = 1; j <= K; j++) {
						if (map[y][x] > map[ny][nx] - j) {
							map[ny][nx] -= j;
							visited[ny][nx] = true;
							dfs(ny, nx, true, len + 1);
							visited[ny][nx] = false;
							map[ny][nx] += j;
						}
					}
				}
			}
		}
	}
}
