package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import kontroler.Kontroler;

public class TrecaStrana extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TrecaStrana dialog = new TrecaStrana();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TrecaStrana() {
		setBounds(100, 100, 564, 486);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblPravitiUgovoreO = new JLabel("21. Pripremati dokumenta za poslovne razgovore");
		lblPravitiUgovoreO.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPravitiUgovoreO.setBounds(10, 38, 228, 14);
		contentPanel.add(lblPravitiUgovoreO);
		
		JRadioButton jrbPrviNe = new JRadioButton("Ne");
		jrbPrviNe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbPrviNe.setBounds(309, 34, 46, 23);
		contentPanel.add(jrbPrviNe);
		
		JRadioButton jrbPrviSlabo = new JRadioButton("Slabo");
		jrbPrviSlabo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbPrviSlabo.setBounds(357, 34, 51, 23);
		contentPanel.add(jrbPrviSlabo);
		
		JRadioButton jrbPrviSrednje = new JRadioButton("Srednje");
		jrbPrviSrednje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbPrviSrednje.setBounds(410, 34, 63, 23);
		contentPanel.add(jrbPrviSrednje);
		
		JRadioButton jrbPrviJako = new JRadioButton("Jako");
		jrbPrviJako.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbPrviJako.setBounds(475, 34, 52, 23);
		contentPanel.add(jrbPrviJako);
		
		ButtonGroup prvoPitanje = new ButtonGroup();
		prvoPitanje.add(jrbPrviJako);
		prvoPitanje.add(jrbPrviSrednje);
		prvoPitanje.add(jrbPrviSlabo);
		prvoPitanje.add(jrbPrviNe);
		
		JLabel lblFizickiObezbedjivatiJavne = new JLabel("22. Obucavati mlade vojnike za koriscenje oruzja");
		lblFizickiObezbedjivatiJavne.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFizickiObezbedjivatiJavne.setBounds(10, 78, 228, 14);
		contentPanel.add(lblFizickiObezbedjivatiJavne);
		
		JRadioButton jrbDrugoNe = new JRadioButton("Ne");
		jrbDrugoNe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbDrugoNe.setBounds(309, 74, 46, 23);
		contentPanel.add(jrbDrugoNe);
		
		JRadioButton jrbDrugoSlabo = new JRadioButton("Slabo");
		jrbDrugoSlabo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbDrugoSlabo.setBounds(357, 74, 51, 23);
		contentPanel.add(jrbDrugoSlabo);
		
		JRadioButton jrbDrugoSrednje = new JRadioButton("Srednje");
		jrbDrugoSrednje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbDrugoSrednje.setBounds(410, 74, 63, 23);
		contentPanel.add(jrbDrugoSrednje);
		
		JRadioButton jrbDrugoJako = new JRadioButton("Jako");
		jrbDrugoJako.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbDrugoJako.setBounds(475, 74, 52, 23);
		contentPanel.add(jrbDrugoJako);
		
		ButtonGroup drugoPitanje = new ButtonGroup();
		drugoPitanje.add(jrbDrugoJako);
		drugoPitanje.add(jrbDrugoNe);
		drugoPitanje.add(jrbDrugoSlabo);
		drugoPitanje.add(jrbDrugoSrednje);
		
		JLabel lblPopravljatiIPodmazivati = new JLabel("23. Izradjivati specijalne alate");
		lblPopravljatiIPodmazivati.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPopravljatiIPodmazivati.setBounds(10, 119, 228, 14);
		contentPanel.add(lblPopravljatiIPodmazivati);
		
		JRadioButton jrbTreceNe = new JRadioButton("Ne");
		jrbTreceNe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbTreceNe.setBounds(309, 115, 46, 23);
		contentPanel.add(jrbTreceNe);
		
		JRadioButton jrbTreceSlabo = new JRadioButton("Slabo");
		jrbTreceSlabo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbTreceSlabo.setBounds(357, 115, 51, 23);
		contentPanel.add(jrbTreceSlabo);
		
		JRadioButton jrbTreceSrednje = new JRadioButton("Srednje");
		jrbTreceSrednje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbTreceSrednje.setBounds(410, 115, 63, 23);
		contentPanel.add(jrbTreceSrednje);
		
		JRadioButton jrbTreceJako = new JRadioButton("Jako");
		jrbTreceJako.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbTreceJako.setBounds(475, 115, 52, 23);
		contentPanel.add(jrbTreceJako);
		
		ButtonGroup trecePitanje = new ButtonGroup();
		trecePitanje.add(jrbTreceJako);
		trecePitanje.add(jrbTreceNe);
		trecePitanje.add(jrbTreceSlabo);
		trecePitanje.add(jrbTreceSrednje);
		
