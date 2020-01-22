package day01;

public class WS_java_0120_이다함 {

	public static void main(String[] args) {
		char ch = 'A';
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < i + 1; j++) {
				System.out.print(ch++ + " ");
			}
			System.out.println("");
		}
	}

}
