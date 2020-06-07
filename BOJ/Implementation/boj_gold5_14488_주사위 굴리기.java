package boj_gold5_14499_주사위_굴리기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] dr = {0, 0, -1, 1}; // 동(우), 서(좌), 북(상), 남(하)
	static int[] dc = {1, -1, 0, 0};
	static int N;
	static int M;
	static int x;
	static int y;
	static int K;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 지도의 세로(행) 크기
		M = sc.nextInt(); // 지도의 가로(열) 크기
		
		x = sc.nextInt(); // 주사위를 놓은 곳의 위치 
		y = sc.nextInt(); // 주사위를 놓은 곳의 위치
		
		K = sc.nextInt(); // 명령의 개수
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int[] commands = new int[K];
		for(int i = 0; i < K; i++) {
			commands[i] = sc.nextInt() - 1; // idx를 0부터 시작하게 하려고
		}
		int[] dice = new int[6]; // 0 : bottom, 1 : top, 2 : left, 3 : right, 4 : up, 5 : down
		// 다 0으로 초기화가 되어 있을거에요
		for(int i = 0; i < K; i++) {
			// 여기서 구현을 하거나
			// 함수를 호출합시다.
			cal(commands[i], dice);
		}
	}
	private static void cal(int i, int[] dice) {
		// 먼저 이동할 수 있는지 없는지 확인을 함
		int xx = x + dr[i];
		int yy = y + dc[i];
		if(!isOk(xx, yy)) { // 범위에 들어오지 못하면 주사위를 굴릴 수 없음
			return;
		}
		
		x = xx;
		y = yy;
		
		switch(i) {
		case 0: // 동 => 
			// bottom => left
			// top => right
			// left => top
			// right => bottom
			// down => down
			// up => up
			east(dice);
			break;
		case 1: // 서 =>
			// bottom => right
			// top => left
			// left => bottom
			// right => top
			// down => down
			// up => up
			west(dice);
			break;
		case 2: // 북 =>
			// bottom => down
			// top => up
			// left => left
			// right => right
			// down => top
			// up => bottom
			north(dice);
			break;
		case 3: // 남 => 
			// bottom => up
			// top => down
			// left => left
			// right => right
			// down => bottom
			// up => top
			south(dice);
			break;
		}
		// 0과 1만 신경써주면 됨
		if(map[x][y] == 0) {
			map[x][y] = dice[0];
		} else {
			dice[0] = map[x][y];
			map[x][y] = 0;
		}
//		System.out.println("xx : " + x + " yy : " + y);
//		System.out.println(Arrays.toString(dice));
		System.out.println(dice[1]);
//		System.out.println("====================");
//		System.out.println("====================");
		// bottom, up, left, right, down, up
	}
	private static void east(int[] dice) {
		int bottom = dice[0]; // bottom;
		int top = dice[1];
		int left = dice[2];
		int right = dice[3];
		dice[0] = right;
		dice[1] = left;
		dice[2] = bottom;
		dice[3] = top;
	}
	private static void west(int[] dice) { // 먹혀
		int bottom = dice[0]; // bottom;
		int top = dice[1];
		int left = dice[2];
		int right = dice[3];
		dice[0] = left;
		dice[1] = right;
		dice[2] = top;
		dice[3] = bottom;
	}
	private static void north(int[] dice) {
		int bottom = dice[0]; // bottom;
		int top = dice[1];
		int down = dice[4];
		int up = dice[5];
		dice[0] = up;
		dice[1] = down;
		dice[4] = bottom;
		dice[5] = top;
	}
	private static void south(int[] dice) { // 먹혀
		int bottom = dice[0]; // bottom;
		int top = dice[1];
		int down = dice[4];
		int up = dice[5];
		dice[0] = down;
		dice[1] = up;
		dice[4] = top;
		dice[5] = bottom;
	}
	
	private static boolean isOk(int xx, int yy) {
		return xx >= 0 && xx < N && yy >= 0 && yy < M;
	}
}
