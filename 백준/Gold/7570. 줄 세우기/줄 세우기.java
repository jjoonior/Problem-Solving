import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> LIS = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Map<Integer, Integer> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int e = Integer.parseInt(st.nextToken());

			map.put(e, map.getOrDefault(e - 1, 0) + 1);
		}

		int max = 0;
		for (Integer v : map.values()) {
			max = Math.max(max, v);
		}

		System.out.println(N - max);
	}
}