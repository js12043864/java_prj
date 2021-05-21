package testDBprj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Testdb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/testdb", "root", "wnstjd12");
			Statement stmt = conn.createStatement();
			
			stmt.execute("INSERT INTO `report` (`date`, `type`, `age`, `count`, `price`, `priority`)" + "VALUES ('2021-04-21 01:39:47.000000', '야간권', '대인', '1', '46000', '없음');");
			
			ResultSet rset = stmt.executeQuery("select * from report");
			System.out.println("날짜                  권종  연령구분 개수    가격    우대사항");

			while (rset.next()) {
				System.out.println(rset.getString(1) + "  " + rset.getString(2) + "  " + rset.getString(3) + "     "
						+ rset.getString(4) + "      " + rset.getString(5) + "     " + rset.getString(6));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
