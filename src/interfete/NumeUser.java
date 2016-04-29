package interfete;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import com.sii.biblioteca.controllers.UserController;
import com.sii.biblioteca.models.User;

import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NumeUser extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumeUser frame = new NumeUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public NumeUser() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(10, 65, 68, 14);
		contentPane.add(lblNewLabel);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(160, 62, 155, 20);
		contentPane.add(comboBox);
		ArrayList<User> listUser=new ArrayList<User>();
		listUser=new UserController().selectNume(listUser);
		for(User u:listUser)
		{
			comboBox.addItem(u.toString());
		}
		
		
		JButton btnNewButton = new JButton("Editeaza");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User u=new User();
				UserController usr=new UserController();
				Object nume=comboBox.getSelectedItem();
				String pass=passwordField_1.getText();

				try
				{
					
					usr.modificaParola(pass, (String) nume);
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(70, 211, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ParolaVeche:");
		lblNewLabel_1.setBounds(10, 111, 95, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ParolaNoua:");
		lblNewLabel_2.setBounds(10, 166, 95, 14);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 111, 155, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(160, 163, 155, 20);
		contentPane.add(passwordField_1);
	}
}
