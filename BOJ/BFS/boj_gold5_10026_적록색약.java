package boj_gold5_10026_적록색약;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Area{
	int i, j;
	Area(int i, int j){
		this.i = i;
		this.j = j;
	}
}

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		char[][] map = new char[N][N];
		char color = '\u0000';
		boolean[][] visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
		}
		// 빨강이랑 초록이랑 구분을 못해
		Queue<Area> queue = new LinkedList<>();

		int sum1 = 0;
		for(int i = 0; i < N; i++) { // 적록색약이 아닌 사람 구분을 할 수 있음
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					sum1++;
					color = map[i][j];
					queue.add(new Area(i, j));
					visited[i][j] = true;
					while(!queue.isEmpty()) {
						Area temp = queue.poll();
						
						for(int k = 0; k < 4; k++) {
							int xx = temp.i + dr[k];
							int yy = temp.j + dc[k];
							
							if(xx >= 0 && xx < N && yy >= 0 && yy < N && !visited[xx][yy] && map[xx][yy] == color) {
								queue.add(new Area(xx, yy));
								visited[xx][yy] = true;
							}
						}
					}
				}
			}
		}
		visited = new boolean[N][N];
		int sum2 = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					sum2++;
					color = map[i][j];
					queue.add(new Area(i, j));
					visited[i][j] = true;
					while(!queue.isEmpty()) {
						Area temp = queue.poll();
						
						for(int k = 0; k < 4; k++) {
							int xx = temp.i + dr[k];
							int yy = temp.j + dc[k];
							
							if(xx >= 0 && xx < N && yy >= 0 && yy < N && !visited[xx][yy] && map[xx][yy] == color) {
								queue.add(new Area(xx, yy));
								visited[xx][yy] = true;
							}
						}
					}
				}
			}
		}
		System.out.println(sum1 + " " + sum2);
	}

}
