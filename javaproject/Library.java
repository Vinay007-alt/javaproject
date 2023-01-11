
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Library extends JFrame {
	static Library frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Library();
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
	public Library() {
		setTitle("Library Management");
		setBounds(100, 100, 450, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Library Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(100, 46, 266, 25);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Admin Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(149, 108, 135, 47);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Librarian Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianLogin.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(149, 192, 135, 47);
		getContentPane().add(btnNewButton_1);
		
		
		JLabel chippi = new JLabel();
		chippi.setBounds(0,0,450 , 400);
		getContentPane().add(chippi);
		ImageIcon icon = new ImageIcon("C:/Users/user/eclipse-workspace/Library/src/8cb6d169d6084542dad36564764bac9f.jpg");
        Image img = icon.getImage();
        Image modify = img.getScaledInstance(450, 400, DO_NOTHING_ON_CLOSE);
        icon = new ImageIcon(modify);
        chippi.setIcon(icon);
        
        
        }

}
