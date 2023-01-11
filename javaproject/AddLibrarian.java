import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.JavaBean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class AddLibrarian extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	static AddLibrarian frame;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddLibrarian();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	int flag = 0;

	/**
	 * Create the frame.
	 */
	public AddLibrarian() {

		setBounds(100, 100, 522, 553);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Add Librarian");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(185, 40, 158, 31);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(41, 111, 50, 29);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Email: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(41, 192, 50, 26);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Address: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(41, 234, 73, 31);
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_2 = new JLabel("Password: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(41, 150, 73, 26);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_5 = new JLabel("City: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(41, 275, 44, 31);
		getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Contact No. : ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(38, 316, 102, 31);
		getContentPane().add(lblNewLabel_6);

		textField = new JTextField();
		textField.setBounds(174, 115, 212, 26);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(174, 195, 212, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(174, 153, 212, 26);
		getContentPane().add(passwordField);

		textField_2 = new JTextField();
		textField_2.setBounds(174, 238, 212, 27);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(174, 280, 212, 26);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(174, 321, 212, 26);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("Add Librarian");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String password = String.valueOf(passwordField.getPassword());
				String email = textField_1.getText();
				String address = textField_2.getText();
				String city = textField_3.getText();
				String contact = textField_4.getText();
				String regex = "^(.+)@(.+)$";
				String reg = "(0/91)?[7-9][0-9]{9}";

				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(email);
				Pattern patter = Pattern.compile(reg);
				Matcher match = patter.matcher(contact);
				if (matcher.matches()) {
					flag = 1;
				} else {
					JOptionPane.showMessageDialog(null, "enter correct email");
				}
				if (match.matches()) {
					flag = 2;
				} else {
					JOptionPane.showMessageDialog(null, "enter correct phone no.");
				}
				if (flag == 2) {

					if (name.isEmpty() || password.isEmpty() || email.isEmpty() || address.isEmpty() || city.isEmpty()
							|| contact.isEmpty()) {
						JOptionPane.showMessageDialog(null, "enter details");
					}

					else {
						int i = LibrarianDao.save(name, password, email, address, city, contact);
						if (i > 0) {
							JOptionPane.showMessageDialog(AddLibrarian.this, "Librarian added Successfully...!!");
							AdminSuccess.main(new String[] {});
							frame.dispose();
						}
					}
				}

			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(185, 368, 158, 49);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSuccess.main(new String[] {});
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(185, 437, 158, 49);
		getContentPane().add(btnNewButton_1);
	}

}
