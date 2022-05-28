package mulesoft;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;
 
public class connect {
	public static  void connect(String dbname) {
        Connection conn = null;
//        Statement stmt=null;
        try {
        	  String url = "jdbc:sqlite:C:/sqlite/"+dbname+".db";
              
              conn = DriverManager.getConnection(url);
              
              System.out.println("Connection to SQLite of name " + dbname +" has been established");
              
//              stmt = conn.createStatement();
              
             // String sql = "CREATE TABLE movie " +"(m_id INTEGER PRIMARY KEY AUTOINCREMENT," +" m_name TEXT NOT NULL, " +"actor  TEXT NOT NULL, " +" actress  TEXT NOT NULL,director  TEXT NOT NULL,year_of_release INTEGER NOT NULL) " ;
            //  stmt.executeUpdate(sql);
              
             // stmt.close();

             // conn.close();
              
//              System.out.println("Table created successfully");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
    }
	public static boolean check(String dbName) {
		File file = new File("C:\\sqlite\\" + dbName + ".db");
		if (file.exists()) {
			return true;
		}
		return false;

	}
}
