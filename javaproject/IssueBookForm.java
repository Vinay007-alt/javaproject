import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class IssueBookForm extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	static IssueBookForm frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new IssueBookForm();
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
	public IssueBookForm() {
		setTitle("Issue Book Page");
		setBounds(100, 100, 456, 485);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Issue Book Section");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(132, 27, 175, 44);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book Call No. : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(43, 98, 103, 27);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Student Id: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(43, 135, 103, 27);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Student Name: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(43, 172, 115, 27);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contact No. : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(43, 209, 103, 27);
		getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(156, 98, 192, 27);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 133, 192, 27);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(156, 170, 192, 27);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(156, 207, 192, 27);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Issue Book");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bookcallno = textField.getText();
				int studentid = Integer.parseInt(textField_1.getText());
				String studentname = textField_2.getText();
				String studentcontact = textField_3.getText();
				
				if(IssueBookDao.checkBook(bookcallno)) 
				{
					int i = IssueBookDao.save(bookcallno, studentid,studentname,studentcontact);
					if(i>0)
					{
						JOptionPane.showMessageDialog(IssueBookForm.this, "Book issued successfully!");
						LibrarianSuccess.main(new String[]{});
						frame.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(IssueBookForm.this, "Sorry, unable to issue");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(IssueBookForm.this, "Sorry, call number doesn't exist");
				}
				
			}
		});
		btnNewButton.setBounds(175, 265, 132, 44);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(175, 319, 132, 44);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("Note :- Please Check Student Id carefully before Issuing Book!");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 400, 428, 27);
		getContentPane().add(lblNewLabel_5);

	}

}
