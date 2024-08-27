import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		int[] answerPoint = new int[2];
		char answerBlock = '.';

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		List<int[]> list = new ArrayList<>();

		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '.')
					continue;

				int[] dIdx = {};

				switch (map[i][j]) {
				case '|':
					dIdx = new int[] { 0, 1 };
					break;
				case '-':
					dIdx = new int[] { 2, 3 };
					break;
				case '+':
					dIdx = new int[] { 0, 1, 2, 3 };
					break;
				case '1':
					dIdx = new int[] { 1, 3 };
					break;
				case '2':
					dIdx = new int[] { 0, 3 };
					break;
				case '3':
					dIdx = new int[] { 0, 2 };
					break;
				case '4':
					dIdx = new int[] { 1, 2 };
					break;
				}

				for (int k = 0; k < dIdx.length; k++) {
					int y = i + dy[dIdx[k]];
					int x = j + dx[dIdx[k]];

					if (map[y][x] == '.') {
						answerPoint[0] = y;
						answerPoint[1] = x;

						list.add(new int[] { i, j });
					}
				}
			}
		}

		if (list.size() == 4) {
			answerBlock = '+';
		} else {
			int[] a = list.get(0);
			int[] b = list.get(1);

			if (a[0] == b[0]) {
				answerBlock = '-';
			} else if (a[1] == b[1]) {
				answerBlock = '|';
			} else if (a[0] < b[0] && a[1] > b[1] && answerPoint[0] == a[0]) {
				answerBlock = '1';
			} else if (a[0] < b[0] && a[1] < b[1] && answerPoint[0] == b[0]) {
				answerBlock = '2';
			} else if (a[0] < b[0] && a[1] > b[1] && answerPoint[0] == b[0]) {
				answerBlock = '3';
			} else if (a[0] < b[0] && a[1] < b[1] && answerPoint[0] == a[0]) {
				answerBlock = '4';
			}
		}

		System.out.println((answerPoint[0] + 1) + " " + (answerPoint[1] + 1) + " " + answerBlock);
	}
}
