import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Pattern infoPattern = Pattern.compile("[3|6|9]");
		
		for(int i = 1; i <= N; i++) {
			String temp = Integer.toString(i);
			Matcher m = infoPattern.matcher(temp);
			if(m.find()) {
				for(int j = 0; j < temp.length(); j++) {
					if(temp.charAt(j) == '3' || temp.charAt(j) == '6' || temp.charAt(j) == '9') {
						System.out.print("-");
					}
				}
				System.out.print(" ");
			}
			else {
				System.out.print(temp + " ");
			}
		}
	}

}
