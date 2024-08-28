import java.io.*;
import java.util.*;

public class Solution {
	static int n, m;
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			p = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				p[i] = i;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}

			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (p[i] == i)
					cnt++;
			}

			System.out.println("#" + t + " " + cnt);
		}
	}

	static int findSet(int k) {
		return p[k] == k ? k : (p[k] = findSet(p[k]));
	}

	static void union(int a, int b) {
		p[findSet(Math.max(a, b))] = findSet(Math.min(a, b));
	}
}
