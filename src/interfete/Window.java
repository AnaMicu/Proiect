package interfete;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.sii.biblioteca.controllers.AbonatController;
import com.sii.biblioteca.models.Abonat;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;

public class Window extends JFrame {

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public Window(int tip) {
		getContentPane().setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		getContentPane().setBackground(new Color(153, 50, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		menuBar.setBackground(Color.PINK);
		setJMenuBar(menuBar);
		
		JMenu mnSetari = new JMenu("Setari");
		menuBar.add(mnSetari);
		
		JMenuItem mntmAdaugaCarte = new JMenuItem("Adauga Carte");
		mntmAdaugaCarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AddCarti().setVisible(true);
			}
		});
		mnSetari.add(mntmAdaugaCarte);
		
		JMenuItem mntmAdaugaAbonat = new JMenuItem("Adauga Abonat");
		mntmAdaugaAbonat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddAbonat().setVisible(true);
			}
		});
		mnSetari.add(mntmAdaugaAbonat);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Adauga User");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddUser().setVisible(true);
			}
		});
		mnSetari.add(mntmNewMenuItem);
		
		JMenuItem mntmEditUser = new JMenuItem("Edit User");
		mntmEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new NumeUser().setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnSetari.add(mntmEditUser);
		
		JMenu mnImprumuturi = new JMenu("Imprumuturi");
		menuBar.add(mnImprumuturi);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Imp.Carte");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ImpCarte().setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnImprumuturi.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Rest.Carte");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ReturneazaCarte().setVisible(true);
			}
		});
		mnImprumuturi.add(mntmNewMenuItem_2);
		
		JMenu mnRapoarte = new JMenu("Rapoarte");
		menuBar.add(mnRapoarte);
		
		JMenuItem mntmTopCarti = new JMenuItem("Top 3 carti");
		mntmTopCarti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TopCarti().setVisible(true);
			}
		});
		mnRapoarte.add(mntmTopCarti);
		
		JMenuItem mntmNrabonatiNactivi = new JMenuItem("Nr.abonati inactivi");
		mntmNrabonatiNactivi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int nr=0;
				try
				{
				nr=	new AbonatController().inactiv();
				 JOptionPane.showMessageDialog(null, "Numarul de abonati inactivi:"+nr);
				 new Inactivi().setVisible(true);
				}catch(SQLException ex)
				{
					ex.printStackTrace();
				}
				
				
				
			}
		});
		mnRapoarte.add(mntmNrabonatiNactivi);
		
		JMenuItem mntmSumaCheltuitaAnual = new JMenuItem("Suma cheltuita anual");
		mntmSumaCheltuitaAnual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SumaAnuala().setVisible(true);
			}
		});
		mnRapoarte.add(mntmSumaCheltuitaAnual);
		
		JMenuItem mntmAbonatiiCu = new JMenuItem("Abonatii cu 4 penalizari");
		mntmAbonatiiCu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AbonatiPenalizati().setVisible(true);
			}
		});
		mnRapoarte.add(mntmAbonatiiCu);
		
		JButton btnNewButton = new JButton("Log out");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new UserPass().setVisible(true);
			}
		});
		menuBar.add(btnNewButton);
		
		
		if(tip==1)
		{
			//mntmNewMenuItem.hide();
			mntmEditUser.hide();
		
			
			
		}
		else if(tip==2)
		{
			mnSetari.hide();
			mnRapoarte.hide();
			mntmNewMenuItem_2.hide();
		}
		
	}
}
