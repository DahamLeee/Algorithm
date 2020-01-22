package notepad;

import java.util.Arrays;

class Car{
	public int speed;
	
}

public class Solution2 {
	
	public static void main(String[] args) {
		int a = 1, b = 3, c = 5, d = 7;
		int[] arr = {1, 3, 5, 7};
		memcpy(a, arr);
		System.out.println(a + " " + arr[0]);
		
		int[] brr = arr; // shaloow copy
		arr[1] = 13;
		System.out.println(brr[1]);
		
		int[] crr = new int[arr.length]; // deep copy
		for(int i = 0; i < arr.length; i++) {
			crr[i] = arr[i];
		}
		System.arraycopy(arr, 0, crr, 0, arr.length);
		System.out.println(Arrays.toString(arr));

		int[][] array = new int[2][2];
		
		Car[][] car = new Car[2][2];
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				car[i][j] = new Car();
			}
		}
	}

	static void memcpy(int ca, int[] cb) {
		ca++;
		System.out.println(ca);
		System.out.println("-------------");
		cb[0]++;
	}
}
