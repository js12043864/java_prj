package amuseprj;

public class Output {
	FileWrite fw = new FileWrite();

	// 가격 출력
	public void print_result() {
		System.out.println("티켓 발권을 종료합니다. 감사합니다.\n\n");
		System.out.println("========================== 준성랜드 =========================");
		for (int i = 0; i < ConstValue.cusInfoArray.size(); i++) {
			CustomerInfo info = ConstValue.cusInfoArray.get(i);
			System.out.println(info.getType() + " " + info.getPerson_Type() + " " + " X " + info.getCount() + "  "
					+ info.getPrice() + "원  *" + info.getPrior());
		}
		System.out.println("\n입장료 총액은 " + ConstValue.total_Price + "원 입니다.");
		System.out.println("=============================================================");
	}

	public void print_price(int Total_Price) {
		System.out.println("가격은 " + Total_Price + " 원 입니다.\n감사합니다.\n");
	}
}
