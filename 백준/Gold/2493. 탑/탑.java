import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= N; i++) {
			while(!stack.isEmpty()) {
				if(arr[stack.peek()] < arr[i]) {
					stack.pop();
				}else {
					System.out.print(stack.peek() + " ");
					stack.add(i);
					break;
				}	
			}
			
			if(stack.isEmpty()) {
				System.out.print("0 ");
				stack.add(i);
				continue;
			}
		}
	}
}