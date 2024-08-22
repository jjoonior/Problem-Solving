import java.io.*;
import java.util.*;

public class Solution {
	static int sum, min;
	static int[] price, month;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sum = 0;
			min = Integer.MAX_VALUE;
			price = new int[4];
			month = new int[12];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}

			f(0);
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	static void f(int m) {
		if (m >= 12) {
			min = Math.min(min, sum);
			return;
		}

		// 1일권
		sum += price[0] * month[m];
		f(m + 1);
		sum -= price[0] * month[m];

		// 1달권
		sum += price[1];
		f(m+1);
		sum -= price[1];
		
		// 3달권
		sum+=price[2];
		f(m+3);
		sum-=price[2];
		
		// 1년권
		sum+=price[3];
		f(m+12);
		sum-=price[3];
	}
}
