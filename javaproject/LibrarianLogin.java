import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibrarianLogin extends JFrame {
	private JTextField txtUsername;
	private JPasswordField passwordField;
	static LibrarianLogin frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LibrarianLogin();
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
	public LibrarianLogin() {
		setTitle("Librarian Login Page");
		setBounds(100, 100, 492, 364);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Librarian Login");
		lblNewLabel.setBounds(180, 50, 145, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username: ");
		lblNewLabel_1.setBounds(30, 100, 78, 48);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblNewLabel_1);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(128, 112, 276, 25);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(30, 158, 78, 25);
		getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 160, 276, 25);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtUsername.getText();
				String password = String.valueOf(passwordField.getPassword());
				
				// check
				if(LibrarianDao.validate(name, password)) {
					LibrarianSuccess.main(new String[]{});
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(LibrarianLogin.this, "Sorry, Username or Passwors Error", "Login Error!",JOptionPane.ERROR_MESSAGE);
					txtUsername.setText("");
					passwordField.setText("");
				}
				
			}
		});
		btnNewButton.setBounds(298, 224, 106, 40);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Library.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(128, 224, 106, 40);
		getContentPane().add(btnNewButton_1);

	}
}
