package sw_d3_9940_순열1;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int[] arr = new int[100001]; // 0 ~ 100,000 까지
			boolean flag = false;
			int N = sc.nextInt();
			for(int i = 0; i < N; i++) {
				int num = sc.nextInt();
				if(arr[num] == 0) {
					arr[num] = 1;
				} else {
					flag = true;
				}
			}
			if(flag) { // 
				System.out.println("#" + test_case + " " + "No");
			} else { // 
				System.out.println("#" + test_case + " " + "Yes");
			}
		}
	}
}
