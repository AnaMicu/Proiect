package interfete;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.sii.biblioteca.controllers.AbonatController;
import com.sii.biblioteca.models.Abonat;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;

public class AddAbonat extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAbonat frame = new AddAbonat();
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
	public AddAbonat() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setBounds(20, 40, 72, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblCnp = new JLabel("CNP:");
		lblCnp.setBounds(20, 77, 34, 38);
		contentPane.add(lblCnp);
		
		JLabel lblNume = new JLabel("Nume:");
		lblNume.setBounds(20, 126, 44, 26);
		contentPane.add(lblNume);
		
		JLabel lblPrenume = new JLabel("Prenume:");
		lblPrenume.setBounds(20, 177, 56, 26);
		contentPane.add(lblPrenume);
		
		JLabel lblOras = new JLabel("Oras:");
		lblOras.setBounds(230, 30, 175, 58);
		contentPane.add(lblOras);
		
		JLabel lblNewLabel_1 = new JLabel("Stare:");
		lblNewLabel_1.setBounds(230, 126, 65, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefon:");
		lblNewLabel_2.setBounds(230, 80, 56, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNrpenalizari = new JLabel("Nr_penalizari:");
		lblNrpenalizari.setBounds(209, 165, 86, 50);
		contentPane.add(lblNrpenalizari);
		
		textField = new JTextField();
		textField.setBounds(102, 49, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 86, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(102, 129, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(102, 180, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(303, 49, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(303, 86, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(303, 129, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(303, 180, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Abonat abn=new Abonat(Integer.parseInt(textField.getText()) , textField_1.getText(),
						textField_2.getText(), textField_3.getText(),
						textField_4.getText(), textField_5.getText(),
						textField_6.getText(), Integer.parseInt(textField_7.getText()) );
				
				AbonatController abonat=new AbonatController();
				try {
					abonat.AddAbonat(abn);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				textField.setText(" ");
				textField_1.setText(" ");
				textField_2.setText(" ");
				textField_3.setText(" ");
				textField_4.setText(" ");
				textField_5.setText(" ");
				textField_6.setText(" ");
				textField_7.setText(" ");
				
			}
		
		});
		btnNewButton.setBounds(148, 212, 89, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Adauga Abonat");
		lblNewLabel_3.setBounds(170, 10, 113, 14);
		contentPane.add(lblNewLabel_3);
	}
}
