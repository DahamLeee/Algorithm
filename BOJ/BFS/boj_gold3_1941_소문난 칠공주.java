package boj_gold3_1941_소문난칠공주;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Point{
		int r, c;

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N;
	static int result;
	static char[][] map;
	static int[] selected;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = 5;
		
		map = new char[N][N];
		selected = new int[7];
		arr = new int[25];
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
		}
		for(int i = 0; i < 25; i++) {
			arr[i] = i;
		}
		result = 0;
		combination(0, 0);
		System.out.println(result);
	}
	private static void combination(int s_idx, int idx) { 
		if(s_idx == selected.length) { // 25개의 좌표중에서 7개를 뽑았습니다.
			int Lee = 0;
			int Lim = 0;
			boolean[][] visited = new boolean[N][N];
			for(int i = 0; i < selected.length; i++) {
				visited[selected[i] / N][selected[i] % N] = true;
				switch(map[selected[i] / N][selected[i] % N]) {
				case 'S': // 이다솜
					Lee++;
					break;
				case 'Y': // 임도연
					Lim++;
					break;
				}
				
				if(Lim >= 4) { // 임도연파가 4보다 크다면 더 볼 필요가 없지
					return;
				}
			}
			
			int cnt = 0; // 연결된 좌표가 7개가 맞는지 아닌지 판단해줄 변수
			// 그냥 0을 시작 좌표로 정해두고 bfs 돌리면 연결이 됐는지 안됐는지 판단할 수 있음
			int r = selected[0] / N;
			int c = selected[0] % N;
			visited[r][c] = true;
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(r, c));
			while(!queue.isEmpty()) {
				Point temp = queue.poll();
				for(int k = 0; k < 4; k++) {
					int xx = temp.r + dr[k];
					int yy = temp.c + dc[k];
					if(isOk(xx, yy) && visited[xx][yy]) {
						visited[xx][yy] = false;
						queue.add(new Point(xx, yy));
						cnt++;
					}
				}
			}
			if(cnt == 7) { // 만약 연결된 좌표가 7개라면 정답의 개수는 증가하게 됨
				result++;
			}
			return;
		}
		if(idx == arr.length) {
			return;
		}
		selected[s_idx] = arr[idx];
		// 아래와 같은 행위도 일종의 백트래킹이라고 할 수 있을까?
		combination(s_idx + 1, idx + 1);
		combination(s_idx, idx + 1);
	}
	private static boolean isOk(int xx, int yy) { // 범위 유효성 판단
		return xx >= 0 && xx < N && yy >= 0 && yy < N;
	}
	
}
