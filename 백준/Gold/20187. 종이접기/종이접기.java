import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());

		int[][] point = new int[4][2];
		point[1][1] = point[2][0] = point[3][0] = point[3][1] = (int) Math.pow(2, k);

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
		int pow = (int) Math.pow(2, k);

		int[][] map = new int[pow][pow];
		boolean[][] visited = new boolean[pow][pow];
		Queue<int[]> q = new LinkedList<>();

		visited[point[0][0]][point[0][1]] = true;
		map[point[0][0]][point[0][1]] = h;
		q.offer(new int[] { point[0][0], point[0][1], h });

		while (!q.isEmpty()) {
			int[] e = q.poll();

			int[] dy = { 1, -1, 0, 0 };
			int[] dx = { 0, 0, 1, -1 };

			for (int i = 0; i < 4; i++) {
				int y = e[0] + dy[i];
				int x = e[1] + dx[i];

				if (y < 0 || y >= pow || x < 0 || x >= pow || visited[y][x])
					continue;

				visited[y][x] = true;
				map[y][x] = i < 2 ? (e[2] + 2) % 4 : (e[2] == 1 || e[2] == 3) ? e[2] - 1 : e[2] + 1;
				q.offer(new int[] { y, x, map[y][x] });
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < pow; i++) {
			for (int j = 0; j < pow; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}