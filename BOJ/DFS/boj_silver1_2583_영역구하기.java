package boj_silver1_2583_영역구하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Point{
		int r, c, sum;

		public Point(int r, int c, int sum) {
			super();
			this.r = r;
			this.c = c;
			this.sum = sum;
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int R, C, K;
	static boolean[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();

		map = new boolean[R][C]; // 7, 5
		visited = new boolean[R][C];
		// C, R, C, R
		for(int k = 0; k < K; k++) {
			int C1 = sc.nextInt(); // 무조건 왼쪽 위
			int R1 = sc.nextInt();
			
			int C2 = sc.nextInt(); // 무조건 오른쪽 아래
			int R2 = sc.nextInt();
			
			for(int i = R1; i < R2; i++) {
				for(int j = C1; j < C2; j++) {
					map[i][j] = true;
				}
			}
		}
		result = new ArrayList<>();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(!map[i][j] && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		for(int temp : result) {
			System.out.print(temp + " ");
		}
	}
	private static void bfs(int i, int j) {
		int sum = 1;
		int localMax = Integer.MIN_VALUE;
		visited[i][j] = true;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(i, j, sum));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			localMax = Math.max(localMax, p.sum);
			for(int k = 0; k < 4; k++) {
				int xx = p.r + dr[k];
				int yy = p.c + dc[k];
				if(isOk(xx, yy) && !map[xx][yy] && !visited[xx][yy]) {
					visited[xx][yy] = true;
					queue.add(new Point(xx, yy, ++sum));
				}
			}
		}
		result.add(localMax);
	}
	private static boolean isOk(int xx, int yy) {
		return xx >= 0 && xx < R && yy >= 0 && yy < C;
	}
}
