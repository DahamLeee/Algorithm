package boj_gold5_17144_미세먼지;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {0, -1, 0, 1}; // 우, 상, 좌, 하 => 반시계
	static int[] dc = {1, 0, -1, 0};
	
	static int[] dr1 = {0, 1, 0, -1}; // 우, 하, 좌, 상 => 시계
	static int[] dc1 = {1, 0, -1, 0};
	static int cur;
	static int cur2;
	static int R, C;
	static boolean[][] visited;
	static int[][] map;
	static Point[] air;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		int T = sc.nextInt();
		air = new Point[2];
		
		map = new int[R][C];
		int idx = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == -1) { // 공기청정기의 위치
					air[idx++] = new Point(i, j);
				}
			}
		}
		// 확산되는 미세먼지 양은 일단 시작은 무조건 (R, C) / 5
		// 현재 위치에 남은 미세먼지의 양은 (R, C) - ((R, C) / 5) * (확산된 방향의 개수)
		
		for(int test_case = 0; test_case < T; test_case++) { // T만큼 돌아야겠지?
			// 미세먼지의 확산
			visited = new boolean[R][C];
			int[][] map2 = new int[R][C];
			
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(map[i][j] > 0) {
						spread(i, j, map2);
					}
				}
			}
			map2[air[0].r][air[0].c] = -1;
			map2[air[1].r][air[1].c] = -1;
			map = map2; // 이걸 그냥 바로 붙여  그러면 계속 spread하는거겠지?
			
			// 0 번째는 무조건 위이기 때문에 반시계방향
			cur2 = map[air[0].r + dr[0]][air[0].c + dc[0]];
			counterClock(air[0].r + dr[0], air[0].c + dc[0]);
			
			// 1 번째는 무조건 아래이기 때문에 시계방향
			cur2 = map[air[1].r + dr1[0]][air[1].c + dc1[0]];
			clock(air[1].r + dr1[0], air[1].c + dc1[0]);
			
		}
		int cnt = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] > 0) {
					cnt += map[i][j];
				}
			}
		}
		System.out.println(cnt);
	}
	private static void counterClock(int r2, int c2) { // 반시계 dr, dc
		map[r2][c2] = 0;
		int xx = r2; // 시작은 공기청정기 오른쪽
		int yy = c2;
		// 그럼 이 값을 저장해두고
		for(int k = 0; k < 4; k++) { 
			while(true) {
				cur = cur2; // 전의 값임
				xx += dr[k];
				yy += dc[k];
				if(xx == air[0].r && yy == air[0].c) {
					return;
				}

				if(!isOk(xx, yy)) {
					xx -= dr[k];
					yy -= dc[k];
					break;
				}
				// 만약 값의 범위를 통과했으면
				cur2 = map[xx][yy];
				map[xx][yy] = cur;
			}
		}
	}
	private static void clock(int r2, int c2) { // 시계 dr1, dc1
		map[r2][c2] = 0;
		int xx = r2;
		int yy = c2;
		for(int k = 0; k < 4; k++) {
			while(true) {
				cur = cur2;
				xx += dr1[k];
				yy += dc1[k];
				if(xx == air[1].r && yy == air[1].c) {
					return;
				}
				
				if(!isOk(xx, yy)) {
					xx -= dr1[k];
					yy -= dc1[k];
					break;
				}
				cur2 = map[xx][yy];
				map[xx][yy] = cur;
			}
		}
	}
	private static void spread(int i, int j, int[][] map2) {
		int num = map[i][j] / 5;
		int count = 0;
		for(int k = 0; k < 4; k++) {
			int xx = i + dr[k];
			int yy = j + dc[k];
			if(isOk(xx, yy) && map[xx][yy] != -1) {
				map2[xx][yy] += num;
				count++;
			}
		}
		map2[i][j] += map[i][j] - num * count;
	}
	private static boolean isOk(int xx, int yy) {
		return xx >= 0 && xx < R && yy >= 0 && yy < C;
	}
}
