import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			boolean[] dir = new boolean[10];
			int num = sc.nextInt();
			
			int count = 0;
			int temp = num;
			int lulu = 0;
			while(true) {
				boolean flag = true;
				while(true) {
					if(temp == 0) {
						break;
					}
					dir[temp % 10] = true;
					temp /= 10;
				}
				for(int i = 0; i < dir.length; i++) {
					if(!dir[i]) {
						flag = false;
					}
				}
				if(flag) {
					break;
				}
				temp = num * count;
				lulu = temp;
				count++;
			}
			System.out.println("#" + test_case + " " + lulu);
		}
	}

}
