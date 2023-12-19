import java.util.*;
import java.util.stream.Collectors;

class Solution {
  public int solution(int n, int[] lost, int[] reserve) {
    Set<Integer> lostSet = Arrays.stream(lost).boxed().collect(Collectors.toCollection(TreeSet::new));
    Set<Integer> reserveSet = Arrays.stream(reserve).boxed().collect(Collectors.toCollection(TreeSet::new));
    Set<Integer> tmp = new HashSet<>(lostSet);

    tmp.retainAll(reserveSet);
    lostSet.removeAll(tmp);
    reserveSet.removeAll(tmp);

    int answer = n - lostSet.size();
    for (Integer x : lostSet) {
      if (reserveSet.contains(x - 1)) {
        answer++;
        reserveSet.remove(x - 1);
      } else if (reserveSet.contains(x + 1)) {
        answer++;
        reserveSet.remove(x + 1);
      }
    }
    
    return answer;
  }
}