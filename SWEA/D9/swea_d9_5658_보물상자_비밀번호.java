package sw_d9_5658_보물상자_비밀번호;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 총 개수
			int K = sc.nextInt(); // K 번째 숫자
			String str = sc.next();
			
			HashMap<String, Integer> map = new HashMap<>();
			
			// 그러면 N을 4로 나눴을 때 몫 만큼 회전을 해야하네?
			for(int i = 0; i < N / 4; i++) {
				int cnt = 1;
				StringBuilder sb = new StringBuilder();
				for(int j = i; j < str.length(); j++) {
					sb.append(str.charAt(j));
					// 붙이고
					
					if(cnt % (N / 4) == 0) {
						map.put(sb.toString(), Integer.parseInt(sb.toString(), 16));
						sb = new StringBuilder();
					}
					cnt++;
				}
				str += str.charAt(i);
			}
			List<Integer> list = new ArrayList<>(map.values());
			Collections.sort(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			int cnt = 1;
			for(int temp : list) {
				if(cnt == K) {
					System.out.println("#" + test_case + " " + temp);
					break;
				}
				cnt++;
			}
		}
	}
}

