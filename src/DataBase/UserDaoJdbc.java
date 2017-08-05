package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDaoJdbc implements UserDao{

	private Connection connection;
	private static final String DRIVER_NAME = "com.msql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/FACTORY";
	private final String USER_PASSWORD = "root";
	private final String USER_NAME = "root";
	private static DataSource ds;
	
	static{
		/*try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		try{
			Context initCtx = new InitialContext();
	
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
	
			ds = (DataSource)envCtx.lookup("jdbc/FACTORY");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private Connection getConnection() throws SQLException{
		return ds.getConnection("root", "root");
	}
	
	@Override
	public List<String> selectAll() throws SQLException {
		List<String> result = new ArrayList<>();
		connection = getConnection();
		
		SQLQuerryBuilder builder = new SQLQuerryBuilder();
		String querry = builder.select("*").from("Users").build();
		
		PreparedStatement statement = connection.prepareStatement(querry);
		
		ResultSet rs = statement.executeQuery();
		while(rs.next()){
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setAge(rs.getInt("age"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
			result.add(user.toString());
		}
		
		return result;
	}

	@Override
	public void deleteById(int id) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		
	}

}
