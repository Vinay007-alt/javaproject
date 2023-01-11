import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class DeleteLibrarian extends JFrame {
	private JTextField textField;
	static DeleteLibrarian frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DeleteLibrarian();
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
	public DeleteLibrarian() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Name: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(29, 43, 66, 12);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(119, 42, 186, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sid = textField.getText();
				if(sid == null || sid.trim().equals("")) {
					JOptionPane.showMessageDialog(DeleteLibrarian.this, "Id can not be blank");
				}else {
					//int (sid);
					int i = LibrarianDao.delete(sid);
					if(i>0) {
						JOptionPane.showMessageDialog(DeleteLibrarian.this, "Recored deleted successfully!");
					}else {
						JOptionPane.showMessageDialog(DeleteLibrarian.this, "Unable to delete given id!");
					}
					
				}
				
			}
		});
		btnNewButton.setToolTipText("To delete the Librarian from the database");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(153, 90, 109, 34);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton_1.setToolTipText("To go to last Menu");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(153, 146, 109, 34);
		getContentPane().add(btnNewButton_1);

	}

}
