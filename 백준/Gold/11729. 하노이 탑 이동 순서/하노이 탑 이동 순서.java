import java.io.*;
import java.util.*;

public class Main {
	static int cnt = 0;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		f(N, 1, 3);
		System.out.println(cnt);
		System.out.println(sb);
	}

	static void f(int n, int s, int e) {
		if (n == 1) {
			cnt++;
			sb.append(s + " " + e + "\n");
			return;
		}

		int m = 6 - s - e;
		f(n - 1, s, m);
		cnt++;
		sb.append(s + " " + e + "\n");
		f(n - 1, m, e);
	}
}
