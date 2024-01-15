package task2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Override;
import java.lang.String;
import javax.swing.*;

public class quiz extends JFrame implements ActionListener {
	
	
	private static final long serialVersionUID = 1L;

	
	/*
	  Three arrays are used :-
	   
	  - one array to store questions.
	  - another array to store correct answers.
	  - one more array to store users answers. 
	  
	 */
	
	String q[][] = new String[10][5] ; //array to store questions with options 
	String uans[][]= new String[10][1]; // array to store user answers
	String ans[][]= new String[10][2]; // array to store correct answers 
	
	
	JLabel qno,qs;
	JRadioButton op1,op2,op3,op4;
	ButtonGroup grp;
	JButton next,submit;
	public static int timer = 15,score = 0,ans_no=0,count = 0;
	

	
	quiz(){
		setSize(1240,700);
		setLocation(50,0);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		setLayout(null);
		
		qno = new JLabel();
		qno.setBounds(50,59,50,30);
		qno.setFont(new Font("new3",Font.PLAIN,24));
		add(qno);
		
		
		qs = new JLabel();
		qs.setBounds(100,59,1100,30);
		qs.setFont(new Font("new3",Font.PLAIN,24));
		add(qs);
		
		q[0][0] = "Which of the following is a programming language?";
        q[0][1] = "Python";
        q[0][2] = "Photoshop";
        q[0][3] = "Microsoft Word";
        q[0][4] = "Adobe Illustrator";

        q[1][0] = "Which programming paradigm emphasizes on writing code that is easy to read and maintain?";
        q[1][1] = "Procedural programming";
        q[1][2] = "Object-oriented programming";
        q[1][3] = "Functional programming";
        q[1][4] = "Structured programming";

        q[2][0] = "What is the term used for a block of code that is executed repeatedly until a certain condition is met?";
        q[2][1] = "Function";
        q[2][2] = "Loop";
        q[2][3] = "Condition";
        q[2][4] = "Variable";

        q[3][0] = "Which data structure is used for storing a collection of elements in a non-linear fashion?";
        q[3][1] = "Array";
        q[3][2] = "Stack";
        q[3][3] = "Queue";
        q[3][4] = "Tree";

        q[4][0] = "Which operator is used for exponentiation in most programming languages?";
        q[4][1] = " ^";
        q[4][2] = " *";
        q[4][3] = " %";
        q[4][4] = " **";

        q[5][0] = "Which programming language is used for developing Android apps?";
        q[5][1] = "Java";
        q[5][2] = "C#";
        q[5][3] = "Python";
        q[5][4] = "Swift";

        q[6][0] = "Which of the following is not a valid variable name in most programming languages?";
        q[6][1] = "myVariable";
        q[6][2] = "123Variable";
        q[6][3] = "_myVariable";
        q[6][4] = "my_variable";

        q[7][0] = "Which of the following is a type of sorting algorithm?";
        q[7][1] = "Binary search";
        q[7][2] = "Quick sort";
        q[7][3] = "Depth-first search";
        q[7][4] = "Breadth-first search";

        q[8][0] = "Which of the following is not a web browser?";
        q[8][1] = "Chrome";
        q[8][2] = "Safari";
        q[8][3] = "Firefox";
        q[8][4] = "Photoshop";

        q[9][0] = "Which programming language is used for developing iOS apps?";
        q[9][1] = "Java";
        q[9][2] = "C#";
        q[9][3] = "Python";
        q[9][4] = "Swift";
        
        ans[0][1] = "Python";
        ans[1][1] = "Object-oriented programming";
        ans[2][1] = "Loop";
        ans[3][1] = "Tree";
        ans[4][1] = " **";
        ans[5][1] = "Java";
        ans[6][1] = "123Variable";
        ans[7][1] = "Quick sort";
        ans[8][1] = "Photoshop";
        ans[9][1] = "Swift";
        
        //Creating buttons for options 
        op1 = new JRadioButton();
        op1.setBounds(170, 320, 700, 30);
        op1.setBackground(Color.WHITE);
        op1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(op1);
        op2 = new JRadioButton();
        op2.setBounds(170, 360, 700, 30);
        op2.setBackground(Color.WHITE);
        op2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(op2);
        op3 = new JRadioButton();
        op3.setBounds(170, 400, 700, 30);
        op3.setBackground(Color.WHITE);
        op3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(op3);
        op4 = new JRadioButton();
        op4.setBounds(170, 440, 700, 30);
        op4.setBackground(Color.WHITE);
        op4.setFont(new Font("Dialog",Font.PLAIN,20));
        add(op4);
		
        //Grouping buttons for selecting only one option at a time 
        
        grp = new ButtonGroup();
        grp.add(op1);
        grp.add(op2);
        grp.add(op3);
        grp.add(op4);
        
        //Buttons 
        next = new JButton("NEXT");
        next.setBounds(300,550,200,30);
        next.setBackground(new Color(22,99,54));
        next.setForeground(Color.WHITE);
        add(next);
        next.addActionListener(this);
        submit = new JButton("SUBMIT");
        submit.setBounds(550,550,200,30);
        submit.setBackground(new Color(255,219,0));
        submit.setForeground(Color.BLACK);
        add(submit);
        submit.addActionListener(this);
        start(count);
        
        
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==next) {
			repaint();
			op1.setEnabled(true);
			op2.setEnabled(true);
			op3.setEnabled(true);
			op4.setEnabled(true);
			ans_no = 1;
			if(grp.getSelection()==null) {
				uans[count][0] = "";
				
			}else {
				uans[count][0] = grp.getSelection().getActionCommand();
			}//user should answer minimum 8 questions to submit
			if(count == 8) {
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			count++;
			start(count);
			
			
		}else if (e.getSource() == submit) {
			ans_no = 1;
			if(grp.getSelection()==null) {
				uans[count][0]="";
				
			}else {
				uans[count][0]=grp.getSelection().getActionCommand();
				
			}
			for(int i =0;i<uans.length;i++) {
				if(uans[i][0].equals(ans[i][1])) {
					score+=1;  //increment score by 1 for each correct answer
					
				}else {
					score+=0;
					
				}
				
				
			}
			setVisible(false);
			new score(score);
	
			
		}
		
		
	}
	//Timer:-
	
