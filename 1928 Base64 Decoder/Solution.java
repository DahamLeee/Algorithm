import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		Decoder decoder = Base64.getDecoder();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();
			
			byte[] decodedBytes = decoder.decode(str);
			
			System.out.println("#" + test_case + " " + new String(decodedBytes));
		}
	}

}
