package boj_gold5_11559_PuyoPuyo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int N = 12;
	static int M = 6;
	static char[][] map;
	
	static boolean[][] visited;
	static int result;
	static boolean flag; // 연쇄작용이 있었는지 없었는지 확인을 해줘야함!
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		// 현재 map 상태에서 터질 수 있는 그룹을 찾고
		// 일단 4개 이상인 놈들이 있는지 없는지 체크부터 하자
		result = 0;
		while(true) {
			flag = false;
			visited = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] != '.' && !visited[i][j]) { // 터질 수 있는 놈인거야
						bfs(i, j, map[i][j]); // 현재 위치도 넘겨줘야 함
					}
				}
			} // 위 2중 포문을 돌고나서 만약 flag가 true가 되지 않았다?
			// 그럼 더 이상 연쇄작용을 할 수 있는 경우가 없다는 것임
			if(!flag) {
				break;
			}
			
			// 근데 break 되지 않고 여기를 나왔다는 것은 연쇄 작용이 일어났다는 거니깐 아래로 미는 작업을 해줘야 합니다.
			visited = new boolean[N][M];
			for(int i = 11; i >= 0; i--) {
				for(int j = 0; j < 6; j++) {
					if(map[i][j] == '.') {
						// 함수 선언해주면 될 듯
						// 이러면 얘를 통해서 위를 보는거지
						down(i, j);
					}
				}
			}
		}
		System.out.println(result);
	}
	
	private static void down(int i, int j) { // 영억이 4개 이상 모여 터졌을 때, 중력이 작용하는 함수
		int xx = i - 1;
		int yy = j; 
		// i, j는 원래 그 자리기 때문에
		while(true) {
			if(xx >= 0 && xx < N && yy >= 0 && yy < M) {
				if(map[xx][yy] != '.') {
					map[i][j] = map[xx][yy];
					map[xx][yy] = '.';
					break;
				}
			} else {
				break;
			}
			xx--;
		}
	}
	
	private static void bfs(int i, int j, char c) {
		visited[i][j] = true;
		Queue<Point> queue = new LinkedList<>(); // 이 녀석은 순전히 bfs를 타기 위한 queue
		Queue<Point> queue2 = new LinkedList<>(); // 같은 값이고, 한 번에 갈 수 있는 놈들의 모임
		int cnt = 1; // 이미 i, j는 추가가 되었기 때문에!
		queue.add(new Point(i, j));
		queue2.add(new Point(i, j)); // 나중에 삭제를 해줘야 될 수 도 있기 때문이지
		
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			for(int k = 0; k < 4; k++) {
				int xx = temp.i + dr[k];
				int yy = temp.j + dc[k];
				if(xx >= 0 && xx < N && yy >= 0 && yy < M && !visited[xx][yy] && map[xx][yy] == c) {
					visited[xx][yy] = true;
					queue.add(new Point(xx, yy)); 
					queue2.add(new Point(xx, yy)); 
					cnt++;
				}
			}
		}
		
		if(cnt >= 4) { // 영역의 크기가 4 이상이다? 그러면 삭제를 해주는 거지 
			// 그럼 그 놈들을 싸그리 .으로 바꾸고
			while(!queue2.isEmpty()) {
				Point temp = queue2.poll();
				map[temp.i][temp.j] = '.'; // 터지게 된 것이죠
			}
			// 그럼 여기서 연쇄작용이 일어난거니깐
			if(!flag) {
				flag = true;
				result++;
			}
		}
	}

	static class Point{
		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}
