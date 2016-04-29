package interfete;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;






import com.sii.biblioteca.controllers.CartiController;
import com.sii.biblioteca.controllers.EdituriController;
import com.sii.biblioteca.models.Carti;
import com.sii.biblioteca.models.Edituri;
import java.awt.Color;


public class AddCarti extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCarti frame = new AddCarti();
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
	public AddCarti() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setBounds(31, 64, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(87, 61, 121, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTitlu = new JLabel("Titlu:");
		lblTitlu.setBounds(31, 89, 46, 14);
		contentPane.add(lblTitlu);
		
		textField_1 = new JTextField();
		textField_1.setBounds(90, 86, 118, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPret = new JLabel("Pret:");
		lblPret.setBounds(31, 132, 46, 14);
		contentPane.add(lblPret);
		
		textField_2 = new JTextField();
		textField_2.setBounds(89, 121, 46, 36);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(31, 176, 46, 14);
		contentPane.add(lblStatus);
		
		JLabel lblEditura = new JLabel("Editura:");
		lblEditura.setBounds(31, 201, 46, 14);
		contentPane.add(lblEditura);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Imprumutata");
		chckbxNewCheckBox.setBounds(83, 172, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		
		
		JLabel lblAn = new JLabel("An:");
		lblAn.setBounds(257, 110, 46, 36);
		contentPane.add(lblAn);
		
		textField_3 = new JTextField();
		textField_3.setBounds(313, 121, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nr_imp:");
		lblNewLabel_1.setBounds(258, 78, 63, 36);
		contentPane.add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(313, 86, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(83, 198, 86, 20);
		contentPane.add(comboBox);
		//Adaugare Edituri 
		ArrayList<Edituri>editura=new ArrayList<Edituri>();
		editura=new EdituriController().stringEdituri(editura);
		for(Edituri edd:editura)
			comboBox.addItem(edd);
		
		
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int check=0;
				if(chckbxNewCheckBox.isSelected())
				{
					check=1;
				}
		
				int id=Integer.parseInt(textField.getText());
				String titlu=textField_1.getText();
				double pret=Double.parseDouble(textField_2.getText());
				
				Edituri editura=(Edituri) comboBox.getSelectedItem();
				int an=Integer.parseInt(textField_3.getText());
				int nr=Integer.parseInt(textField_4.getText());
			
        Carti carte =new Carti(id,titlu,pret,check,editura.getIdEditura(),an,nr);
				CartiController carti=new CartiController();
				try {
					carti.AddCarti(carte);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				textField.setText(" ");
				textField_1.setText(" ");
				textField_2.setText(" ");
				textField_3.setText(" ");
				textField_4.setText(" ");
				
				new AddAutor().setVisible(true);
			
			}
		
		});
		
		btnNewButton.setBounds(228, 176, 89, 60);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Adauga Carte");
		lblNewLabel_2.setBounds(123, 11, 104, 14);
		contentPane.add(lblNewLabel_2);
	
		
		
		
		
	}
}
