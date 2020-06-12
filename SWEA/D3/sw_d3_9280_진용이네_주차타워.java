import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// 
		for(int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[] parkingPay = new int[n];
			int[] weight = new int[m];
			
			for(int i = 0; i < n; i++) {
				parkingPay[i] = sc.nextInt();
			}
			for(int i = 0; i < m; i++) {
				weight[i] = sc.nextInt();
			}
			
			// -�� �Ͼ�� �ٽ� �ڸ� ����?
			Queue<Integer> queue = new LinkedList<Integer>();
			Queue<Integer> waiting = new LinkedList<Integer>();
			for(int i = 0; i < 2 * m; i++) {
				queue.add(sc.nextInt());
			}

			int[] parking = new int[n];
			for(int i = 0; i < parking.length; i++) {
				parking[i] = -1;
			}
			boolean flag = false; // true�� ���� ����
			
			int score = 0;
			
			while(true) {
				flag = false;
				// queue.poll() �� �ε���
				if(queue.isEmpty() && waiting.isEmpty()) {
					break;
				}
				if(queue.peek() > 0) { // ���� �� ��
					for(int i = 0; i < parking.length; i++) { // ���� �� ������ �ִ��� Ȯ��
						if(parking[i] == -1) {
							flag = true;
							break;
						}
					}
					if(flag) {
						for(int i = 0; i < parking.length; i++) {
							if(parking[i] == -1) {
								parking[i] = queue.peek() - 1; // index
								score += parkingPay[i] * weight[queue.peek() - 1];
								queue.poll();
								break;
							}
						}
					}else {
						// �׷� �׳� ��ٷ�����
						waiting.add(queue.poll());
						continue;
					}
				}
				else { // ���� �� ��
					for(int i = 0; i < parking.length; i++) {
						if(parking[i] == Math.abs(queue.peek()) - 1) {
							parking[i] = -1;
							queue.poll();
							break;
						}
					}
					if(!waiting.isEmpty()) { // ������� �ʴٸ�
						for(int i = 0; i < parking.length; i++) {
							if(parking[i] == -1) {
								parking[i] = waiting.peek() - 1;
								score += parkingPay[i] * weight[waiting.peek() - 1];
								waiting.poll();
								break;
							}
						}
					}
					
				}
			}
			System.out.println("#" + test_case + " " + score);
		}
	}
}
