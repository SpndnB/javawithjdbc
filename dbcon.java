import java.sql.*;

class ConOra
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	public void showData()
	{
		//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		try
		{
			String driver="oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String userid="system";
			String password="spandan";
			con=DriverManager.getConnection(url,userid,password);
			stmt=con.createStatement();
			String query="SELECT SID,SNAME,AGE,RATING FROM SAILOR";
			rs=stmt.executeQuery(query);
			while(rs.next())
			{
				System.out.println(rs.getInt("SID")+" "+rs.getString("SNAME")+" "+rs.getString("AGE")+" "+rs.getDouble("RATING"));
			}
			con.close();
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}
}
class Demo
{
	public static void main(String[] args)
	{
		ConOra ob= new ConOra();
		ob.showData();
	}
}
