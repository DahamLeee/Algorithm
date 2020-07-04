package sw_d4_4366_정식이의_은행업무;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			String second = sc.next();
			String third = sc.next();
			
			HashMap<String, Integer> map1 = new HashMap<>();
			HashMap<String, Integer> map2 = new HashMap<>();
			StringBuilder sb = new StringBuilder(second);
			for(int i = 0; i < second.length(); i++) {
				sb = new StringBuilder(second);
				if(second.charAt(i) == '0') {
					sb.setCharAt(i, '1');
				} else {
					sb.setCharAt(i, '0');
				}
				map1.put(sb.toString(), Integer.parseInt(sb.toString(), 2));
			}
			StringBuilder sb1 = new StringBuilder(third);
			for(int i = 0; i < third.length(); i++) {
				sb1 = new StringBuilder(third);
				for(int j = 0; j < 2; j++) {
					if(sb1.toString().charAt(i) == '0') {
						sb1.setCharAt(i, '1');
					} else if(sb1.toString().charAt(i) == '1') {
						sb1.setCharAt(i, '2');
					} else {
						sb1.setCharAt(i, '0');
					}
					map2.put(sb1.toString(), Integer.parseInt(sb1.toString(), 3));
				}
			}
			int result = 0;

			L : for(String key1 : map1.keySet()) {
				int temp = map1.get(key1);
				for(String key2 : map2.keySet()) {
					if(temp == map2.get(key2)) {
						result = temp;
						break L;
					}
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}
