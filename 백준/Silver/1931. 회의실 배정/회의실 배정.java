import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    ArrayList<Time> timeList = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      timeList.add(new Time(s, e));
    }

    Collections.sort(timeList);

    int et = -1;
    int cnt = 0;
    for (Time t : timeList) {
      if (t.s >= et) {
        et = t.e;
        cnt++;
      }
    }

    System.out.println(cnt);
  }
}

class Time implements Comparable<Time>{
  int s;
  int e;

  Time(int s, int e) {
    this.s = s;
    this.e = e;
  }

  @Override
  public int compareTo(Time o) {
    if (this.e != o.e) {
      return this.e - o.e;
    } else {
      return this.s - o.s;
    }
  }
}