import java.io.*;
import java.util.*;

public class Main {
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		p = new int[V+1];
		
		for (int i = 1; i <= V; i++) {
			p[i]=i;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			int c =Integer.parseInt(st.nextToken());
			pq.add(new Edge(a,b,c));
		}

		int sum = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(findSet(edge.u) != findSet(edge.v)) {
				sum+= edge.w;
				union(edge.u, edge.v);
			}
		}
	
		System.out.println(sum);
	}
	
	static int findSet(int a) {
		return p[a] == a ? a : (p[a] = findSet(p[a]));
	}
	
	static void union(int a, int b) {
		p[findSet(a)] =  findSet(b);
	}
}

class Edge implements Comparable<Edge>{
	int u;
	int v;
	int w;
	
	public Edge(int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}
	
	public int compareTo(Edge o) {
		return this.w - o.w;
	}
}