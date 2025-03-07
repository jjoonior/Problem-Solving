import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    List<Integer> mooLengths = new ArrayList<>();
    mooLengths.add(3);  // S(0)의 길이

    while (mooLengths.get(mooLengths.size() - 1) < N) {
      int prevLength = mooLengths.get(mooLengths.size() - 1);
      mooLengths.add(prevLength * 2 + mooLengths.size() + 3);
    }

    System.out.println(getCharAtPosition(N, mooLengths));
  }

  private static char getCharAtPosition(int N, List<Integer> mooLengths) {
    int index = mooLengths.size() - 1;

    while (index >= 0) {
      int prevLength = (index == 0) ? 0 : mooLengths.get(index - 1);
      int middleLength = index + 3;

      if (N <= prevLength) {
        index--;
      } else if (N == prevLength + 1) {
        return 'm';
      } else if (N <= prevLength + middleLength) {
        return 'o';
      } else {
        N -= (prevLength + middleLength);
        index--;
      }
    }

    return 'o';  // 기본값 (이론상 도달하지 않음)
  }
}
