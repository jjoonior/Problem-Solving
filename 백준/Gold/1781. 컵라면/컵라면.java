import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (!map.containsKey(d)) {
				map.put(d, new PriorityQueue<>(Collections.reverseOrder()));
			}
			map.get(d).add(c);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (Integer d : map.keySet()) {
			PriorityQueue<Integer> list = map.get(d);

			int c = list.poll();
			pq.offer(c);

			while (!list.isEmpty() && pq.size() < d) {
				pq.offer(list.poll());
			}

			while (!list.isEmpty() && pq.peek() < list.peek()) {
				pq.poll();
				pq.offer(list.poll());
			}
		}

		int cnt = 0;
		for (Integer e : pq) {
			cnt += e;
		}
		
		System.out.println(cnt);
	}
}