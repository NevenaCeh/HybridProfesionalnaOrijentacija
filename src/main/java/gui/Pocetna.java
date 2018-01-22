package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontroler.Kontroler;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Pocetna extends JFrame {

	private JPanel contentPane;

	public Pocetna() {
		setTitle("Profesionalna orijentacija");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 343);		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);		
		JMenu mnTest = new JMenu("Test");
		menuBar.add(mnTest);
		JMenuItem jmiZapocniTest = new JMenuItem("Zapocni test");
		jmiZapocniTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UlogujSe us = new UlogujSe();
				us.setVisible(true);
				Kontroler.getInstanca().sakrijPocetnu();
			}
		});
		mnTest.add(jmiZapocniTest);
		
		JMenu mnPomoc = new JMenu("Pomoc");
		menuBar.add(mnPomoc);
		
		JMenuItem jmiSvasta = new JMenuItem("O profesionalnoj orijentaciji");
		jmiSvasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfOrijentacijaAbout about = new ProfOrijentacijaAbout();
				about.setVisible(true);
			}
		});
		mnPomoc.add(jmiSvasta);
		
		JMenuItem jmiOblasti = new JMenuItem("Oblasti");
		jmiOblasti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OblastiPregled2 info = new OblastiPregled2();
				info.setVisible(true);
			}
		});
		mnPomoc.add(jmiOblasti);
		
		JMenu mnIzlaz = new JMenu("Izlaz");
		menuBar.add(mnIzlaz);
		
		JMenuItem jmiIzlaz = new JMenuItem("Izlaz");
		jmiIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnIzlaz.add(jmiIzlaz);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Profesionalna orijentacija");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(99, 36, 252, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnZapocniTest = new JButton("Zapocni test");
		btnZapocniTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UlogujSe us = new UlogujSe();
				us.setVisible(true);
				Kontroler.getInstanca().sakrijPocetnu();
				us.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent arg0) {
						System.exit(0);
					}
				});
			}
		});
		btnZapocniTest.setBounds(163, 113, 110, 23);
		contentPane.add(btnZapocniTest);
		
		JLabel lblUpozorenjeOvajTest = new JLabel("Upozorenje!!!!".toUpperCase());
		lblUpozorenjeOvajTest.setBounds(173, 156, 100, 14);
		lblUpozorenjeOvajTest.setForeground(Color.RED);
		contentPane.add(lblUpozorenjeOvajTest);
		
		JLabel lblNewLabel_1 = new JLabel("Ovaj test je moguce raditi samo jednom!!!");
		lblNewLabel_1.setBounds(99, 183, 263, 28);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.red);
	}
}
