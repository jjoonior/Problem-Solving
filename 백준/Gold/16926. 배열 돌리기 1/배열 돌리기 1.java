import java.io.*;
import java.util.*;

public class Main {
	static int N, M, R, min, sum;
	static int[][] A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		A = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rotate();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(A[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void rotate() {
		int m = Math.min(N / 2, M / 2);
		List<Node>[] xy = new List[m];
		List<Integer>[] v = new List[m];

		for (int i = 0; i < m; i++) {
			xy[i] = new ArrayList<>();
			v[i] = new ArrayList<>();

			int h = N - i * 2;
			int w = M - i * 2;

			for (int j = 0; j < w - 1; j++) {
				xy[i].add(new Node(i, i + j));
				v[i].add(A[i][i + j]);
			}
			for (int j = 0; j < h - 1; j++) {
				xy[i].add(new Node(i + j, i + w - 1));
				v[i].add(A[i + j][i + w - 1]);
			}
			for (int j = w - 1; j > 0; j--) {
				xy[i].add(new Node(i + h - 1, i + j));
				v[i].add(A[i + h - 1][i + j]);
			}
			for (int j = h - 1; j > 0; j--) {
				xy[i].add(new Node(i + j, i));
				v[i].add(A[i + j][i]);
			}

			for (int j = 0; j < R % v[i].size(); j++) {
				v[i].add(v[i].remove(0));
			}

			for (int j = 0; j < xy[i].size(); j++) {
				Node node = xy[i].get(j);
				int y = node.y;
				int x = node.x;

				A[y][x] = v[i].get(j);
			}
		}
	}
}

class Node {
	int y;
	int x;

	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
