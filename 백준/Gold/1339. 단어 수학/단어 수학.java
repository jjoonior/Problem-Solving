import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(br.readLine());
    Map<Character, Node> map = new HashMap<>();
    ArrayList<Node> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      String str = br.readLine();

      for (int j = 0; j < str.length(); j++) {
        char key = str.charAt(j);
        if (!map.containsKey(key)) {
          Node node = new Node(key, 0);
          map.put(key, node);
          list.add(node);
        }

        map.get(key).sum += (int) Math.pow(10, str.length() - j - 1);
      }
    }

    Collections.sort(list);

    int sum = 0;
    int v = 9;
    for (Node node : list) {
      sum += node.sum * v--;
    }

    System.out.println(sum);
  }
}

class Node implements Comparable<Node> {
  char c;
  int sum;

  Node(char c, int sum) {
    this.c = c;
    this.sum = sum;
  }

  @Override
  public int compareTo(Node o) {
    return o.sum - this.sum;
  }
}
