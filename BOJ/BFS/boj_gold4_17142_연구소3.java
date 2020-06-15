package boj_gold4_17142_연구소3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Point{
		int i, j, time;
		public Point(int i, int j, int time) {
			super();
			this.i = i;
			this.j = j;
			this.time = time;
		}
		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + "]";
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N;
	static int M;
	static int[][] map;
	static Point[] arr;
	static Point[] selected;
	static int MIN;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt(); // 놓을 수 있는 바이러스의 개수
		
		map = new int[N][N];
		int num = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) { // 그러면 조합의 대상이 되는거임
					num++;
				}
			}
		}
		arr = new Point[num];
		selected = new Point[M];
		int idx = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 2) {
					arr[idx++] = new Point(i, j, 0);
				}
			}
		}
		
		// 0은 그냥 빈칸, 1은 벽, 2는 바이러스를 놓을 수 있는 위치
		// 그럼 바이러스를 놓을 수 있는 위치를 먼저 찾아서 2개중에 3개를 뽑는걸로 가자
		MIN = Integer.MAX_VALUE;
		combination(0, 0);
		System.out.println(MIN == Integer.MAX_VALUE ? - 1 : MIN);
	}
	private static void combination(int s_idx, int idx) {
		if(s_idx == selected.length) {
			// 그럼 이놈들의 좌표를 3으로 만들어주면 되지 않을까?
			int[][] temp = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			char[][] result = new char[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					temp[i][j] = map[i][j];
					if(temp[i][j] == 1) {
						result[i][j] = '-';
					} else if(temp[i][j] == 2) {
						result[i][j] = '*';
					} else if(temp[i][j] == 0) {
						result[i][j] = '0';
					}
				}
			}
			Queue<Point> queue = new LinkedList<>();
			for(int i = 0; i < selected.length; i++) {
				temp[selected[i].i][selected[i].j] = 3;
				result[selected[i].i][selected[i].j] = '0';
				queue.add(new Point(selected[i].i, selected[i].j, 0));
				visited[selected[i].i][selected[i].j] = true;
			}
			int localMax = Integer.MIN_VALUE;
			while(!queue.isEmpty()) {
				Point p = queue.poll();
				if(temp[p.i][p.j] == 3) {
					localMax = Math.max(localMax, p.time); // 여기서 0으로 세팅이 됐음
				}
				for(int k = 0; k < 4; k++) {
					int xx = p.i + dr[k];
					int yy = p.j + dc[k];
					if(xx >= 0 && xx < N && yy >= 0 && yy < N && temp[xx][yy] == 0 && !visited[xx][yy]) {
						temp[xx][yy] = 3;
						visited[xx][yy] = true;
						queue.add(new Point(xx, yy, p.time + 1));
					} else if(xx >= 0 && xx < N && yy >= 0 && yy < N && temp[xx][yy] == 2 && !visited[xx][yy]) {
						visited[xx][yy] = true;
						queue.add(new Point(xx, yy, p.time + 1));
					}
				}
			}
			if(isCorrect(temp)) {
				MIN = Math.min(MIN, localMax);
			}
			// 3으로 만들어주면 이제 거기서 시작을 하면 되지
			// 여기서 bfs해주면 될 듯
			return;
		}
		if(idx == arr.length) {
			return;
		}
		
		selected[s_idx] = arr[idx];
		combination(s_idx + 1, idx + 1);
		combination(s_idx, idx + 1);
	}
	private static boolean isCorrect(int[][] temp) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(temp[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