		JLabel lblBitiVoditeljRadio = new JLabel("24. Fotografisati vazne licnosti za ugledni casopis");
		lblBitiVoditeljRadio.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBitiVoditeljRadio.setBounds(10, 159, 228, 14);
		contentPanel.add(lblBitiVoditeljRadio);
		
		JRadioButton jrbCetvrtoNe = new JRadioButton("Ne");
		jrbCetvrtoNe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbCetvrtoNe.setBounds(309, 155, 46, 23);
		contentPanel.add(jrbCetvrtoNe);
		
		JRadioButton jrbCetvrtoSlabo = new JRadioButton("Slabo");
		jrbCetvrtoSlabo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbCetvrtoSlabo.setBounds(357, 155, 51, 23);
		contentPanel.add(jrbCetvrtoSlabo);
		
		JRadioButton jrbCetvrtoSrednje = new JRadioButton("Srednje");
		jrbCetvrtoSrednje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbCetvrtoSrednje.setBounds(410, 155, 63, 23);
		contentPanel.add(jrbCetvrtoSrednje);
		
		JRadioButton jrbCetvrtoJako = new JRadioButton("Jako");
		jrbCetvrtoJako.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbCetvrtoJako.setBounds(475, 155, 52, 23);
		contentPanel.add(jrbCetvrtoJako);
		
		ButtonGroup cetvrtoPitanje = new ButtonGroup();
		cetvrtoPitanje.add(jrbCetvrtoJako);
		cetvrtoPitanje.add(jrbCetvrtoSrednje);
		cetvrtoPitanje.add(jrbCetvrtoSlabo);
		cetvrtoPitanje.add(jrbCetvrtoNe);
		
		JLabel lblBitiClanTima = new JLabel("25. Naucno pratiti promene u ozonskom omotacu Zemlje");
		lblBitiClanTima.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBitiClanTima.setBounds(10, 199, 266, 14);
		contentPanel.add(lblBitiClanTima);
		
		JRadioButton jrbPetoNe = new JRadioButton("Ne");
		jrbPetoNe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbPetoNe.setBounds(306, 195, 46, 23);
		contentPanel.add(jrbPetoNe);
		
		JRadioButton jrbPetoSlabo = new JRadioButton("Slabo");
		jrbPetoSlabo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbPetoSlabo.setBounds(357, 195, 51, 23);
		contentPanel.add(jrbPetoSlabo);
		
		JRadioButton jrbPetoSrednje = new JRadioButton("Srednje");
		jrbPetoSrednje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbPetoSrednje.setBounds(410, 195, 63, 23);
		contentPanel.add(jrbPetoSrednje);
		
		JRadioButton jrbPetoJako = new JRadioButton("Jako");
		jrbPetoJako.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbPetoJako.setBounds(475, 195, 52, 23);
		contentPanel.add(jrbPetoJako);
		
		ButtonGroup petoPitanje = new ButtonGroup();
		petoPitanje.add(jrbPetoJako);
		petoPitanje.add(jrbPetoNe);
		petoPitanje.add(jrbPetoSlabo);
		petoPitanje.add(jrbPetoSrednje);
		
		JLabel lblZasticivatiDjubritiI = new JLabel("26. Uzgajati povrce u staklenicima");
		lblZasticivatiDjubritiI.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblZasticivatiDjubritiI.setBounds(10, 241, 228, 14);
		contentPanel.add(lblZasticivatiDjubritiI);
		
		JRadioButton jrbSestoNe = new JRadioButton("Ne");
		jrbSestoNe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbSestoNe.setBounds(306, 237, 46, 23);
		contentPanel.add(jrbSestoNe);
		
		JRadioButton jrbSestoSlabo = new JRadioButton("Slabo");
		jrbSestoSlabo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbSestoSlabo.setBounds(357, 237, 51, 23);
		contentPanel.add(jrbSestoSlabo);
		
		JRadioButton jrbSestoSrednje = new JRadioButton("Srednje");
		jrbSestoSrednje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbSestoSrednje.setBounds(410, 237, 63, 23);
		contentPanel.add(jrbSestoSrednje);
		
		JRadioButton jrbSestoJako = new JRadioButton("Jako");
		jrbSestoJako.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbSestoJako.setBounds(475, 237, 52, 23);
		contentPanel.add(jrbSestoJako);
		
		ButtonGroup sestoPitanje = new ButtonGroup();
		sestoPitanje.add(jrbSestoJako);
		sestoPitanje.add(jrbSestoNe);
		sestoPitanje.add(jrbSestoSlabo);
		sestoPitanje.add(jrbSestoSrednje);
		
