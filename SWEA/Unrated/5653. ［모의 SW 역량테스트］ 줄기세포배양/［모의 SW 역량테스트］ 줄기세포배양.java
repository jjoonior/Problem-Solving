import java.io.*;
import java.util.*;

class Solution {
	static int N, M, K;
	static Map<Integer, Map<Integer, Integer>> map;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new HashMap<>();
			PriorityQueue<Cell> pq = new PriorityQueue<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int v = Integer.parseInt(st.nextToken());
					if (v > 0) {
						put(i, j, v);

						Cell cell = new Cell(i, j, v, v);
						pq.add(cell);
					}
				}
			}

			while (K-- > 0) {
				PriorityQueue<Cell> tmp = new PriorityQueue<>();

				while (!pq.isEmpty()) {
					Cell cell = pq.poll();

					if (!cell.isActive && cell.remain == 0) {
						for (int i = 0; i < 4; i++) {
							int y = cell.y + dy[i];
							int x = cell.x + dx[i];

							if (get(y, x) == 0) {
								put(y, x, cell.v);
								tmp.add(new Cell(y, x, cell.v, cell.v));
							}
						}

						cell.isActive = true;
						cell.remain = cell.v - 1;
					}

					if (--cell.remain >= 0)
						tmp.add(cell);
				}

				pq = tmp;
			}

			System.out.println("#" + t + " " + pq.size());
		}
	}

	static int get(int y, int x) {
		if (map.containsKey(y) && map.get(y).containsKey(x)) {
			return map.get(y).get(x);
		}

		return 0;
	}

	static void put(int y, int x, int v) {
		if (!map.containsKey(y)) {
			map.put(y, new HashMap<>());
		}

		map.get(y).put(x, v);
	}
}

class Cell implements Comparable<Cell> {
	int y, x, v, remain;
	boolean isActive;

	public Cell(int y, int x, int v, int remain) {
		this.y = y;
		this.x = x;
		this.v = v;
		this.remain = remain;
		this.isActive = false;
	}

	@Override
	public int compareTo(Cell o) {
		if (this.remain == o.remain) {
			return o.v - this.v;
		}
		return this.remain - o.remain;
	}
}