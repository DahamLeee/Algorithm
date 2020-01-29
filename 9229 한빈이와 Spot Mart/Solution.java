import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int num = sc.nextInt();
			int limit = sc.nextInt();
			int max = 0;
			int[] snack = new int[num];
			
			for(int i = 0; i < num; i++) {
				snack[i] = sc.nextInt();
			}
			
			for(int i = 0; i < num - 1; i++) {
				for(int j = i + 1; j < num; j++) {
					if(snack[i] + snack[j] <= limit && max < snack[i] + snack[j]) {
						max = snack[i] + snack[j];
					}
				}
			}
			if(max == 0) {
				System.out.println("#" + test_case + " " + -1);
			}else {
				System.out.println("#" + test_case + " " + max);
			}
		}
	}

}
