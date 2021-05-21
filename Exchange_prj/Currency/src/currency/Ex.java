package currency;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Ex {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputClass inputClass = new InputClass();
		RunExchange run = new RunExchange();
		int input_won = 0;
		int option = 0;
		do {
			input_won = inputClass.inputFromConsole();
			option = inputClass.inputFromConsoleType();
			if (option == ConstValueClass.CHANGE_TYPE_USD) {
				run.Exchange(input_won, option);
			} else if (option == ConstValueClass.CHANGE_TYPE_EUR) {
				run.Exchange(input_won, option);
			} else if (option == ConstValueClass.CHANGE_TYPE_JPY) {
				run.Exchange(input_won, option);
			} else {
				break;
			}
			System.out.println("==============================");
		} while (input_won != 0);
	}
}