		JLabel lblPriprematiSpecijaliteteItalijanske = new JLabel("27. Peci i ukrasavati torte i kolace po porudzbini");
		lblPriprematiSpecijaliteteItalijanske.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPriprematiSpecijaliteteItalijanske.setBounds(10, 279, 228, 14);
		contentPanel.add(lblPriprematiSpecijaliteteItalijanske);
		
		JRadioButton jrbSedmoNe = new JRadioButton("Ne");
		jrbSedmoNe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbSedmoNe.setBounds(306, 275, 46, 23);
		contentPanel.add(jrbSedmoNe);
		
		JRadioButton jrbSedmoSlabo = new JRadioButton("Slabo");
		jrbSedmoSlabo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbSedmoSlabo.setBounds(357, 275, 51, 23);
		contentPanel.add(jrbSedmoSlabo);
		
		JRadioButton jrbSedmoSrednje = new JRadioButton("Srednje");
		jrbSedmoSrednje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbSedmoSrednje.setBounds(410, 275, 63, 23);
		contentPanel.add(jrbSedmoSrednje);
		
		JRadioButton jrbSedmoJako = new JRadioButton("Jako");
		jrbSedmoJako.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbSedmoJako.setBounds(475, 275, 52, 23);
		contentPanel.add(jrbSedmoJako);
		
		ButtonGroup sedmoPitanje = new ButtonGroup();
		sedmoPitanje.add(jrbSedmoJako);
		sedmoPitanje.add(jrbSedmoNe);
		sedmoPitanje.add(jrbSedmoSlabo);
		sedmoPitanje.add(jrbSedmoSrednje);
		
		JLabel lblNabavljatiRobuOd = new JLabel("28. Za trgovinsku firmu otkupljivati poljoprivredne proizvode");
		lblNabavljatiRobuOd.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNabavljatiRobuOd.setBounds(10, 315, 290, 14);
		contentPanel.add(lblNabavljatiRobuOd);
		
		JRadioButton jrbOsmoNe = new JRadioButton("Ne");
		jrbOsmoNe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbOsmoNe.setBounds(306, 311, 46, 23);
		contentPanel.add(jrbOsmoNe);
		
		JRadioButton jrbOsmoSlabo = new JRadioButton("Slabo");
		jrbOsmoSlabo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbOsmoSlabo.setBounds(357, 311, 51, 23);
		contentPanel.add(jrbOsmoSlabo);
		
		JRadioButton jrbOsmoSrednje = new JRadioButton("Srednje");
		jrbOsmoSrednje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbOsmoSrednje.setBounds(410, 311, 63, 23);
		contentPanel.add(jrbOsmoSrednje);
		
		JRadioButton jrbOsmoJako = new JRadioButton("Jako");
		jrbOsmoJako.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbOsmoJako.setBounds(475, 311, 52, 23);
		contentPanel.add(jrbOsmoJako);
		
		ButtonGroup osmoPitanje = new ButtonGroup();
		osmoPitanje.add(jrbOsmoJako);
		osmoPitanje.add(jrbOsmoNe);
		osmoPitanje.add(jrbOsmoSlabo);
		osmoPitanje.add(jrbOsmoSrednje);
		
		JLabel lblIzradjivatiUnikatniNamestaj = new JLabel("29. Oblikovati modne frizure");
		lblIzradjivatiUnikatniNamestaj.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblIzradjivatiUnikatniNamestaj.setBounds(10, 351, 228, 14);
		contentPanel.add(lblIzradjivatiUnikatniNamestaj);
		
		JRadioButton jrbDevetoNe = new JRadioButton("Ne");
		jrbDevetoNe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbDevetoNe.setBounds(306, 347, 46, 23);
		contentPanel.add(jrbDevetoNe);
		
		JRadioButton jrbDevetoSlabo = new JRadioButton("Slabo");
		jrbDevetoSlabo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbDevetoSlabo.setBounds(357, 347, 51, 23);
		contentPanel.add(jrbDevetoSlabo);
		
		JRadioButton jrbDevetoSrednje = new JRadioButton("Srednje");
		jrbDevetoSrednje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbDevetoSrednje.setBounds(410, 347, 63, 23);
		contentPanel.add(jrbDevetoSrednje);
		
		JRadioButton jrbDevetoJako = new JRadioButton("Jako");
		jrbDevetoJako.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbDevetoJako.setBounds(475, 347, 52, 23);
		contentPanel.add(jrbDevetoJako);
		
