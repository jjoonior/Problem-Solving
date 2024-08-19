import java.io.*;
import java.util.*;

public class Solution {
	static int N, min, max;
	static int[] nums, cmd;
	static List<Character> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			cmd = new int[4];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cmd[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());

			}

			list = new ArrayList<>();
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;

			f(0);

			System.out.println("#" + t + " " + (max - min));
		}
	}

	static void f(int k) {
		// 조합 구헀을 때 값 계산 후 최대, 최소와 비교
		if (k == N - 1) {
			int result = nums[0];

			for (int i = 0; i < N - 1; i++) {
				char c = list.get(i);
				switch (c) {
				case '+':
					result += nums[i + 1];
					break;
				case '-':
					result -= nums[i + 1];
					break;
				case '*':
					result *= nums[i + 1];
					break;
				case '/':
					result /= nums[i + 1];
					break;
				}
			}

			min = Math.min(min, result);
			max = Math.max(max, result);

			return;
		}

		// 연산자 순서 모든 조합 구하기
		for (int i = 0; i < 4; i++) {
			if (cmd[i] > 0) {
				switch (i) {
				case 0:
					list.add('+');
					break;
				case 1:
					list.add('-');
					break;
				case 2:
					list.add('*');
					break;
				case 3:
					list.add('/');
					break;
				}

				cmd[i]--;
				f(k + 1);
				cmd[i]++;
				list.remove(list.size() - 1);
			}
		}
	}
}
