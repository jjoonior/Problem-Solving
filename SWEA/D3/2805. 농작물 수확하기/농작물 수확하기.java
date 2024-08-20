import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					int e = Integer.parseInt(Character.toString(input.charAt(j)));
					int y = i < N / 2 ? i : N - 1 - i;
					int x = j < N / 2 ? j : N - 1 - j;

					if (x + y >= N / 2) {
						cnt += e;
					}
				}
			}

			System.out.println("#" + t + " " + cnt);
		}
	}
}
