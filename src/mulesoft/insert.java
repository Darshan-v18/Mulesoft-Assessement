package mulesoft;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class insert {
	private Connection connect (String dbName) {
		String url = "jdbc:sqlite:C://sqlite/"+dbName+".db";
		Connection conn = null;
		try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
   	}
	public void insertNewData(String db, String tblName) {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the Movie name");
		String name=scanner.nextLine();
		System.out.println("Enter the Actor name");
		String actor=scanner.nextLine();
		System.out.println("Enter the Actress name");
		String actress=scanner.nextLine();
		System.out.println("Enter the Director name");
		String director=scanner.nextLine();
		System.out.println("Enter the year of release");
		int yor=scanner.nextInt();
		
		String sql="INSERT INTO "+tblName+" (m_name,actor,actress,director,yor) VAlUES(?,?,?,?,?) ";
		try {
			    Connection conn = this.connect(db);  
			    PreparedStatement pstmt = conn.prepareStatement(sql);  
	            pstmt.setString(1, name);  
	            pstmt.setString(2, actor);
	            pstmt.setString(3, actress);
	            pstmt.setString(4, director);
	            pstmt.setInt(5, yor);  
	            pstmt.executeUpdate();  
	            System.out.println("Data inserted");
	        } 
			catch (SQLException e) {  
	        System.out.println(e.getMessage());  
	       }  
	}   
		
		
}

