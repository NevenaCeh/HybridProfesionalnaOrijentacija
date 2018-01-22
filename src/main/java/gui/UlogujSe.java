package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sun.org.apache.xerces.internal.util.DraconianErrorHandler;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import kontroler.Kontroler;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UlogujSe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jtfImeIPrezime;
	private JTextField jtfJMBG;
	private JTextField jtfProsekPrva;
	private JTextField jtfProsekDruga;
	private JTextField jtfProsekTreca;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public UlogujSe() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Kontroler.getInstanca().vratiPocetnu();
			}
		});
		setTitle("Uloguj se");
		setBounds(100, 100, 503, 435);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Ime i prezime:");
			lblNewLabel.setBounds(33, 50, 81, 14);
			contentPanel.add(lblNewLabel);
		}
		
		jtfImeIPrezime = new JTextField();
		jtfImeIPrezime.setBounds(178, 47, 269, 20);
		contentPanel.add(jtfImeIPrezime);
		
		JLabel lblMaticniBroj = new JLabel("Maticni broj:");
		lblMaticniBroj.setBounds(33, 95, 81, 14);
		contentPanel.add(lblMaticniBroj);
		
		jtfJMBG = new JTextField();
		jtfJMBG.setBounds(178, 92, 269, 20);
		contentPanel.add(jtfJMBG);
		jtfJMBG.setColumns(10);
		
		JComboBox jcbZanimanja = new JComboBox();
		jcbZanimanja.setModel(new DefaultComboBoxModel(new String[] {"Pravnik", "Racunovodja", "Blagajnik", "Policajac", "Vojno lice", "Tehnicar", "Programer", "Fotograf", "Prodavac ", "Muzicar (pevac, kompozitor, pijanista...)", "Likovni umetnik (slikar, vajar)", "Glumac", "Traktorista", "Lekar (sve vrste)", "Kuvar", "Biolog", "Hemicar", "Fizicar", "Veterinar", "Psihijatar"}));
		jcbZanimanja.setBounds(178, 275, 269, 20);
		contentPanel.add(jcbZanimanja);
		
		JButton btnZapocniTest = new JButton("Zapocni test");
		btnZapocniTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ime = jtfImeIPrezime.getText().trim();
				String jmbg = jtfJMBG.getText().trim();
				String prva = jtfProsekPrva.getText().trim();
				String druga = jtfProsekDruga.getText().trim();
				String treca = jtfProsekTreca.getText().trim();
				String izabrano = (String) jcbZanimanja.getSelectedItem();
				try {
					double prosek = validacija(ime, jmbg, prva, druga, treca);
					Kontroler.getInstanca().proveriImaLiGA(jmbg);
					Kontroler.getInstanca().postaviPrvePodatke(ime, jmbg, prosek, izabrano);
					PrvaStrana ps = new PrvaStrana();
					ps.setVisible(true);
					setVisible(false);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}				
			}

			private double validacija(String ime, String jmbg, String prva, String druga, String treca) throws Exception {
				if (ime == null || ime == "") {
					throw new Exception("Niste uneli Vase ime i prezime");
				}
				if (jmbg == null || jmbg == "") {
					throw new Exception("Niste uneli Vas maticni broj!!");
				}
				if (jmbg.length() != 13) {
					throw new Exception("Niste dobro uneli Vas maticni broj! Nema 13 cifara!!!");
				}
				if (prva == null || prva == "") {
					throw new Exception("Niste uneli prosek ostvaren u prvoj godini!!");
				}
				
				if (druga == null || druga == "") {
					throw new Exception("Niste uneli prosek ostvaren u drugoj godini!!");
				}
				if (treca == null || treca == "") {
					throw new Exception("Niste uneli prosek ostvaren u trecoj godini!!");
				}
				try {
					double prvabr = Double.parseDouble(prva);
					double drugabr = Double.parseDouble(druga);
					double trbr = Double.parseDouble(treca);
					if (prvabr < 2.00 || prvabr > 5.00) {
						throw new Exception("Unesite tacan prosek prve godine!!!");
					}
					if (drugabr < 2.00 || drugabr > 5.00) {
						throw new Exception("Unesite tacan prosek druge godine!!!");
					}
					if (trbr < 2.00 || trbr > 5.00) {
						throw new Exception("Unesite tacan prosek trece godine!!!");
					}
					double rezultat = izracunajProsek(prvabr, drugabr, trbr);
					return rezultat;
				} catch (NumberFormatException e) {
					throw new Exception("Upisite broj u formatu cc.cc!!!");
				}	
			}

			private double izracunajProsek(double prva, double druga, double treca) {
				double prosek = 0;
				double suma = prva+druga+treca;
				prosek = suma/3;
				return prosek;
			}
		});
		btnZapocniTest.setBounds(151, 351, 159, 23);
		contentPanel.add(btnZapocniTest);
		
		JLabel lblProsekIzI = new JLabel("Prosek iz I godine");
		lblProsekIzI.setBounds(33, 139, 124, 14);
		contentPanel.add(lblProsekIzI);
		
		jtfProsekPrva = new JTextField();
		jtfProsekPrva.setBounds(178, 136, 269, 20);
		contentPanel.add(jtfProsekPrva);
		jtfProsekPrva.setColumns(10);
		
		JLabel lblProsekIzIi = new JLabel("Prosek iz II godine");
		lblProsekIzIi.setBounds(33, 187, 124, 14);
		contentPanel.add(lblProsekIzIi);
		
		jtfProsekDruga = new JTextField();
		jtfProsekDruga.setColumns(10);
		jtfProsekDruga.setBounds(178, 184, 269, 20);
		contentPanel.add(jtfProsekDruga);
		
		JLabel lblProsekIzIii = new JLabel("Prosek iz III godine");
		lblProsekIzIii.setBounds(33, 232, 135, 14);
		contentPanel.add(lblProsekIzIii);
		
		jtfProsekTreca = new JTextField();
		jtfProsekTreca.setColumns(10);
		jtfProsekTreca.setBounds(178, 229, 269, 20);
		contentPanel.add(jtfProsekTreca);
		
		JLabel lblZelimDaBudem = new JLabel("Zelim da budem:");
		lblZelimDaBudem.setBounds(33, 278, 124, 14);
		contentPanel.add(lblZelimDaBudem);
		
		
	}
}
