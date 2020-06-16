package boj_silver1_14888_연산자끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int max;
	static int min;
	static int[] arr;
	static char[] cal;
	static char[] selected;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		cal = new char[N - 1]; // '+' , '-', '*', '/'
		selected = new char[N - 1];
		visited = new boolean[N - 1];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int idx = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			int temp = Integer.parseInt(st.nextToken());
			switch(i) {
			case 0:
				for(int j = 0; j < temp; j++) {
					cal[idx++] = '+';
				}
				break;
			case 1:
				for(int j = 0; j < temp; j++) {
					cal[idx++] = '-';
				}
				break;
			case 2:
				for(int j = 0; j < temp; j++) {
					cal[idx++] = '*';
				}
				break;
			case 3:
				for(int j = 0; j < temp; j++) {
					cal[idx++] = '/';
				}
				break;
			}
		}
		permutaion(0);
		System.out.println(max);
		System.out.println(min);
	}
	private static void permutaion(int idx) {
		if(idx == selected.length) {
			int result = arr[0];
			for(int i = 1, j = 0; i < N; i++, j++) {
				switch(selected[j]) {
				case '+':
					result += arr[i];
					break;
				case '-':
					result -= arr[i];
					break;
				case '*':
					result *= arr[i];
					break;
				case '/':
					result /= arr[i];
					break;
				}
			}
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
			// 계산을 어떻게 할까
		}
		for(int i = 0; i < cal.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[idx] = cal[i];
				permutaion(idx + 1);
				visited[i] = false;
			}
		}
	}
}
