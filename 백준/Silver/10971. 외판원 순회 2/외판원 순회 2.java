import java.io.*;
import java.util.*;

public class Main {
	static int N, min;
	static int[][] map;
	static boolean[] visited;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		map = new int[N][N];
		visited = new boolean[N];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		f(0);

		System.out.println(min);
	}

	static void f(int cnt) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (map[list.get(i)][list.get((i + 1) % N)] == 0)
					return;
				sum += map[list.get(i)][list.get((i + 1) % N)];
			}
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				list.add(i);
				f(cnt + 1);
				list.remove(list.size() - 1);
				visited[i] = false;
			}
		}
	}
}
