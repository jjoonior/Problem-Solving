import java.io.*;
import java.util.*;

public class Solution {
	static int N, start, max, answer;
	static boolean[] visited;
	static Set<Integer>[] nextList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			visited = new boolean[101];
			nextList = new Set[101];

			for (int i = 1; i <= 100; i++) {
				nextList[i] = new HashSet<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				nextList[from].add(to);
			}

			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {start,0});
			max = answer = 0;
			visited[start] = true;
            
            while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				if (cur[1] > max) {
					max = cur[1];
					answer = cur[0];
				} else if (cur[1] == max) {
					answer = Math.max(answer, cur[0]);
				}
				
				for (Integer next : nextList[cur[0]]) {
					if (!visited[next]) {
						visited[next] = true;
						q.offer(new int[] {next, cur[1] + 1});
					}
				}
				
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}
}
