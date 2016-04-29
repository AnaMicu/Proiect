package interfete;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import com.sii.biblioteca.controllers.AbonatController;
import com.sii.biblioteca.controllers.CartiController;
import com.sii.biblioteca.controllers.EdituriController;
import com.sii.biblioteca.controllers.ImprumutController;
import com.sii.biblioteca.models.Abonat;
import com.sii.biblioteca.models.Carti;
import com.sii.biblioteca.models.Edituri;
import com.sii.biblioteca.models.Imprumut;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;

public class ImpCarte extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImpCarte frame = new ImpCarte();
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
	public ImpCarte() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNumeabnt = new JLabel("Nume_Abnt:");
		lblNumeabnt.setBackground(new Color(65, 105, 225));
		lblNumeabnt.setBounds(10, 61, 200, 50);
		contentPane.add(lblNumeabnt);

		JLabel lblTiltucrt = new JLabel("Tiltu_Crt:");
		lblTiltucrt.setBounds(10, 97, 200, 50);
		contentPane.add(lblTiltucrt);

		JLabel lblDataimp = new JLabel("Data_imp:");
		lblDataimp.setBackground(new Color(65, 105, 225));
		lblDataimp.setBounds(10, 143, 200, 50);
		contentPane.add(lblDataimp);

		JLabel lblDatarest = new JLabel("Data_rest:");
		lblDatarest.setBounds(10, 189, 200, 50);
		contentPane.add(lblDatarest);

		textField_2 = new JTextField();
		textField_2.setBounds(117, 158, 132, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(117, 204, 132, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(117, 76, 118, 20);
		contentPane.add(comboBox_1);
		ArrayList<Abonat> abnt = new ArrayList<Abonat>();
		abnt = new AbonatController().vreauNume(abnt);
		for (Abonat a : abnt)
			comboBox_1.addItem(a);

		final JComboBox<Carti> comboBox = new JComboBox<Carti>();
		comboBox.setBounds(117, 112, 116, 20);
		contentPane.add(comboBox);
		ArrayList<Carti> crt = new ArrayList<Carti>();
		crt = new CartiController().vreauTitlu(crt);
		for (Carti c : crt)
			comboBox.addItem(c);
		
	    
		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"0", "1"}));
		comboBox_2.setBounds(117, 235, 52, 20);
		comboBox_2.setSelectedIndex(0);
		contentPane.add(comboBox_2);


		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Carti c = (Carti) comboBox.getSelectedItem();
				Abonat a = (Abonat) comboBox_1.getSelectedItem();
				Date data_i=Date.valueOf(textField_2.getText());
				Date data_r=Date.valueOf(textField_3.getText());
				int id=Integer.parseInt(textField.getText());
				
				 Imprumut imp=new Imprumut(id,a.getIdAbonat(),c.getIdCarti(),data_i,data_r);
				 ImprumutController control = new ImprumutController();
				
				try {
					control.addLista(imp);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}

                CartiController ctr=new CartiController();
				
				try
				{
					Object o = comboBox_2.getSelectedItem();
					ctr.modificaStareToIndisponibil((Integer.parseInt((String) o)),((Carti)comboBox.getSelectedItem()).getIdCarti());
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
				textField.setText(" ");
				textField_2.setText(" ");
				textField_3.setText(" ");
			}
		});
		btnNewButton.setBounds(276, 112, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nr_imprumut:");
		lblNewLabel.setBounds(10, 36, 65, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(117, 30, 118, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 236, 46, 14);
		contentPane.add(lblStatus);
		
		
		
		
		
		
	}
}
