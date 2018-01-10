package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import kontroler.Kontroler;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Konacnaaaa extends JDialog {


	public Konacnaaaa() {
		setBounds(100, 100, 701, 412);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Postovani");
		lblNewLabel.setBounds(22, 35, 56, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblIme = new JLabel("ime");
		lblIme.setBounds(107, 35, 305, 14);
		getContentPane().add(lblIme);
		
		JLabel lblOblastKojaVam = new JLabel("Oblast koja Vam najvise odgovara je ");
		lblOblastKojaVam.setBounds(22, 77, 214, 14);
		getContentPane().add(lblOblastKojaVam);
		
		JLabel jlbOblast = new JLabel("New label");
		jlbOblast.setBounds(22, 114, 437, 14);
		getContentPane().add(jlbOblast);
		
		JLabel lblPreporucujemo = new JLabel("Preporucujemo:");
		lblPreporucujemo.setBounds(22, 279, 108, 14);
		getContentPane().add(lblPreporucujemo);
		
		JTextArea jtaObjasnjenje = new JTextArea();
		jtaObjasnjenje.setBounds(21, 139, 636, 129);
		getContentPane().add(jtaObjasnjenje);
		
		JLabel jlbFaks = new JLabel("New label");
		jlbFaks.setBounds(22, 304, 635, 14);
		getContentPane().add(jlbFaks);
		
		postaviTextLabele(jlbOblast, jlbFaks, jtaObjasnjenje, lblIme);
		
	}

	private void postaviTextLabele(JLabel jlbResenje, JLabel fax, JTextArea obj, JLabel im) {
		// TODO Auto-generated method stub
		try {
			Kontroler.getInstanca().odradiEspertDeo();
			String ime = Kontroler.getInstanca().getIspitanik().getImePrezime();
		//	String objasnjenje = Kontroler.getInstanca().getIspitanik().getObjasnjenje();
		//	String rez = Kontroler.getInstanca().getIspitanik().getRezultat();
		//	String prfax = Kontroler.getInstanca().getIspitanik().getPredlozeniFakultet();
		//	jlbResenje.setText(rez);
		//	fax.setText(prfax);
		//	obj.setText(objasnjenje);
			im.setText(ime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
