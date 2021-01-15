import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener; 
public class Feedback  implements ActionListener,ItemListener
 {
	JFrame fr = new JFrame();
	 JTextArea  area ;
	 JLabel label, 	q1 ,q2 ,q3	, lr;
	 JButton submit ;
	Font f;
   JRadioButton rb1,rb2 ,b1,b2,b3,b4,b5;
   Feedback()
  {
	//   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  fr. getContentPane().setBackground(Color.lightGray);
	      fr.getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
	  fr.setTitle("Luxurious BUS seat reservation system");
	  fr.setSize(500, 650);
	  label = new JLabel("Seat Reservation Feedback ! ");
	  label.setForeground(Color.red);
	  label.setVerticalAlignment(JLabel.NORTH);
	  label.setHorizontalAlignment(JLabel.CENTER);
	  label.setBounds(40,40,400,150);
	  f = new Font("Arial",Font.ITALIC,26);
	  label.setFont(f);
	  fr.add(label);
	  
	  q1 = new JLabel("How was your experience making your reservation? ");
	  q1.setFont(new Font("Arial",Font.BOLD,16));
	  q1.setBounds(20,70,400,100);
	  fr.add(q1);
	  
	  lr = new JLabel("(required) ");
	  lr.setFont(new Font("Arial",Font.BOLD,16));
	  lr.setBounds(20,90,400,100);
	  fr.add(lr);
	  
	  q2 = new JLabel("Do you have trouble during your journey?(required) ");
	  q2.setFont(new Font("Arial",Font.BOLD,16));
	  q2.setBounds(20,220,400,100);
	  fr.add(q2);
	  
	  q3 = new JLabel("What feedback do you have for us? ");
	  q3.setFont(new Font("Arial",Font.BOLD,16));
	  q3.setBounds(20,380,400,100);
	  fr.add(q3);
	  
	  area = new JTextArea();
	  area.setBounds(20,450,410,50);
	  fr.add(area);
	  
	  submit=new JButton("SUBMIT");
	   submit.setBounds(30,520,100,40);
	   submit.setBackground(Color.black);
	   submit.setForeground(Color.red);
	   fr.add(submit);
	   
	   rb1 = new JRadioButton("Yes");  
       rb1.setBounds(50,300, 100,50); 
        rb2 = new JRadioButton("No");  
       rb2.setBounds(50,350, 100,50);  
       
       b1 = new JRadioButton(" Worst");  
       b1.setBounds(50,180, 100,30); 
        b2 = new JRadioButton(" Bad");  
       b2.setBounds(150,180, 100,30); 
       b3 = new JRadioButton(" Natural");  
       b3.setBounds(270,180, 100,30); 
        b4 = new JRadioButton(" Good");  
       b4.setBounds(50,200, 100,30);
       b5 = new JRadioButton(" Excellent");  
       b5.setBounds(150,200, 100,30);  
       
       ButtonGroup bg=new ButtonGroup();
       ButtonGroup bg1=new ButtonGroup();
       rb1.setBackground(Color.lightGray);
       rb2.setBackground(Color.lightGray);
       b1.setBackground(Color.lightGray);
       b2.setBackground(Color.lightGray);
       b3.setBackground(Color.lightGray);
       b4.setBackground(Color.lightGray);
       b5.setBackground(Color.lightGray);
       bg.add(rb1);
       bg.add(rb2);
       bg1.add(b1);
       bg1.add(b2);
       bg1.add(b3);
       bg1.add(b4);
       bg1.add(b5);
       fr.add(rb1); fr.add(rb2); fr.add(b1);fr.add(b2);fr.add(b3);fr.add(b4);fr.add(b5);
    //   f.add(label);  
      rb1.addItemListener(this);
       rb2.addItemListener(this);
       b1.addItemListener(this);
       b2.addItemListener(this);
       b3.addItemListener(this);
       b4.addItemListener(this);
       b5.addItemListener(this);
       
	  fr.setLayout(null);
	   fr.setVisible(true);
	   submit.addActionListener(this);
	  fr.setLocationRelativeTo(null);
  }  
	  
   public void actionPerformed(ActionEvent e)
	{ 
 if( ((rb1.isSelected())||(rb2.isSelected()))&&((b1.isSelected())||(b2.isSelected())||(b3.isSelected())||(b4.isSelected())||(b5.isSelected())))
	   {
	   if (e.getSource()==submit)
	   {
		Survey sv = new Survey();
	   }}
	   else 
		   JOptionPane.showMessageDialog(null,"These are required questions");
	}
   public void itemStateChanged(ItemEvent e) { }
   
	  public static void main(String[] args) 
	   {
	   new Feedback();
	   }
  
  }