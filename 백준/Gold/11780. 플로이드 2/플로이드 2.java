import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int INF = 10000001;
		StringBuilder sb = new StringBuilder();

		int[][] map = new int[n + 1][n + 1];
		List<Integer>[][] list = new List[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
			for (int j = 1; j <= n; j++) {
				list[i][j] = new ArrayList<>();
//				if (i != j) {
//					list[i][j].add(i);
//					list[i][j].add(j);
//				}
			}
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
					if (map[j][k] > map[j][i] + map[i][k]) {
						list[j][k].clear();
						list[j][k].addAll(list[j][i]);
						list[j][k].add(i);
//						list[j][k].remove(list[j][k].size()-1);
						list[j][k].addAll(list[i][k]);
						map[j][k] = map[j][i] + map[i][k];
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append((map[i][j] = map[i][j] == INF ? 0 : map[i][j]) + " ");
			}
			sb.append("\n");
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int size = list[i][j].size();
				if(map[i][j] == 0) {
					sb.append(0+"\n");
					continue;
					
				}
				sb.append((size+2)+" "+ i+" ");
				for(int num : list[i][j]) {
					sb.append(num+" ");
				}
				sb.append(j+"\n");
				
				
//				if (!list[i][j].isEmpty()) {
//					sb.append(list[i][j].size() + " ");
//					for (int k = 0; k < list[i][j].size(); k++) {
//						sb.append(list[i][j].get(k) + " ");
//					}
//				} else {
//					sb.append(0);
//				}
//				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}