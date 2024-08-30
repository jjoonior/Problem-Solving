import java.io.*;
import java.util.*;

public class Main {
	static int N, min;
	static int[][] city;
	static int[] p;
	static PriorityQueue<Edge> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		city = new int[N + 1][2];
		p = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			city[i][0] = Integer.parseInt(st.nextToken());
			p[i] = i;
		}

		pq = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int a = Integer.parseInt(st.nextToken());
				pq.add(new Edge(i, a, 1));
			}
		}

		min = Integer.MAX_VALUE;
		f(1);

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static int findSet(int a) {
		return p[a] == a ? a : (p[a] = findSet(p[a]));
	}

	static void union(int a, int b) {
		p[Math.max(findSet(a), findSet(b))] = Math.min(findSet(a), findSet(b));
	}

	static void f(int k) {
		if (k == N + 1) {
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}

			PriorityQueue<Edge> q = new PriorityQueue<>(pq);

			while (!q.isEmpty()) {
				Edge edge = q.poll();

				if (city[edge.u][1] == city[edge.v][1]) {
					if (findSet(edge.u) != findSet(edge.v)) {
						union(edge.u, edge.v);
					}
				}
			}

			int sum = 0;
			int cnt = 0;
			int cntP = 0;

			for (int i = 1; i <= N; i++) {
				cntP += p[i] == i ? 1 : 0;

				if (city[i][1] == 0) {
					sum += city[i][0];
					cnt++;
				} else {
					sum -= city[i][0];
				}
			}

			if (cnt > 0 && cnt < N && cntP == 2)
				min = Math.min(min, Math.abs(sum));

			return;
		}

		city[k][1] = 1;
		f(k + 1);
		city[k][1] = 0;
		f(k + 1);
	}
}

class Edge implements Comparable<Edge> {
	int u;
	int v;
	int w;

	public Edge(int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}

	public int compareTo(Edge o) {
		return this.w - o.w;
	}
}