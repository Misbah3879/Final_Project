import java.awt.FlowLayout;
import javax.swing.*;
public class AllRecords {
	JFrame jf;
	AllRecords(String outp)
	{
	 jf=new JFrame("Detail of All records");
		jf.setLayout(new FlowLayout());
		JTextArea textArea = new JTextArea(200, 200);
	    textArea.setText(outp);
	    textArea.setWrapStyleWord(true);
	    textArea.setLineWrap(true);
	    textArea.setOpaque(false);
	    textArea.setEditable(false);
	    textArea.setFocusable(false);
	    jf.add(textArea);
		jf.setSize(300,300);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
	}
	
}