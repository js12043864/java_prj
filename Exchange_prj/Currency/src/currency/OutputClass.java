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
				System.out.println(array[i] + "�޷� : " + Count[i] + "��");
			} else if (array == ConstValueClass.KIND_OF_EUR) {
				System.out.println(array[i] + "���� : " + Count[i] + "��");
			} else if (array == ConstValueClass.KIND_OF_JPY) {
				System.out.println(array[i] + "�� : " + Count[i] + "��");
			} else {
				System.out.println(array[i] + "�� : " + Count[i] + "��");
			}
		}
	}

	public void print_Text(String moneyUnit, double balance) {
		System.out.println("�˼��մϴ�. â�� �� �׼� ���� �����ϴ�.");
		System.out.println("���� â���� �ִ� " + moneyUnit + " : " + balance);
	}

	public void print_ResultTrade(int output, int option) {
		if (option == ConstValueClass.CHANGE_TYPE_JPY) {
			System.out.println(ConstValueClass.MONEY_UNIT[option - 1] + "(��)�� ȯ�� ��� : " + (output - (output % 1000))
					+ ConstValueClass.MONEY_UNIT[option - 1]);
		} else {
			System.out.println(ConstValueClass.MONEY_UNIT[option - 1] + "(��)�� ȯ�� ��� : " + output
					+ ConstValueClass.MONEY_UNIT[option - 1]);
		}
	}
}
