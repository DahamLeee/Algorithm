import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			// char[] input = sc.next().toCharArray();
			int count = 0;
			Stack<Character> stack = new Stack<Character>();
			stack.push('0');
			String str = sc.next();
			for(int i = 0; i < str.length(); i++) {
				stack.push(str.charAt(i));
			}
			while(true) {
				char temp = stack.pop();
				if(stack.isEmpty()) {
					break;
				}
				char top = stack.peek();
				if(temp != top) {
					count++;
				}
			}
			
			System.out.println("#" + test_case + " " + count);
			stack.removeAllElements();
		}
		
		
	}
}
