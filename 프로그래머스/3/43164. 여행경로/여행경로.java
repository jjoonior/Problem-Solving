import java.util.*;
import java.util.stream.Collectors;

class Solution {
  boolean[] isVisited;
  Stack<String> stack = new Stack<>();
  String[] answer = {};

  public String[] solution(String[][] tickets) {
    isVisited = new boolean[tickets.length];
    for (int i = 0; i < tickets.length; i++) {
      if (tickets[i][0].equals("ICN")) {
        isVisited[i] = true;
        stack.push(tickets[i][0]);
        dfs(i, tickets);
        stack.clear();
        isVisited[i] = false;
      }
    }
    return answer;
  }

  void dfs(int idx, String[][] tickets) {
    if (stack.size() == tickets.length) {
      String[] temp = stack.toArray(new String[tickets.length + 1]);
      temp[tickets.length] = tickets[idx][1];

      if (answer.length == 0) {
        answer = temp;
        return;
      }

      String tempString = Arrays.stream(temp)
          .collect(Collectors.joining());
      String answerString = Arrays.stream(answer)
          .collect(Collectors.joining());

      if (tempString.compareTo(answerString) < 0) {
        answer = temp;
      }

      return;
    }


    for (int i = 0; i < tickets.length; i++) {
      if (!isVisited[i] && tickets[idx][1].equals(tickets[i][0])) {
        isVisited[i] = true;
        stack.push(tickets[i][0]);
        dfs(i, tickets);
        stack.pop();
        isVisited[i] = false;
      }
    }
  }
}