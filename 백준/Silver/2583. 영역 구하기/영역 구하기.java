import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[M][N];
		boolean[][] visited = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int ax = Integer.parseInt(st.nextToken());
			int ay = Integer.parseInt(st.nextToken());
			int bx = Integer.parseInt(st.nextToken());
			int by = Integer.parseInt(st.nextToken());

			for (int j = ay; j < by; j++) {
				for (int j2 = ax; j2 < bx; j2++) {
					map[j][j2] = -1;
				}
			}
		}

		List<Integer> answer = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] || map[i][j] == -1)
					continue;

				int cnt = 0;
				Queue<int[]> q = new LinkedList<>();
				visited[i][j] = true;
				q.offer(new int[] { i, j });

				while (!q.isEmpty()) {
					cnt++;
					int[] e = q.poll();

					int[] dy = { 1, -1, 0, 0 };
					int[] dx = { 0, 0, 1, -1 };

					for (int l = 0; l < 4; l++) {
						int y = e[0] + dy[l];
						int x = e[1] + dx[l];

						if (y < 0 || y >= M || x < 0 || x >= N || map[y][x] == -1 || visited[y][x])
							continue;

						visited[y][x] = true;
						q.offer(new int[] { y, x });
					}

				}

				answer.add(cnt);
			}
		}

		Collections.sort(answer);
		
		System.out.println(answer.size());
		for (Integer cnt : answer) {
			System.out.print(cnt + " ");
		}
	}
}