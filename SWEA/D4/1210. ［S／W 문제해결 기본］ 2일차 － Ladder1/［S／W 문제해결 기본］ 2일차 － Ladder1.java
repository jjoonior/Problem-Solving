import java.io.*;
import java.util.*;
class Solution
{
    	static int answer;
	static int[][] map;
	static boolean[][] isVisited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			map = new int[100][100];
			isVisited = new boolean[100][100];
			int end = 0;

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2)
						end = j;
				}
			}

			isVisited[99][end] = true;
			f(99, end);

			System.out.println("#" + t + " " + answer);
		}
	}

	static void f(int y, int x) {
		if (y == 0) {
			answer = x;
			return;
		}

		if (x - 1 >= 0 && map[y][x - 1] == 1 && !isVisited[y][x - 1]) {
			isVisited[y][x - 1] = true;
			f(y, x - 1);
		}else if (x + 1 < 100 && map[y][x + 1] == 1 && !isVisited[y][x + 1]) {
			isVisited[y][x + 1] = true;
			f(y, x + 1);
		}else {
			isVisited[y - 1][x] = true;
			f(y - 1, x);
		}
	}
}