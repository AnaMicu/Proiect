package interfete;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JPasswordField;

import com.sii.biblioteca.controllers.UserController;
import com.sii.biblioteca.models.User;

import java.awt.Color;

public class UserPass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPass frame = new UserPass();
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
	public UserPass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(10, 57, 79, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(10, 100, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(124, 54, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				User user=new User();
				boolean vf=false;
				int tip=-1;
				String n=textField.getText();
				String p=passwordField.getText();
	
	try{
		
vf=new UserController().verificaType(textField.getText(), new String(passwordField.getPassword()));
tip=new UserController().adminActiv(textField.getText(), new String(passwordField.getPassword()));		
	}catch(SQLException ex){
					ex.printStackTrace();
				}
				UserController uc=new UserController();
				
				if(vf==true )
				{
					if(tip==1)
					{
						JOptionPane.showMessageDialog(null, "Success!");
						   try {
							new Window(uc.tipUser(n, p)).setVisible(true);
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
						}
					else JOptionPane.showMessageDialog(null, "User inactiv!");	
					}
				
					
			
					else
						
						JOptionPane.showMessageDialog(null, "Parola incorecta sau utilizator inactiv!");			
			}
			
		});
		btnNewButton.setBounds(124, 147, 89, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(124, 97, 86, 20);
		contentPane.add(passwordField);
		
		label = new JLabel("New label");
		Image img=new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(223, 41, 200, 172);
		contentPane.add(label);
	}
}
