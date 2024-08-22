import java.io.*;
import java.util.*;

public class Solution {
	static int N, n, cnt, max, maxN, start;
	static int[][] map;
	static Map<Integer, int[]> xy;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			xy = new HashMap<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					xy.put(map[i][j], new int[] { i, j });
				}
			}

			int[] dy = { 1, -1, 0, 0 };
			int[] dx = { 0, 0, 1, -1 };

			max = 0;
			n = 1;
			cnt = 1;
			start = 1;
			maxN = 1;

			while (n <= Math.pow(N, 2)) {
				boolean flag= false;
				
				for (int i = 0; i < 4; i++) {
					int y = xy.get(n)[0] + dy[i];
					int x = xy.get(n)[1] + dx[i];

					if (y < 0 || y >= N || x < 0 || x >= N || map[y][x] != n + 1) {
						continue;
					}

					cnt++;
					n++;
					flag = true;
					break;
				}
				if(flag) continue;

				if(cnt > max) {
					max = cnt;
					maxN = start;
				}
				
				cnt = 1;
				n++;
				start = n;
			}

			sb.append("#").append(t).append(" ").append(maxN).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
