package crudsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Canvas;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSlider;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SystemLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLayeredPane contentPane;
	private JTextField textbox;
	private JPasswordField passwordbox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					SystemLogin frame = new SystemLogin();
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
	public SystemLogin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 516);
		contentPane = new JLayeredPane();
		contentPane.setOpaque(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CRUD ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Goudy Stout", Font.BOLD, 24));
		lblNewLabel_1.setBounds(84, 24, 164, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SystemLogin.class.getResource("/crudsystem/Images/logo.png")));
		lblNewLabel.setBounds(10, 10, 64, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Login into ");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Lucida Console", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(22, 98, 251, 43);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\r\nyour Account");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Lucida Console", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(22, 125, 251, 49);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Let us make the CRUD bigger !");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(22, 168, 251, 32);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(331, 224, 135, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(331, 284, 135, 22);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Forgot Password ?");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(331, 362, 126, 32);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		textbox = new JTextField();
		textbox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textbox.setBounds(331, 241, 273, 33);
		contentPane.add(textbox);
		textbox.setColumns(10);
		
		passwordbox = new JPasswordField();
		passwordbox.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordbox.setBounds(331, 304, 273, 32);
		contentPane.add(passwordbox);
		
		JLabel errorlbl = new JLabel("");
		errorlbl.setHorizontalTextPosition(SwingConstants.CENTER);
		errorlbl.setHorizontalAlignment(SwingConstants.CENTER);
		errorlbl.setForeground(new Color(255, 0, 0));
		errorlbl.setBounds(331, 404, 273, 13);
		contentPane.add(errorlbl);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(new Color(149, 203, 221));
		lblNewLabel_4.setBounds(312, 187, 304, 259);
		contentPane.add(lblNewLabel_4);
				
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(SystemLogin.class.getResource("/crudsystem/Images/istockphoto-1176497914-612x612 (4).jpg")));
		lblNewLabel_5.setBounds(0, 0, 754, 479);
		contentPane.add(lblNewLabel_5);
		
		// Login Process
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				Connection conn =DBConnection.connect();
			
				PreparedStatement pst = null ;
				ResultSet rs = null;
				
				String username =textbox.getText().trim();
				String password = passwordbox.getText().trim();
				
				if(username.isEmpty() || password.isEmpty() ){
				
					errorlbl.setText("Username and Password Cannot be Empty");
					//JOptionPane.showMessageDialog(null, "Username and Password Cannot be Empty");
				}
				
				String loginsql = "SELECT User_Id FROM users WHERE Username=? AND Password=? ";
				try {
					pst = (PreparedStatement)conn.prepareStatement(loginsql);
					pst.setString(1, username);
					pst.setString(2, password);
					
					rs = pst.executeQuery();
					
					if (rs.next()) {
						SystemDashboard sysdb = new SystemDashboard(username);
						sysdb.setVisible(true);
						SystemLogin.this.dispose();
						
					}else {
						errorlbl.setText("Username or Password Invalid");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(95, 131, 186));
	
		btnNewButton.setBounds(467, 359, 137, 32);
		contentPane.add(btnNewButton);
		
		setLocationRelativeTo(null);
		
	
	}
}
