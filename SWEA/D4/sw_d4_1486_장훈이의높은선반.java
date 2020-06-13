package sw_d4_1486_장훈이의높은선반;

import java.util.Scanner;

public class Solution {
	static int[] clerk;
	static int B;
	static boolean[] selected;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 이것은 clerk 수고용
			B = sc.nextInt(); // 이것은 넘겨야 하구용
			
			clerk = new int[N];
			selected = new boolean[N];
			for(int i = 0; i < N; i++) {
				clerk[i] = sc.nextInt();
			}
			
			powerset(0);
			System.out.println("#" + test_case + " " + min);
			min = Integer.MAX_VALUE;
		}
	}
	static void powerset(int idx) {
		if(idx == clerk.length) {
			int sum = 0;
			for(int i = 0; i < clerk.length; i++) {
				if(selected[i]) {
					sum += clerk[i];
				}
			}
			// sum => 14
			if(sum >= B && min > Math.abs(B - sum)) {
				min = Math.abs(B - sum);
			}
			return;
		}
		selected[idx] = true;
		powerset(idx + 1);
		selected[idx] = false;
		powerset(idx + 1);
	}
}
