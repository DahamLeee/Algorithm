package boj_gold5_14502_연구소;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Main {
	static class Point{
		int i, j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
		Point(){}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int R, C;
	static int max;
	static Point[] selected;
	static Point[] arr;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new int[R][C];
		
		int N = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0) {
					N++;
				}
			}
		}
		
		selected = new Point[3];
		for(int i = 0; i < 3; i++) {
			selected[i] = new Point();
		}
		arr = new Point[N];
		int count = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 0) {
					arr[count] = new Point(i, j);
					count++;
				}
			}
		}
		max = 0;
		combination(0, 0);
		// class를 써서 0인놈들의 좌표를 배열로 좌르륵 관리를 해서 그놈들만 특정적으로 1을 만든다
		// max 출력
		System.out.println(max);
	}
	public static void combination(int s_idx, int idx) {
		if(s_idx == selected.length) {
			// 이제 여기서 map에다가 selected된 배열에 해당하는 i,j 좌표를 1로 수정해주고
			// 가지고 놀면 될듯
			Queue<Point> queue = new LinkedList<>();
			int[][] temp = new int[R][C];
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					temp[i][j] = map[i][j];
					if(temp[i][j] == 2) {
						queue.add(new Point(i, j));
					}
				}
			}
			for(int i = 0; i < selected.length; i++) {
				temp[selected[i].i][selected[i].j] = 1;
			}
			while(!queue.isEmpty()) {
				Point susu = queue.poll();
				for(int k = 0; k < 4; k++) {
					int xx = susu.i + dr[k];
					int yy = susu.j + dc[k];
					
					if(xx >= 0 && xx < R && yy >= 0 && yy < C && temp[xx][yy] == 0) {
						queue.add(new Point(xx, yy));
						temp[xx][yy] = 2;
					}
				}
			}
			int sum = 0;
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(temp[i][j] == 0) {
						sum++;
					}
				}
			}
			max = Math.max(max, sum);
			return;
		}
		if(idx == arr.length) {
			return;
		}
		
		selected[s_idx] = arr[idx];
		combination(s_idx + 1, idx + 1);
		combination(s_idx, idx + 1);
	}
}
