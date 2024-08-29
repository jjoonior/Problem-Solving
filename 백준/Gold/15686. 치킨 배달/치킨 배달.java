import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] home;
    static int[][] chicken;
    static int home_cnt = 0;
    static int chicken_cnt = 0;
    static int[][] arr;
    static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        home = new int[N * N][2];
        chicken = new int[N * N][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int x = Integer.parseInt(st.nextToken());

                if (x == 1) {
                    home[home_cnt][0] = i;
                    home[home_cnt][1] = j;
                    home_cnt++;
                } else if (x == 2) {
                    chicken[chicken_cnt][0] = i;
                    chicken[chicken_cnt][1] = j;
                    chicken_cnt++;
                }
            }
        }

        arr = new int[chicken_cnt][2];

        func(0, 0);
        System.out.println(Collections.min(list));

    }

    static void func(int m, int idx) {
        if (m == M) {
            list.add(len());
            return;
        }

        for (int i = idx; i < chicken_cnt; i++) {
            arr[m][0] = chicken[i][0];
            arr[m][1] = chicken[i][1];
            func(m + 1, i + 1);

        }
    }


    static int len() {
        int sum = 0;
        for (int i = 0; i < home_cnt; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < M; j++) {
                min = Math.min(min, Math.abs(home[i][0] - arr[j][0]) + Math.abs(home[i][1] - arr[j][1]));
            }
            sum += min;
        }

        return sum;
    }
}