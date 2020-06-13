package sw_d9_4012_요리사;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[][] map;
	static int N;
	static int[] arr; // 어떤 행과 열을 선택할 것인지 정하기
	static int[] selected; // 선택될 것 // 이건 무조건 2개
	static int[] selected2;
	static int min;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			selected = new int[N / 2];
			selected2 = new int[N / 2];
			arr = new int[N];
			min = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) { // 초기화
				arr[i] = i;
			}
			combination(0, 0);
			System.out.println("#" + test_case + " " + min);
		}
	}
	public static void combination(int s_idx, int idx) {
		if(s_idx == selected.length) {
			// 2개가 선택이 됐다면 여기서 또 한번 combination을 해야겠는데?
			visited = new boolean[N];
			for(int i = 0; i < selected.length; i++) {
				visited[selected[i]] = true;
			}
			combination2(0, 0);
			return;
		}
		if(idx == arr.length) {
			return;
		}
		
		selected[s_idx] = arr[idx];
		combination(s_idx + 1, idx + 1);
		combination(s_idx, idx + 1);
	}
	
	public static void combination2(int s_idx, int idx) {
		if(s_idx == selected2.length) {
			int result = calculator();
			min = Math.min(min, result);
			return;
		}
		if(idx == arr.length) {
			return;
		}
		
		if(!visited[idx]) { // 선택되지 않았더라면
			selected2[s_idx] = arr[idx];
			combination2(s_idx + 1, idx + 1);
			combination2(s_idx, idx + 1);
		} else {
			combination2(s_idx, idx + 1);
		}
	}
	private static int calculator() {
		int temp1 = 0;
		int temp2 = 0;
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < N / 2; j++) {
				temp1 += map[selected[i]][selected[j]];
				temp2 += map[selected2[i]][selected2[j]];
			}
		}
		return Math.abs(temp1 - temp2);
	}
}
