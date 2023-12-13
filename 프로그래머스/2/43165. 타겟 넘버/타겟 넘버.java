import java.util.*;

class Solution {
  int answer = 0;

  public int solution(int[] numbers, int target) {

    dfs(0, numbers[0], numbers, target);
    dfs(0, -numbers[0], numbers, target);

    return answer;
  }

  void dfs(int idx, int sum, int[] numbers, int target) {
    if (idx == numbers.length - 1) {
      if (sum == target) {
        answer++;
      }
      return;
    }

    dfs(idx + 1, sum + numbers[idx + 1], numbers, target);
    dfs(idx + 1, sum - numbers[idx + 1], numbers, target);
  }
}