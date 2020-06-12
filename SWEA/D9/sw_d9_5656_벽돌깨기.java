package sw_d9_5656_벽돌깨기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
	static int[] dc = {0, 0, -1, 1};
	static int N, R, C;
	static int[] selected;
	static int[] arr;
	static int[][] map;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt(); // 횟수
			C = sc.nextInt();
			R = sc.nextInt();
			map = new int[R][C];
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			selected = new int[N];
			arr = new int[C];
			for(int i = 0; i < C; i++) {
				arr[i] = i;
			}
			// 중복 순열
			min = Integer.MAX_VALUE;
			permutation(0);
			System.out.println("#" + test_case + " " + min);
		}
	}
	private static void permutation(int idx) {
		if(idx == selected.length) {
			// selected가 공이 떨어질 위치인거임
			
			// 여기서 map을 deep copy 해야겠다
			int[][] temp = new int[R][C];
			deepCopy(temp);
			
			// (0, selected[i]);
			for(int i = 0; i < selected.length; i++) {
				down(0, selected[i], temp);
			}
			// 여기서의 temp 값의 최소를 가지고 와야겠다.
			int cnt = 0;
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(temp[i][j] != 0) {
						cnt++;
					}
				}
			}
			min = Math.min(cnt, min);
			return;
		}
		
		for(int i = 0; i < C; i++) {
			selected[idx] = arr[i];
			permutation(idx + 1);
		}
	}
	
	private static void down(int i, int j, int[][] temp) {
		// 해당 위치에서 떨궈서
		// 0이 아닌놈을 만났을 때, bfs 한 번 해주면 될 것 같음
		int xx = i; 
		int yy = j; 
		if(temp[xx][yy] != 0) {
			boolean[][] visited = new boolean[R][C];
			bfs(xx, yy, visited, temp);
		} else {
			while(true) {
				xx += dr[1];
				yy += dc[1];
				if(isOk(xx, yy)) { // 범위 계산
					if(temp[xx][yy] != 0) { // 0이 아닌 숫자면 해당 위치에서 bfs 계속 돌려주고
						// visited가 있는게 낫지 않을까? 그럴거 같아
						// bfs는 한 번만 하는 것이다.
						boolean[][] visited = new boolean[R][C];
						bfs(xx, yy, visited, temp);
						break;
					}
				} else {
					break;
				}
			}
		}
		
		// 각각의 값들을 다 중력 작용해야겠다.
		for(int r = R - 1; r >= 0; r--) {
			for(int c = 0; c < C; c++) {
				if(temp[r][c] == 0) {
					gravity(temp, r, c);
				}
			}
		}
	}
	private static void gravity(int[][] temp, int r2, int c2) {
		// 상은 index가 0임
		int xx = r2;
		int yy = c2;
		while(true) {
			xx += dr[0];
			yy += dc[0];
			if(isOk(xx, yy)) {
				if(temp[xx][yy] != 0) {
					temp[r2][c2] = temp[xx][yy];
					temp[xx][yy] = 0;
					return;
				}
			} else {
				return;
			}
		}
	}
	static class Point{
		int r, c, power;

		public Point(int r, int c, int power) {
			super();
			this.r = r;
			this.c = c;
			this.power = power;
		}
		
	}
	private static void bfs(int xx, int yy, boolean[][] visited, int[][] temp) {
		visited[xx][yy] = true;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(xx, yy, temp[xx][yy]));
		temp[xx][yy] = 0;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			// p.r, p.c, p.power
			int power = p.power;
			for(int i = 1; i < power; i++) {
				for(int k = 0; k < 4; k++) {
					int xxx = p.r + dr[k] * i;
					int yyy = p.c + dc[k] * i;
					if(isOk(xxx, yyy) && !visited[xxx][yyy]) { // 범위가 괜찮은지 알아보고
						visited[xxx][yyy] = true;
						queue.add(new Point(xxx, yyy, temp[xxx][yyy]));
						temp[xxx][yyy] = 0;
					}
				}
			}
		}
	}
	private static boolean isOk(int xx, int yy) {
		return xx >= 0 && xx < R && yy >= 0 && yy < C;
	}
	private static void deepCopy(int[][] temp) {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				temp[i][j] = map[i][j];
			}
		}
	}
}
