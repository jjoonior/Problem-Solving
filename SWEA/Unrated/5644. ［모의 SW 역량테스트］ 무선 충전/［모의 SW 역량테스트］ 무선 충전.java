import java.io.*;
import java.util.*;

public class Solution {
  static int M, A, max;
  static User userA, userB;
  static AP[] ap;

  static int[] dy = {0, -1, 0, 1, 0};
  static int[] dx = {0, 0, 1, 0, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      A = Integer.parseInt(st.nextToken());

      // 유저 A 정보 저장
      userA = new User(0, 0, new int[M + 1]);
      st = new StringTokenizer(br.readLine());
      userA.t[0] = 0;
      for (int i = 1; i <= M; i++) {
        userA.t[i] = Integer.parseInt(st.nextToken());
      }

      // 유저 B 정보 저장
      userB = new User(9, 9, new int[M + 1]);
      st = new StringTokenizer(br.readLine());
      userB.t[0] = 0;
      for (int i = 1; i <= M; i++) {
        userB.t[i] = Integer.parseInt(st.nextToken());
      }

      // AP 정보 저장
      ap = new AP[A];
      for (int i = 0; i < A; i++) {
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        ap[i] = new AP(i, x, y, c, p);
      }

      max = 0;

      for (int i = 0; i <= M; i++) {
        move(i);
      }
      sb.append("#").append(t).append(" ").append(max).append("\n");
    }
    System.out.println(sb);
  }

  static void move(int t) {
    userA.y += dy[userA.t[t]];
    userA.x += dx[userA.t[t]];

    userB.y += dy[userB.t[t]];
    userB.x += dx[userB.t[t]];

    int sum = findIncludeAPAndCalPower();
    max += sum;
  }

  static int findIncludeAPAndCalPower() {
    int sum = 0;
    for (int i = 0; i < A; i++) {
      for (int j = 0; j < A; j++) {
        if (i == j) {
          sum = Math.max(Math.max(getDistance(userA, ap[i]), getDistance(userB, ap[j])), sum);
        } else {
          sum = Math.max(getDistance(userA, ap[i])+ getDistance(userB, ap[j]), sum);
        }
      }
    }

    return sum;
  }

  static int getDistance(User user, AP ap) {
    int d = Math.abs(user.y - ap.y) + Math.abs(user.x - ap.x);
    return d <= ap.c ? ap.p : 0;
  }

  static int sumBC(List<AP> APointAPList, List<AP> BPointAPList) {
    if (APointAPList.isEmpty() && BPointAPList.isEmpty()) {
      return 0;
    }

    if (APointAPList.isEmpty())
      return BPointAPList.get(0).p;

    if (BPointAPList.isEmpty())
      return APointAPList.get(0).p;

    if (APointAPList.get(0).idx == BPointAPList.get(0).idx) {
      if (APointAPList.size() >= 2 && BPointAPList.size() >= 2)
        return APointAPList.get(0).p + Math.max(APointAPList.get(1).p, BPointAPList.get(1).p);

      if (APointAPList.size() >= 2)
        return APointAPList.get(1).p + BPointAPList.get(0).p;

      if (BPointAPList.size() >= 2)
        return APointAPList.get(0).p + BPointAPList.get(1).p;
    }
    return APointAPList.get(0).p + BPointAPList.get(0).p;
  }
}

class User {
  int y;
  int x;
  int[] t;

  public User(int y, int x, int[] t) {
    this.y = y;
    this.x = x;
    this.t = t;
  }
}

class AP implements Comparable<AP> {
  int idx;
  int y;
  int x;
  int c;
  int p;

  public AP(int idx, int y, int x, int c, int p) {
    this.idx = idx;
    this.y = y;
    this.x = x;
    this.c = c;
    this.p = p;
  }

  @Override
  public int compareTo(AP o) {
    return o.p - this.p;
  }
}
