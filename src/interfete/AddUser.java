package interfete;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.JButton;

import com.sii.biblioteca.controllers.UserController;
import com.sii.biblioteca.models.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class AddUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser frame = new AddUser();
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
	public AddUser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setBounds(28, 72, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setBounds(28, 112, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Parola:");
		lblNewLabel_2.setBounds(28, 147, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Type:");
		lblNewLabel_3.setBounds(28, 172, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Adauga Utilizator");
		lblNewLabel_4.setBounds(128, 11, 104, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnOk = new JButton("ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			boolean vf=false;
				
User user=new User(Integer.parseInt(textField.getText()),textField_1.getText(),passwordField.getText(),Integer.parseInt(textField_3.getText()),
		Integer.parseInt(textField_2.getText()));
UserController uss=new UserController();
try {
	
	uss.AddUser(user);
	
		
} catch (SQLException e) {
	
	e.printStackTrace();
}

textField.setText(" ");
textField_1.setText(" ");
textField_2.setText(" ");
textField_3.setText(" ");
passwordField.setText(" ");


			}
			
		});
		btnOk.setBounds(281, 129, 123, 50);
		contentPane.add(btnOk);
		
		textField = new JTextField();
		textField.setBounds(111, 69, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 109, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 200, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(111, 169, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(111, 144, 86, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_5 = new JLabel("SuperType:");
		lblNewLabel_5.setBounds(20, 197, 64, 14);
		contentPane.add(lblNewLabel_5);
		
		
	}
}
