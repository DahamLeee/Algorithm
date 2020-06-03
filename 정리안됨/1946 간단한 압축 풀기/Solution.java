import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int num = sc.nextInt();
			int flag = 0;
			System.out.println("#" + test_case);
			for(int i = 0; i < num; i++) {
				String s = sc.next();
				int time = sc.nextInt();
				char alpha = s.charAt(0);
				
				for(int j = 0; j < time; j++, flag++) {
					if(flag != 0 && flag % 10 == 0) {
						System.out.println("");
					}
					System.out.print(alpha);
				}
			}
			System.out.println("");
		}
	}
}
