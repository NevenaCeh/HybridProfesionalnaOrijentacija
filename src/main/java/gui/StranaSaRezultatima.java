package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import kontroler.Kontroler;

public class StranaSaRezultatima extends JDialog {

	private final JPanel contentPanel = new JPanel();
	int brojOblasti;
	private JPanel panelSaDugmicima;
	private JLabel jlbOblast;
	private JTextArea jtaObjasnjenje;
	private JLabel jlbFaks;	
	private JPanel panelSaOblastima;
	private JButton btnPan1;
	private JButton btnPan2;
	private JButton btnPan3;
	private JButton btnPan4;
	
	public StranaSaRezultatima(int brojOblasti) {
		setBounds(100, 100, 1000, 627);
		//setUndecorated(true); 
		//setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds()); 
		getContentPane().setLayout(null);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setTitle("Rezultati");
		this.brojOblasti = brojOblasti;
		
		JLabel lblNewLabel = new JLabel("Postovani");
		lblNewLabel.setBounds(22, 35, 56, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblIme = new JLabel("ime");
		lblIme.setBounds(107, 35, 305, 14);
		getContentPane().add(lblIme);
		lblIme.setText(Kontroler.getInstanca().getIspitanik().getImePrezime());
		
		JPanel panel = new JPanel();
		panel.setBounds(599, 35, 333, 159);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblProsek = new JLabel("Prosek");
		lblProsek.setBounds(141, 27, 56, 16);
		panel.add(lblProsek);
		lblProsek.setText(Kontroler.getInstanca().getIspitanik().getProsek()+"");
		
		JLabel lblIzabranoZanimanje = new JLabel("Izabrano zanimanje");
		lblIzabranoZanimanje.setBounds(141, 68, 132, 66);
		panel.add(lblIzabranoZanimanje);
		lblIzabranoZanimanje.setText(Kontroler.getInstanca().getIspitanik().getIzabranoZanimanje());		
		
		JLabel lblProsekNeMenjaj = new JLabel("Prosek:");
		lblProsekNeMenjaj.setBounds(12, 27, 56, 16);
		panel.add(lblProsekNeMenjaj);
		
		JLabel lblIzabrano = new JLabel("Izabrano");
		lblIzabrano.setBounds(12, 80, 56, 16);
		panel.add(lblIzabrano);
		
		JLabel lblZanimanje = new JLabel("zanimanje:");
		lblZanimanje.setBounds(12, 105, 72, 16);
		panel.add(lblZanimanje);
		
		JLabel lblPreporucujemoVam = new JLabel("Preporucujemo Vam");
		lblPreporucujemoVam.setBounds(22, 73, 145, 16);
		getContentPane().add(lblPreporucujemoVam);
		
		JLabel lblZaBroj = new JLabel();
		lblZaBroj.setBounds(161, 73, 56, 16);
		getContentPane().add(lblZaBroj);
		
		JLabel lblOblasti = new JLabel("oblasti");
		lblOblasti.setBounds(22, 90, 56, 16);
		getContentPane().add(lblOblasti);
		
		panelSaDugmicima = new JPanel();
		panelSaDugmicima.setBounds(21, 125, 316, 61);
		getContentPane().add(panelSaDugmicima);
		panelSaDugmicima.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		try {
			postaviDugmice();
			lblZaBroj.setText(brojOblasti+"");
			//postaviIzgledPanelaOblasti(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		panelSaOblastima = new JPanel();
		panelSaOblastima.setBounds(12, 233, 945, 308);
		getContentPane().add(panelSaOblastima);
		panelSaOblastima.setLayout(null);
		
		JLabel lblOblastKojaVam = new JLabel("Oblast koja Vam najvise odgovara je ");
		lblOblastKojaVam.setBounds(22, 8, 214, 16);
		panelSaOblastima.add(lblOblastKojaVam);
		
		jlbOblast = new JLabel();
		jlbOblast.setBounds(265, 8, 632, 16);
		panelSaOblastima.add(jlbOblast);
		
		jtaObjasnjenje = new JTextArea();
		jtaObjasnjenje.setEditable(false);
		jtaObjasnjenje.setBounds(22, 58, 892, 162);
		panelSaOblastima.add(jtaObjasnjenje);
		
		JLabel lblPreporucujemo = new JLabel("Preporucujemo:");
		lblPreporucujemo.setBounds(32, 243, 496, 16);
		panelSaOblastima.add(lblPreporucujemo);
		
		jlbFaks = new JLabel();
		jlbFaks.setBounds(129, 243, 785, 16);
		panelSaOblastima.add(jlbFaks);
		postaviIzgledPanelaOblasti(0);		
	}
	
	private void postaviDugmice() throws Exception {
		int oblastiIma = brojOblasti;
		if (oblastiIma == 0) {
			throw new Exception("Nema nijedne oblasti");
		}
		if (oblastiIma >=1) {
			btnPan1 = new JButton("Oblast 1");
			btnPan1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					postaviIzgledPanelaOblasti(0);
				}
			});
			panelSaDugmicima.add(btnPan1);
			btnPan1.setVisible(true);
			//postaviIzgledPanelaOblasti(0);
		}		
		if (oblastiIma>=2) {
			btnPan2 = new JButton("Oblast 2");
			panelSaDugmicima.add(btnPan2);
			btnPan2.setVisible(true);
			btnPan2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					postaviIzgledPanelaOblasti(1);
				}
			});
		}		
		if (oblastiIma >=3) {
			btnPan3 = new JButton("Oblast 3");
			panelSaDugmicima.add(btnPan3);
			btnPan3.setVisible(true);
			btnPan3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					postaviIzgledPanelaOblasti(2);
				}
			});
		}		
		if (oblastiIma == 4) {
			btnPan4 = new JButton("Oblast 4");
			panelSaDugmicima.add(btnPan4);
			btnPan4.setVisible(true);
			btnPan4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					postaviIzgledPanelaOblasti(3);
				}
			});
		}

	}

	private void postaviIzgledPanelaOblasti(int index) {
		try {					
			String objasnjenje = Kontroler.getInstanca().getIspitanik().getObjasnjenja().get(index);
			String rez = Kontroler.getInstanca().getIspitanik().getOblasti().get(index);
			if (rez == "tehnicki") {
				rez = "Tehnika i zanati";
			}
			if (rez == "estetOblik") {
				rez = "Estetsko oblikovanje";
			}
			if (rez == "humRad") {
				rez = "Humanitarno - zdravstveni rad";
			}
			String prfax = Kontroler.getInstanca().getIspitanik().getPredlozeniFakulteti().get(index);
			jlbOblast.setText(rez.toUpperCase());
			jlbFaks.setText(prfax);
			jtaObjasnjenje.setText(objasnjenje);
			jtaObjasnjenje.setLineWrap(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}

}
