package DataBase;

public class SQLQuerryBuilder {

	private String querry;
	private final String SELECT = "SELECT";
	private final String INSERT = "INSERT";
	private final String DELETE = "DELETE";
	
	private final String FROM = "FROM";
	private final String ALL = "*";
	private final String PARAM = "?";
	
	private final String WHERE = "WHERE";
	private final String EQUALS = "=";
	
	private StringBuilder builder;
	
	public SQLQuerryBuilder(){
		builder = new StringBuilder();
	}
	
	public SQLQuerryBuilder select(String ...colls){
		builder.append(SELECT);
		builder.append(" ");
		for(String coll:colls){
			builder.append(coll);
			builder.append(",");
		}
		builder.deleteCharAt(colls.length);
		
		return this;
	}
	
	public SQLQuerryBuilder from(String table){
		
		builder.append(" ");
		builder.append(FROM);
		builder.append(" ");
		builder.append(table);
		
		return this;
	}
	
	public String build(){
		return builder.toString();
	}
}
