import java.io.*;
import java.util.*;

public class Main {
	static int N, min;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		min = Integer.MAX_VALUE;
		f(0, 1, 0);
		System.out.println(min);
	}

	static void f(int k, int S, int B) {
		if (k == N + 1) {
			if (S != 0 && B != 0) {
				min = Math.min(min, Math.abs(S - B));
			}
			return;
		}

		for (int i = k; i <= N; i++) {
			if (i == N) {
				f(i + 1, S, B);
			} else {
				f(i + 1, S * arr[i][0], B + arr[i][1]);
			}
		}
	}
}
