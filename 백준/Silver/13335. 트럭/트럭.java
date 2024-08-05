import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] arr = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		int idx = 1;
		int curL = 0;
		int[] W = new int[w + 1];

		while (W[0] != n) {
			cnt++;

			for (int i = 0; i < w; i++) {
				W[i] = W[i + 1];
			}
			W[w] = 0;
			curL -= arr[W[0]];

			if (idx <= n && curL + arr[idx] <= L) {
				W[w] = idx;
				curL += arr[idx++];
			}
		}
		System.out.println(cnt);
	}
}
