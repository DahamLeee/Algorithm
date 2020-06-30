package sw_d4_3289_서로소집합;

import java.util.Scanner;

public class Solution {
	static int[] parents;
	static int[] rank;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 처음 집합의 개수
			int M = sc.nextInt(); // 연산의 횟수
			
			parents = new int[N + 1];
			rank = new int[N + 1];
			
			for(int i = 1; i <= N; i++) {
				parents[i] = i;
			}
			sb.append("#" + test_case + " ");
//			System.out.print("#" + test_case + " ");
			for(int i = 0; i < M; i++) {
				int way = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				// 0 a b 는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미
				if(way == 0) {
					union(a, b);
				}
				// 1 a b 는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산
				else {
					if(find(a) == find(b)) {
						// 같은 집합
//						System.out.print(1);
						sb.append(1);
					}
					else {
						// 다른 집합
//						System.out.print(0);
						sb.append(0);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	public static int find(int x) {
		if(parents[x] == x) { // base point는 자기 자신이 부모일 때
			return x;
		}else {
			return find(parents[x]);
		}
	}
	public static void union(int a, int b) {
		int px = find(a);
		int py = find(b);
		
		if(rank[px] < rank[py]) {
			// rank가 py가 더 높아
			// 그러면 py를 루트로 해야겠지?
			parents[px] = py;
		}
		else if(rank[px] > rank[py]) {
			parents[py] = px;
		}
		else { // 같아
			rank[py]++;
			parents[px] = py;
		}
		
	}

}
