import java.io.*;
import java.util.*;
class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();

			Stack<Character> stack = new Stack<>();
			boolean flag = false;

			for (int i = 0; i < N; i++) {
				char c = str.charAt(i);
				if (c == '(' || c == '{' || c == '[' || c == '<') {
					stack.add(c);
					continue;
				}

				switch (c) {
				case ')':
					if (stack.peek() != '(') {
						flag = true;
					}
					stack.pop();
					break;
				case '}':
					if (stack.peek() != '{') {
						flag = true;
					}
					stack.pop();
					break;
				case ']':
					if (stack.peek() != '[') {
						flag = true;
					}
					stack.pop();
					break;
				case '>':
					if (stack.peek() != '<') {
						flag = true;
					}
					stack.pop();
					break;
				}

				if (flag) {
					break;
				}
			}

			if (flag) {
				System.out.println("#" + t + " " + 0);
			} else {
				System.out.println("#" + t + " " + 1);
			}
		}
	}
}