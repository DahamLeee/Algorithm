package sw_d9_1953_탈주범검거;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	// 1. 상, 하, 좌, 우
	// 2. 상, 하
	// 3. 좌, 우
	// 4. 상, 우
	// 5. 하, 우
	// 6. 하, 좌
	// 7. 상, 좌
	static int[][] dr = {{-1, 1, 0, 0}, {-1, 1}, {0, 0}, {-1, 0}, {1, 0}, {1, 0}, {-1, 0}};
	static int[][] dc = {{0, 0, -1, 1}, {0, 0}, {-1, 1}, {0, 1}, {0, 1}, {0, -1}, {0, -1}};
	// 이걸 어떻게 잘 짜볼까나.. ㅠ_ㅠ
	// 이중배열로 하면 되려나
	
	static int[][] map;
	static int[][] visited;
	static int N;
	static int M;
	static int L;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt(); // 세로
			M = sc.nextInt(); // 가로
			int R = sc.nextInt(); // 맨홀 뚜껑이 위치한장소의 세로 위치 R
			int C = sc.nextInt(); // 가로 위치 C
			L = sc.nextInt(); // 탈출 후 소요된 시간 L
			
			map = new int[N][M];
			visited = new int[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt() - 1;
				}
			}
			result = 0;
			bfs(R, C);
			System.out.println("#" + test_case + " " + result);
		}
	}
	static class Point{
		int r, c, time;

		public Point(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	private static void bfs(int r, int c) {
		visited[r][c] = 1;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c, 1));
		
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			if(temp.time == L) {
				break;
			}
			int len = map[temp.r][temp.c];
			for(int k = 0; k < dr[len].length; k++) {
				int xx = temp.r + dr[len][k];
				int yy = temp.c + dc[len][k];
				if(xx >= 0 && xx < N && yy >= 0 && yy < M && visited[xx][yy] == 0 && map[xx][yy] >= 0) {
					// 여기서 체킹을 해야겠는데
					// 내가 움직인 값을 이용해서 지금 위치로 다시 이동을 할 수 있는가 없는가를 판별
					if(isOk(xx, yy, temp.r, temp.c)) {
						visited[xx][yy] = 1;
						queue.add(new Point(xx, yy, temp.time + 1));
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j] == 1) {
					result++;
				}
			}
		}
	}
	private static boolean isOk(int xx, int yy, int r, int c) { // xx, yy는 움직일 위치, r, c는 현재 위치
		int len = map[xx][yy];
		for(int k = 0; k < dr[len].length; k++) {
			int xxx = xx + dr[len][k];
			int yyy = yy + dc[len][k];
			if(xxx >= 0 && xxx < N && yyy >= 0 && yyy < M && xxx == r && yyy == c) {
				return true;
			}
		}
		return false;
	}
}
