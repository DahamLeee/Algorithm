import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static ArrayList<Integer> result = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
//		for(int test_case = 1; test_case <= T; test_case++) {
//			int len = sc.nextInt(); // 3
//			int maxKcal = sc.nextInt(); // 500
//			boolean[] visited = new boolean[len];
//			
//			int[] gradient = new int[len];
//			int[] kcal = new int[len];
//			for(int i = 0; i < len; i++) {
//				gradient[i] = sc.nextInt();
//				kcal[i] = sc.nextInt();
//			}
//			        
//	        for(int i=1; i<=len; i++) {
//	            comb(gradient, kcal, visited, 0, len, i, maxKcal);
//	        }
//	        int max = 0;
//	        for(int item : result) {
//	        	if(item > max) {
//	        		max = item;
//	        	}
//	        }
//	        System.out.println("#" + test_case + " " + max);
//	        result.clear();
//		}
//		sc.close();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			callimit = sc.nextInt();
			scores = new int[N];
			cals = new int[N];
			for(int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}
			solve(0, 0, 0);
			System.out.println("#" + test_case + " " + MAX);
		}
		
	}
	static int callimit;
	static int[] cals;
	static int[] scores;
	static int MAX;
    static void solve(int idx, int score, int cal) {
    	if(cal > callimit) {
    		return;
    	}
    	if(idx == cals.length) {
    		// cal의 최고 값을 기억하자. gradient의 값을 기억하자.
    		if(MAX < score) {
    			MAX = score;
    		}
    		return;
    	}
    	solve(idx + 1, score + scores[idx], cal + cals[idx]); // 먹고 가는 재귀  
    	solve(idx + 1, score, cal); // 안먹고 가는 재귀
    }
	// r이 i임
	static void comb(int[] gradient, int[] kcal, boolean[] visited, int depth, int len, int r, int maxKcal) {
        if(r == 0) {
            cal(gradient, kcal, visited, len, maxKcal);
            return;
        }
        if(depth == len) {
            return;
        } else {
            visited[depth] = true;
            comb(gradient, kcal, visited, depth + 1, len, r - 1, maxKcal);
 
            visited[depth] = false;
            comb(gradient, kcal, visited, depth + 1, len, r, maxKcal);
        }
    }
    static void cal(int[] gradient, int[] kcal, boolean[] visited, int n, int maxKcal) {
    	int graSum = 0;
    	int kcalSum = 0;
    	for(int i = 0; i < n; i++) {
    		if(visited[i] == true) {
    			graSum += gradient[i];
    			kcalSum += kcal[i];
    		}
    	}
    	if(kcalSum < maxKcal) {
    		result.add(graSum);
    	}
    }
    
}




























