package interfete;
import com.sii.biblioteca.controllers.AbonatController;
import com.sii.biblioteca.models.Abonat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class Inactivi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inactivi frame = new Inactivi();
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
	public Inactivi() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 105, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("282px:grow"),
				ColumnSpec.decode("113px"),},
			new RowSpec[] {
				RowSpec.decode("123px:grow"),
				RowSpec.decode("33px"),}));
		
		final JList list = new JList();
		contentPane.add(list, "1, 1, fill, fill");
		
		JButton btnNewButton = new JButton("Afisare");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Abonat> listAbnt = null;
				try {
					listAbnt = new AbonatController().vreauTabel("inactiv");
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				DefaultListModel listModel = new DefaultListModel();
				
				for(Abonat a: listAbnt){
					
					listModel.addElement(a.toStringLista());
				}
			list.setModel(listModel);
				
				
			}
		});
		contentPane.add(btnNewButton, "2, 1, fill, fill");
	}
}
