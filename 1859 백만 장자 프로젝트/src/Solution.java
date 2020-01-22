import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
			
		int ans = 0;
		int[] cost = new int[] {
				629, 3497, 7202, 7775, 4325, 3982, 4784, 8417, 2156, 1932
		};
		int max = cost[cost.length - 1];
		for(int i = cost.length - 1; i >= 1; i--) {
			if(cost[i] < max) {
				ans += max - cost[i];
			}else {
				max = Math.max(cost[i], max);
			}
		}
		System.out.println(ans);
	}

}
