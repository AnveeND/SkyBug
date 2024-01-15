package skybug_internship;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class table extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	table()
	{  
		this.setLocation(250, 200);
		this.setPreferredSize(new Dimension(900,400));  
		getContentPane().setBackground(Color.white);
		setVisible(true);    
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container cnt = this.getContentPane();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("CourseID");
		model.addColumn("NAME");
		model.addColumn("DURATION");
		model.addColumn("SEATS");
		model.addColumn("START DATE");
		try {
			cnt.setLayout(new FlowLayout(FlowLayout.CENTER,15,70));
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/courses","root","hello@123");

			Statement st = con.createStatement();
			String qry="select * from crs";
			ResultSet rs=st.executeQuery(qry);
			String obj1[]= {"CourseID","NAME","DURATION","SEATS","START DATE"};
			model.addRow(obj1);
			while(rs.next())
			{
				String cd = rs.getString("cid");
				String cn = rs.getString("cname");
				String du = rs.getString("duration");
				String cap=rs.getString("capacity");
				String sd=rs.getString("startdate");
				model.addRow(new Object[]{cd,cn,du,cap,sd});
			}


			st.close();
			con.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

		JTable jt=new JTable(model); 
		jt.setPreferredSize(new Dimension(700,120));
		jt.setLocation(100, 100);    
		jt.setPreferredScrollableViewportSize(jt.getPreferredSize());
		jt.setShowGrid(true);
		//jt.setBackground(Color.pink);
		jt.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
		JScrollPane sp=new JScrollPane(jt);  
		getContentPane().add(sp);
		jt.setVisible(true);
		add(jt);
		add(sp);
		cnt.add(sp);
		this.pack();

	}

	public static void main(String args[]) {
		new table();
	}
}
