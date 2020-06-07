package boj_gold5_16234_인구이동;

import java.util.LinkedList;
import java.util.Queue;
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
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited; // 방문 배열이랑
	static int[][] numbering; // 구역을 나눠줄 친구
	static boolean flag; // 인구 이동이 이뤄질 수 있는지 없는지 판단
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 맵의 크기
		L = sc.nextInt(); // 최소 값
		R = sc.nextInt(); // 최댓 값
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int result = 0; // 결과
		while(true) {
			flag = false;
			visited = new boolean[N][N];
			numbering = new int[N][N];
			int cnt = 1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						bfs(i, j, cnt);
						cnt++;
					}
				}
			}
			if(flag) { // 인구 이동이 가능해진거임
				// 여기서 cnt를 가지고 갈 수 있는거지
				result++;
				int[] sum = new int[cnt + 1]; // 구역이 4개임 처음에는
				int[] counts = new int[cnt + 1]; // 구역별 개수
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++){
						sum[numbering[i][j]] += map[i][j];
						counts[numbering[i][j]]++;
					}
				}
				// sum은 어찌어찌 해서 구했어
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						map[i][j] = sum[numbering[i][j]] / counts[numbering[i][j]];
					}
				}
			}else {
				break;
			}
		}
		System.out.println(result);
	}

	private static void bfs(int i, int j, int cnt) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(i ,j));
		visited[i][j] = true;
		numbering[i][j] = cnt;
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			for(int k = 0; k < 4; k++) {
				int xx = temp.r + dr[k];
				int yy = temp.c + dc[k];
				if(isOk(xx, yy) && !visited[xx][yy]) {
					if(Math.abs(map[temp.r][temp.c] - map[xx][yy]) >= L && Math.abs(map[temp.r][temp.c]- map[xx][yy]) <= R) {
						flag = true;
						visited[xx][yy] = true;
						queue.add(new Point(xx, yy));
						numbering[xx][yy] = cnt;
					}
				}
			}
		}
	}

	private static boolean isOk(int xx, int yy) {
		return xx >= 0 && xx < N && yy >= 0 && yy < N;
	}

}

