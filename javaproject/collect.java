import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class collect extends JFrame  {
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	
	public collect()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Name");
		l1.setBounds(10, 29, 49, 14);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Class");
		l2.setBounds(10, 69, 49, 14);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("Mark");
		l3.setBounds(10, 126, 49, 14);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Sex");
		l4.setBounds(10, 169, 49, 14);
		contentPane.add(l4);
		
		t1 = new JTextField();
		t1.setBounds(66, 26, 96, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(66, 66, 96, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(66, 123, 96, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(66, 166, 96, 20);
		contentPane.add(t4);
		t4.setColumns(10);
		
		JButton b1 = new JButton("Submit");
		
		b1.setBounds(212, 165, 89, 23);
		contentPane.add(b1);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=t1.getText();
				String class1=t2.getText();
				String mark=t3.getText();
				String sex=t4.getText();
				// creating one object 
				my_update obj=new my_update();
//				obj.my_db_update(name, class1, mark, sex);
			}
		});
	}
	

	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					collect frame = new collect();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	}


