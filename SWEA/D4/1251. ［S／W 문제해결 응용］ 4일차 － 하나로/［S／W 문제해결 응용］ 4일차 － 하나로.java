import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static double E;
	static int[][] map;
	static int[] p;
	static PriorityQueue<Edge> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][3];
			p = new int[N];
			pq = new PriorityQueue<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				p[i] = i;
				map[i][0] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				map[i][1] = Integer.parseInt(st.nextToken());
			}

			E = Double.parseDouble(br.readLine());

			addEdges();

			int cnt = N - 1;
			double w = 0;

			while (!pq.isEmpty() && cnt > 0) {
				Edge edge = pq.poll();

				if (findSet(edge.u) != findSet(edge.v)) {
					cnt--;
					w += edge.w;
					union(edge.u, edge.v);
				}
			}

			System.out.println("#" + t + " " + Math.round(E * w));
		}
	}

	static int findSet(int a) {
		return p[a] == a ? a : (p[a] = findSet(p[a]));
	}

	static void union(int a, int b) {
		p[findSet(a)] = findSet(b);
	}

	static void addEdges() {
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				double len = Math.pow(map[i][0] - map[j][0], 2) + Math.pow(map[i][1] - map[j][1], 2);
				pq.add(new Edge(i, j, len));
			}
		}
	}
}

class Edge implements Comparable<Edge> {
	int u;
	int v;
	double w;

	public Edge(int u, int v, double w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}

	public int compareTo(Edge o) {
		return this.w <= o.w ? -1 : 1;
	}
}
