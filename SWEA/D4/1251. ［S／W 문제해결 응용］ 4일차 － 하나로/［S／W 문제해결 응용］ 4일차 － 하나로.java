import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static double E;
	static int[][] map;
	static List<Edge>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][3];
			graph = new List[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				graph[i] = new ArrayList<>();
				map[i][0] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				map[i][1] = Integer.parseInt(st.nextToken());
			}

			E = Double.parseDouble(br.readLine());

			addEdges();

			int cnt = N;
			double w = 0;

			boolean[] visited = new boolean[N];
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.offer(new Edge(0, 0));

			while (!pq.isEmpty() && cnt > 0) {
				Edge edge = pq.poll();

				if (!visited[edge.v]) {
					visited[edge.v] = true;
					w += edge.w;
					cnt--;
					
					for(Edge e : graph[edge.v]) {
						if(!visited[e.v])
							pq.offer(e);
					}
				}
			}

			System.out.println("#" + t + " " + Math.round(E * w));
		}
	}

	static void addEdges() {
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				double len = Math.pow(map[i][0] - map[j][0], 2) + Math.pow(map[i][1] - map[j][1], 2);
				graph[i].add(new Edge(j, len));
				graph[j].add(new Edge(i, len));
			}
		}
	}
}

class Edge implements Comparable<Edge> {
	int v;
	double w;

	public Edge(int v, double w) {
		this.v = v;
		this.w = w;
	}

	public int compareTo(Edge o) {
		return this.w <= o.w ? -1 : 1;
	}
}
