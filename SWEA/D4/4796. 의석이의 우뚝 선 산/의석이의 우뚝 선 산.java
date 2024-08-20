import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			int cnt = 0;
			for (int i = 1; i < N - 1; i++) {
				if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
					int left, right;
					left = right = 0;

					int idx = i - 1;
					while (idx >= 0) {
						if (arr[idx] < arr[idx + 1]) {
							left++;
							idx--;
						} else {
							break;
						}
					}

					idx = i + 1;
					while (idx < N) {
						if (arr[idx] < arr[idx - 1]) {
							right++;
							idx++;
						} else {
							break;
						}
					}

					cnt += left * right;
				}
			}

			System.out.println("#" + t + " " + cnt);
		}
	}
}
