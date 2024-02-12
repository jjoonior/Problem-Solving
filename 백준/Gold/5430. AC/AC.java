import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();

            StringTokenizer stk = new StringTokenizer(br.readLine(), "[],");

            for (int i = 0; i < n; i++) {
                deque.addLast(Integer.parseInt(stk.nextToken()));
            }


            boolean x = true; // false 면 뒤집힌상태
            boolean error = false;

            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    x=!x;
                } else if (p.charAt(i) == 'D') {
                    if (deque.size() == 0) {
                        error = true;
                        break;
                    }

                    if (x)
                        deque.removeFirst();
                    else
                        deque.removeLast();
                }
            }


//            if (error)
//                System.out.println("error");
//            else {
//                System.out.print("[");
//                if (x) {
//                    while (!deque.isEmpty()) {
//                        System.out.print(deque.pollFirst());
//                        if (deque.size() != 0)
//                            System.out.print(',');
//                    }
//                } else {
//                    while (!deque.isEmpty()) {
//                        System.out.print(deque.pollLast());
//                        if (deque.size() != 0)
//                            System.out.print(',');
//                    }
//                }
//                System.out.println("]");
//            }
            if (error)
                System.out.println("error");
            else {
                StringBuilder sb = new StringBuilder("[");
                while (!deque.isEmpty()) {
                    sb.append(x ? deque.removeFirst() : deque.removeLast());
                    if (deque.size() != 0)
                        sb.append(',');
                }
                sb.append(']');

                System.out.println(sb.toString());
            }
        }
    }
}
