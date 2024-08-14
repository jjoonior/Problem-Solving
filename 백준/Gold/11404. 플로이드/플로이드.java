import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int INF = 10000000;

		int[][] map = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			map[s][e] = Math.min(w, map[s][e]);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print((map[i][j] = map[i][j] == INF ? 0 : map[i][j]) + " ");
			}
			System.out.println();
		}
	}
}