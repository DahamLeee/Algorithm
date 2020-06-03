import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		double[] result = new double[num];
		for(int i = 0; i < num; i++) {
			int len = sc.nextInt();
			int[] arr = new int[len];
			double sum = 0;
			int over_avg = 0;
			double rate = 0.0;
			double avg = 0.0;
			for(int j = 0; j < len; j++) {
				arr[j] = sc.nextInt();
			}
			
			for(int k = 0; k < len; k++) {
				sum += arr[k];
			}
			avg = sum / len;
			for(int l = 0; l < len; l++) {
				if(arr[l] > avg) {
					over_avg++;
				}
			}
			rate = over_avg * 100 / (double)len;
			result[i] = (Math.round(rate*1000)/1000.0);
		}
		
		for(int i = 0; i < num; i++) {
			System.out.printf("%.3f", result[i]);
			System.out.println("%");
		}
	}

}
