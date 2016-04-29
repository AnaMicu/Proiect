package interfete;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.sii.biblioteca.controllers.AbonatController;
import com.sii.biblioteca.controllers.CartiController;
import com.sii.biblioteca.controllers.ImprumutController;
import com.sii.biblioteca.models.Abonat;
import com.sii.biblioteca.models.Carti;
import com.sii.biblioteca.models.Imprumut;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class ReturneazaCarte extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturneazaCarte frame = new ReturneazaCarte();
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
	public ReturneazaCarte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
		
		final JList list = new JList();
		contentPane.add(list, "6, 8, 3, 5, fill, fill");
		
		
		
		final JComboBox comboBox = new JComboBox();
		contentPane.add(comboBox, "8, 2, fill, default");
		ArrayList<Carti>lista=new ArrayList<Carti>();
		lista=new CartiController().vreauID(lista);
		for(Carti c:lista)
			comboBox.addItem(c.toStringId());
		
		
		
		
		JButton btnNewButton = new JButton("Modificare-Carte    ");
		btnNewButton.addActionListener(new ActionListener() {
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
				list.clearSelection();
			}
		});
		contentPane.add(btnNewButton, "2, 2");
		
		
		final JComboBox comboBox_1 = new JComboBox();
		contentPane.add(comboBox_1, "8, 6, fill, default");
		ArrayList<Abonat>listaAbnt=new ArrayList<Abonat>();
		listaAbnt=new AbonatController().vreauIDAbnt(listaAbnt);
		for(Abonat c:listaAbnt)
			comboBox_1.addItem(c.toStringIdAbnt());
		
			JButton btnNewButton_1 = new JButton("Penalizeaza-Abonat  ");
			btnNewButton_1.addActionListener(new ActionListener() {
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
			contentPane.add(btnNewButton_1, "2, 6");
		
		
		
		
			
		
		
		
		JButton btnNewButton_2 = new JButton("Afisare");
		btnNewButton_2.addActionListener(new ActionListener() {
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
		
		
		
		contentPane.add(btnNewButton_2, "2, 12");
		
		
	}

}
