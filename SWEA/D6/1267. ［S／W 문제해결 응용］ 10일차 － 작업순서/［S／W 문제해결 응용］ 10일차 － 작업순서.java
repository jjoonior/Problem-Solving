import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int[] cnt = new int[V + 1];
			List<Integer>[] edges = new List[V + 1];

			for (int i = 1; i <= V; i++) {
				edges[i] = new ArrayList<>();
			}

			Queue<Integer> q = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				cnt[v]++;
				edges[u].add(v);
			}

			sb.append("#").append(t);

			for (int i = 1; i <= V; i++) {
				if (cnt[i] == 0) {
					q.add(i);
					sb.append(" " + i);
				}
			}

			while (!q.isEmpty()) {
				int idx = q.poll();
				for (int i = 0; i < edges[idx].size(); i++) {
					if (--cnt[edges[idx].get(i)] == 0) {
						q.add(edges[idx].get(i));
						sb.append(" " + edges[idx].get(i));
					}
				}
			}

			sb.append("\n");
		}
		System.out.println(sb);
	}
}
