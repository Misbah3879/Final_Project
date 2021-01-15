import javax.swing.*;
import java.util.Scanner;
import java.util.Date;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Bookseat implements ActionListener {
	JFrame jf;
	JLabel label,jl1,jl2,jl3,jl4,jl5,jl6;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JButton jb1,jb2,jb3,jb4,jb5;
	DBTasks dbt;
	 private static int[] seats = new int[12];
	Bookseat(){
		 
	jf=new JFrame("Luxurious BUS seat reservation system");
		dbt=new DBTasks();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(null);
		//jf.setVisible(true);
		jf.setSize(400,540);
		jf. getContentPane().setBackground(Color.lightGray);
	      jf.getRootPane().setBorder(BorderFactory.createEmptyBorder(0,4,4,4));
		
		label = new JLabel(" Reserve Seat" );
		  label.setFont(new Font("Century Gothic",Font.BOLD,20));
		  label.setForeground(Color.red);
		 label.setVerticalAlignment(JLabel.NORTH);
		label.setHorizontalAlignment(JLabel.CENTER);
		  label.setBounds(50,20,280,150);
		  jf.add(label);
		  
		jl1=new JLabel("Customer Full Name");
		jl1.setBounds(20,60,210,30);
		jl2=new JLabel("Contact No");
		jl2.setBounds(30,100,210,30);
		jl3=new JLabel(" Date");
		jl3.setBounds(30,140,210,30);
		jl4=new JLabel("Gender");
		jl4.setBounds(30,180,210,30);
		jl5=new JLabel("Age");
		jl5.setBounds(30,220,210,30);
		jl6=new JLabel("Price ");
		jl6.setBounds(30,260,210,30);
	//	jl7=new JLabel("Price");
	//	jl7.setBounds(30,300,210,30);
		
		tf1=new JTextField("");
		tf1.setBounds(140,60,170,30);
		tf2=new JTextField("");
		tf2.setBounds(140,100,170,30);
		tf3=new JTextField("dd-mm-yyyy");
		tf3.setBounds(140,140,170,30);
		tf4=new JTextField("");
		tf4.setBounds(140,180,30,30);
		tf5=new JTextField("");
		tf5.setBounds(140,220,170,30);
		tf6=new JTextField("Rs 1800");
		tf6.setBounds(140,260,170,30);
		//tf7=new JTextField("Rs 1800 ");
	//	tf7.setBounds(140,300,170,30);
		
		jb1=new JButton("Book Seat");
		jb1.setBounds(148,350,105,30);
		jb1.setBackground(Color.black);
	    jb1.setForeground(Color.red);
		jb1.addActionListener(this);
		jb2=new JButton("Clear");
		jb2.setBounds(260,350,90,30);
		jb2.setBackground(Color.black);
	    jb2.setForeground(Color.red);
		jb2.addActionListener(this);
		jb3=new JButton("Search seat");
		jb3.setBounds(10,350, 130,30);
		jb3.setBackground(Color.black);
	    jb3.setForeground(Color.red);
		jb3.addActionListener(this);
		jb4=new JButton("Delete Record");
		jb4.setBounds(30,400,140,30);
		jb4.setBackground(Color.black);
	    jb4.setForeground(Color.red);
		jb4.addActionListener(this);
		jb5=new JButton("Show All Records");
		jb5.setBounds(180,400,150,30);
		jb5.setBackground(Color.black);
	    jb5.setForeground(Color.red);
		jb5.addActionListener(this);
		
		jf.add(jl1);jf.add(jl2);jf.add(jl3);jf.add(jl4);jf.add(jl5);jf.add(jl6);//jf.add(jl7);
		jf.add(tf1);jf.add(tf2);jf.add(tf3);jf.add(tf4);jf.add(tf5);jf.add(tf6);//jf.add(tf7);
		jf.add(jb1);jf.add(jb2);jf.add(jb3);jf.add(jb4);jf.add(jb5);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
	}
	
	public static void main(String[]args)
	{
		new Bookseat();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==jb2)
		{
            tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
		}
		else
			if(e.getSource()==jb1)
		{
		 for (int i = 0; i < 12; i++) 
		 {
			 seats[i] = 0;
		 }
		 Scanner s = new Scanner(System.in);
		         int choice = 1;
		 System.out.print("Please enter 1 for window, 2 for without window, or 0 to exit: ");
		  choice = s.nextInt();
		  while (choice != 0)
		  {
			  int seatnumber = 0;
			  if (choice == 1) {
			   seatnumber = bookWindow();
		 if (seatnumber == -1) // No window seats available, try booking without window seat for them instead.
			 {
			   seatnumber = bookWithoutWindow();
			    if (seatnumber != -1) 
			    {
	 System.out.println("Sorry, we were not able to book a window seat. But do have without window seat.");
			   printBoardingPass(seatnumber);
			   }
			 }
	          else {
			    // Booking a window seat was successful.
			    System.out.println(" Good luck,  window seat is available!");
			   printBoardingPass(seatnumber);
			   }
			  }
			   if (choice == 2) {
			  // If customer want to book without window seat
			      seatnumber = bookWithoutWindow();
	            if (seatnumber == -1) // If not available, see if we have window seats available.
	            {
			       seatnumber = bookWindow();
			           if (seatnumber != -1)
			           {
	      System.out.println("Sorry, we were not able to book without window seat. But do have a window seat.");
			 printBoardingPass(seatnumber);
			   }
			    }
			    else {
                 // Booking an aisle seat was successful.
			    System.out.println(" Good luck, without window seat is available!");
			    printBoardingPass(seatnumber);
			    
			   }
			 }
			    else {
			         //  if they did not choose 1, 2, or 0 for their choice.
			    System.out.println("Invalid choice made. Please try again!");
			    choice = 0;
			     }
			  
			              // No window or without window seats were available. 
			   if (seatnumber == -1) {
			 System.out.println("We are sorry, there are no window or without window seats available.");
			    System.out.println();
			   }
			    System.out.print("Please enter 1 for window, 2 for aisle, or 0 to exit: ");
			  choice = s.nextInt();
			   }
		  JOptionPane.showMessageDialog(null,"seat booked,,,Record is inserted");
		dbt.insert(tf1.getText(),tf2.getText(),tf3.getText(),tf4.getText(),tf5.getText());
		
}
		else
			if(e.getSource()==jb3)
			{
				String res=dbt.SearchData(tf6.getText());
				if(res!=null)
				{
				System.out.println(res);
				String rs[]=res.split("#");
				    tf1.setText(rs[0]);
					tf2.setText(rs[1]);
					tf3.setText(rs[2]);
					tf4.setText(rs[3]);
					tf5.setText(rs[4]);
				}
				else
					JOptionPane.showMessageDialog(null, "No Record found ");
				
			}
			else 
				if(e.getSource()==jb4)
				{
					if(tf6.getText()!="")
					{
						int ans=dbt.Delete(tf6.getText());
						if(ans>0)
							JOptionPane.showMessageDialog(null, ans+" Seat free successfully");
						else
							JOptionPane.showMessageDialog(null, " seat is already free");
					}
				}
		
				else
					if(e.getSource()==jb5)
					{
						String allrecords=dbt.AllRecords();
						new AllRecords(allrecords);
					}				
}
	 // This function checks for window seats and returns seat number or -1 if full.
	
    private static int bookWindow() {
 for (int i = 0; i < 6; i++) {
 if (seats[i] == 0) {
 seats[i] = 1;
return i + 1;
}
}
 return -1;
 }

    // This function checks to see if without window seats were available, -1 if full.

    private static int bookWithoutWindow() {
  for (int i = 6; i < 12; i++) {
       if (seats[i] == 0) {
        seats[i] = 1;
         return i + 1;
   }
 }
return -1;
 }

  private static void printBoardingPass(int seatnumber) {
  System.out.println();
 System.out.println(" Reserve seat number: " + seatnumber);
  System.out.println("This ticket is non-refundable and non-transferable.");
  System.out.println();
  }
  
}