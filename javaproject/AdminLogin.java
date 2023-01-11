import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {
	static AdminLogin frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminLogin();
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
	public AdminLogin() {
		setTitle("Admin Login Page");
		setBounds(100, 100, 474, 367);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setBounds(196, 50, 129, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username: ");
		lblNewLabel_1.setBounds(30, 100, 78, 48);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblNewLabel_1);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(128, 112, 234, 25);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(30, 170, 78, 25);
		getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 172, 234, 25);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name = txtUsername.getText();
				String password = String.valueOf(passwordField.getPassword());
				
				if(name.equals("admin") && password.equals("456"))
				{
					AdminSuccess.main(new String[]{});
					frame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(AdminLogin.this, "Sorry, Username or Password Error", "Login Error!", JOptionPane.ERROR_MESSAGE);
					txtUsername.setText("");
					passwordField.setText("");
				}
			}
		});
		btnNewButton.setBounds(256, 231, 106, 40);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Library.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(128, 231, 106, 40);
		getContentPane().add(btnNewButton_1);

	}
}
