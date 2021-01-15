import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class DBTasks {
	Connection con;
	DBTasks(){
 String url = "jdbc:mysql://localhost:3306/testdb?allowPublicKeyRetrieval=true&useSSL=false";
        String user = "testuser";
        String password = "test623";
	    String Q1 ="DROP TABLE IF EXISTS Person";
	    String Q2="CREATE TABLE Person(Id BIGINT PRIMARY KEY AUTO_INCREMENT, Name VARCHAR(100), ContactNo VARCHAR(13), Date VARCHAR(12), Gender VARCHAR(1),Age INTEGER)";
	     try {con = DriverManager.getConnection(url, user, password);
	       PreparedStatement pst = con.prepareStatement(Q1);
	         pst.execute(Q1);
	         pst.execute(Q2); 
	        } catch (SQLException ex) {

	         Logger lgr = Logger.getLogger(DBTasks.class.getName());
	             lgr.log(Level.SEVERE, ex.getMessage(), ex);
	        }
	    }
	
	public void insert(String name, String cont ,String date,String gen ,String age)
	{
		int age1=Integer.parseInt(age);
		//int SN1=Integer.parseInt(SN);
		
		String sql = "insert into Person(Name,ContactNo,Date,Gender,Age)"
		+" values (?,?,?,?,?)";
		try
		{
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, cont);
			pst.setString(3, date);
			pst.setString(4, gen);
			pst.setInt(5, age1);
		//	pst.setInt(6,sno);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"A new record has been inserted");
          //  System.out.println("A new record has been inserted");

        } catch (SQLException ex) {

            System.out.println(ex.getStackTrace());
            }
		}
		
	public String SearchData(String SN)
	{	
		int SN1=Integer.parseInt(SN);
		String sql = "Select * from Person where seat number is " + SN1;
		System.out.println(sql);
		String ans=null;
		try
		{
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs= pst.executeQuery();
         while(rs.next())
         {  ans=rs.getString(1)+"#"+rs.getString(2)+"#"+rs.getString(3)  +"#"+rs.getString(4)+"#"+rs.getInt(5);
                System.out.println("Data is "+ans);}
           
           // System.out.print(rs.getString(2));
           return ans;

        } catch (SQLException ex) {

        	 Logger lgr = Logger.getLogger(DBTasks.class.getName());
             lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
		return null;
		}
		
	public int Delete(String SN)
	{
		int SN1=Integer.parseInt(SN);
		String sql = "Free the seat where number like"+ SN1;
		System.out.println(sql);
		String ans="";
		try
		{
			PreparedStatement pst=con.prepareStatement(sql);
			
           int rows= pst.executeUpdate();
         
           return rows;

        } catch (SQLException ex) {

        	 Logger lgr = Logger.getLogger(DBTasks.class.getName());
             lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
		return 0;
		}
		
	public String AllRecords()
	{
		
		
		String sql = "Select * from Person";
		//System.out.println(sql);
		String ans=null;
		try
		{
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs= pst.executeQuery();
           ans="";
         while(rs.next())
         {  ans+=rs.getString(1)+"  " + rs.getString(2)+"  "+rs.getString(3)+ "  "+rs.getString(4)+"  "+rs.getInt(5)+ "  "+rs.getInt(6)  +"\n";
                }
           
           // System.out.print(rs.getString(2));
           return ans;

        } catch (SQLException ex) {

        	 Logger lgr = Logger.getLogger(DBTasks.class.getName());
             lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
		return null;
		}
	 public static void main(String[] args) 
	   {
	 //  new Feedback();
	   }
	
	}