import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int a = 0;
        int b = 0;
        int min = 100000;
        int sum = 0;

        if (Arrays.stream(arr).sum() < S) {
            System.out.println(0);
            return;
        }

        while (true) {
            if (sum >= S) {
                sum -= arr[a++];
                min = Math.min(min, (b - a + 1));
            } else if (b == N)
                break;
            else
                sum += arr[b++];
        }

        System.out.println(min);
    }
}

