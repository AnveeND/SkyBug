package task2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;
import javax.swing.*;

public class Rules extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton start,Exit;
	Rules(){
		JLabel h = new JLabel("Welcome To The Quiz Game ");
		h.setBounds(150,60, 500,50);
		h.setFont(getFont());
		h.setFont(new Font("new",Font.BOLD,28));
		h.setForeground(new Color(255,165,0));
		
		JLabel r = new JLabel();
		r.setBounds(70,100, 700, 300);
		r.setFont(getFont());
		r.setFont(new Font("new2",Font.PLAIN,20));
		r.setForeground(new Color(170,51,106));
		r.setText(
				"<html>"
				+"******************************** RULES *********************************<br><br>"
				+ "1.Options will be provided for each question ."
				+ "<br><br>"
				+ "2.Timer will be of 15 sec. for each questions ."
				+ "<br><br>"
				+ "3. You can select only one of the options ."
				+ "<html>"
				);
		setSize(800,600);
		
		Exit = new JButton("Exit");
		Exit.setBounds(450, 450, 100, 30);
		Exit.setBackground(new Color(255,0,0));
		Exit.setForeground(Color.WHITE);
		Exit.addActionListener(this);
		
		
		
		start = new JButton("Start");
		start.setBounds(200, 450, 100, 30);
		start.setBackground(new Color(0,0,255));
		start.setForeground(Color.WHITE);
		start.addActionListener(this);
				
				
				
		setLocation(350,100);
		setVisible(true);
		setLayout(null);
		add(h);
		add(r);
		add(start);
		add(Exit);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==start) {
			setVisible(false);
			new quiz();
			
		}else {
			setVisible(false);
		}
	}
	public static void main(String args[])
	{
		new Rules();
		
	}

}
