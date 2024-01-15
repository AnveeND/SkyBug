package skybug_internship;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;



public class reg extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField rn,fnm,lnm,em;
	JButton sb,bk;
	JComboBox<Object> dp1,dp2,dp3;

	public reg()
	{

		setLocation(400,100);
		setVisible(true);
		setLayout(null);
		setSize(500,600);
		getContentPane().setBackground(Color.PINK);

		JLabel l = new JLabel("COURSE REGISTRATION ");
		add(l);
		l.setSize(500,30);
		l.setLocation(110, 10);
		l.setFont(new Font("new",Font.BOLD,20));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel rollno = new JLabel("Roll number :- ");
		add(rollno);
		rn = new JTextField();
		add(rn);
		rollno.setBounds(10,100,100,20);
		rn.setBounds(90, 100, 50, 20);

		JLabel fname = new JLabel("First Name :- ");
		add(fname);
		fname.setBounds(10,150,150,20);
		fnm = new JTextField();
		add(fnm);
		fnm.setBounds(90, 150,250, 20);

		JLabel lname = new JLabel("Last Name :- ");
		add(lname);
		lname.setBounds(10,200,150,20);
		lnm = new JTextField();
		add(lnm);
		lnm.setBounds(90, 200,250, 20);


		JLabel email = new JLabel("Email Address :- ");
		add(email);
		email.setBounds(10,250,150,20);
		em = new JTextField();
		add(em);
		em.setBounds(110, 250,310, 20);




		String course[] ={" ","python","Java","JavaScript","MEAN Stack","MERN Stack","Web Development"};

		JLabel c1 = new JLabel("Course 1 :");
		add(c1);
		c1.setBounds(30, 300, 100, 20);
		dp1 = new JComboBox<Object>(course);
		add(dp1);
		dp1.setBounds(20,330,100,20);

		JLabel c2 = new JLabel("Course 2 :");
		add(c2);
		c2.setBounds(200, 300, 100, 20);
		dp2 = new JComboBox<Object>(course);
		add(dp2);
		dp2.setBounds(190,330,100,20);

		JLabel c3 = new JLabel("Course 3 :");
		add(c3);
		c3.setBounds(370, 300, 100, 20);
		dp3 = new JComboBox<Object>(course);
		add(dp3);
		dp3.setBounds(350,330,100,20);



		sb = new JButton("SUBMIT");
		sb.setBounds(130, 520,80, 25);
		add(sb);
		sb.setVisible(true);
		sb.addActionListener(this);	

		bk = new JButton("BACK");
		bk.setBounds(270, 520,80, 25);
		add(bk);
		bk.setVisible(true);
		bk.addActionListener(this);

	}
	public void actionPerformed(ActionEvent ac) {
		if(ac.getSource()==sb) {
			int roll = Integer.parseInt(rn.getText());
			String firstname = fnm.getText();
			String lastname = lnm.getText();
			String emailaddress = em.getText();
			String co1=(String) dp1.getSelectedItem();
			String co2=(String) dp2.getSelectedItem();
			String co3=(String) dp3.getSelectedItem();

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/courses","root","hello@123");

				String qry1 = "insert into student values (?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(qry1);
				ps.setInt(1, roll);
				ps.setString(2, firstname);
				ps.setString(3, lastname);
				ps.setString(4,emailaddress);
				ps.setString(5,co1);
				ps.setString(6,co2);
				ps.setString(7,co3);
				int i=ps.executeUpdate();
				JOptionPane.showMessageDialog(sb,i+" Record Added Successfully!!");

				if(co1=="python" || co2=="python"||co3=="python") {
					String q2="Update crs set capacity=capacity-1 where cid=1 ";
					PreparedStatement ps2 = con.prepareStatement(q2);
					ps2.executeUpdate();
				}
				if(co1=="Java" || co2=="Java"||co3=="Java") {
					String q3="Update crs set capacity=capacity-1 where cid=2 ";
					PreparedStatement ps3 = con.prepareStatement(q3);
					ps3.executeUpdate();
				}
				if(co1=="JavaScript" || co2=="JavaScript"||co3=="JavaScript") {
					String q4="Update crs set capacity=capacity-1 where cid=3 ";
					PreparedStatement ps4 = con.prepareStatement(q4);
					ps4.executeUpdate();
				}
				if(co1=="MEAN Stack" || co2=="MEAN Stack"||co3=="MEAN Stack") {
					String q5="Update crs set capacity=capacity-1 where cid=4 ";
					PreparedStatement ps5 = con.prepareStatement(q5);
					ps5.executeUpdate();
				}
				if(co1=="MERN Stack" || co2=="MERN Stack"||co3=="MERN Stack") {
					String q6="Update crs set capacity=capacity-1 where cid=5 ";
					PreparedStatement ps6 = con.prepareStatement(q6);
					ps6.executeUpdate();
				}
				if(co1=="Web Development" || co2=="Web Development"||co3=="Web Development") {
					String q7="Update crs set capacity=capacity-1 where cid=6 ";
					PreparedStatement ps7 = con.prepareStatement(q7);
					ps7.executeUpdate();
				}


				ps.close();
				con.close();	

			}catch(Exception e) {System.out.println(e);}
		}
		else {
			new task4();
		}


	}


	public static void main(String args[])
	{
		new reg();
	}
}
