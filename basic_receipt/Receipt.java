package chap5;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Receipt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat ko12_df = new DecimalFormat("###,###,###,###"); // ���ڸ� 3�ڸ����� �޸��������� �ϰ��ϴ� �޼ҵ� �θ�
		Calendar ko12_cal = Calendar.getInstance(); // calendar �Լ� ���
		SimpleDateFormat ko12_sf = new SimpleDateFormat("YYYY-MM-dd HH:mm"); // �ð��� �̷� �������� ��Ÿ���ڴ�
		SimpleDateFormat ko12_sf2 = new SimpleDateFormat("YYYYMMdd"); // �ð��� �̷� �������� ��Ÿ���ڴ�
		SimpleDateFormat ko12_sf3 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); // �ð��� �̷� �������� ��Ÿ���ڴ�
		String[] ko12_itemname = { "�������̸��ִ�!", "�����͸�aaaaaaaaaaaaa", "��aaaaaaaaa��aa��", "�������̷��Ը��ִٴ�", "���ڿ���", "Ȩ��������", "��īĨĨĨĨĨĨ", "����Ĩ", "�����ο���", "����Ĩ����", "�̴Ͻ����Ķ�",
				"������", "���̱��̱��̴뱸", "�ղ�Ʋ��", "�̴��̷α�", "¯�԰�ʹ�", "12345667777���ں��Ĺ�����", "������2���Ը���������", "ī��ὺ�丮�����ý��丮", "���̼�sick��", "���ڼ���choco", "���ũ����123", "���Ű��(�ְ���ǰ��)", "������", "������", // ���ڿ� �迭 �����ϰ� ǰ�����
				"���̸�", "���󿡸�", "���ڸ�", "�����", "īī�����丮����" };																												// �迭 ��ҿ� �ִ´�.
		int[] ko12_price = { 100000, 1100, 1200, 1300, 1400, 1500, 99900, 1700, 1800, 100000, 2000, 2100, 2200, 2300, 2300, // ������ �迭 �����ϰ� ������ �迭 ��ҿ� �ִ´�.
				2500, 2600, 2700, 2800, 2900, 3000, 3100, 30, 3300, 10000, 3500, 500, 3700, 3800, 6000 };
		int[] ko12_num = { 12, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, // ������ �迭 �����ϰ� ������ �迭 ��ҿ� �ִ´�.
				10 };
		boolean[] ko12_tax = { true, true, true, true, false, true, false, true, true, false, true, false, true, 		// boolean�迭�� �����ϰ� true/false(�鼼) ���� ��ҿ� �ִ´�.
				true, false, true, true, true, true, false, true, false, false, true, false, true, true, false, true,
				false };
		int ko12_sum_nontaxfreeiprice = 0; // �鼼��ǰ�� �ƴ� �͵��� ���� ������ ������ �����ϰ� 0���� �Է�
		int ko12_sum_taxfreeiprice = 0; // �鼼��ǰ���� ���� ������ ������ �����ϰ� 0���� �Է�
		for (int ko12_j = 0; ko12_j < ko12_itemname.length; ko12_j++) { // ������ ���� ko12_j�� ���� �������ְ� 0���� �����ؼ� ǰ��迭�� ���̸�ŭ
																		// �����ϴµ� 1�� �����Ѵ�.
			if (ko12_tax[ko12_j] == false) { // boolean�迭�� ko12_j��Ұ� false�� �� =>�鼼
				ko12_sum_taxfreeiprice = ko12_sum_taxfreeiprice + ko12_price[ko12_j] * ko12_num[ko12_j]; // �鼼��ǰ�� ���� ������ �鼼��ǰ�� �տ� �鼼��ǰ�� ���ݰ� ������ ���� ���� ���Ѵ�.
			} else { // boolean�迭�� ko12_j��Ұ� true�� �� =>�鼼�� �ƴ� ǰ��
				ko12_sum_nontaxfreeiprice = ko12_sum_nontaxfreeiprice + ko12_price[ko12_j] * ko12_num[ko12_j]; // ������ǰ�� ���� ������ ������ǰ�� �տ� ������ǰ�� ���ݰ� ������ ���� ���� ���Ѵ�.
			}
		}
		double ko12_taxrate = 11.0/10.0; // 11.0 /10.0 �� ���� ������ �Ǽ��� ����
		int ko12_sumprice = ko12_sum_taxfreeiprice + ko12_sum_nontaxfreeiprice; // �� �հ�� �����ݾװ� �鼼�ݾ��� ���� ��
		ko12_sum_nontaxfreeiprice = (int)((ko12_sumprice - ko12_sum_taxfreeiprice) / ko12_taxrate); //�����ݾ��� �ᱹ �ٽ� ���հ迡�� �鼼�ݾ��� �� ���� 1.1�� ������ ���� ��
		int ko12_taxprice = ko12_sumprice - ko12_sum_taxfreeiprice - ko12_sum_nontaxfreeiprice; // �ΰ����� �鼼��ǰ�� ������ǰ�� �հ迡�� �� ��.
		System.out.println("emart �̸�Ʈ ������ (031)888-1234"); // ���
		System.out.println("emart 206-86-50913 ����"); // ���
		System.out.println("emart ���� ������ ������� 552"); // ���
		System.out.println("������ �������� ��ȯ/ȯ�� �Ұ�"); // ���
		System.out.println("�����ǰ�� ����, 30�� �̳�(�ż� 7��)"); // ���
		System.out.println("���Ϻ� �귣����� ����(���� ����������)"); // ���
		System.out.println("��ȯ/ȯ�� ���������� ����(����ī�� ����)\n"); // ���
		System.out.printf("[�� ��]%s     P0S:0011-9861\n", ko12_sf.format(ko12_cal.getTime())); // ����ð� ����ϴµ� sf��ü�� ���Ŀ� ���缭
																								// ���
		System.out.println("-----------------------------------------"); // ���
		System.out.println("  �� ǰ ��            �� �� ����   �� �� ");	//���
		System.out.println("-----------------------------------------"); // ���
		
		for (int ko12_i = 0; ko12_i < ko12_itemname.length; ko12_i++) {  // ko12_i�� 0���� �����ؼ� ǰ��迭�� ���̱��� 1�� �����ϴµ�
			while (true) {	//��� ����
				if (ko12_itemname[ko12_i].getBytes().length > 16) {	//ǰ����� ����Ʈ���� 16���� ũ��
					ko12_itemname[ko12_i] = ko12_itemname[ko12_i].substring(0, ko12_itemname[ko12_i].length() - 1);	//�ѱ��ھ� ���� 
				} else {	//�ƴϸ�
					break;	//�����.
				}
			}
			      int ko12_more = 16 - ko12_itemname[ko12_i].getBytes().length;		//������ ������ 8���ڿ� �ѱ��� ���� �� �ִ� 16����Ʈ���� 8�ڸ��� �ڸ� ������ ����Ʈ�� �� ���̴�. 
			      for(int ko12_j = 0; ko12_j < ko12_more; ko12_j++) {		//�� ����ŭ ������ �ִ� �ݺ���
			         ko12_itemname[ko12_i] = ko12_itemname[ko12_i] + " ";	//�� ����ŭ ������ �ִ� �ݺ���
			      }
				if (ko12_tax[ko12_i] == false) { //ǰ���� �鼼��ǰ�� ��
					System.out.printf("*%s %9s%3d%11s\n", ko12_itemname[ko12_i],			//���																	
							ko12_df.format(ko12_price[ko12_i]), ko12_num[ko12_i],
							ko12_df.format(ko12_num[ko12_i] * ko12_price[ko12_i]));
				} else { //�鼼��ǰ�� �ƴ� ��
					System.out.printf(" %s %9s%3d%11s\n", ko12_itemname[ko12_i], 			//���																	
							ko12_df.format(ko12_price[ko12_i]), ko12_num[ko12_i],
							ko12_df.format(ko12_num[ko12_i] * ko12_price[ko12_i]));
				}
				
				if(ko12_itemname.length == 1) {	//ǰ���� 1����
					System.out.println();	//�ٶ���	
				}		
			
			if ((ko12_i + 1) % 5 == 0) { // ko12_i + 1 �� 5�� ���� �������� 0�̸� => 5�ٸ��� -------����� ���ֱ� ���ؼ�
				if (ko12_i == ko12_itemname.length - 1) { // ko12_i �� 29�̸�
					System.out.println(); // �ٹٲ�
					continue; // ���� ------�� ������� ����
				}
				System.out.println("-----------------------------------------"); // ���
			}
		}
		System.out.printf("               �� ǰ�� ����%14d\n", ko12_itemname.length); // �� ǰ�� ���� ����ϴµ� ǰ�� �迭�� ���� ���
		System.out.printf("            (*)�� ��  �� ǰ%14s\n", ko12_df.format(ko12_sum_taxfreeiprice)); // �鼼��ǰ�� �հ� ����ϴµ� �޸� ��� ���
		System.out.printf("               �� ��  �� ǰ%14s\n", ko12_df.format(ko12_sum_nontaxfreeiprice)); // ������ǰ�� �հ� ����ϴµ� �޸� ��� ���																								
		System.out.printf("               ��   ��   ��%14s\n", ko12_df.format(ko12_taxprice)); // �ΰ��� ����ϴµ� �޸� ��� ���
		System.out.printf("               ��        ��%14s\n", ko12_df.format(ko12_sumprice)); // �� �ݾ� ����ϴµ� �޸� ��� ���
		System.out.printf("�� �� �� �� �� �� %23s\n", ko12_df.format(ko12_sumprice)); // �� �ݾ� ����ϴµ� �޸� ��� ���
		System.out.println("-----------------------------------------"); // ���
		System.out.println("0012 KEB �ϳ�       541707**0484/35860658"); // ���
		System.out.printf("ī�����(IC)          �Ͻú� / %10s\n", ko12_df.format(ko12_sumprice));	//���
		System.out.println("-----------------------------------------"); // ���
		System.out.printf("%24s\n", "[�ż�������Ʈ ����]"); // ���
		System.out.println("��*�� ������ ����Ʈ ��Ȳ�Դϴ�."); // ���
		System.out.println("��ȸ�߻�����Ʈ        9350**9995      164"); // ���
		System.out.println("����(����)����Ʈ         5,637(    5,473)"); // ���
		System.out.println("*�ż�������Ʈ ��ȿ�Ⱓ�� 2���Դϴ�."); // ���
		System.out.println("-----------------------------------------"); // ���
		System.out.printf("%21s\n", "���űݾױ��� ���������ð� �ڵ��ο�"); // ���
		System.out.println("������ȣ :                       34��****"); // ���
		System.out.printf("�����ð� : %30s\n", ko12_sf3.format(ko12_cal.getTime())); // ����ð� ����ϴµ� sf��ü�� ���Ŀ� ���缭 ���
		System.out.println("-----------------------------------------"); // ���
		System.out.println("ĳ��:084599 ��00                     1150"); // ���
		System.out.printf("%14s/00119861/00164980/31", ko12_sf2.format(ko12_cal.getTime()));	//���糯¥ ���
	}
}
