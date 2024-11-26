import java.sql.*;

public class mysqlConn {
  public static void main (String [] args){
  
//defining the connection string
  String url = "jdbc:mysql://165.227.235.122/ss2979_LargeScaleDataProcessing";

String username = "ss2979_ci502";
String password = "ci502Brighton";

//declaring the JDBS objects
Connection con = null;
Statement stmt = null;
ResultSet rs = null;

//establishing the connection to MySQL DBMS
try {
  System.out.println("Loading the JDBC Driver");
  Class.forName("com.mysql.cj.jdbc.Driver");
  System.out.println("Establishing connection");

  con = DriverManager.getConnection(url,username,password);
  
  //create and execute an SQL Statement
  System.out.println("Executing SQL");
  String SQL = "SELECT * FROM tCust";
  stmt = con.createStatement();
  rs = stmt.executeQuery(SQL);
  while (rs.next()){
    System.out.println(rs.getInt(1) + " " + rs.getString(4));
    }
}
 catch (Exception e) {e.printStackTrace();}
//closing the connection
try {
  con.close();
}
catch (Exception e) {}
}
}

