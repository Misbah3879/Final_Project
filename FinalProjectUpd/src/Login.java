import java.awt.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.border.*;
class Login  implements ActionListener
 {
  JButton SUBMIT; 
 JFrame jf;
  JLabel  labels , flabel,label1,label2,labelPic;
  Font f;
  final JTextField  text1,text2;
   Login()
  {
	   jf = new JFrame("Luxurious BUS seat reservation system");
       jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jf.setSize( 450, 400);
      jf. getContentPane().setBackground(Color.lightGray);
      jf.getRootPane().setBorder(BorderFactory.createEmptyBorder(0,4,4,4));
     labelPic=new JLabel("");
     ImageIcon img= new ImageIcon("books.PNG");
     labelPic.setIcon(img);
     labelPic.setBounds(0,0,430,140);
   
     flabel = new JLabel("Seat Reservation System");
     flabel.setBounds(60,130,300,50);
     flabel.setForeground(Color.red);
     f = new Font("Arial",Font.ITALIC,26);
     flabel.setFont(f);
     

     labels = new JLabel("You must first LOGIN to access the system");
      labels.setBounds(10,160,400,50);
     
      label1 = new JLabel("Username:");
       label1.setBounds(70,190,100,50);
       
       text1 = new JTextField();
       text1.setBounds(180,200,150,30);
       
   label2 = new JLabel("Password:");
   label2.setBounds(70,240,100,50);
   
      text2 = new JPasswordField();
     text2.setBounds(180,250,150,30);
     
   SUBMIT=new JButton("SUBMIT");
   SUBMIT.setBounds(140,290,100,40);
   SUBMIT.setBackground(Color.black);
   SUBMIT.setForeground(Color.red);
   
  jf.add(labelPic);
  jf.add(flabel);
  jf.add(labels);
   jf.add(label1);
   jf.add(text1);
   jf.add(label2);
   jf.add(text2);
   jf.add(SUBMIT);
  jf.setLayout(null);
   jf.setVisible(true);
   SUBMIT.addActionListener(this);
   jf.setLocationRelativeTo(null);
   }
  public void actionPerformed(ActionEvent e)
   {
  String value1=text1.getText();
  String value2=text2.getText();
   if (value1.equals("Misbah") && value2.equals("12345")) {
   NextPage page=new NextPage();
   String un;
   un=value1;
   
   }
   else{
   
   JOptionPane.showMessageDialog(null,"Incorrect username or password","Password",JOptionPane.WARNING_MESSAGE);
   text1.setText("");
   text2.setText("");
   }
 }
  public static void main(String[] args) 
   {
   new Login();
   }
  }