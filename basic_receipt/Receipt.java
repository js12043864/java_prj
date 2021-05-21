package chap5;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Receipt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat ko12_df = new DecimalFormat("###,###,###,###"); // 숫자를 3자리마다 콤마형식으로 하게하는 메소드 부름
		Calendar ko12_cal = Calendar.getInstance(); // calendar 함수 사용
		SimpleDateFormat ko12_sf = new SimpleDateFormat("YYYY-MM-dd HH:mm"); // 시간을 이런 형식으로 나타내겠다
		SimpleDateFormat ko12_sf2 = new SimpleDateFormat("YYYYMMdd"); // 시간을 이런 형식으로 나타내겠다
		SimpleDateFormat ko12_sf3 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); // 시간을 이런 형식으로 나타내겠다
		String[] ko12_itemname = { "초코파이맛있다!", "좋은것만aaaaaaaaaaaaa", "건aaaaaaaaa포aa도", "오렌지이렇게맛있다니", "초코에몽", "홈런볼링장", "포카칩칩칩칩칩칩", "꼬북칩", "빼빼로우터", "스윙칩코인", "미니쉘쉘쳐라",
				"오감자", "마이구미구미대구", "왕꿈틀이", "미니켈로그", "짱먹고싶다", "12345667777초코빅파바이이", "다이제2렇게맛있을수가", "카라멜스토리메이플스토리", "아이셔sick행", "초코송이choco", "쿠앤크시즌123", "골든키위(최고의품질)", "에너지", "꼬북이", // 문자열 배열 선언하고 품목명을
				"파이리", "도라에몽", "리자몽", "토게피", "카카오스토리하이" };																												// 배열 요소에 넣는다.
		int[] ko12_price = { 100000, 1100, 1200, 1300, 1400, 1500, 99900, 1700, 1800, 100000, 2000, 2100, 2200, 2300, 2300, // 정수형 배열 선언하고 가격을 배열 요소에 넣는다.
				2500, 2600, 2700, 2800, 2900, 3000, 3100, 30, 3300, 10000, 3500, 500, 3700, 3800, 6000 };
		int[] ko12_num = { 12, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, // 정수형 배열 선언하고 수량을 배열 요소에 넣는다.
				10 };
		boolean[] ko12_tax = { true, true, true, true, false, true, false, true, true, false, true, false, true, 		// boolean배열을 선언하고 true/false(면세) 값을 요소에 넣는다.
				true, false, true, true, true, true, false, true, false, false, true, false, true, true, false, true,
				false };
		int ko12_sum_nontaxfreeiprice = 0; // 면세상품이 아닌 것들의 합을 정수형 변수로 선언하고 0으로 입력
		int ko12_sum_taxfreeiprice = 0; // 면세상품들의 합을 정수형 변수로 선언하고 0으로 입력
		for (int ko12_j = 0; ko12_j < ko12_itemname.length; ko12_j++) { // 정수형 변수 ko12_j의 값을 선언해주고 0부터 시작해서 품목배열의 길이만큼
																		// 돌게하는데 1씩 증가한다.
			if (ko12_tax[ko12_j] == false) { // boolean배열의 ko12_j요소가 false일 때 =>면세
				ko12_sum_taxfreeiprice = ko12_sum_taxfreeiprice + ko12_price[ko12_j] * ko12_num[ko12_j]; // 면세상품의 합은 이전의 면세상품의 합에 면세상품의 가격과 수량을 곱한 값을 더한다.
			} else { // boolean배열의 ko12_j요소가 true일 때 =>면세가 아닌 품목
				ko12_sum_nontaxfreeiprice = ko12_sum_nontaxfreeiprice + ko12_price[ko12_j] * ko12_num[ko12_j]; // 과세상품의 합은 이전의 과세상품의 합에 과세상품의 가격과 수량을 곱한 값을 더한다.
			}
		}
		double ko12_taxrate = 11.0/10.0; // 11.0 /10.0 의 값을 가지는 실수형 변수
		int ko12_sumprice = ko12_sum_taxfreeiprice + ko12_sum_nontaxfreeiprice; // 총 합계는 과세금액과 면세금액을 더한 값
		ko12_sum_nontaxfreeiprice = (int)((ko12_sumprice - ko12_sum_taxfreeiprice) / ko12_taxrate); //과세금액은 결국 다시 총합계에서 면세금액을 뺀 값에 1.1을 나눴을 때의 값
		int ko12_taxprice = ko12_sumprice - ko12_sum_taxfreeiprice - ko12_sum_nontaxfreeiprice; // 부가세는 면세물품과 과세물품을 합계에서 뺀 값.
		System.out.println("emart 이마트 죽전점 (031)888-1234"); // 출력
		System.out.println("emart 206-86-50913 강희석"); // 출력
		System.out.println("emart 용인 수지구 포은대로 552"); // 출력
		System.out.println("영수증 미지참시 교환/환불 불가"); // 출력
		System.out.println("정상상품에 한함, 30일 이내(신선 7일)"); // 출력
		System.out.println("※일부 브랜드매장 제외(매장 고지물참조)"); // 출력
		System.out.println("교환/환불 구매점에서 가능(결제카드 지참)\n"); // 출력
		System.out.printf("[구 매]%s     P0S:0011-9861\n", ko12_sf.format(ko12_cal.getTime())); // 현재시각 출력하는데 sf객체의 형식에 맞춰서
																								// 출력
		System.out.println("-----------------------------------------"); // 출력
		System.out.println("  상 품 명            단 가 수량   금 액 ");	//출력
		System.out.println("-----------------------------------------"); // 출력
		
		for (int ko12_i = 0; ko12_i < ko12_itemname.length; ko12_i++) {  // ko12_i는 0부터 시작해서 품목배열의 길이까지 1씩 증가하는데
			while (true) {	//계속 돈다
				if (ko12_itemname[ko12_i].getBytes().length > 16) {	//품목명의 바이트수가 16보다 크면
					ko12_itemname[ko12_i] = ko12_itemname[ko12_i].substring(0, ko12_itemname[ko12_i].length() - 1);	//한글자씩 뺀다 
				} else {	//아니면
					break;	//멈춘다.
				}
			}
			      int ko12_more = 16 - ko12_itemname[ko12_i].getBytes().length;		//정수형 변수는 8글자에 한글이 들어갔을 때 최대 16바이트에서 8자리로 자른 글자의 바이트를 뺀 값이다. 
			      for(int ko12_j = 0; ko12_j < ko12_more; ko12_j++) {		//뺀 값만큼 공백을 주는 반복문
			         ko12_itemname[ko12_i] = ko12_itemname[ko12_i] + " ";	//뺀 값만큼 공백을 주는 반복문
			      }
				if (ko12_tax[ko12_i] == false) { //품목이 면세물품일 때
					System.out.printf("*%s %9s%3d%11s\n", ko12_itemname[ko12_i],			//출력																	
							ko12_df.format(ko12_price[ko12_i]), ko12_num[ko12_i],
							ko12_df.format(ko12_num[ko12_i] * ko12_price[ko12_i]));
				} else { //면세물품이 아닐 때
					System.out.printf(" %s %9s%3d%11s\n", ko12_itemname[ko12_i], 			//출력																	
							ko12_df.format(ko12_price[ko12_i]), ko12_num[ko12_i],
							ko12_df.format(ko12_num[ko12_i] * ko12_price[ko12_i]));
				}
				
				if(ko12_itemname.length == 1) {	//품목이 1개면
					System.out.println();	//줄띄우기	
				}		
			
			if ((ko12_i + 1) % 5 == 0) { // ko12_i + 1 을 5로 나눈 나머지가 0이면 => 5줄마다 -------출력을 해주기 위해서
				if (ko12_i == ko12_itemname.length - 1) { // ko12_i 가 29이면
					System.out.println(); // 줄바꿈
					continue; // 밑의 ------를 출력하지 마라
				}
				System.out.println("-----------------------------------------"); // 출력
			}
		}
		System.out.printf("               총 품목 수량%14d\n", ko12_itemname.length); // 총 품목 수량 출력하는데 품목 배열의 길이 출력
		System.out.printf("            (*)면 세  물 품%14s\n", ko12_df.format(ko12_sum_taxfreeiprice)); // 면세물품의 합계 출력하는데 콤마 찍게 출력
		System.out.printf("               과 세  물 품%14s\n", ko12_df.format(ko12_sum_nontaxfreeiprice)); // 과세물품의 합계 출력하는데 콤마 찍게 출력																								
		System.out.printf("               부   가   세%14s\n", ko12_df.format(ko12_taxprice)); // 부가세 출력하는데 콤마 찍게 출력
		System.out.printf("               합        계%14s\n", ko12_df.format(ko12_sumprice)); // 총 금액 출력하는데 콤마 찍게 출력
		System.out.printf("결 제 대 상 금 액 %23s\n", ko12_df.format(ko12_sumprice)); // 총 금액 출력하는데 콤마 찍게 출력
		System.out.println("-----------------------------------------"); // 출력
		System.out.println("0012 KEB 하나       541707**0484/35860658"); // 출력
		System.out.printf("카드결제(IC)          일시불 / %10s\n", ko12_df.format(ko12_sumprice));	//출력
		System.out.println("-----------------------------------------"); // 출력
		System.out.printf("%24s\n", "[신세계포인트 적립]"); // 출력
		System.out.println("박*성 고객님의 포인트 현황입니다."); // 출력
		System.out.println("금회발생포인트        9350**9995      164"); // 출력
		System.out.println("누계(가용)포인트         5,637(    5,473)"); // 출력
		System.out.println("*신세계포인트 유효기간은 2년입니다."); // 출력
		System.out.println("-----------------------------------------"); // 출력
		System.out.printf("%21s\n", "구매금액기준 무료주차시간 자동부여"); // 출력
		System.out.println("차량번호 :                       34저****"); // 출력
		System.out.printf("입차시간 : %30s\n", ko12_sf3.format(ko12_cal.getTime())); // 현재시각 출력하는데 sf객체의 형식에 맞춰서 출력
		System.out.println("-----------------------------------------"); // 출력
		System.out.println("캐셔:084599 양00                     1150"); // 출력
		System.out.printf("%14s/00119861/00164980/31", ko12_sf2.format(ko12_cal.getTime()));	//현재날짜 출력
	}
}
