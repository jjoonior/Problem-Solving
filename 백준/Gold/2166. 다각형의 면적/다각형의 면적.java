import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
        long[] x = new long[N + 1];
        long[] y = new long[N + 1];
        long sum_a = 0, sum_b = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        x[N] = x[0];
        y[N] = y[0];

        for (int i = 0; i < N; i++) {
            sum_a += x[i] * y[i + 1];
            sum_b += x[i + 1] * y[i];
        }

        String area = String.format("%.1f", (Math.abs(sum_a - sum_b) / 2.0));
        System.out.println(area);
    }
}