		ButtonGroup devetoPitanje = new ButtonGroup();
		devetoPitanje.add(jrbDevetoJako);
		devetoPitanje.add(jrbDevetoNe);
		devetoPitanje.add(jrbDevetoSlabo);
		devetoPitanje.add(jrbDevetoSrednje);
		
		JLabel lblBrinutiSeZa = new JLabel("30. Vaspitavati decu bez roditelja u decjem selu");
		lblBrinutiSeZa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBrinutiSeZa.setBounds(10, 387, 228, 14);
		contentPanel.add(lblBrinutiSeZa);
		
		JRadioButton jrbDesetoNe = new JRadioButton("Ne");
		jrbDesetoNe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbDesetoNe.setBounds(306, 383, 46, 23);
		contentPanel.add(jrbDesetoNe);
		
		JRadioButton jrbDesetoSlabo = new JRadioButton("Slabo");
		jrbDesetoSlabo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbDesetoSlabo.setBounds(357, 383, 51, 23);
		contentPanel.add(jrbDesetoSlabo);
		
		JRadioButton jrbDesetoSrednje = new JRadioButton("Srednje");
		jrbDesetoSrednje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbDesetoSrednje.setBounds(410, 383, 63, 23);
		contentPanel.add(jrbDesetoSrednje);
		
		JRadioButton jrbDesetoJako = new JRadioButton("Jako");
		jrbDesetoJako.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jrbDesetoJako.setBounds(475, 383, 52, 23);
		contentPanel.add(jrbDesetoJako);
		
		ButtonGroup desetoPitanje = new ButtonGroup();
		desetoPitanje.add(jrbDesetoJako);
		desetoPitanje.add(jrbDesetoNe);
		desetoPitanje.add(jrbDesetoSlabo);
		desetoPitanje.add(jrbDesetoSrednje);
		
