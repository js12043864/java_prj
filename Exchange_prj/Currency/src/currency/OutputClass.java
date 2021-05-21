package currency;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class OutputClass {

	static int[] Count = { 0, 0, 0, 0, 0, 0, 0 };

	public void Count(int output, int[] array) {
		for (int i = 0; i < array.length; i++) {
			Count[i] = output / array[i];
			output = output % array[i];
		}
		print_Count(array);
	}

	public void print_Count(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array == ConstValueClass.KIND_OF_USD) {
				System.out.println(array[i] + "달러 : " + Count[i] + "장");
			} else if (array == ConstValueClass.KIND_OF_EUR) {
				System.out.println(array[i] + "유로 : " + Count[i] + "장");
			} else if (array == ConstValueClass.KIND_OF_JPY) {
				System.out.println(array[i] + "엔 : " + Count[i] + "장");
			} else {
				System.out.println(array[i] + "원 : " + Count[i] + "장");
			}
		}
	}

	public void print_Text(String moneyUnit, double balance) {
		System.out.println("죄송합니다. 창구 안 액수 보다 많습니다.");
		System.out.println("현재 창구에 있는 " + moneyUnit + " : " + balance);
	}

	public void print_ResultTrade(int output, int option) {
		if (option == ConstValueClass.CHANGE_TYPE_JPY) {
			System.out.println(ConstValueClass.MONEY_UNIT[option - 1] + "(으)로 환전 결과 : " + (output - (output % 1000))
					+ ConstValueClass.MONEY_UNIT[option - 1]);
		} else {
			System.out.println(ConstValueClass.MONEY_UNIT[option - 1] + "(으)로 환전 결과 : " + output
					+ ConstValueClass.MONEY_UNIT[option - 1]);
		}
	}
}
