package currency;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import currency.ConstValueClass;

public class RunExchange {

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private OutputClass outClass = new OutputClass();
	FileWrite FW = new FileWrite();

	public RunExchange() {
		outClass = new OutputClass();
	}

	private boolean checkBalance(int requestMoney, double checkMoney) {
		if (requestMoney <= checkMoney) {
			return true;
		} else {
			return false;
		}
	}

	public int ReturnKOR(int input_won, int output, double currency) {
		if (currency == ConstValueClass.Currency[2]) {
			double changeWon = (output % 1000) * currency;
			int returnKOR = (int) (changeWon - (changeWon % 10));
			return returnKOR;
		} else {
			double changeWon = input_won - output * currency;
			int returnKOR = (int) (changeWon - (changeWon % 10));
			return returnKOR;
		}
	}

	public void Exchange(int input_won, int option) throws IOException {
		int output = (int) (input_won / ConstValueClass.Currency[option - 1]);
		outClass.print_ResultTrade(output, option);
		int returnKOR = ReturnKOR(input_won, output, ConstValueClass.Currency[option - 1]);
		if (checkBalance(output, ConstValueClass.BALANCE[option - 1])) {
			FW.Filewrite_First(input_won, option, output);
			if (option == ConstValueClass.CHANGE_TYPE_JPY) {
				outClass.Count(output, ConstValueClass.KIND_OF_JPY);
				FW.Filewrite_Count(outClass.Count, ConstValueClass.KIND_OF_JPY);
			} else if (option == ConstValueClass.CHANGE_TYPE_EUR) {
				outClass.Count(output, ConstValueClass.KIND_OF_EUR);
				FW.Filewrite_Count(outClass.Count, ConstValueClass.KIND_OF_EUR);
			} else {
				outClass.Count(output, ConstValueClass.KIND_OF_USD);
				FW.Filewrite_Count(outClass.Count, ConstValueClass.KIND_OF_USD);
			}
			System.out.println("\n거스름돈 : " + returnKOR + "원");
			outClass.Count(returnKOR, ConstValueClass.KIND_OF_KOR);
			FW.Filewrite_KOR(returnKOR);
			FW.Filewrite_Count(outClass.Count, ConstValueClass.KIND_OF_KOR);
			if (option == ConstValueClass.CHANGE_TYPE_JPY) {
				ConstValueClass.BALANCE[option - 1] -= (output - (output % 1000));
			} else {
				ConstValueClass.BALANCE[option - 1] -= output;
			}
			FW.Filewrite_Balance(ConstValueClass.BALANCE[option - 1], option);
			System.out.println(
					"현재 창구에 있는 " + ConstValueClass.MONEY_UNIT[option - 1] + ": " + ConstValueClass.BALANCE[option - 1]);
		} else {
			outClass.print_Text(ConstValueClass.MONEY_UNIT[option - 1], ConstValueClass.BALANCE[option - 1]);
			FW.Filewrite_No_Money(input_won, option, output, returnKOR, ConstValueClass.BALANCE[option - 1]);
		}

	}
}
