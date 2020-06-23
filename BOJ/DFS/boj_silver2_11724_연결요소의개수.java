package boj_silver2_11724_연결요소의개수;

import java.util.Scanner;

public class Main {
	static int[][] adj;
	static boolean[] visited;
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M = sc.nextInt();
		
		adj = new int[N][N];
		visited = new boolean[N];
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			adj[a][b] = 1;
			adj[b][a] = 1;
		}
		int result = 0;
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				dfs(i);
				result++;
			}
		}
		System.out.println(result);
	}

	private static void dfs(int idx) {
		visited[idx] = true;
		for(int i = 0; i < N; i++) {
			if(adj[idx][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
}
