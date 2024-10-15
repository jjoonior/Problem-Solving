import java.io.*;
import java.util.*;

public class Main {
	static long N, P, Q;
	static Map<Long, Long> map;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());

		map = new HashMap<>();

		map.put(0L, 1L);

		System.out.println(f(N));
	}

	static long f(long k) {
		if(!map.containsKey(k)) {
			map.put(k, f(k/P) + f(k/Q));
		}
		
		return map.get(k);
	}
}
