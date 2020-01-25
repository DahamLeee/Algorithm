import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int[] arr = new int[5];
			int num = sc.nextInt();
			solve(num, arr);

			System.out.print("#");
			for(int i = 0; i < 5; i++) {
				System.out.print(" " + arr[i]);
			}
			System.out.println("");
		}
		sc.close();
	}

	static void solve(int num, int[] arr) {
		int count = 2;
		while (!(num == 1)) {
			if (num % count == 0) {
				switch (count) {
				case 2:
					arr[0]++;
					num /= 2;
					break;
				case 3:
					arr[1]++;
					num /= 3;
					break;
				case 5:
					arr[2]++;
					num /= 5;
					break;
				case 7:
					arr[3]++;
					num /= 7;
					break;
				case 11:
					arr[4]++;
					num /= 11;
					break;
				default:
					num /= count;
					break;
				}
			} else {
				count++;
			}
		}

	}

}
