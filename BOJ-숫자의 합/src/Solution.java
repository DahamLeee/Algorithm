import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int score = sc.nextInt();
		int sum = 0;
		
		for(int i = 0; i < num; i++) {
			int temp = score % 10;
			sum += temp;
			score /= 10;
		}
		
		System.out.println(sum);
	}

}
