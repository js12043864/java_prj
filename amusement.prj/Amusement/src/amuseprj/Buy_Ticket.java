package amuseprj;

public class Buy_Ticket {
	FileWrite fw = new FileWrite();

	//가격 계산
	public int total_price_no_discount(int option, int identification, int count, int priority) {
		int price;
		String type_of_person;
		if (option == 1) {
			if (identification >= ConstValue.age_Standard[3]) {
				price = (int) (ConstValue.day_Price[3] * count * (1 - ConstValue.discount[priority]));
				type_of_person = ConstValue.type_Person[3];
			} else if (identification > ConstValue.age_Standard[1] && identification <= ConstValue.age_Standard[0]) {
				price = (int) (ConstValue.day_Price[0] * count * (1 - ConstValue.discount[priority]));
				type_of_person = ConstValue.type_Person[0];
			} else if (identification > ConstValue.age_Standard[2] && identification <= ConstValue.age_Standard[1]) {
				price = (int) (ConstValue.day_Price[1] * count * (1 - ConstValue.discount[priority]));
				type_of_person = ConstValue.type_Person[1];
			} else if (identification > ConstValue.age_Standard[4] && identification <= ConstValue.age_Standard[2]) {
				price = (int) (ConstValue.day_Price[2] * count * (1 - ConstValue.discount[priority]));
				type_of_person = ConstValue.type_Person[2];
			} else {
				price = (int) (ConstValue.day_Price[4] * count * (1 - ConstValue.discount[priority]));
				type_of_person = ConstValue.type_Person[4];
			}
		} else {
			if (identification >= ConstValue.age_Standard[3]) {
				price = (int) (ConstValue.night_Price[3] * count * (1 - ConstValue.discount[priority]));
				type_of_person = ConstValue.type_Person[3];
			} else if (identification > ConstValue.age_Standard[1] && identification <= ConstValue.age_Standard[0]) {
				price = (int) (ConstValue.night_Price[0] * count * (1 - ConstValue.discount[priority]));
				type_of_person = ConstValue.type_Person[0];
			} else if (identification > ConstValue.age_Standard[2] && identification <= ConstValue.age_Standard[1]) {
				price = (int) (ConstValue.night_Price[1] * count * (1 - ConstValue.discount[priority]));
				type_of_person = ConstValue.type_Person[1];
			} else if (identification > ConstValue.age_Standard[4] && identification <= ConstValue.age_Standard[2]) {
				price = (int) (ConstValue.night_Price[2] * count * (1 - ConstValue.discount[priority]));
				type_of_person = ConstValue.type_Person[2];
			} else {
				price = (int) (ConstValue.night_Price[4] * count * (1 - ConstValue.discount[priority]));
				type_of_person = ConstValue.type_Person[4];
			}
		}
		ConstValue.total_Price = ConstValue.total_Price + price;
		customer(option, count, price, priority, type_of_person);
		return price;
	}

	// 총 출력을 위한 arraylist에 넣을 값 세팅 메소드
	public static void customer(int option, int count, int price, int priority, String type_of_person) {
		CustomerInfo cusInfo = null;
		
		cusInfo = new CustomerInfo();
		cusInfo.setType(ConstValue.type_Ticket[option]);
		cusInfo.setPerson_Type(type_of_person);
		cusInfo.setCount(count);
		cusInfo.setPrice(price);
		cusInfo.setPrior(ConstValue.applied_Priority[priority]);
		ConstValue.cusInfoArray.add(cusInfo);
	}
}
