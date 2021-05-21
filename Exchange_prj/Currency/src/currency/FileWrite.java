package currency;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileWrite {

	public void Filewrite_First(int input_won, int option, int output) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\Currency.csv", true);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format1 = format.format(cal.getTime());
		try {
			if (option == ConstValueClass.CHANGE_TYPE_JPY) {
				fw.write(format1 + "," + input_won + "원," + ConstValueClass.MONEY_UNIT[option - 1] + ","
						+ (output - (output % 1000)) + " " + ConstValueClass.MONEY_UNIT[option - 1] + ",");
			} else {
				fw.write(format1 + "," + input_won + "원," + ConstValueClass.MONEY_UNIT[option - 1] + "," + output + " "
						+ ConstValueClass.MONEY_UNIT[option - 1] + ",");
			}
		} finally {
			fw.close();
		}
	}

	public void Filewrite_KOR(int returnKOR) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\Currency.csv", true);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format1 = format.format(cal.getTime());

		try {
			fw.write(returnKOR + "원,");
		} finally {
			fw.close();
		}
	}

	public void Filewrite_Balance(double balance, int option) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\Currency.csv", true);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format1 = format.format(cal.getTime());
		try {
			fw.write(balance + " " + ConstValueClass.MONEY_UNIT[option - 1] + "\n");
		} finally {
			fw.close();
		}
	}

	public void Filewrite_No_Money(int input_won, int option, int output, int returnKOR, double balance)
			throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\Currency.csv", true);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format1 = format.format(cal.getTime());
		try {
			if (option == ConstValueClass.CHANGE_TYPE_JPY) {
				fw.write(format1 + "," + input_won + "," + ConstValueClass.MONEY_UNIT[option - 1] + ","
						+ (output - (output % 1000)) + " " + ConstValueClass.MONEY_UNIT[option - 1] + "," + returnKOR
						+ "원," + balance + " " + ConstValueClass.MONEY_UNIT[option - 1] + "," + "잔액부족\n");
			} else {
				fw.write(format1 + "," + input_won + "," + ConstValueClass.MONEY_UNIT[option - 1] + "," + output + " "
						+ ConstValueClass.MONEY_UNIT[option - 1] + "," + returnKOR + "원," + balance + " "
						+ ConstValueClass.MONEY_UNIT[option - 1] + "," + "잔액부족\n");
			}
		} finally {
			fw.close();
		}
	}

	public void Filewrite_Count(int[] Count, int[] type) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\Currency.csv", true);
		try {
			for (int i = 0; i < type.length; i++) {
				fw.write(Count[i] + "장,");
			}
		} finally {
			fw.close();
		}
	}
}
