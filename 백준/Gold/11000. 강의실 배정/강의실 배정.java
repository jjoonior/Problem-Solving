import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Node> nodes = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			nodes.add(new Node(s, e));
		}
		Collections.sort(nodes);

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.e - o2.e);
		int cnt = 0;
		int min = 0;
		for (Node node : nodes) {
			if (!pq.isEmpty() && node.s >= pq.peek().e) {
				pq.poll();
				pq.add(node);
				continue;
			}
			pq.add(node);
			min = Math.max(++cnt, min);
		}

		System.out.println(min);
	}
}

class Node implements Comparable<Node> {
	int s;
	int e;

	Node(int s, int e) {
		this.s = s;
		this.e = e;
	}

	public int compareTo(Node o) {
		return this.s == o.s ? this.e - o.e : this.s - o.s;
	}
}
