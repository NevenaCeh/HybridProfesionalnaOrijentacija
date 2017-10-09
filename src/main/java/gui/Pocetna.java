package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pocetna extends JFrame {

	private JPanel contentPane;

	public Pocetna() {
		//setTitle("Profesionalna orijentacija");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
				dispose();
			}
		});
		btnZapocniTest.setBounds(163, 113, 110, 23);
		contentPane.add(btnZapocniTest);
		
		JLabel lblUpozorenjeOvajTest = new JLabel("Upozorenje!!!! ");
		lblUpozorenjeOvajTest.setBounds(173, 147, 86, 14);
		contentPane.add(lblUpozorenjeOvajTest);
		
		JLabel lblNewLabel_1 = new JLabel("Ovaj test je moguce raditi samo jednom!!!");
		lblNewLabel_1.setBounds(116, 172, 252, 14);
		contentPane.add(lblNewLabel_1);
	}
}
