import java.util.Scanner;

public class Solution {
	static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int time = sc.nextInt();
			char[][] input = new char[8][8];
			for(int i = 0; i < 8; i++) {
				char[] temp = sc.next().toCharArray();
				input[i] = temp;
			}
			
			for(int i = 0; i < 8; i++) {
				isColumnCal(input[i], time);
			}
			isRowCal(input, time);
			System.out.println("#" + test_case + " " + result);
			result = 0;
		}
		
	}

	static void isColumnCal(char[] str, int time) {
		for(int i = 0; i < str.length - time + 1; i++) {
			int flag = i;
			String string = "";
			for(int j = 0; j < time; j++) {
				string += String.valueOf(str[flag]);
				flag++;
			}
			isPal(string);
		}
	}
	static void isRowCal(char[][] str, int time) {
		for(int i = 0; i < 8; i++) {
			char[] temp = new char[8];
			for(int j = 0; j < 8; j++) {
				temp[j] = str[j][i];
			}
			isColumnCal(temp, time);
		}
	}
	static void isPal(String str) {
		for(int i = 0, j = str.length() - 1; i < str.length() / 2; i++, j --) {
			if(str.charAt(i) == str.charAt(j)) {
				
			}
			else {
				return;
			}
		}
		result++;
	}
}
