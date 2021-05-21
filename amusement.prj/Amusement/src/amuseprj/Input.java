package amuseprj;

import java.util.Scanner;

public class Input {
	Scanner sc = new Scanner(System.in);

	public int ticket_option() {
		System.out.println("권종을 선택하세요");
		for (int i = 1; i < ConstValue.type_Ticket.length; i++) {
			System.out.println(i + ". " + ConstValue.type_Ticket[i]);
		}
		int option;
		while (true) {
			option = sc.nextInt();
			if (option == 1 || option == 2) {
				break;
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
		return option;
	}

	public int identification() {
		System.out.println("주민번호를 입력하세요");
		String identification = sc.next();
		int age = Integer.parseInt(identification.substring(0, 2));
		if (age > 21) {
			age = (2021 - (1900 + age) + 1);
			return age;
		} else {
			age = (2021 - (2000 + age) + 1);
			return age;
		}
	}

	public int ticket_count() {
		System.out.println("몇개를 주문하시겠습니까? (최대 10개)");
		int count = sc.nextInt();
		if (count > 10) {
			System.out.println("10개 초과하므로 10개로 입력됩니다.\n");
			count = 10;
		}
		return count;
	}

	public int priority() {
		System.out.println("우대사항을 선택하세요.\n1. 없음 (나이 우대는 자동처리)\n2. 장애인\n3. 국가유공자\n4. 다자녀\n5. 임산부");
		int priority;
		while (true) {
			priority = sc.nextInt();
			if (priority == 1 || priority == 2 || priority == 3 || priority == 4 || priority == 5) {
				break;
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
		return priority;
	}

	public int ticket_continue() {
		System.out.println("계속 발권 하시겠습니까?\n1. 티켓 발권\n2. 종료");
		int num;
		while (true) {
			num = sc.nextInt();
			if (num == 1 || num == 2) {
				break;
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
		return num;
	}

	public int ticket_final_continue() {
		System.out.printf("\n\n계속 진행(1: 새로운 주문, 2: 프로그램 종료) : ");
		int num;
		while (true) {
			num = sc.nextInt();
			if (num == 1 || num == 2) {
				break;
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
		
		return num;
	}
}
