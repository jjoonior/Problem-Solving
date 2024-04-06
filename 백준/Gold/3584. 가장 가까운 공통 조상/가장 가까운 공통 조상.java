import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());

      Map<Integer, Node> map = new HashMap<>();

      for (int j = 0; j < n - 1; j++) {
        st = new StringTokenizer(br.readLine());
        int ax = Integer.parseInt(st.nextToken());
        int bx = Integer.parseInt(st.nextToken());
        Node a = map.getOrDefault(ax, new Node(ax));
        Node b = map.getOrDefault(bx, new Node(bx));
        b.parent = a;

        map.put(a.x, a);
        map.put(b.x, b);
      }

      st = new StringTokenizer(br.readLine());
      Node a = map.get(Integer.parseInt(st.nextToken()));
      Node b = map.get(Integer.parseInt(st.nextToken()));

      Node cur = a;
      Queue<Integer> qa = new LinkedList<>();
      while (cur != null) {
        qa.offer(cur.x);
        cur = cur.parent;
      }

      cur = b;
      Queue<Integer> qb = new LinkedList<>();
      while (cur != null) {
        qb.offer(cur.x);
        cur = cur.parent;
      }

      int ans;
      while (true) {
        if (qa.size() != qb.size()) {
          if (qa.size() > qb.size()) {
            qa.poll();
          } else {
            qb.poll();
          }
          continue;
        }

        if ((ans = qa.poll()) == qb.poll()) {
          break;
        }
      }

      System.out.println(ans);
    }
  }
}

class Node{
  int x;
  Node parent = null;

  Node(int x){
    this.x = x;
  }
}