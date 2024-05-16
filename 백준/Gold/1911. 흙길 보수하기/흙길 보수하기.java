import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    List<Node> list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      list.add(new Node(s, e));
    }

    Collections.sort(list);

    int cnt = 0;
    int idx = 0;
    int i = 0;
    while (idx < list.get(list.size() - 1).e) {
      if (idx >= list.get(i).s) {
        if (idx < list.get(i).e) {
          idx += L;
          cnt++;
        } else {
          i++;
        }
      } else {
        idx = list.get(i).s;
      }
    }

    System.out.println(cnt);
  }
}

class Node implements Comparable<Node> {
  int s;
  int e;

  Node(int s, int e) {
    this.s = s;
    this.e = e;
  }

  @Override
  public int compareTo(Node o) {
    return this.s - o.s;
  }
}
