import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int num = sc.nextInt();
			int[] arr = new int[1000];
			for(int i = 0; i < 1000; i++) {
				arr[i] = sc.nextInt();
			}
			
			int[] result = new int[101];
			for(int i = 0; i < arr.length; i++) {
				result[arr[i]]++;
			}
			int max = 0;
			int maxIndex = 0;
			for(int i = 0; i < 100; i++) {
				if(max <= result[i]) {
					max = result[i];
					maxIndex = i;
				}
			}
			System.out.println(maxIndex);
		}
//		int[] arr = new int[1000];
//		for(int i = 0; i < 1000; i++) {
//			arr[i] = sc.nextInt();
//		}
//		
//
//		int[] result = new int[101];
//		for(int i = 0; i < arr.length; i++) {
//			result[arr[i]]++;
//		}
//		int max = 0;
//		int maxIndex = 0;
//		for(int i = 0; i < 100; i++) {
//			if(max < result[i]) {
//				max = result[i];
//				maxIndex = i;
//			}
//		}
//		System.out.println(maxIndex);
		
		
	}

}
