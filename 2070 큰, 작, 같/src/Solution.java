import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			System.out.print("#" + test_case);
			
			if(num1 > num2) {
				System.out.println(" >");
			}
			else if(num1 < num2) {
				System.out.println(" <");
			}else {
				System.out.println(" =");
			}
		}
	}
}
