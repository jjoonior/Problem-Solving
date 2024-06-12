import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int bCnt = N/b;
		int min = -1;
		
		while(bCnt >= 0){
			if((N - b * bCnt) % a == 0){
				min = bCnt + (N - b * bCnt) / a;
				break;
			}
			bCnt--;
		}
		
		System.out.println(min);
	}
}