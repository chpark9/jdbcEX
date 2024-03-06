package jdbcEX;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcEX4 {

	public static void main(String[] args) {
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String DBURL = "jdbc:mysql://localhost:3306/study";
		String DBID = "root";
		String DBPW = "12345678";
		
		try {
				Class.forName(DRIVER);
				Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);
				String sql = "select * from student where id=?";
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, "2");
				ResultSet result = preparedStatement.executeQuery();
				
				while(result.next()) {
					System.out.println(result.getString(1));
					System.out.println(result.getString(2));
					System.out.println(result.getString(3));
				}
				con.close();
		} catch (ClassNotFoundException e) {
				System.out.println("JDBC 드라이버 오류");
		} catch (SQLException e) {
				System.out.println("DB 연결 오류");
		}
	}

}
