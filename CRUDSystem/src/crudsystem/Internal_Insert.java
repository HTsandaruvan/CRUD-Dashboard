package crudsystem;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Internal_Insert extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField insert_name;
	private JTextField insert_email;
	private JTextField insert_nic;
	private JTextField insert_phone;
	
	String ImagePath =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Internal_Insert frame = new Internal_Insert();
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
	public Internal_Insert() {
		setBounds(100, 100, 718, 553);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 74, 138));
		
		JLabel lblNewLabel = new JLabel("INSERT");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(32, 74, 138));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
					.addGap(118)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(31))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 56, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_2 = new JLabel("Full Name :");
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 16));
		
		insert_name = new JTextField();
		insert_name.setFont(new Font("Dubai", Font.BOLD, 13));
		insert_name.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email :");
		lblNewLabel_2_1.setFont(new Font("Cambria", Font.BOLD, 16));
		
		insert_email = new JTextField();
		insert_email.setFont(new Font("Dubai", Font.BOLD, 13));
		insert_email.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Address :");
		lblNewLabel_2_1_1.setFont(new Font("Cambria", Font.BOLD, 16));
		
		JTextArea insert_address = new JTextArea();
		
		JLabel lblNewLabel_2_1_2 = new JLabel("NIC No :");
		lblNewLabel_2_1_2.setFont(new Font("Cambria", Font.BOLD, 16));
		
		insert_nic = new JTextField();
		insert_nic.setFont(new Font("Dubai", Font.BOLD, 13));
		insert_nic.setColumns(10);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Contact No :");
		lblNewLabel_2_1_3.setFont(new Font("Cambria", Font.BOLD, 16));
		
		insert_phone = new JTextField();
		insert_phone.setFont(new Font("Dubai", Font.BOLD, 13));
		insert_phone.setColumns(10);
		
		JLabel profilepic = new JLabel("");
		profilepic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// import External file in System
				JFileChooser imgfile = new JFileChooser();
				imgfile.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "*.jpg","*.png");
				imgfile.addChoosableFileFilter(filter);
				
				int result = imgfile.showSaveDialog(null);
				
				if(result == JFileChooser.APPROVE_OPTION) {
					
					File selectedFile = imgfile.getSelectedFile();
					String Path = selectedFile.getAbsolutePath();
					
					ImageIcon image = new ImageIcon(Path);
					Image in = image.getImage();
					
					Image Modified = in.getScaledInstance(104, 110, java.awt.Image.SCALE_SMOOTH);
					
					image = new ImageIcon(Modified);
					profilepic.setIcon(image);
					ImagePath = Path;
				}
				
			}
		});
		profilepic.setHorizontalAlignment(SwingConstants.CENTER);
		profilepic.setIcon(new ImageIcon("C:\\Users\\Harsha\\Downloads\\attach_img (1).png"));
		profilepic.setOpaque(true);
		profilepic.setBackground(new Color(255, 255, 255));
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setOpaque(true);
		
		// Insert Data 
		JButton insert_save = new JButton("Save");
		insert_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(ImagePath);
				try {
				String get_name = insert_name.getText();
				String get_email = insert_email.getText();
				String get_address = insert_address.getText();
				String get_nic = insert_nic.getText();
				int get_phone = Integer.parseInt(insert_phone.getText());
				//String get_image = insert_ima.getText();
				
				FileInputStream img = null;
				
				try {
					img = new FileInputStream(new File(ImagePath));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//Regex
				
				Connection conn = DBConnection.connect();
				
				String insertsql ="INSERT INTO students (Full_name,Email,Address,NIC,Phone_Number,Profile_picture) VALUES (?,?,?,?,?,?)";
				
					PreparedStatement insertpst = (PreparedStatement)conn.prepareStatement(insertsql);
					insertpst.setString(1, get_name);
					insertpst.setString(2, get_email);
					insertpst.setString(3, get_address);
					insertpst.setString(4, get_nic);
					insertpst.setInt(5, get_phone);
					insertpst.setBlob(6,img);
					
					insertpst.execute();
					JOptionPane.showMessageDialog(null, "Saved");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		insert_save.setForeground(new Color(255, 255, 255));
		insert_save.setBackground(new Color(80, 162, 175));
		
		JButton btnSavcancel = new JButton("Cancel");
		btnSavcancel.setForeground(Color.WHITE);
		btnSavcancel.setBackground(new Color(80, 162, 175));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
							.addGap(265))
						.addComponent(insert_name, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
							.addGap(265))
						.addComponent(insert_email, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_2_1_1, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
							.addGap(265))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(insert_address, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
							.addGap(139))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_2_1_2, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
							.addGap(265))
						.addComponent(insert_nic, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_3, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addComponent(insert_phone, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))
					.addGap(70)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(60)
							.addComponent(profilepic, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(28)
							.addComponent(insert_save, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnSavcancel, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
					.addGap(37))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(26)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 13, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(insert_name, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 13, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(insert_email, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
							.addGap(16)
							.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 13, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(insert_address, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblNewLabel_2_1_2, GroupLayout.PREFERRED_SIZE, 13, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(insert_nic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(lblNewLabel_2_1_3, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(insert_phone, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(71))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(49)
							.addComponent(profilepic, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
							.addGap(47)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(insert_save, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
								.addComponent(btnSavcancel, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
							.addGap(222)))
					.addGap(1))
		);
		panel_1.setLayout(gl_panel_1);
		
		getContentPane().setLayout(groupLayout);

	}
}
