import java.util.Scanner;

public class Solution {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++) {
			int len = sc.nextInt();
			int word = sc.nextInt();
			
			int[][] map = new int[len][len];
			for(int i = 0; i < len; i++) {
				for(int j = 0; j < len; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int result = 0;
			for(int i = 0; i < len; i++) {
				for(int j = 0; j < len; j++) {
					if(map[i][j] == 1) {
						// 이제 사방을 볼만한 가치가 있는 거임;
						for(int k = 0; k < 4; k++) {
							int xx = i + dr[k];
							int yy = j + dc[k];
							
						}
						
					}
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}

}
