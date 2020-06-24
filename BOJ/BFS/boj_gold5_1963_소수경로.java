package boj_gold5_1963_소수경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point{
		String str;
		int cnt;
		public Point(String str, int cnt) {
			super();
			this.str = str;
			this.cnt = cnt;
		}
	}
	static int result;
	static String target;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String start = st.nextToken();
			target = st.nextToken();
			result = -1;
			visited = new boolean[10000];
			// 여기서 다 돌려보는거지
			bfs(start);
			
			if(result >= 0) {
				System.out.println(result);
			} else {
				System.out.println("Impossible");
			}
		}
	}
	
	private static void bfs(String start) {
		Queue<Point> queue = new LinkedList<>();
		visited[Integer.parseInt(start)] = true;
		queue.add(new Point(start, 0));
		
		while(!queue.isEmpty()) {
			
			Point temp = queue.poll();
			
			if(temp.str.equals(target)) {
				result = temp.cnt;
				return;
			}
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 10; j++) {
					StringBuilder sb = new StringBuilder(temp.str);
					if(i == 0 && j == 0) {
						continue;
					}
					if(temp.str.charAt(i) - '0' == j) {
						continue;
					}
					sb.setCharAt(i, (char) (j + '0'));
					if(isPrime(sb.toString()) && !visited[Integer.parseInt(sb.toString())]) {
						visited[Integer.parseInt(sb.toString())] = true;
						queue.add(new Point(sb.toString(), temp.cnt + 1));
					}
				}
			}
		}
		
	}

	public static boolean isPrime(String str) {
		int num = Integer.parseInt(str);
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
