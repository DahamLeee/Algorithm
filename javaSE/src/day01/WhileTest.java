package day01;

public class WhileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 2;
		int j = 1;
		while(i < 10) {
			j = 1;
			if(i == 8) {
				i++;
				continue;
			}
			while(j < 10) {
				if(j == 3) {
					j++;
					continue;
				}
				System.out.println(i + " * " + j + " = " + i * j);	
				j++;
			}
			i++;
		}
	}

}
