package interfete;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.sii.biblioteca.controllers.AbonatController;
import com.sii.biblioteca.controllers.CartiController;
import com.sii.biblioteca.controllers.ImprumutController;
import com.sii.biblioteca.models.Abonat;
import com.sii.biblioteca.models.Carti;
import com.sii.biblioteca.models.Edituri;
import com.sii.biblioteca.models.Imprumut;

import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.xml.bind.ParseConversionEvent;

import java.awt.Color;

public class ReturnCarte extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnCarte frame = new ReturnCarte();
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
	public ReturnCarte() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		

		final JComboBox comboBox_1 = new JComboBox();
		contentPane.add(comboBox_1, "2, 4, fill, default");
		ArrayList<Abonat>listaAbnt=new ArrayList<Abonat>();
		listaAbnt=new AbonatController().vreauIDAbnt(listaAbnt);
		for(Abonat c:listaAbnt)
			comboBox_1.addItem(c.toStringIdAbnt());
		
		
		final JComboBox comboBox = new JComboBox();
		contentPane.add(comboBox, "2, 8, fill, default");
		ArrayList<Carti>lista=new ArrayList<Carti>();
		lista=new CartiController().vreauID(lista);
		for(Carti c:lista)
			comboBox.addItem(c.toStringId());
		
		
		
		
		JButton btnNewButton_2 = new JButton("Penalizeaza-Abonat");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Abonat a=new Abonat();
				AbonatController ctr=new AbonatController();
			
				try
				{
					Object o = comboBox_1.getSelectedItem();
					ctr.modificaPenalizari((Integer)o);
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				
			}
		});
		contentPane.add(btnNewButton_2, "2, 2");
		
		
		final JList list = new JList();
		
		JButton btnNewButton = new JButton("Afisare");
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			List<Imprumut> imp=new ImprumutController().returnCarti();
			DefaultListModel listaModel=new DefaultListModel();
			for(Imprumut i : imp)
			{
				listaModel.addElement(i.toString());
			}
				list.setModel(listaModel);
				
				
				
				
			}
			
		
			
		});
		
		JButton btnNewButton_1 = new JButton("Modificare-Carte");
		btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Carti c=new Carti();
				CartiController ctr=new CartiController();
			
				try
				{
					Object o = comboBox.getSelectedItem();
					ctr.modificaStareToDisponibil((Integer)o);
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton_1, "2, 6");
		
		contentPane.add(btnNewButton, "2, 10");
		
		
		
		contentPane.add(list, "2, 12, fill, fill");
	
	}
}
