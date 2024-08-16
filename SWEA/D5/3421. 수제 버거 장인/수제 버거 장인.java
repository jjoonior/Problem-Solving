import java.io.*;
import java.util.*;

public class Solution {
	static int N, M;
	static boolean[][] arr;
	static int cnt;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new boolean[N + 2][N + 2];
			cnt = 0;
			list = new ArrayList<>();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				arr[a][b] = arr[b][a] = true;
			}

			f(1);

			System.out.println("#" + t + " " + cnt);
		}
	}

	static void f(int k) {
		if (k == N + 2) {
			cnt++;
			return;
		}

		for (int i = k; i <= N + 1; i++) {
			boolean flag = false;

			for (Integer e : list) {
				if (arr[i][e]) {
					flag = true;
					break;
				}
			}

			if (!flag) {
				list.add(i);
				f(i + 1);
				list.remove(list.size() - 1);
			}
		}

	}
}