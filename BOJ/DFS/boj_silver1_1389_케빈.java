package boj_silver1_1389_DFS_케빈;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] adj;
	static boolean[] visited;
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		adj = new int[N + 1][N + 1];
		// 일단 인접행렬이 필요함
		for(int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a][b] = 1;
			adj[b][a] = 1;
		}
		int min = Integer.MAX_VALUE;
		int minIdx = 0;
		for(int i = 1; i <= N; i++) {
			int sum = 0;
			visited = new boolean[N + 1];
			visited[i] = true;
			result = new int[N + 1];
			Arrays.fill(result, Integer.MAX_VALUE);
			dfs(i, 1);
			for(int j = 1; j <= N; j++) {
				sum += result[j] == Integer.MAX_VALUE ? 0 : result[j];
			}
			if(min > sum) {
				min = sum;
				minIdx = i;
			}
		}
		System.out.println(minIdx);
		
	}
	private static void dfs(int idx, int cnt) {
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && adj[idx][i] == 1) { // 0이면 방문을 하지 않은 것 // 0보다
				visited[i] = true;
				if(result[i] > cnt) {
					result[i] = cnt;
				}
				dfs(i, cnt + 1);
				visited[i] = false;
			}
		}
	}
}
