package boj_gold5_15686_치킨배달;

import java.util.Scanner;

public class Main {
	public static class Point{
		int r, c;

		public Point() {
			this.r = 0;
			this.c = 0;
		}
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	static int N, M;
	static int[][] map;
	static Point[] list;
	static Point[] selected;
	static int globalMin;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int totalChicken = 0;
		map = new int[N][N]; // 0은 빈 칸, 1은 집, 2는 치킨 집
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) {
					totalChicken++;
				}
			}
		}
		list = new Point[totalChicken];
		selected = new Point[M];
		
		int idx = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 2) {
					list[idx++] = new Point(i, j);
				}
			}
		}
		globalMin = Integer.MAX_VALUE;
		combination(0, 0);
		System.out.println(globalMin);
	}
	public static void combination(int s_idx, int idx) {
		if(s_idx == selected.length) {
			// 그럼 여기서 min을 계산해줘야겠지?
			int result = calculator();
			globalMin = Math.min(globalMin, result);
			return;
		}
		if(idx == list.length) {
			return; // 선택할게 더 없다
		}
		selected[s_idx] = new Point(list[idx].r, list[idx].c);
		combination(s_idx + 1, idx + 1);
		combination(s_idx, idx + 1);
	}
	private static int calculator() {
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					int localMin = Integer.MAX_VALUE;
					for(int k = 0; k < selected.length; k++) {
						int temp = Math.abs((i + 1) - (selected[k].r + 1)) + Math.abs((j + 1) - (selected[k].c + 1));
						localMin = Math.min(localMin, temp);
					}
					result += localMin;
				}
			}
		}
		return result;
	}
}
