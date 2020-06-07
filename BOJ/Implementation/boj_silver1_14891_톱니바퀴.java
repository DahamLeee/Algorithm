package boj_silver1_14891_톱니바퀴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 배열의 회전에 관한 문제임
		map = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String temp = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int what = Integer.parseInt(st.nextToken()) - 1; // 무슨 자석을
			int how = Integer.parseInt(st.nextToken()); // 어떠한 방향으로 1 : 시계방향, -1 : 시계 반대방향
			visited = new boolean[4];
			clock(map[what], how, what);
		}

		int result = 0;
		for (int i = 0; i < 4; i++) {
			if (map[i][0] == 1) {
				if (i == 0) {
					result += 1;
				} else {
					result += Math.pow(2, i);
				}
			}
		}
		System.out.println(result);
	}

	public static void clock(int[] arr, int how, int index) {
		visited[index] = true;
		if (how == 1) { // 시계 방향으로
			// 왼쪽과
			boolean left = false;
			boolean right = false;
			if (index - 1 >= 0 && !visited[index - 1] && map[index][6] != map[index - 1][2]) { // 다르다? 그러면 너는 돌아야지
				left = true;
			}
			// 같다? 그러면 뭘 해줄 필요가 없음
			// 오른쪽을 봐야해
			if (index + 1 < 4 && !visited[index + 1] && map[index][2] != map[index + 1][6]) {
				right = true;
			}
			int last = arr[7];
			for (int i = 6; i >= 0; i--) {
				arr[i + 1] = arr[i];
			}
			arr[0] = last;
			if (left) {
				clock(map[index - 1], -1, index - 1);
			}
			if (right) {
				clock(map[index + 1], -1, index + 1);
			}
		} else { // 반시계 방향으로
			boolean left = false;
			boolean right = false;
			if (index - 1 >= 0 && !visited[index - 1] && map[index][6] != map[index - 1][2]) {
				left = true;
			}
			if (index + 1 < 4 && !visited[index + 1] && map[index][2] != map[index + 1][6]) {
				right = true;
			}
			int first = arr[0];
			for (int i = 1; i < 8; i++) {
				arr[i - 1] = arr[i];
			}
			arr[7] = first;
			if (left) {
				clock(map[index - 1], 1, index - 1);
			}
			if (right) {
				clock(map[index + 1], 1, index + 1);
			}
		}
	}

}
