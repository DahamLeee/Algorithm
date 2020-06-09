package boj_gold5_3055_탈출;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Point {
		int r, c, min;

		public Point(int r, int c, int min) {
			super();
			this.r = r;
			this.c = c;
			this.min = min;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int R, C;
	static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = sc.next().toCharArray();
		}
		// '.' => 비어있는 곳
		// '*' => 물이 차있어
		// 'X' => 돌
		// 'D' => 비버의 굴
		// 'S' => 고슴도치의 위치

		// 일단 물이 있는 곳을 찾아야징
		// 그리고 고슴도치의 위치도 찾아야 함
		int sRow = 0;
		int sCol = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					sRow = i;
					sCol = j;
				}
			}
		}
		int result = 0;
		// 물이 먼저 차고 그 다음 움직인다
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(sRow, sCol, 0));
		L: while (!queue.isEmpty()) {
			// 물이 먼저 이동...?
			boolean[][] visited = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == '*' && !visited[i][j]) {
						for (int k = 0; k < 4; k++) {
							int xx = i + dr[k];
							int yy = j + dc[k];
							if (isOk(xx, yy) && !visited[xx][yy] && map[xx][yy] == '.') {
								visited[xx][yy] = true;
								map[xx][yy] = '*';
							}
						}
					}
				}
			}
			visited = new boolean[R][C];
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Point p = queue.poll();
				for (int k = 0; k < 4; k++) {
					int xx = p.r + dr[k];
					int yy = p.c + dc[k];
					if (isOk(xx, yy) && !visited[xx][yy]) {
						if (map[xx][yy] == 'D') {
							result = p.min + 1;
							break L;
						} else if (map[xx][yy] == '.') {
							queue.add(new Point(xx, yy, p.min + 1));
							visited[xx][yy] = true;
						}
					}
				}
			}
		}
		System.out.println(result == 0 ? "KAKTUS" : result);
	}

	private static boolean isOk(int xx, int yy) {
		return xx >= 0 && xx < R && yy >= 0 && yy < C;
	}
}
