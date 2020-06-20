package sw_d4_1861_정사각형방;

import java.util.Scanner;

public class Solution {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int idx = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// 현재 위치 i, j
					for(int k = 0; k < 4; k++) {
						int count = 1;
						int xx = i + dr[k];
						int yy = j + dc[k];
						if(xx < 0 || xx >= N || yy < 0 || yy >= N) {
							continue;
						}
						if(map[i][j] + 1 != map[xx][yy]) {
							continue;
						}
						count++;
						while(true) {
							boolean flag = false;
							for(int u = 0; u < 4; u++) {
								int xxx = xx + dr[u];
								int yyy = yy + dc[u];
								
								if(xxx < 0 || xxx >= N || yyy < 0 || yyy >= N) {
									continue;
								}
								if(map[xx][yy] + 1 == map[xxx][yyy]) {
									xx = xxx;
									yy = yyy;
									count++;
									flag = true;
									continue;
								}
							}
							if(!flag) {
								break;
							}
						}
						if(max < count) {
							idx = map[i][j];
							max = count;
						}else if(max == count) {
							if(idx > map[i][j]) {
								idx = map[i][j];
							}
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + idx + " " + max);
		}
	}

}
