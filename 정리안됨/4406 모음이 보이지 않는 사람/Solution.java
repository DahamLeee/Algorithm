import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Character> queue = new LinkedList<Character>();
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();
			
			for(int i = 0; i < str.length(); i++) {
				queue.add(str.charAt(i));
			}
			
			System.out.print("#" + test_case + " ");
			while(!queue.isEmpty()) {
				char temp = queue.poll();
				if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
					
				}else {
					System.out.print(temp);
				}
			}
			System.out.println();
		}
	}

}
