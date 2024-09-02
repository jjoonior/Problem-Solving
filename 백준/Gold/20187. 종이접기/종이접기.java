import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());

		int[][] point = new int[4][2];
		point[1][1] = point[2][0] = point[3][0] = point[3][1] = 2 * k;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * k; i++) {
			char c = st.nextToken().charAt(0);
			switch (c) {
			case 'D':
				point[0][0] = (point[0][0] + point[2][0]) / 2;
				point[1][0] = (point[1][0] + point[3][0]) / 2;
				break;
			case 'U':
				point[2][0] = (point[0][0] + point[2][0]) / 2;
				point[3][0] = (point[1][0] + point[3][0]) / 2;
				break;
			case 'R':
				point[0][1] = (point[0][1] + point[1][1]) / 2;
				point[2][1] = (point[2][1] + point[3][1]) / 2;
				break;
			case 'L':
				point[1][1] = (point[0][1] + point[1][1]) / 2;
				point[3][1] = (point[2][1] + point[3][1]) / 2;
				break;
			}
		}

		int h = Integer.parseInt(br.readLine());

		int[][] map = new int[(int) Math.pow(2, k)][(int) Math.pow(2, k)];
		boolean[][] visited = new boolean[(int) Math.pow(2, k)][(int) Math.pow(2, k)];

		Queue<int[]> q = new LinkedList<>();
		visited[point[0][0]][point[0][1]] = true;
		map[point[0][0]][point[0][1]] = h;
		q.offer(new int[] { point[0][0], point[0][1], h });

		while (!q.isEmpty()) {
			int[] e = q.poll();

			int[] dy = { 1, -1, 0, 0 };
			int[] dx = { 0, 0, 1, -1 };

			for (int i = 0; i < 2; i++) {
				int y = e[0] + dy[i];
				int x = e[1] + dx[i];

				if (y < 0 || y >= (int) Math.pow(2, k) || x < 0 || x >= (int) Math.pow(2, k) || visited[y][x])
					continue;

				visited[y][x] = true;
				map[y][x] = (e[2] + 2) % 4;
				q.offer(new int[] { y, x, map[y][x] });
			}

			for (int i = 2; i < 4; i++) {
				int y = e[0] + dy[i];
				int x = e[1] + dx[i];

				if (y < 0 || y >= (int) Math.pow(2, k) || x < 0 || x >= (int) Math.pow(2, k) || visited[y][x])
					continue;

				visited[y][x] = true;
				map[y][x] = e[2] == 1 || e[2] == 3 ? e[2] - 1 : e[2] + 1;
				q.offer(new int[] { y, x, map[y][x] });
			}

		}

		for (int i = 0; i < (int) Math.pow(2, k); i++) {
			for (int j = 0; j < (int) Math.pow(2, k); j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}