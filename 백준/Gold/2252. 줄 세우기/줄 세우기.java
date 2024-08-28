import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] cnt = new int[N];
		List<Integer>[] list = new List[N];
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			list[a].add(b);
			cnt[b]++;
		}
		
		for (int i = 0; i < N; i++) {
			if(cnt[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int u = q.poll();
			sb.append(u+1).append(" ");
			for(Integer v : list[u]) {
				if(--cnt[v] == 0) q.offer(v);
			}
		}
		
		System.out.println(sb);
	}
}
