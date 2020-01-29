import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int lenA = sc.nextInt();
			int lenB = sc.nextInt();
			
			int[] A = new int[lenA];
			int[] B = new int[lenB];
			
			for(int i = 0; i < lenA; i++) {
				A[i] = sc.nextInt();
			}
			for(int i = 0; i < lenB; i++) {
				B[i] = sc.nextInt();
			}
			int max = 0;
			int sum = 0;
			if(lenA > lenB) { // B가 더 작아
				for(int i = 0; i < lenA - lenB + 1; i++) {
					sum = 0;
					for(int j = 0, k = i; j < lenB; j++, k++) {
						sum += B[j] * A[k];
					}
					if(max < sum) {
						max = sum;
					}
				}
			}else { // A가 더 작아
				for(int i = 0; i < lenB - lenA + 1; i++) {
					sum = 0;
					for(int j = 0, k = i; j < lenA; j++, k++) {
						sum += A[j] * B[k];
					}
					if(max < sum) {
						max = sum;
					}
				}
			}
			System.out.println("#" + test_case + " " + max);
				
		}
	}

}
