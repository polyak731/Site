package DataBase;

import java.sql.SQLException;

public class Test {

	public static void main(String args[]) throws SQLException{
		UserDaoJdbc udj = new UserDaoJdbc();
		System.out.println(udj.selectAll());
	}
}
