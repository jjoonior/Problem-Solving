import java.io.*;
import java.util.*;

public class Solution {
	static int N, min;
	static int[][] map;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			list = new ArrayList<>();
			min = Integer.MAX_VALUE;
			f(0, 0);

			System.out.println("#" + t + " " + min);
		}
	}

	static void f(int k, int cnt) {
		if (k == N) {
			return;
		}

		if (cnt == N / 2) {
			// 두 음식의 맛 차이와 최소인지 계산
			calMin();
			return;
		}

		// N/2 개 첫번째 조합 결정
		list.add(k);
		f(k + 1, cnt + 1);
		list.remove(list.size() - 1);
		f(k + 1, cnt);
	}

	static void calMin() {
		// 정해진 한쪽 조합으로 나머지 조합 구함
		List<Integer> tmp = new ArrayList<>();
		for (Integer e : list) {
			for (int i = 0; i < N; i++) {
				if (list.contains(i))
					continue;
				tmp.add(i);
			}
		}

		// 각 음식의 맛 구해서 차이 계산
		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				sumA += map[list.get(i)][list.get(j)] + map[list.get(j)][list.get(i)];
				sumB += map[tmp.get(i)][tmp.get(j)] + map[tmp.get(j)][tmp.get(i)];
			}
		}

		min = Math.min(Math.abs(sumA - sumB), min);
	}
}
