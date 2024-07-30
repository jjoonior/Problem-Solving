import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Node[] list = new Node[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[i] = new Node(s,e);
		}
		
		Arrays.sort(list);
		
		int s = list[0].s;
		int e = list[0].e;
		int cnt = 0;
		
		for (int i = 1; i < list.length; i++) {
			if(list[i].s <= e) {
				e = Math.max(list[i].e, e);
			}else {
				cnt += e-s;
				s= list[i].s;
				e= list[i].e;
			}
		}
		
		System.out.println(cnt + e - s);
	}
}

class Node implements Comparable<Node>{
	int s;
	int e;
	
	public Node(int s, int e) {
		this.s = s;
		this.e = e;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.s == o.s ? this.e - o.e : this.s-o.s;
	}
}