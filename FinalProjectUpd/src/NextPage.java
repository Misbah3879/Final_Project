import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
class NextPage  implements ActionListener
 {
  JFrame f = new JFrame();
	 JTextArea  area = new JTextArea(10,30);
	 JLabel label , label1;
	 JScrollPane sp;
	 JButton b ;
	 JMenuBar mb;
    JMenu m1,m2;
	 JMenuItem m11,m22;
   NextPage()
  {
	//   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  f. getContentPane().setBackground(Color.lightGray);
      f.getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
  f.setTitle("Luxurious BUS seat reservation system");
  f.setSize(500, 400);
  label = new JLabel("Welcome ! " );
  label.setFont(new Font("Century Gothic",Font.BOLD,16));
  label.setForeground(Color.red);
  label.setVerticalAlignment(JLabel.NORTH);
  label.setHorizontalAlignment(JLabel.CENTER);
  label.setBounds(140,50,150,150);
  f.add(label);
	
    sp = new JScrollPane (area);
   sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    area.setText("We implemented a Seat Reservation System to give you"
    		+ " an opportunity to reserve a seat for travelling through a bus from Karachi to Islamabad."
  	  		+ "A reservation ensures that the seat is saved for you and cannot be taken by another person during your scheduled time."
  	  		+ "If you have used our system and would like to provide FEEDBACK,we would love to hear from you.This is a new system and we "
  	  		+ "hope to adopt it to our users needs as we go.");
    area.setFont(new Font("Century Gothic",Font.BOLD,16));
  area.setBackground(Color.lightGray);
    area.setLineWrap(true);
    area.setWrapStyleWord(true);
  //  area.setOpaque(false);
    area.setEditable(false);
    area.setFocusable(false);
     area.setBounds(30,80,450,200);
     sp.setBounds(30,80,435,150);
      f.add(sp);
      
      b =new JButton("FEEDBACK");
      b.setBounds(360,260,100,40);
      b.setBackground(Color.black);
      b.setForeground(Color.red);
      f.add(b);
      
      label1 = new JLabel("Contacts:  051-23654 , 0316-5157121 " );
      label1.setFont(new Font("Century Gothic",Font.BOLD,14));
      //label.setForeground(Color.red);
     // label.setVerticalAlignment(JLabel.NORTH);
      //label.setHorizontalAlignment(JLabel.CENTER);
      label1.setBounds(20,310,300,50);
      f.add(label1);
      
       mb = new JMenuBar();
       m1 = new JMenu("DETAIL");
       m2 = new JMenu("SEAT");
      mb.add(m1);
      mb.add(m2);
       m11 = new JMenuItem("Reserve Seat");
       m22 = new JMenuItem("Cancel Seat");
      m2.add(m11);
    //  m2.add(m22);
      mb.setBounds(0,0,500,40);
      mb.setBackground(Color.black);
      m1.setForeground(Color.red);
      m2.setForeground(Color.red);
      f.add(mb);
      
   f.setLayout(null);
   f.setVisible(true);
  f.setLocationRelativeTo(null);
  b.addActionListener(this);
  m11.addActionListener(this);
  m22.addActionListener(this);
   }
   
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==b)
		{
		Feedback fd = new Feedback();
		}
		   if (e.getSource() == m11)
		 {  
			Bookseat bs = new Bookseat();
		 }
		
	}
	 public static void main(String[] args) 
	   {
	   new NextPage();
	   }	
  }