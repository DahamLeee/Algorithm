package sw_d4_5432_쇠막대기_자르기;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String temp = sc.next();
			Stack<Character> stack = new Stack<Character>();
			
			int sum = 0;
			
			for(int i = 0; i < temp.length(); i++) {
				if(temp.charAt(i) == '(') {
					stack.push(temp.charAt(i));
				}
				else if(temp.charAt(i) == ')') {
					stack.pop();
					if(temp.charAt(i - 1) == ')') {
						sum++;
					}
					else {
						sum += stack.size();
					}
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}

}
