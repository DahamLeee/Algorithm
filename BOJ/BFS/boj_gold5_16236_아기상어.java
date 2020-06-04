package boj_gold5_16236_아기상어;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Point {
		int r, c, distance;

		public Point(int r, int c, int distance) {
			super();
			this.r = r;
			this.c = c;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", distance=" + distance + "]";
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int sharkRow;
	static int sharkColumn;
	static int sharkSize;
	static int cnt;
	static int result = 0;
	// 먹을 수 있는 물고기의 목록을 담을 리스트가 필요하네
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		sharkRow = 0; // 아기상어의 row
		sharkColumn = 0; // 아기상어의 column
		sharkSize = 2; // 아기상어의 크기
		cnt = 0; // 물고기를 먹은 횟수
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				// 여기서 아기상어의 위치 구해야되겠고
				if(map[i][j] == 9) {
					sharkRow = i;
					sharkColumn = j;
					map[sharkRow][sharkColumn] = 0;
				}
			}
		}
		while(true) {
			visited = new boolean[N][N];
			if(!bfs()) {
				break;
			}
		}
		System.out.println(result);
	}
	private static boolean bfs() {
		visited[sharkRow][sharkColumn] = true;
		Queue<Point> queue = new LinkedList<>();
		Queue<Point> list = new LinkedList<>();
		queue.add(new Point(sharkRow, sharkColumn, 0));
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			for(int k = 0; k < 4; k++) {
				int xx = temp.r + dr[k];
				int yy = temp.c + dc[k];
				if(isOk(xx, yy) && !visited[xx][yy]) {
					// 여기서 물고기인지, 그냥 빈칸인지 구별해주고
					visited[xx][yy] = true;
					if(map[xx][yy] == 0) { // 그냥 빈칸이다? 그러면 계속 탐색을 하는거지
						queue.add(new Point(xx, yy, temp.distance + 1));
					} else if(map[xx][yy] < sharkSize) {
						queue.add(new Point(xx, yy, temp.distance + 1));
						list.add(new Point(xx, yy, temp.distance + 1));
					} else if(map[xx][yy] == sharkSize){ // 아니면 내가 만든 queue에 삽입
						queue.add(new Point(xx, yy, temp.distance + 1));
					}
				}
			}
		}
		// 그래서 여기서 판별하고 // 음 근데 거리가 가까운 기준은 어떻게 할 것인가
		if(list.size() == 0) { // 엄마 상어의 도움이 필요 함
			return false;
		} else if(list.size() == 1) { // 만약 한명이면 니놈한테 갈거야
			Point temp = list.poll();
			sharkRow = temp.r;
			sharkColumn = temp.c;
			map[sharkRow][sharkColumn] = 0;
			result += temp.distance;
			cnt++;
			if(cnt == sharkSize) {
				sharkSize++;
				cnt = 0;
			}
		} else { // 만약 잡아먹을 수 있는 먹이가 여러 개면 여기서 판정을 해줘야겠지?
			Point[] food = new Point[list.size()];
			int idx = 0;
			while(!list.isEmpty()) {
				Point temp = list.poll();
				food[idx++] = new Point(temp.r, temp.c, temp.distance);
			}
			Arrays.sort(food, new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					if(o1.distance == o2.distance) { // 거리가 같으면
						if(o1.r == o2.r) { // row도 같으면
							if(o1.c < o2.c) { // column으로 비교 // columm은 작은 순
								return -1;
							}else {
								return 1;
							}
						}else { //
							if(o1.r < o2.r) { // 만약 o1.r의 값이 작다 // row는 작은순
								return -1;
							}else {
								return 1;
							}
						}
					}else {
						if(o1.distance < o2.distance) {
							return -1;
						}else {
							return 1;
						}
					}
				}
			});
			sharkRow = food[0].r;
			sharkColumn = food[0].c;
			map[sharkRow][sharkColumn] = 0;
			result += food[0].distance;
			cnt++;
			if(cnt == sharkSize) {
				sharkSize++;
				cnt = 0;
			}
		}
		return true;
	}
	private static boolean isOk(int xx, int yy) {
		return xx >= 0 && xx < N && yy >= 0 && yy < N;
	}
}
