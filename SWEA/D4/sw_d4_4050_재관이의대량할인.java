package sw_d4_4050_재관이의대량할인;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			Integer[] arr = new Integer[N];
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr, Collections.reverseOrder());
			int result = 0;
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				if(i % 3 == 2 && cnt < N / 3) {
					cnt++;
					continue;
				}
				result += arr[i];
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}
