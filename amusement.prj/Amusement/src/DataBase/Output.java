package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Output {

	private Connection conn;
	private Statement stmt;
	private ResultSet rset;

	//mysql의 나의 계정으로 연결
	public Output() {		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb", "root", "wnstjd12");
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//DB에 저장되어 있는 데이터들을 출력
	public void print_readDB() {
		try {
			System.out.println("\n\n=============================report==================================");
			rset = stmt.executeQuery("select * from report");

			while (rset.next()) {

				System.out.println(rset.getString(1) + "  " + rset.getString(2) + "  " + rset.getString(3) + "     "
						+ rset.getInt(4) + "      " + rset.getInt(5) + "     " + rset.getString(6));
			}
			System.out.println("------------------------------------------------------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//주간권에서 판매개수, 총 판매액 출력
	public void print_dayDB() {
		try {
			System.out.println("\n\n=================== 권종 별 판매현황 ========================");
			rset = stmt.executeQuery("SELECT `type`, SUM(count), SUM(price) FROM report WHERE `type` = '주간권'");
			while (rset.next()) {
				System.out.println(rset.getString(1) + " 총 " + rset.getString(2) + "매\n" + rset.getString(1) + " 매출 : "
						+ rset.getString(3) + "원");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//야간권에서 판매개수, 총 판매액 출력
	public void print_nightDB() {
		try {
			System.out.println();
			rset = stmt.executeQuery("SELECT `type`, SUM(count), SUM(price) FROM report WHERE `type` = '야간권'");
			while (rset.next()) {
				System.out.println(rset.getString(1) + " 총 " + rset.getString(2) + "매\n" + rset.getString(1) + " 매출 : "
						+ rset.getString(3) + "원");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//주간권에서 AGE를 그룹화해서 AGE마다의 판매개수 출력
	public void print_dayDB2() {
		try {
			rset = stmt.executeQuery("SELECT `age`, SUM(count) FROM report WHERE `type` LIKE '주간%'  group by `age`");
			while (rset.next()) {
				System.out.print(rset.getString(1) + " " + rset.getString(2) + "매   ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//야간권에서 AGE를 그룹화해서 AGE마다의 판매개수 출력
	public void print_nightDB2() {
		try {
			rset = stmt.executeQuery("SELECT `age`, SUM(count) FROM report WHERE `type` LIKE '야간%'  group by `age`");
			while (rset.next()) {
				System.out.print(rset.getString(1) + " " + rset.getString(2) + "매   ");
			}
			System.out.println("\n-----------------------------------------------------------\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//DATE를 그룹화하여 DATE마다의 판매액 출력
	public void print_dayProfit() {
		try {
			rset = stmt.executeQuery("SELECT `date`, SUM(price) FROM report group by `date`");
			System.out.println("\n-----------------------일자별 매출 현황--------------------");
			while (rset.next()) {
				System.out.print(rset.getString(1) + " : 총 매출   " + rset.getString(2) + "원\n");
			}
			System.out.println("-----------------------------------------------------------\n\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//PRIORITY를 그룹화하여 PRIORITY마다의 판매개수 출력
	public void priority_Count() {
		try {
			Output o = new Output();
			System.out.println("=================== 우대권 판매 현황 ========================");
			o.priority_Count2();
			rset = stmt.executeQuery("SELECT `priority`, SUM(count)  FROM report group by `priority`");
			while (rset.next()) {
				System.out.println(rset.getString(1) + " : " + rset.getString(2) + "매");
			}
			System.out.println("-------------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//총 판매량 출력
	public void priority_Count2() {
		try {
			rset = stmt.executeQuery("SELECT SUM(count) FROM report");
			while (rset.next()) {
				System.out.println("총 판매 티켓수 : " + rset.getString(1) + "매");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
