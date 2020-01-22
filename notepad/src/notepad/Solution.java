package notepad;

import java.util.Arrays;
import java.util.Random;

public class Solution {
	
	public static void main(String[] args) {
		int[] arr = new int[5];
		for(int i = 0; i < 5; i++) {
			arr[i] = i + 1;
		}
		int number = (int)(Math.random() * 100) + 1;
		Random r = new Random();
		int score=  r.nextInt(100) + 1;
//		
//		System.out.println(number);
//		System.out.println(score);
//		
//		System.out.println(arr[1]);
	
		int[] lotto = new int[6];
		for(int i = 0; i < 6; i++) {
			boolean flag = true;
			int num = r.nextInt(45) + 1;
			for(int j = 0; j < i; j++) {
				if(lotto[j] == num) {
					flag = false;
					break;
				}
			}
			if(flag == true) {
				lotto[i] = num;
			}else {
				i--;
			}
		}
		Arrays.sort(lotto);
		for(int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i]);
		}
		
//		int k = 0;
//		int[] lotto1 = new int[6];
//		while(k < 6) {
//			boolean flag = true;
//			int temp = r.nextInt(45) + 1;
//			for(int i = 0; i < k; i++) {
//				if(lotto1[i] == temp) {
//					flag = false;
//					break;
//				}
//			}
//			if(flag == false) {
//				
//			}else {
//				lotto1[	k] = temp;
//				k++;
//			}
//		}
//		for(int i = 0; i < lotto1.length; i++) {
//			System.out.println(lotto1[i]);
//		}
		
	}
	
}
