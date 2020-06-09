package boj_gold4_1987_알파벳;

import java.util.Scanner;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[] alphabet = new boolean[26];
	static char[][] map;
	static int R, C;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			map[i] = sc.next().toCharArray();
		}
		max = Integer.MIN_VALUE;
		dfs(0, 0, 1, 0); // 좌표, 이동한거리,
		System.out.println(max);
	}
	private static void dfs(int r, int c, int distance, int cnt) { // r, c : 좌표, distance 이동한 거리, cnt 종료조건
		if(r == 0 && c == 0) { // 만약 원점으로 돌아온다면 cnt 값을 증가해주고
			cnt++;
		}
		// 1. 처음 시작 0, 0 방문
		// 2. 왼쪽 다 돌고 오른쪽으로 돌아갈 때 0, 0 방문
		// 3. 오른쪽 다 돌고 왼쪽 가려고 할 때 0, 0 방문
		if(cnt == 3) { // 만약 0, 0을 3번 방문했다는것은 모든 경우를 탐색한거지
			return;
		}
		max = Math.max(distance, max);
		alphabet[map[r][c] - 'A'] = true; // 처음 왔을 때 방문
		for(int k = 0; k < 4; k++) {
			int xx = r + dr[k];
			int yy = c + dc[k];
			if(isOk(xx, yy) && !alphabet[map[xx][yy] - 'A']) {
				alphabet[map[xx][yy] - 'A'] = true;
				dfs(xx, yy, distance + 1, cnt);
				alphabet[map[xx][yy] - 'A'] = false;
			}
		}
	}
	private static boolean isOk(int xx, int yy) {
		return xx >= 0 && xx < R && yy >= 0 && yy < C;
	}
}
