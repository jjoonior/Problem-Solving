import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int INF = 10000001;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[] t = new int[n + 1];
		int[][] map = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			map[s][e] = map[e][s] = Math.min(w, map[s][e]);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (map[j][k] > map[j][i] + map[i][k]) {
						map[j][k] = map[j][i] + map[i][k];
					}
				}
			}
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			
			for (int j = 1; j <= n; j++) {
				if(map[i][j] <= m) {
					sum+=t[j];
				}
			}
			
			max = Math.max(max, sum);
		}


		System.out.println(max);
	}
}