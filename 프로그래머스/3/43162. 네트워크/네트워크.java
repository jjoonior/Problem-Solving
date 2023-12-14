import java.util.*;

class Solution {
  boolean[] isVisited;

  public int solution(int n, int[][] computers) {
    int answer = 0;

    isVisited = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (isVisited[i] == false) {
        answer++;
        dfs(i, n, computers);
      }
    }

    return answer;
  }

  void dfs(int idx, int n , int[][] computers) {
    if (isVisited[idx]) {
      return;
    }

    isVisited[idx] = true;

    for (int i = 0; i < n; i++) {
      if (computers[idx][i] == 1) {
        dfs(i, n, computers);
      }
    }
  }
}