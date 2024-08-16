import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			t = Integer.parseInt(br.readLine());
			int[] arr = new int[8];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int idx = 0;

			while (true) {
				boolean flag = false;
				
				for (int i = 1; i <= 5; i++) {
					arr[idx] -= i;
				
					if (arr[idx] <= 0) {
						flag = true;
						arr[idx++] = 0;
						sb.append("#" + t);
						for (int j = 0; j < 8; j++) {
							sb.append(" " + arr[(idx + j) % 8]);
						}
						break;
					}
					
					idx = (idx + 1) % 8;
				}


				if (flag)
					break;
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
