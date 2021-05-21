package report;

import java.util.List;

public class Output {
	static FileWrite fw = new FileWrite();
	FileRead read = new FileRead();
	List<List<String>> List = read.Report();
	static Calculate cal = new Calculate();
	
	// report파일 읽어오고 console출력
	public void total_Report() {
			System.out.println("==================== report.csv =========================");
			System.out.println("날짜        권종  연령구분 수량    가격   우대사항");
			cal.change(List);
			for (int i = 0; i < List.size(); i++) {
				for (int j = 0; j < List.get(i).size(); j++) {
					System.out.print(List.get(i).get(j) + "     ");
				}
				System.out.println();
			}
			System.out.println("---------------------------------------------------------\n\n");
			type_Count(List);
			day_Profit(List);
			priority_Count(List);
	}

	// 권종 별 판매현황
	public static void type_Count(List<List<String>> List) {
		System.out.println("=================== 권종 별 판매현황 ========================");
		cal.type_Count(List);
		System.out.println(ConstValue.type_Ticket[1] + " 총 " + ConstValue.day_count + "매");
		for (int i = 0; i < ConstValue.type_Person.length; i++) {
			System.out.print(ConstValue.type_Person[i] + " : " + ConstValue.type_Day_Count[i] + "매  ");
		}
		System.out.println("\n" + ConstValue.type_Ticket[1] + " 매출 : " + ConstValue.day_Total_Price + "원\n");

		System.out.println(ConstValue.type_Ticket[2] + " 총 " + ConstValue.night_count + "매");
		for (int i = 0; i < ConstValue.type_Person.length; i++) {
			System.out.print(ConstValue.type_Person[i] + " : " + ConstValue.type_Night_Count[i] + "매  ");
		}
		System.out.println("\n" + ConstValue.type_Ticket[2] + " 매출 : " + ConstValue.night_Total_Price + "원\n");
		System.out.println("-------------------------------------------------------------\n\n");
	}

	// 일자별 매출 현황
	public static void day_Profit(List<List<String>> List) {
		System.out.println("=================== 일자별 매출 현황 ========================");
		int[] price = cal.day_Profit(List); 
		for(int i = 0; i < cal.date.size(); i++) {
			System.out.println(cal.date_Data.get(i) + " : 총 매출 " + price[i] + "원");
		}
		fw.day_Profit(cal.date_Data, price);
	}

	// 우대권 판매 현황
	public static void priority_Count(List<List<String>> List) {
		System.out.println("-------------------------------------------------------------\n\n");
		System.out.println("=================== 우대권 판매 현황 ========================");
		cal.priority_Count(List);
		System.out.println("총 판매 티켓수   :   " + ConstValue.total_Count + "매");
		for (int i = 1; i < ConstValue.priority_Count.length; i++) {
			System.out.println(ConstValue.applied_Priority[i] + "   :   " + ConstValue.priority_Count[i] + "매");
		}
		System.out.println("-------------------------------------------------------------");
	}
}
