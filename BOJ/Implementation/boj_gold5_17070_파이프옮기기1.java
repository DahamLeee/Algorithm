package boj_gold5_17070_파이프옮기기1;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static int result;
	static int[] dr = {0, 1, 1}; // 우, 하, 우하
	static int[] dc = {1, 0, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		Point prefix = new Point(0, 0);
		Point suffix = new Point(0, 1);
		
		result = 0;
		dfs(prefix, suffix);
		
		// 일단 dfs로 해야 될 듯
		// 그러고 나서 base 에 도달하게 된다면
		// plus
		System.out.println(result);
	}
	
	private static void dfs(Point prefix, Point suffix) {
		if(suffix.r == N - 1 && suffix.c == N - 1) { // 파이프의 한쪽이 도착!
			result++;
			return;
		}
		// 여기서 지금 현재 상태가 가로인지, 세로인지, 대각선인지 확인을 해준다.
		int row = prefix.r - suffix.r;
		int column = prefix.c - suffix.c;
		
		// 일단 suffix가 왔다는 의미는 prefix가 suffix가 될 수 있다는 말이겠죠?
		// 오른쪽 대각선 탐색하는 함수하나 만들어야겠다
		if(row == 0 && column < 0) { // 현재 상태 가로
			// suffix는 column 하나 증가
			if(suffix.c + 1 < N && map[suffix.r][suffix.c + 1] == 0) {
				dfs(new Point(suffix.r, suffix.c), new Point(suffix.r, suffix.c + 1));
			}
			// suffix는 오른쪽 아래로 감
			if((suffix.r + 1) < N && (suffix.c + 1) < N && isOk(suffix.r, suffix.c)) {
				dfs(new Point(suffix.r, suffix.c), new Point(suffix.r + 1, suffix.c + 1));
			}
		} else if(row < 0 && column == 0) { // 현재 상태 세로
			// suffix는 row하나 증가
			if(suffix.r + 1 < N && map[suffix.r + 1][suffix.c] == 0) {
				dfs(new Point(suffix.r, suffix.c), new Point(suffix.r + 1, suffix.c));
			}
			// suffix는 오른쪽 아래로 감
			if(suffix.r + 1 < N && suffix.c + 1 < N && isOk(suffix.r, suffix.c)) {
				dfs(new Point(suffix.r, suffix.c), new Point(suffix.r + 1, suffix.c + 1));
			}
		} else if(row < 0 && column < 0) { // 현재 상태 대각선
			// suffix는 row 하나 증가
			if(suffix.r + 1 < N && map[suffix.r + 1][suffix.c] == 0) {
				dfs(new Point(suffix.r, suffix.c), new Point(suffix.r + 1, suffix.c));
			}
			// suffix는 column 하나 증가
			if(suffix.c + 1 < N && map[suffix.r][suffix.c + 1] == 0) {
				dfs(new Point(suffix.r, suffix.c), new Point(suffix.r, suffix.c + 1));
			}
			// suffix는 오른쪽 아래로 감
			if(suffix.r + 1 < N && suffix.c + 1 < N && isOk(suffix.r, suffix.c)) {
				dfs(new Point(suffix.r, suffix.c), new Point(suffix.r + 1, suffix.c + 1));
			}
		}
	}
	
	public static boolean isOk(int r, int c) {
		for(int k = 0; k < dr.length; k++) {
			int xx = r + dr[k];
			int yy = c + dc[k];
			if(xx >= 0 && xx < N && yy >= 0 && yy < N && map[xx][yy] == 1) {
				return false;
			}
		}
		return true;
	}

	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
}
