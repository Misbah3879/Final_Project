import javax.swing.*;
import java.awt.*;
public class Survey                         
 {
  JFrame fr = new JFrame();
	 JLabel label1, label2	;
	Font f;
   Survey()
  {
	//   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  fr. getContentPane().setBackground(Color.lightGray);
	      fr.getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
	  fr.setTitle("Luxurious BUS seat reservation system");
	  fr.setSize(450, 200);
	  label1 = new JLabel("Seat Reservation Feedback ! ");
	  label1.setForeground(Color.red);
	  label1.setVerticalAlignment(JLabel.NORTH);
	  label1.setHorizontalAlignment(JLabel.CENTER);
	  label1.setBounds(40,20,400,150);
	  f = new Font("Arial",Font.ITALIC,26);
	  label1.setFont(f);
	  fr.add(label1);
	  
	  label2 = new JLabel("THANKS, your feedback was submitted !");
	  label2.setFont(new Font("Arial",Font.ITALIC,16));
	  label2.setBounds(80,40,400,100);
	  fr.add(label2);
	  
	  fr.setLayout(null);
	   fr.setVisible(true);
	  fr.setLocationRelativeTo(null);
 }
   
   public static void main(String[] args) 
   {
   new Survey();
   }
 }