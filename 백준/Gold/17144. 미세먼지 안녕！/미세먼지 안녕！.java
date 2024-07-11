import java.io.*;
import java.util.*;

public class Main {
	static int R, C, T;
	static int[][][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[2][R][C];
		int sum = 0;
		int b = 0;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[0][i][j] = Integer.parseInt(st.nextToken());
				sum += map[0][i][j];
				if (map[0][i][j] == -1) {
					b = i;
					sum++;
				}
			}
		}

		int[] dy = { 0, 0, 1, -1 };
		int[] dx = { 1, -1, 0, 0 };

		for (; T > 0; T--) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[0][i][j] > 0) {
						for (int k = 0; k < 4; k++) {
							int y = i + dy[k];
							int x = j + dx[k];
							if (y >= 0 && y < R && x >= 0 && x < C && map[0][y][x] != -1) {
								map[1][y][x] += map[0][i][j] / 5;
								map[1][i][j] -= map[0][i][j] / 5;
							}
						}
					}
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[0][i][j] != -1) {
						map[0][i][j] += map[1][i][j];
						map[1][i][j] = 0;
					}
				}
			}

			for (int i = b - 1; i > 0; i--) {
				if (map[0][i][0] == -1) {
					sum -= map[0][i - 1][0];
				} else {
					map[0][i][0] = map[0][i - 1][0];
				}
			}
			for (int i = 0; i < C - 1; i++) {
				if (map[0][0][i] == -1) {
					sum -= map[0][0][i + 1];
				} else {
					map[0][0][i] = map[0][0][i + 1];
				}
			}
			for (int i = 0; i < b - 1; i++) {
				map[0][i][C - 1] = map[0][i + 1][C - 1];
			}
			for (int i = C - 1; i > 1; i--) {
				map[0][b - 1][i] = map[0][b - 1][i - 1];
			}

			for (int i = b; i < R - 1; i++) {
				if (map[0][i][0] == -1) {
					sum -= map[0][i + 1][0];
				} else {
					map[0][i][0] = map[0][i + 1][0];
				}
			}
			for (int i = 0; i < C - 1; i++) {
				if (map[0][R - 1][i] == -1) {
					sum -= map[0][R - 1][i + 1];
				} else {
					map[0][R - 1][i] = map[0][R - 1][i + 1];
				}
			}
			for (int i = R - 1; i > b; i--) {
				map[0][i][C - 1] = map[0][i - 1][C - 1];
			}
			for (int i = C - 1; i > 1; i--) {
				map[0][b][i] = map[0][b][i - 1];
			}
			map[0][b][1] = map[0][b - 1][1] = 0;
		}

		System.out.println(sum);

	}
}
