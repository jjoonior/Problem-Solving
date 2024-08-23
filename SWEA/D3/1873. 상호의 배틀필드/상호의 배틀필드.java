import java.io.*;
import java.util.*;

public class Solution {
	static int H, W, N;
	static char[][] map;
	static Tank tank;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				String input = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = input.charAt(j);
					if ("^v<>".contains(Character.toString(map[i][j]))) {
						switch (map[i][j]) {
						case '^':
							tank = new Tank(i, j, 0);
							break;
						case 'v':
							tank = new Tank(i, j, 1);
							break;
						case '<':
							tank = new Tank(i, j, 2);
							break;
						case '>':
							tank = new Tank(i, j, 3);
							break;
						}
					}
				}
			}

			N = Integer.parseInt(br.readLine());
			String cmd = br.readLine();

			for (int i = 0; i < cmd.length(); i++) {
				char c = cmd.charAt(i);
				switch (c) {
				case 'S':
					S();
					break;
				default:
					UDLR(c);
					break;
				}
			}

			sb.append("#").append(t).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	static void UDLR(char cmd) {
		tank.d = cmd == 'U' ? 0 : cmd == 'D' ? 1 : cmd == 'L' ? 2 : 3;
		int y = tank.y + dy[tank.d];
		int x = tank.x + dx[tank.d];

		if (y >= 0 && y < H && x >= 0 && x < W && map[y][x] == '.') {
			map[tank.y][tank.x] = '.';
			tank.y = y;
			tank.x = x;
		}
		
		map[tank.y][tank.x] = tank.d == 0 ? '^' : tank.d == 1 ? 'v' : tank.d == 2 ? '<' : '>';
	}

	static void S() {
		int by = tank.y;
		int bx = tank.x;

		while (by >= 0 && by < H && bx >= 0 && bx < W) {
			if (map[by][bx] == '#') {
				break;
			}

			if (map[by][bx] == '*') {
				map[by][bx] = '.';
				break;
			}

			by += dy[tank.d];
			bx += dx[tank.d];
		}
	}
}

class Tank {
	int y;
	int x;
	int d;

	public Tank(int y, int x, int d) {
		this.y = y;
		this.x = x;
		this.d = d;
	}
}
