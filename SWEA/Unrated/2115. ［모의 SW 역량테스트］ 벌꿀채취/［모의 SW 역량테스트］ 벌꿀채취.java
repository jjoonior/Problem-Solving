import java.io.*;
import java.util.*;

import com.sun.imageio.plugins.common.InputStreamAdapter;

public class Solution {
	static int N, M, C, max;
	static int[][] map;
	static List<Integer> list;
	static Queue<int[]> answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			list = new ArrayList<>();
			answer = new PriorityQueue<>((a, b) -> b[2] - a[2]);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) {
					max = 0;
					f(0, i, j);
					answer.add(new int[] { i, j, max });
				}
			}

			int[] a = answer.poll();

			while (true) {
				int[] b = answer.poll();

				if (a[0] == b[0] && Math.abs(a[1] - b[1]) < M)
					continue;

				System.out.println("#" + t + " " + (a[2] + b[2]));
				break;
			}
		}
	}

	static void f(int k, int y, int x) {
		if (k == M) {
			int sum = 0;
			int sumP = 0;
			for (Integer e : list) {
				sum += e;
				sumP += e * e;
				if (sum > C)
					return;
			}
			max = Math.max(max, sumP);
			return;
		}

		list.add(map[y][x]);
		f(k + 1, y, x + 1);
		list.remove(list.size() - 1);
		f(k + 1, y, x + 1);
	}
}
