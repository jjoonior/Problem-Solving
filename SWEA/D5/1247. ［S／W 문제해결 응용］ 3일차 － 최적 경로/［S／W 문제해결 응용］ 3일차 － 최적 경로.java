import java.io.*;
import java.util.*;

public class Solution {
	static int N, min;
	static int[][] point;
	static boolean[] isSelected;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			point = new int[N + 2][2];
			isSelected = new boolean[N + 2];
			list = new ArrayList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N + 2; i++) {
				point[i][0] = Integer.parseInt(st.nextToken());
				point[i][1] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			list.add(0);
			f(0);
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	static void f(int cnt) {
		if (cnt == N) {
			list.add(1);
			
			int sum = 0;
			for (int i = 1; i < list.size(); i++) {
				sum += Math.abs(point[list.get(i - 1)][0] - point[list.get(i)][0]) + Math.abs(point[list.get(i - 1)][1] - point[list.get(i)][1]);
			}
			min = Math.min(min, sum);
			
			list.remove(N + 1);
			return;
		}

		for (int i = 2; i < N + 2; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				list.add(i);
				f(cnt + 1);
				list.remove(list.size() - 1);
				isSelected[i] = false;
			}
		}
	}
}