	public void paint(Graphics g) {
		super.paint(g);
		String time = "Time left - "+timer+" seconds";
		g.setColor(Color.BLUE);
		g.setFont(new Font("new3",Font.BOLD,25));
		if(timer>0) {
			g.drawString(time, 800, 500);     //drawString() is used to display the string 
		}else {
			g.drawString("Times up!!", 1100, 500);
		}
		timer --;
		try {
			Thread.sleep(1000);
			repaint();
			
			
		}catch(Exception e) {
			e.printStackTrace();
				
		}
		if(ans_no==1) {
			ans_no=0;
			timer = 15;
			start(count);
			
		}else if(timer < 0) {
			timer = 15;
			op1.setEnabled(true);
			op2.setEnabled(true);
			op3.setEnabled(true);
			op4.setEnabled(true);
			
			if(count==8) {
				next.setEnabled(false);
				submit.setEnabled(true);
				
			}
			if(count == 0) {
				if(grp.getSelection()==null) {
					uans[count][0] = "";
					
					
				}else {
					uans[count][0] = grp.getSelection().getActionCommand();
					
					}
				for(int i=0;i<uans.length;i++) {
					if(uans[i][0].equals(ans[i][1])) {
						score +=1;
						
					}else {
						score+=0;
						
					}
				}
				setVisible(false);
				new score(score);
			}else {
				if(grp.getSelection()==null) {
					uans[count][0]="";
					
				}else {
					uans[count][0]=grp.getSelection().getActionCommand();
					
				}count++;
				start(count);
				
			}
			
		}
		
	}
	public void start(int count) {
		qno.setText(""+(count+1)+". ");
		qs.setText(q[count][0]);
		op1.setText(q[count][1]);
		op1.setActionCommand(q[count][1]);
		op2.setText(q[count][2]);
		op2.setActionCommand(q[count][2]);
		op3.setText(q[count][3]);
		op3.setActionCommand(q[count][3]);
		op4.setText(q[count][4]);
		op4.setActionCommand(q[count][4]);
		
		grp.clearSelection();
		
	}

	public static void main(String[] args) {
		new quiz();

	}

}
