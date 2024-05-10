import java.io.*;
import java.util.*;

public class Main {
    static int a, b, c;
    static int[][][] dp = new int[101][101][101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1)
                return;

            System.out.println("w("+a+", "+b+ ", "+c+ ") = "+w(a,b,c));
        }

    }

    static int w(int a, int b, int c) {
        if (dp[a + 50][b + 50][c + 50] != 0)
            return dp[a + 50][b + 50][c + 50];

        if (a <= 0 || b <= 0 || c <= 0) {
            return dp[a + 50][b + 50][c + 50] = 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return dp[a + 50][b + 50][c + 50] = w(20, 20, 20);
        }

        if (a < b && b < c) {
            return dp[a + 50][b + 50][c + 50] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return dp[a + 50][b + 50][c + 50] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}