package report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Calculate {
	FileRead read = new FileRead();
	List<List<String>> List = read.Report();
	HashSet<String> date = new HashSet<String>();
	ArrayList<String> date_Data;
	
	//권종별 판매현황 계산 
	public void type_Count(List<List<String>> List) {
		for (int i = 0; i < List.size(); i++) {
			if (List.get(i).get(1).equals(ConstValue.option[1])) {
				ConstValue.day_count = ConstValue.day_count + Integer.parseInt(List.get(i).get(3));
				ConstValue.day_Total_Price = ConstValue.day_Total_Price + Integer.parseInt(List.get(i).get(4));
				for (int j = 0; j < ConstValue.type_Day_Count.length; j++) {
					if (ConstValue.type_Person[j].equals(List.get(i).get(2))) {
						ConstValue.type_Day_Count[j] = ConstValue.type_Day_Count[j]
								+ Integer.parseInt(List.get(i).get(3));
					}
				}
			} else {
				ConstValue.night_count = ConstValue.night_count + Integer.parseInt(List.get(i).get(3));
				ConstValue.night_Total_Price = ConstValue.night_Total_Price + Integer.parseInt(List.get(i).get(4));
				for (int j = 0; j < ConstValue.type_Night_Count.length; j++) {
					if (ConstValue.type_Person[j].equals(List.get(i).get(2))) {
						ConstValue.type_Night_Count[j] = ConstValue.type_Night_Count[j]
								+ Integer.parseInt(List.get(i).get(3));
					}
				}
			}
		}
	}
	
	//우대권별 판매현황 계산 
	public void priority_Count(List<List<String>> List) {
		for (int i = 0; i < List.size(); i++) {
			ConstValue.total_Count = ConstValue.total_Count + Integer.parseInt(List.get(i).get(3));
			for (int j = 1; j < ConstValue.applied_Priority.length; j++) {
				if (List.get(i).get(5).equals(ConstValue.option[j])) {
					ConstValue.priority_Count[j] = ConstValue.priority_Count[j] + Integer.parseInt(List.get(i).get(3));
				}
			}
		}
	}
	
	//일자별 매출현황 계산
	public int[] day_Profit(List<List<String>> List) {	
		for (int i = 0; i < List.size(); i++) {
			date.add(List.get(i).get(0));
		}
		date_Data = new ArrayList<String>(date);
		Collections.sort(date_Data);
		int[] date_Price = new int[date.size()];

		for (int i = 0; i < date.size(); i++) {
			for (int j = 0; j < List.size(); j++) {
				if (List.get(j).get(0).equals(date_Data.get(i))) {
					date_Price[i] = date_Price[i] + Integer.parseInt(List.get(j).get(4));
				}
			}
		}
		return date_Price;
	}
	
	//권종을 숫자로 바꿔주는 메소드
	public void change(List<List<String>> List) {
		for (int i = 0; i < List.size(); i++) {
			for (int j = 0; j < ConstValue.type_Ticket.length; j++) {
				if (List.get(i).get(1).equals(ConstValue.type_Ticket[j])) {
					List.get(i).set(1, ConstValue.option[j]);
				}
			}
			for (int j = 0; j < ConstValue.applied_Priority.length; j++) {
				if (List.get(i).get(5).equals(ConstValue.applied_Priority[j])) {
					List.get(i).set(5, ConstValue.option[j]);
				}
			}
		}
	}
}

