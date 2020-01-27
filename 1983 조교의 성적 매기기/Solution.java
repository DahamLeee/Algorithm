import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T;
		T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int num = sc.nextInt();
			int target = sc.nextInt();
			int rank = 1;
			
			int[][] score = new int[num][3];
			double[] sum = new double[num];	
			// 0 : 중간(35%), 1 : 기말(45%), 2 : 과제(20%)
			for(int i = 0; i < num; i++) {
				for(int j = 0; j < 3; j++) {
					score[i][j] = sc.nextInt();
				}
				sum[i] = ((double)score[i][0] * 0.35) + ((double)score[i][1] * 0.45) + ((double)score[i][2] * 0.2);
			}
			for(int i = 0; i < num; i++) {
				if(sum[i] > sum[target - 1]) {
					rank++;
				}
			}
			System.out.print("#" + test_case + " ");
			printRank(num, rank);
		}
	}
	static void printRank(int num, int rank) {
		double temp = Math.ceil(rank / (num / 10.0));
		int rate = (int)temp;
		switch(rate) {
		case 1:
			System.out.print("A+");
			break;
		case 2:
			System.out.print("A0");
			break;
		case 3:
			System.out.print("A-");
			break;
		case 4:
			System.out.print("B+");
			break;
		case 5:
			System.out.print("B0");
			break;
		case 6:
			System.out.print("B-");
			break;
		case 7:
			System.out.print("C+");
			break;
		case 8:
			System.out.print("C0");
			break;
		case 9:
			System.out.print("C-");
			break;
		case 10:
			System.out.print("D-");
			break;
		}
	}
}
