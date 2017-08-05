package DataBase;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

	public List<String> selectAll() throws SQLException;
	public void deleteById(int id) throws SQLException;
	public void insert(User user) throws SQLException;
}
