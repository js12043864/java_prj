package amuseprj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DBwrite {
		
	// db에 저장
	public void addDB() {
		try {
			String content;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb", "root", "wnstjd12");
			for (int i = 0; i < ConstValue.cusInfoArray.size(); i++) {
				CustomerInfo info = ConstValue.cusInfoArray.get(i);
				content = String.format(
						"INSERT INTO `report` (`date`, `type`, `age`, `count`, `price`, `priority`) "
								+ "VALUES ('%s','%s','%s','%d','%d','%s')",
						date(), info.getType(), info.getPerson_Type(), info.getCount(), info.getPrice(),
						info.getPrior());
				Statement stmt = conn.createStatement();
				stmt.execute(content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 시간 호출 메소드
	public static String date() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		String time = format.format(cal.getTime());
		return time;
	}
}

//				ResultSet rset = stmt.executeQuery("select * from report");
// System.out.println("날짜 권종 연령구분 개수 가격 우대사항");

//				while (rset.next()) {
//					System.out.println(rset.getString(1) + "  " + rset.getString(2) + "  " + rset.getString(3) + "     "
//							+ rset.getString(4) + "      " + rset.getString(5) + "     " + rset.getString(6));
//				}
