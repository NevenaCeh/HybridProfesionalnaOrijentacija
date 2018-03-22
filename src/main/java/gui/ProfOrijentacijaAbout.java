package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;

public class ProfOrijentacijaAbout extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public ProfOrijentacijaAbout() {
		setBounds(100, 100, 543, 705);
		setModal(true);
		setLocationRelativeTo(null);
		setTitle("O profesionalnoj orijentaciji");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnProfesionalnaOrijentacijaJe = new JTextPane();
		txtpnProfesionalnaOrijentacijaJe.setForeground(Color.BLACK);
		txtpnProfesionalnaOrijentacijaJe.setEditable(false);
		txtpnProfesionalnaOrijentacijaJe.setText("Profesionalna orijentacija je pomoc pri izboru idealne profesije, odnosno karijere. Osnovni njen cilj je podrska u odabiru zanimanja. Profesionalna orijentacija je veoma vazna jer utice na formiranje stava prema radu, stvaranje profesionalnog duha i zadovoljstva u buducem radu.");
		txtpnProfesionalnaOrijentacijaJe.setBounds(36, 26, 448, 86);
		txtpnProfesionalnaOrijentacijaJe.setOpaque(false);
		contentPanel.add(txtpnProfesionalnaOrijentacijaJe);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ProfOrijentacijaAbout.class.getResource("/img/sign.jpg")));
		lblNewLabel.setBounds(36, 125, 448, 336);
		contentPanel.add(lblNewLabel);
		
		JTextPane txtpnProfesionalnaOrijentacijaPredstavlja = new JTextPane();
		txtpnProfesionalnaOrijentacijaPredstavlja.setText("Profesionalna orijentacija predstavlja skup usluga i aktivnosti koja omogucava pojedincima da donose odluke o svom obrazovanju, obuci i zanimanjima i upravljaju sopstvenim karijerama. Tokom tih procesa pojedincima se pruzaju informacije o trzistu rada i o razlicitim mogucnostima u obrazovanju i zaposljavanju, a pored toga im pomaze da razumeju sebe, svoje sopstvene teznje, interesovanja i da ih povezu sa pozeljnim mogucnostima za rad.");
		txtpnProfesionalnaOrijentacijaPredstavlja.setEditable(false);
		txtpnProfesionalnaOrijentacijaPredstavlja.setOpaque(false);		
		txtpnProfesionalnaOrijentacijaPredstavlja.setBounds(36, 474, 448, 118);
		contentPanel.add(txtpnProfesionalnaOrijentacijaPredstavlja);
		
		
	}
}
