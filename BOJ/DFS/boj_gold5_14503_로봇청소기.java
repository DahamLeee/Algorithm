package boj_gold5_14503_로봇청소기;

import java.util.Scanner;

public class Main {
	static int N, M;
	static int result;
	static int[][] map;
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 북, 동, 남, 서

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		int r = sc.nextInt();
		int c = sc.nextInt();
		int dir = sc.nextInt();

		map = new int[N][M];
		result = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 뒤에놈 찾기
		
		dfs(r, c, dir);
		System.out.println(result);
	}

	private static void dfs(int r, int c, int dir) {
		if(map[r][c] == 0) {
			map[r][c] = 2;
			result++;
		}
		boolean flag = false;
		
		for(int k = 0; k < 4; k++) { 
			int xx = r + dirs[(dir - k + 3) % 4][0];
			int yy = c + dirs[(dir - k + 3) % 4][1];
			if(map[xx][yy] == 0) { // 만약 맞는애가 있어?
				flag = true;
				dfs(xx, yy, (dir - k + 3) % 4);
				break;
			}
		}
		
		if(!flag) {
			if(map[(r + dirs[(dir + 2) % 4][0])][(c + dirs[(dir + 2) % 4][1])] != 1) {
				dfs((r + dirs[(dir + 2) % 4][0]),(c + dirs[(dir + 2) % 4][1]), dir);
			} else {
				return;
			}
		}
	}
}
