package crudsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.beans.PropertyVetoException;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SystemDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemDashboard frame = new SystemDashboard();
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
	public SystemDashboard() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 640);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(0, 5, 0, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setBackground(new Color(255, 255, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(63, 189, 192), new Color(63, 189, 192), null, null));
		panel_1.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_1.setBackground(new Color(255, 255, 255));
		
		JDesktopPane mainwindow = new JDesktopPane();
		
		mainwindow.setAlignmentY(Component.TOP_ALIGNMENT);
		mainwindow.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainwindow.setBackground(new Color(98, 134, 210));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(mainwindow, GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 118, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(mainwindow, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Internal_Home home = new Internal_Home();
				mainwindow.removeAll();
				mainwindow.add(home).setVisible(true);
				try {
					home.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(63, 189, 192));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Internal_Insert insert = new Internal_Insert();
				mainwindow.removeAll();
				mainwindow.add(insert).setVisible(true);
				try {
					insert.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnInsert.setFont(new Font("Arial Black", Font.BOLD, 17));
		btnInsert.setBackground(new Color(63, 189, 192));
		
		JButton btnNewButton_1_1 = new JButton("MANAGE");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Internal_Manage manage = new Internal_Manage();
				mainwindow.removeAll();
				mainwindow.add(manage).setVisible(true);
				try {
					manage.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial Black", Font.BOLD, 17));
		btnNewButton_1_1.setBackground(new Color(63, 189, 192));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
						.addComponent(btnInsert, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
						.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
					.addGap(41))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(41)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(btnInsert, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
					.addGap(33)
					.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
					.addGap(310))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Welcome to CRUD Dashboard");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
		
		JLabel lblNewLabel_1 = new JLabel("Harsha Tharuka");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_1 = new JLabel("Log Out");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SystemLogin showLogin = new SystemLogin();
				showLogin.setVisible(true);
				SystemDashboard.this.dispose();
			}
		});
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Harsha\\Downloads\\gradient-geometric-shapes-dark-background\\3413468.jpg"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(165)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(298)
							.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addGap(10))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 1010, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addGap(43)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addGap(22))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
					.addGap(50))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 120, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		Internal_Home home = new Internal_Home();
		mainwindow.removeAll();
		mainwindow.add(home).setVisible(true);
		try {
			home.setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SystemDashboard(String currentuser) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 640);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(0, 5, 0, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setBackground(new Color(255, 255, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(63, 189, 192), new Color(63, 189, 192), null, null));
		panel_1.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_1.setBackground(new Color(255, 255, 255));
		
		JDesktopPane mainwindow = new JDesktopPane();
		
		mainwindow.setAlignmentY(Component.TOP_ALIGNMENT);
		mainwindow.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainwindow.setBackground(new Color(98, 134, 210));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(mainwindow, GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 118, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(mainwindow, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Internal_Home home = new Internal_Home();
				mainwindow.removeAll();
				mainwindow.add(home).setVisible(true);
				try {
					home.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(63, 189, 192));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Internal_Insert insert = new Internal_Insert();
				mainwindow.removeAll();
				mainwindow.add(insert).setVisible(true);
				try {
					insert.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnInsert.setFont(new Font("Arial Black", Font.BOLD, 17));
		btnInsert.setBackground(new Color(63, 189, 192));
		
		JButton btnNewButton_1_1 = new JButton("MANAGE");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Internal_Manage manage = new Internal_Manage();
				mainwindow.removeAll();
				mainwindow.add(manage).setVisible(true);
				try {
					manage.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial Black", Font.BOLD, 17));
		btnNewButton_1_1.setBackground(new Color(63, 189, 192));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
						.addComponent(btnInsert, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
						.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
					.addGap(41))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(41)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(btnInsert, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
					.addGap(33)
					.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
					.addGap(310))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Welcome to CRUD Dashboard");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
		
		JLabel lblNewLabel_1 = new JLabel("Harsha Tharuka");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_1 = new JLabel("Log Out");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SystemLogin showLogin = new SystemLogin();
				showLogin.setVisible(true);
				SystemDashboard.this.dispose();
			}
		});
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Harsha\\Downloads\\gradient-geometric-shapes-dark-background\\3413468.jpg"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(165)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(298)
							.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addGap(10))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 1010, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addGap(43)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addGap(22))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
					.addGap(50))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 120, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		Internal_Home home = new Internal_Home();
		mainwindow.removeAll();
		mainwindow.add(home).setVisible(true);
		try {
			home.setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		lblNewLabel_1.setText(currentuser);
		
		
	}
	
	
	
}
