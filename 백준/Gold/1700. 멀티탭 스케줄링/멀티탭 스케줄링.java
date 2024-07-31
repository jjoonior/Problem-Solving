import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[K];
		Set<Integer> set = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		for (int i = 0; i < K; i++) {
			if (set.contains(arr[i])) {
				continue;
			}

			if (set.size() < N) {
				set.add(arr[i]);
				continue;
			}

			List<Integer> list = new ArrayList<>();
			for (int j = i + 1; j < K; j++) {
				if (!list.contains(arr[j])) {
					list.add(arr[j]);
				}
			}

			int x = 0;
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
			for (Integer e : set) {
				boolean flag = false;
				for (int j = 0; j < list.size(); j++) {
					if (e == list.get(j)) {
						pq.add(new int[] { e, j });
						flag= true;
						break;
					}
				}
				if(!flag) {
					pq.add(new int[] { e, Integer.MAX_VALUE });
				}
			}

			x = pq.poll()[0];
			set.remove(x);
			set.add(arr[i]);
			cnt++;
		}

		System.out.println(cnt);
	}
}