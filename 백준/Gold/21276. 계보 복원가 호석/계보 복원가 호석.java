import java.io.*;
import java.util.*;

//21276
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Map<String, Integer> cnt = new HashMap<>();
		Map<String, Set<String>> childList = new TreeMap<>();
		Map<String, Set<String>> cList = new TreeMap<>();
		Queue<String> q = new LinkedList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			String name = st.nextToken();
			cnt.put(name, 0);
			childList.put(name, new TreeSet<>());
			cList.put(name, new TreeSet<>());
		}

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			childList.get(b).add(a);
			cnt.put(a, cnt.get(a) + 1);
		}

		int K = 0;
		for (String name : cnt.keySet()) {
			if (cnt.get(name) == 0) {
				K++;
				sb.append(name).append(" ");
				q.add(name);
			}
		}
		sb.append("\n");

		while (!q.isEmpty()) {
			String name = q.poll();

			Set<String> list = childList.get(name);

			for (String str : list) {
				int k = cnt.get(str) - 1;
				cnt.put(str, k);
				
				if (k == 0) {
					q.offer(str);
					cList.get(name).add(str);
				}
			}
		}

		for(String name: cList.keySet()) {
			 Set<String> list = cList.get(name);
			sb.append(name).append(" ").append(list.size());
			for(String child: list) {
				sb.append(" ").append(child);
			}
			sb.append("\n");
		}

		System.out.println(K);
		System.out.println(sb);
	}
}
