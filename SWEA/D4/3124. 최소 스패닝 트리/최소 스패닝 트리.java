import java.io.*;
import java.util.*;

public class Solution {
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			boolean[] visited = new boolean[V + 1];
			List<Edge>[] graph = new List[V + 1];
			for (int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				graph[a].add(new Edge(b, c));
				graph[b].add(new Edge(a, c));
			}

			long sum = 0;
			int cnt = V;

			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.add(new Edge(1, 0));

			while (!pq.isEmpty() && cnt > 0) {
				Edge edge = pq.poll();

				if (!visited[edge.v]) {
					visited[edge.v] = true;
					sum += edge.w;
					cnt--;

					for (Edge e : graph[edge.v]) {
						if (!visited[e.v])
							pq.offer(e);
					}
				}
			}

			System.out.println("#" + t + " " + sum);
		}
	}
}

class Edge implements Comparable<Edge> {
	int v;
	int w;

	public Edge(int v, int w) {
		this.v = v;
		this.w = w;
	}

	public int compareTo(Edge o) {
		return this.w - o.w;
	}
}