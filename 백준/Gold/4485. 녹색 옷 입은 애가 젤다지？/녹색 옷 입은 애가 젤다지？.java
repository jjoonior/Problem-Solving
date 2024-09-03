import java.io.*;
import java.util.*;

public class Main {
	static int n, m, cnt;
	static boolean[][] visited;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;

		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				return;

			List<Node>[] list = new List[n * n];
			for (int i = 0; i < n * n; i++) {
				list[i] = new ArrayList<>();
			}

			int start = 0;

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int w = Integer.parseInt(st.nextToken());
					if (i == 0 && j == 0)
						start = w;

					for (int k = 0; k < 4; k++) {
						int y = i + dy[k];
						int x = j + dx[k];

						if (y < 0 || y >= n || x < 0 || x >= n)
							continue;

						list[y * n + x].add(new Node(i * n + j, w));
					}
				}
			}

			boolean[] visited = new boolean[n * n];
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0, start));

			int[] d = new int[n * n];
			Arrays.fill(d, Integer.MAX_VALUE);
			d[0] = start;

			while (!pq.isEmpty()) {
				Node node = pq.poll();

				if (visited[node.v])
					continue;

				visited[node.v] = true;

				for (Node e : list[node.v]) {
					if (d[e.v] > d[node.v] + e.w) {
						d[e.v] = d[node.v] + e.w;
						pq.offer(new Node(e.v, d[e.v]));
					}
				}

			}

			System.out.println("Problem " + t++ + ": " + d[n * n - 1]);
		}
	}
}

class Node implements Comparable<Node> {
	int v;
	int w;

	public Node(int v, int w) {
		this.v = v;
		this.w = w;
	}

	public int compareTo(Node o) {
		return this.w - o.w;
	}
}