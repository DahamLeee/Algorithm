import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int month1 = sc.nextInt();
			int day1 = sc.nextInt();
			int month2 = sc.nextInt();
			int day2 = sc.nextInt();
			
			//
			int sum = 0;
			while(true) {
				if(month1 == month2) {
					sum += day2 - day1 + 1;
					break;
				}
				if(month1 < month2) {
					switch(month1) {
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						sum += 31 - day1 + 1;
						month1++;
						day1 = 1;
						break;
						
					case 2:
						sum += 28 - day1 + 1;
						month1++;
						day1 = 1;
						break;
						
					case 4:
					case 6:
					case 9:
					case 11:
						sum += 30 - day1 + 1;
						month1++;
						day1 = 1;
						break;
					}
				}
			}
			System.out.println("#" + test_case + " " + sum);
			
		}
		
	}

}
