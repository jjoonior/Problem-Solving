import java.io.*;
import java.util.*;

public class Main {
	static int S, P, cnt;
	static String str;
	static Map<Character, Integer>[] ACGT;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		str = br.readLine();
		ACGT = new Map[2];
		ACGT[0] = new HashMap<>();
		ACGT[1] = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			ACGT[0].put("ACGT".charAt(i), Integer.parseInt(st.nextToken()));
		}

		cnt = 0;

		for (int i = 0; i < P; i++) {
			char C = str.charAt(i);

			if (!"ACGT".contains(Character.toString(C)))
				continue;

			ACGT[1].put(C, ACGT[1].getOrDefault(C, 0) + 1);
		}

		int s = 0;
		int e = P - 1;

		while (e < S) {
			boolean flag = true;
			for (int i = 0; i < 4; i++) {
				if (ACGT[0].get("ACGT".charAt(i)) > ACGT[1].getOrDefault("ACGT".charAt(i), 0)) {
					flag = false;
					break;
				}
			}

			if (flag) {
				cnt++;
			}

			ACGT[1].put(str.charAt(s), ACGT[1].getOrDefault(str.charAt(s), 0) - 1);
			s++;
			e++;
			if(e>=S) break;
			ACGT[1].put(str.charAt(e), ACGT[1].getOrDefault(str.charAt(e), 0) + 1);	
		}

		System.out.println(cnt);
	}
}
