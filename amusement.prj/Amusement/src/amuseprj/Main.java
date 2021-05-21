package amuseprj;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Input input = new Input();
		Output output = new Output();
		Buy_Ticket buy = new Buy_Ticket();
		FileWrite fw = new FileWrite();
		DBwrite db = new DBwrite();
		int option, identification, count, priority, Continue;
		while (true) {
			while (true) {
				option = input.ticket_option();
				identification = input.identification();
				count = input.ticket_count();
				priority = input.priority();
				output.print_price(buy.total_price_no_discount(option, identification, count, priority));

				Continue = input.ticket_continue();
				if (Continue == 2) {
					output.print_result();
					db.addDB();
					fw.profit();
					ConstValue.cusInfoArray = new ArrayList<CustomerInfo>(); // cusInfoArray 초기화
					ConstValue.total_Price = 0; // total_price 초기화
					break;
				}
			}
			int Final = input.ticket_final_continue();
			if (Final == 2) {
				break;
			}

		}
	}
}
