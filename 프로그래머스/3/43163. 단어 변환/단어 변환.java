import java.util.*;

class Solution {
  boolean[] isVisited;

  public int solution(String begin, String target, String[] words) {
    int answer = 0;
    isVisited = new boolean[words.length];
    Queue<int[]> q = new LinkedList<>();

    for (int i = 0; i < words.length; i++) {
      if (!isVisited[i] && !words[i].equals(begin)) {
        int differenceCount = 0;

        for (int j = 0; j < words[i].length(); j++) {
          if (begin.charAt(j) != words[i].charAt(j)) {
            differenceCount++;
          }

          if (differenceCount > 1) {
            break;
          }
        }

        if (differenceCount == 1) {
          q.add(new int[]{i, 1});
        }
      }
    }

    while (!q.isEmpty()){
      int[] node = q.poll();
      if (isVisited[node[0]]){
        continue;
      }

      isVisited[node[0]] = true;

      if (words[node[0]].equals(target)) {
        return node[1];
      }

      for (int i = 0; i < words.length; i++) {
        if (!isVisited[i] && !words[i].equals(begin)) {
          int differenceCount = 0;

          for (int j = 0; j < words[node[0]].length(); j++) {
            if (words[node[0]].charAt(j) != words[i].charAt(j)) {
              differenceCount++;
            }

            if (differenceCount > 1) {
              break;
            }
          }

          if (differenceCount == 1) {
            q.add(new int[]{i, node[1] + 1});
          }
        }
      }
    }
    return 0;
  }
}