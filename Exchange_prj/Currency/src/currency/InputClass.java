package currency;

import java.util.Scanner;

public class InputClass {
	
	Scanner sc = null;
	
	public InputClass() {
		sc = new Scanner(System.in);
	}
	
	public int inputFromConsole() {
		int input_won;
		System.out.println("받은 원화 입력 : ");
		input_won = sc.nextInt();
		return input_won;
	}
	
	public int inputFromConsoleType() {
		System.out.println("1.USD 2.EUR 3.JPY 4.EXIT");
		int option = sc.nextInt();
		return option;
	}
	
}
