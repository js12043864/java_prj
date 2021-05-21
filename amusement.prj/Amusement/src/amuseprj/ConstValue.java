package amuseprj;

import java.util.ArrayList;

public class ConstValue {
	public static int[] day_Price = { 56000, 47000, 44000, 44000, 0 }; // 대인,청소년,소인,경로,유아
	public static int[] night_Price = { 46000, 40000, 37000, 37000, 0 };// 대인,청소년,소인,경로,유아
	public static final int[] age_Standard = { 64, 18, 12, 65, 2 }; // 대인,청소년,소인,경로,유아
	public static final double[] discount = { 0, 0, 0.4, 0.5, 0.2, 0.15 }; // -> 할인율 ->맨 앞의 0(선택지는 배열은 0부터 시작해서 -1을
																			// 해줘야하지만 그것보단 0의 값을 주어 다른 사람이 봤을 때 혼동되지 않게
																			// 설정
																			// 없음,장애인,국가유공자,다자녀,임산부 순
	public static final String[] type_Ticket = { null, "주간권", "야간권" }; // 위와 동일 이유로 null값 설정
	public static final String[] type_Person = { "대인", "청소년", "소인", "경로", "유아" }; // 위와 동일 이유로 null값 설정
	public static String[] applied_Priority = { null, "우대적용 없음", "장애인 우대적용", "국가유공자 우대적용", "다자녀 우대적용", "임산부 우대적용" }; // 위와
																														// 동일
																														// 이유로
																														// null값
																														// 설정
	public static int total_Price = 0; // 구매할 때 총 합계금액
	public static ArrayList<CustomerInfo> cusInfoArray = new ArrayList<CustomerInfo>(); // 권종,고객유형,개수,가격,우대사항 저장
	public static String address = "..\\report.csv";
}

