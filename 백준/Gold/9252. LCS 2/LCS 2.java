import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine();
		String str2 = br.readLine();

		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		int a = str1.length(), b = str2.length();

		while (a >= 1 && b >= 1) {
			if (dp[a][b] == dp[a - 1][b]) {
				a--;

			} else if (dp[a][b] == dp[a][b - 1]) {
				b--;
			} else {
				sb.append(str2.charAt(b - 1));
				a--;
				b--;
			}
		}

		System.out.println(dp[str1.length()][str2.length()]);
		if (sb.length() > 0){
			System.out.println(sb.reverse());
        }
	}
}