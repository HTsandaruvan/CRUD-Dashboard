package crudsystem;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;

public class Internal_Manage extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField Update_Email;
	private JTextField Update_Name;
	private JTextField Update_NIC;
	private JTextField Update_Phone;
	private JTable table;
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextField txtFilter;
	int SelectedID ;
	private JTextField stuid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Internal_Manage frame = new Internal_Manage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public Internal_Manage() {
		setBounds(100, 100, 1126, 592);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 74, 138));
		
		JLabel lblNewLabel = new JLabel("MANAGE");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(new Color(32, 74, 138));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
					.addGap(118)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(31))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
					.addGap(3))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		
		Update_Email = new JTextField();
		Update_Email.setFont(new Font("Dubai", Font.BOLD, 13));
		Update_Email.setColumns(10);
		
		Update_Name = new JTextField();
		Update_Name.setFont(new Font("Dubai", Font.BOLD, 13));
		Update_Name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Full Name :");
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 16));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Address :");
		lblNewLabel_2_1_1.setFont(new Font("Cambria", Font.BOLD, 16));
		
		JTextArea Update_Address = new JTextArea();
		
		JLabel lblNewLabel_2_1_2 = new JLabel("NIC No :");
		lblNewLabel_2_1_2.setFont(new Font("Cambria", Font.BOLD, 16));
		
		Update_NIC = new JTextField();
		Update_NIC.setFont(new Font("Dubai", Font.BOLD, 13));
		Update_NIC.setColumns(10);
		
		Update_Phone = new JTextField();
		Update_Phone.setFont(new Font("Dubai", Font.BOLD, 13));
		Update_Phone.setColumns(10);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Contact No :");
		lblNewLabel_2_1_3.setFont(new Font("Cambria", Font.BOLD, 16));
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Email:");
		lblNewLabel_2_1_1_1.setFont(new Font("Cambria", Font.BOLD, 16));
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				//int getid = Integer.parseInt(stuid.getText());
				String getname = Update_Name.getText();
				String getemail = Update_Email.getText();
				String getaddress = Update_Address.getText();
				String getnic = Update_NIC.getText();
				int getphone = Integer.parseInt(Update_Phone.getText());
				
				String UpdateQuery = "UPDATE students SET Full_name='"+getname+"',Email ='"+getemail+"', Address = '"+getaddress+"', NIC='"+getnic+"',Phone_Number='"+getphone+"' WHERE Student_Id=?";
				
					pst = (PreparedStatement)conn.prepareStatement(UpdateQuery);
					pst.setInt(1, SelectedID);
					pst.execute();
					table();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JLabel Update_ProfilePic = new JLabel("");
		Update_ProfilePic.setIcon(new ImageIcon("C:\\Users\\Harsha\\Downloads\\attach_img (1).png"));
		Update_ProfilePic.setOpaque(true);
		Update_ProfilePic.setHorizontalAlignment(SwingConstants.CENTER);
		Update_ProfilePic.setBackground(Color.WHITE);
		
		JSeparator separator = new JSeparator();
		separator.setRequestFocusEnabled(false);
		separator.setOpaque(true);
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		
		stuid = new JTextField();
		stuid.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(1)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
										.addGap(265))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblNewLabel_2_1_3, GroupLayout.PREFERRED_SIZE, 251, Short.MAX_VALUE)
										.addGap(265))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_panel_1.createSequentialGroup()
												.addComponent(lblNewLabel_2_1_1, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
												.addGap(152))
											.addGroup(gl_panel_1.createSequentialGroup()
												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_panel_1.createSequentialGroup()
														.addComponent(lblNewLabel_2_1_1_1, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
														.addGap(132))
													.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(Update_Email, Alignment.LEADING)
														.addComponent(Update_Name, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)))
												.addGap(143))
											.addGroup(gl_panel_1.createSequentialGroup()
												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_panel_1.createSequentialGroup()
														.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
															.addGroup(gl_panel_1.createSequentialGroup()
																.addComponent(Update_Address, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
																.addGap(32))
															.addGroup(gl_panel_1.createSequentialGroup()
																.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
																	.addComponent(Update_NIC, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
																	.addComponent(lblNewLabel_2_1_2, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
																.addGap(53)))
														.addPreferredGap(ComponentPlacement.RELATED))
													.addGroup(gl_panel_1.createSequentialGroup()
														.addComponent(Update_Phone, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
														.addGap(58)))
												.addComponent(Update_ProfilePic, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
												.addGap(91)))
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGap(22))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addGap(449)))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(stuid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(121))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 14, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(Update_Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 14, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(Update_Email, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(Update_Address, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2_1_2, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(Update_NIC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(lblNewLabel_2_1_3, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
						.addComponent(Update_ProfilePic, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(Update_Phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(29)
							.addComponent(btnNewButton)
							.addGap(65))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(stuid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(46))))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		// add key search Filter
		
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int RowIndex =table.getSelectedRow();
				SelectedID =(int)table.getModel().getValueAt(RowIndex, 0);
				try {
					
					String GetRowdata = "SELECT * FROM students WHERE Student_Id =?";
			        
					pst = (PreparedStatement)conn.prepareStatement(GetRowdata);
					pst.setInt(1, SelectedID);
					ResultSet rs1= pst.executeQuery();
					
					if (rs1.next()==true) {
						stuid.setText(rs1.getString("Student_Id"));
						Update_Name.setText(rs1.getString("Full_name"));
						Update_Email.setText(rs1.getString("Email"));
						Update_Address.setText(rs1.getString("Address"));
						Update_NIC.setText(rs1.getString("NIC"));
						Update_Phone.setText(rs1.getString("Phone_Number"));
						
						//InputStream img = rs.getBinaryStream("Profile_picture");
						//Update_ProfilePic.setIcon((Icon)img);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//System.out.println(SlectedID);
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(3), "Harsha Tharuka", "768479097"},
				{new Integer(5), "uyrtururuirt", "1235468779"},
			},
			new String[] {
				"Student_Id", "Full_name", "NIC"
			}
		));
     	//table.getColumnModel().getColumn(0).set
		//table.getColumnModel().setColumnVisible(0, false);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(0).setMinWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setMinWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setMinWidth(10);
		
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.addActionListener(new ActionListener() {
			String dltmsg = "Are Sure DELETE";
			
			public void actionPerformed(ActionEvent e) {
				
			int reply =	JOptionPane.showConfirmDialog(null, dltmsg, "DELETE",JOptionPane.YES_NO_OPTION);
				
				if(reply == JOptionPane.YES_OPTION) {
					if(SelectedID>0) {
					try {
						String DelQuary = "DELETE FROM students WHERE Student_Id = ?";
					
						pst = (PreparedStatement)conn.prepareStatement(DelQuary);
						pst.setInt(1, SelectedID);
						pst.execute();
						table();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
				}
					
				}
			}
		});
		
		txtFilter = new JTextField();
		txtFilter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				try {
					String userInput = txtFilter.getText();
					System.out.println(userInput);
					conn =DBConnection.connect();
					String getDataSql = "SELECT Student_Id,Full_name,NIC FROM students WHERE NIC LIKE '%"+userInput+"%'";
			
					pst = (PreparedStatement)conn.prepareStatement(getDataSql);
					ResultSet Filterrs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(Filterrs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
						
			
			}
		});
		
		
		txtFilter.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		txtFilter.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(txtFilter, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
							.addGap(121)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtFilter, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
					.addComponent(btnDelete)
					.addGap(58))
		);
		panel_2.setLayout(gl_panel_2);
		getContentPane().setLayout(groupLayout);
	    table();
	
		
		
	}
	
	void table () {
		try {
			conn =DBConnection.connect();
			String getDataSql = "SELECT Student_Id,Full_name,NIC FROM students";
		
			pst = (PreparedStatement)conn.prepareStatement(getDataSql);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
