import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int len = sc.nextInt();
			int[] obstacle = new int[len];
			
			for(int i = 0; i < len; i++) {
				obstacle[i] = sc.nextInt();
			}
			int up = 0;
			int down = 0;
			for(int i = 0; i < len - 1; i++) {
				if(obstacle[i] < obstacle[i + 1]) {
					if(up < obstacle[i + 1] - obstacle[i]) {
						up = obstacle[i + 1] - obstacle[i];
					}
				}else {
					if(down < obstacle[i] - obstacle[i + 1]) {
						down = obstacle[i] - obstacle[i + 1];
					}
				}
			}
			System.out.println("#" + test_case + " " + up + " " + down);
		}
	}

}
