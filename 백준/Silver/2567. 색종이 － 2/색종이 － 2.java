import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[][] map = new boolean[102][102];
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = 0; j < 10; j++) {
				for (int j2 = 0; j2 < 10; j2++) {
					map[y + j][x + j2] = true;
				}
			}
		}

		int cnt = 0;
		int[] dy = { 1, -1, 0, 0 };
		int[] dx = { 0, 0, 1, -1 };
		
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if(!map[i][j]) continue;
				
				for (int j2 = 0; j2 < 4; j2++) {
					int y = i + dy[j2];
					int x = j + dx[j2];

					if (!map[y][x]) {
						cnt++;
					}
				}
			}
		}

		System.out.println(cnt);
	}

}
