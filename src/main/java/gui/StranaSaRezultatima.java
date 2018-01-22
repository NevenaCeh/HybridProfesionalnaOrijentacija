package gui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import kontroler.Kontroler;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

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
	private JLabel lblPreporucujemoVam;
	private JLabel lblZaBroj;
	private JLabel lblOblasti;
	private JLabel lblError;
	
	public StranaSaRezultatima(int brojOblasti) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowDeactivated(WindowEvent e) {
				Kontroler.getInstanca().vratiPocetnu();
			}
		});
		setBounds(100, 100, 923, 520);
		getContentPane().setLayout(null);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setTitle("Rezultati");
		this.brojOblasti = brojOblasti;
		
		JLabel lblNewLabel = new JLabel("Postovani");
		lblNewLabel.setBounds(22, 13, 56, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblIme = new JLabel("ime");
		lblIme.setBounds(104, 13, 351, 14);
		Font font = lblIme.getFont();
		lblIme.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
		lblIme.setFont(font.deriveFont(font.getStyle() | Font.ITALIC));
		getContentPane().add(lblIme);
		lblIme.setText(Kontroler.getInstanca().getIspitanik().getImePrezime());
		
		JPanel panel = new JPanel();
		panel.setBounds(470, 35, 422, 167);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblProsek = new JLabel("Prosek");
		lblProsek.setBounds(141, 27, 239, 16);
		Font f = lblProsek.getFont();
		lblProsek.setFont(f.deriveFont(f.getStyle() | Font.ITALIC));
		//lblProsek.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		panel.add(lblProsek);
		lblProsek.setText(Kontroler.getInstanca().getIspitanik().getProsek()+"");
		
		JTextArea lblIzabranoZanimanje = new JTextArea("Izabrano zanimanje");
		lblIzabranoZanimanje.setBounds(141, 68, 239, 66);
		Font f1 = lblIzabranoZanimanje.getFont();
		lblIzabranoZanimanje.setFont(f.deriveFont(f.getStyle() | Font.ITALIC));
		panel.add(lblIzabranoZanimanje);
		lblIzabranoZanimanje.setEditable(false);
		lblIzabranoZanimanje.setLineWrap(true);
		lblIzabranoZanimanje.setWrapStyleWord(true);
		lblIzabranoZanimanje.setOpaque(false);
		//lblIzabranoZanimanje.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblIzabranoZanimanje.setAlignmentX(CENTER_ALIGNMENT);
		lblIzabranoZanimanje.setAlignmentY(CENTER_ALIGNMENT);
		lblIzabranoZanimanje.setText(Kontroler.getInstanca().getIspitanik().getIzabranoZanimanje());		
		
		JLabel lblProsekNeMenjaj = new JLabel("Prosek:");
		lblProsekNeMenjaj.setBounds(12, 27, 56, 16);
		panel.add(lblProsekNeMenjaj);
		
		JLabel lblIzabrano = new JLabel("Izabrano");
		lblIzabrano.setBounds(12, 71, 56, 16);
		panel.add(lblIzabrano);
		
		JLabel lblZanimanje = new JLabel("zanimanje:");
		lblZanimanje.setBounds(12, 105, 72, 16);
		panel.add(lblZanimanje);
		
		lblPreporucujemoVam = new JLabel("Preporucujemo Vam");
		lblPreporucujemoVam.setBounds(22, 73, 145, 16);
		getContentPane().add(lblPreporucujemoVam);
		
		lblZaBroj = new JLabel();
		lblZaBroj.setBounds(161, 73, 21, 16);
		getContentPane().add(lblZaBroj);
		
		lblOblasti = new JLabel("oblasti");
		lblOblasti.setBounds(194, 73, 56, 16);
		getContentPane().add(lblOblasti);			
		
		panelSaDugmicima = new JPanel();
		panelSaDugmicima.setBounds(21, 115, 423, 71);
		getContentPane().add(panelSaDugmicima);
		panelSaDugmicima.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblError = new JLabel("");
		lblError.setBounds(22, 51, 422, 151);
		getContentPane().add(lblError);
		lblError.setIcon(new ImageIcon(StranaSaRezultatima.class.getResource("/img/no-results-found.png")));
		lblError.setVisible(false);
		
		try {
			postaviDugmice();
			lblZaBroj.setText(brojOblasti+"");			
		} catch (Exception e) {
			e.printStackTrace();
		}

		panelSaOblastima = new JPanel();
		panelSaOblastima.setBounds(12, 207, 880, 253);
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
		jtaObjasnjenje.setBounds(22, 37, 810, 162);
		panelSaOblastima.add(jtaObjasnjenje);
		jtaObjasnjenje.setOpaque(false);
		
		JLabel lblPreporucujemo = new JLabel("Preporucujemo:");
		lblPreporucujemo.setBounds(22, 212, 104, 16);
		panelSaOblastima.add(lblPreporucujemo);
		
		jlbFaks = new JLabel();
		jlbFaks.setBounds(148, 212, 785, 16);
		panelSaOblastima.add(jlbFaks);
		
		
		postaviIzgledPanelaOblasti(0);		
	}
	
	private void postaviDugmice() throws Exception {
		int oblastiIma = brojOblasti;
		if (oblastiIma == 0) {
			throw new Exception("Nema nijedne oblasti");
		}
		if (oblastiIma == 1) {
			String text = Kontroler.getInstanca().getIspitanik().getOblasti().get(0);
			if (text == "Obavezno ponovno testiranje!!!") {
				panelSaDugmicima.setVisible(false);
				lblPreporucujemoVam.setVisible(false);
				lblZaBroj.setVisible(false);
				lblOblasti.setVisible(false);
				lblError.setVisible(true);
			}
		}
		if (oblastiIma >=1) {
			btnPan1 = new JButton("Oblast 1");
			lblOblasti.setText("oblast");
			btnPan1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					postaviIzgledPanelaOblasti(0);
				}
			});
			panelSaDugmicima.add(btnPan1);
			if (oblastiIma == 1) {
				btnPan1.setVisible(false);
			}else {
				btnPan1.setVisible(true);
			}			
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
			Font f = jlbOblast.getFont();
			jlbOblast.setFont(f.deriveFont(f.getStyle() | Font.BOLD));;
			jlbFaks.setText(prfax);
			jtaObjasnjenje.setText(objasnjenje);
			jtaObjasnjenje.setWrapStyleWord(true);
			jtaObjasnjenje.setLineWrap(true);
			
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
}