		JButton btnNastavi = new JButton("Nastavi ->");
		btnNastavi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nastaviDalje();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}

			private void nastaviDalje() throws Exception {
				// TODO Auto-generated method stub
				if (prvoPitanje.getSelection() == null) {
					throw new Exception("Niste selektovali nijedan odgovor u 21. pitanju!!!");
				}
				if (jrbPrviNe.isSelected()) {
					Kontroler.getInstanca().postaviBodoveAdministracije(1);
				}
				if (jrbPrviSlabo.isSelected()) {
					Kontroler.getInstanca().postaviBodoveAdministracije(2);
				}
				if (jrbPrviSrednje.isSelected()) {
					Kontroler.getInstanca().postaviBodoveAdministracije(3);
				}
				if (jrbPrviJako.isSelected()) {
					Kontroler.getInstanca().postaviBodoveAdministracije(4);
				}
				if (drugoPitanje.getSelection() == null) {
					throw new Exception("Niste selektovali nijedan odgovor u 22 pitanju!!!");
				}
				if (jrbDrugoNe.isSelected()) {
					Kontroler.getInstanca().postaviBodoveBezbednost(1);
				}
				if (jrbDrugoSlabo.isSelected()) {
					Kontroler.getInstanca().postaviBodoveBezbednost(2);
				}
				if (jrbDrugoSrednje.isSelected()) {
					Kontroler.getInstanca().postaviBodoveBezbednost(3);
				}
				if (jrbDrugoJako.isSelected()) {
					Kontroler.getInstanca().postaviBodoveBezbednost(4);
				}
				if (trecePitanje.getSelection() == null) {
					throw new Exception("Niste selektovali nijedan odgovor u 23. pitanju!!!");
				}
				if (jrbTreceNe.isSelected()) {
					Kontroler.getInstanca().postaviBodoveTehnicke(1);
				}
				if (jrbTreceSlabo.isSelected()) {
					Kontroler.getInstanca().postaviBodoveTehnicke(2);
				}
				if (jrbTreceSrednje.isSelected()) {
					Kontroler.getInstanca().postaviBodoveTehnicke(3);
				}
				if (jrbTreceJako.isSelected()) {
					Kontroler.getInstanca().postaviBodoveTehnicke(4);
				}
				if (cetvrtoPitanje.getSelection() == null) {
					throw new Exception("Niste selektovali nijedan odgovor u 24. pitanju!!!");
				}
				if (jrbCetvrtoNe.isSelected()) {
					Kontroler.getInstanca().postaviBodoveKultura(1);
				}
				if (jrbCetvrtoSlabo.isSelected()) {
					Kontroler.getInstanca().postaviBodoveKultura(2);
				}
				if (jrbCetvrtoSrednje.isSelected()) {
					Kontroler.getInstanca().postaviBodoveKultura(3);
				}
				if (jrbCetvrtoJako.isSelected()) {
					Kontroler.getInstanca().postaviBodoveKultura(4);
				}
				if (petoPitanje.getSelection() == null) {
					throw new Exception("Niste selektovali nijedan odgovor u 25. pitanju!!!");
				}
				if (jrbPetoNe.isSelected()) {
					Kontroler.getInstanca().postaviBodoveNauka(1);
				}
				if (jrbPetoSlabo.isSelected()) {
					Kontroler.getInstanca().postaviBodoveNauka(2);
				}
				if (jrbPetoSrednje.isSelected()) {
					Kontroler.getInstanca().postaviBodoveNauka(3);
				}
				if (jrbPetoJako.isSelected()) {
					Kontroler.getInstanca().postaviBodoveNauka(4);
				}
				if (sestoPitanje.getSelection() == null) {
					throw new Exception("Niste selektovali nijedan odgovor u 26. pitanju!!!");
				}
				if (jrbSestoNe.isSelected()) {
					Kontroler.getInstanca().postaviBodovePoljoprivreda(1);
				}
				if (jrbSestoSlabo.isSelected()) {
					Kontroler.getInstanca().postaviBodovePoljoprivreda(2);
				}
				if (jrbSestoSrednje.isSelected()) {
					Kontroler.getInstanca().postaviBodovePoljoprivreda(3);
				}
				if (jrbSestoJako.isSelected()) {
					Kontroler.getInstanca().postaviBodovePoljoprivreda(4);
				}
				if (sedmoPitanje.getSelection() == null) {
					throw new Exception("Niste selektovali nijedan odgovor u 27. pitanju!!!");
				}
				if (jrbSedmoNe.isSelected()) {
					Kontroler.getInstanca().postaviBodovePrehrana(1);
				}
				if (jrbSedmoSlabo.isSelected()) {
					Kontroler.getInstanca().postaviBodovePrehrana(2);
				}
				if (jrbSedmoSrednje.isSelected()) {
					Kontroler.getInstanca().postaviBodovePrehrana(3);
				}
				if (jrbSedmoJako.isSelected()) {
					Kontroler.getInstanca().postaviBodovePrehrana(4);
				}
				if (osmoPitanje.getSelection() == null) {
					throw new Exception("Niste selektovali nijedan odgovor u 28. pitanju!!!");
				}
				if (jrbOsmoNe.isSelected()) {
					Kontroler.getInstanca().postaviBodoveTrgovina(1);
				}
				if (jrbOsmoSlabo.isSelected()) {
					Kontroler.getInstanca().postaviBodoveTrgovina(2);
				}
				if (jrbOsmoSrednje.isSelected()) {
					Kontroler.getInstanca().postaviBodoveTrgovina(3);
				}
				if (jrbOsmoJako.isSelected()) {
					Kontroler.getInstanca().postaviBodoveTrgovina(4);
				}
				if (devetoPitanje.getSelection() == null) {
					throw new Exception("Niste selektovali nijedan odgovor u 29. pitanju!!!");
				}
				if (jrbDevetoNe.isSelected()) {
					Kontroler.getInstanca().postaviBodoveEstObl(1);
				}
				if (jrbDevetoSlabo.isSelected()) {
					Kontroler.getInstanca().postaviBodoveEstObl(2);
				}
				if (jrbDevetoSrednje.isSelected()) {
					Kontroler.getInstanca().postaviBodoveEstObl(3);
				}
				if (jrbDevetoJako.isSelected()) {
					Kontroler.getInstanca().postaviBodoveEstObl(4);
				}
				if (desetoPitanje.getSelection() == null) {
					throw new Exception("Niste selektovali nijedan odgovor u 30. pitanju!!!");
				}
				if (jrbDesetoNe.isSelected()) {
					Kontroler.getInstanca().postaviBodoveHumRad(1);
				}
				if (jrbDesetoSlabo.isSelected()) {
					Kontroler.getInstanca().postaviBodoveHumRad(2);
				}
				if (jrbDesetoSrednje.isSelected()) {
					Kontroler.getInstanca().postaviBodoveHumRad(3);
				}
				if (jrbDesetoJako.isSelected()) {
					Kontroler.getInstanca().postaviBodoveHumRad(4);
				}
				CetvrtaStrana cetvrta = new CetvrtaStrana();
				cetvrta.setVisible(true);
				dispose();
				
			}
		});

		btnNastavi.setBounds(214, 412, 115, 23);
		contentPanel.add(btnNastavi);
		}

}
