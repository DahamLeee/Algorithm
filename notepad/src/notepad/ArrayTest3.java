package notepad;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayTest3 {
	/*
	 * 2차원 배열의 갯수와 좌표를 입력받아서 해당 좌표의 상하좌우에 1을 입력하고
	 * 배열을 출력하는 프로그램을 작성하세요.
	 * 4 <= row, column <= 20
	 * 10 * 10 배열에 길이가 3인 포를 3방으로 랜덤으로 쏩니다
	 * 이 포는 8방으로 길이만큼 ++ 증가하는데 가장 큰 값을 출력하세요
	 * 
	 */
	public static void main(String[] args) {
		int row, column = 0;
		Scanner sc = new Scanner(System.in);
//		System.out.print("배열의 개수 (row, column) : ");
//		row = sc.nextInt();
//		column = sc.nextInt();
		
		Random r = new Random();
		
//		System.out.println("좌표 입력 (x, y) : ");
//		int x, y = 0;
//		x = sc.nextInt(); // 상, 하
//		y = sc.nextInt(); // 좌, 우
		
//		System.out.println("폭탄의 위력을 입력해주세요 : ");
//		int power = 0;
//		power = sc.nextInt();
		
		int[][] arr = new int[10][10];
		
		int[] dr = {0, 0, 1, -1, 1, 1, -1, -1}; // 상, 하, 좌, 우, 오아래, 오른위 , 왼아래 , 왼위
		int[] dc = {1, -1, 0, 0, 1, -1, 1, -1}; // 
		
		for(int k = 0; k < 3; k++) {
			int x = r.nextInt(10);
			int y = r.nextInt(10);
			for(int i = 0; i < 8; i++) {
				for(int j = 1; j <= 3; j++) {
					int xx = x + dr[i] * j; // 위, 아래
					if(xx >= 10 || xx < 0) {
						continue;
					}
					int yy = y + dc[i] * j; // 좌, 우
					if(yy >= 10 || yy < 0) {
						continue;
					}
					arr[xx][yy]++;
				}
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(max < arr[i][j]) {
					max = arr[i][j];
				}
			}
		}
		System.out.println("Max : " + max);
	}
}
