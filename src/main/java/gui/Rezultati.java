package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import domen.Ispitanik;
import gui.komponente.TblModelIspitanici;
import kontroler.Kontroler;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Rezultati extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tblIspitanici;
	private JTextField jtfKriterijumPretrage;

	public Rezultati() {
		setTitle("Rezultati ispitivanja");
		setBounds(100, 100, 554, 379);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		tblIspitanici = new JTable();
		List<Ispitanik> ispitanici = Kontroler.getInstanca().vratiListuIspitanika();
		TblModelIspitanici tm = new TblModelIspitanici(ispitanici);
        tblIspitanici.setModel(tm);
		JButton btnDetalji = new JButton("Detalji");
		btnDetalji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int red = tblIspitanici.getSelectedRow();
		        if (red >= 0) {
		            TblModelIspitanici tm = (TblModelIspitanici) tblIspitanici.getModel();
		            Ispitanik isp = tm.getIspitanik(red);
		            Ispitanik i;
		            try {
		                i = Kontroler.getInstanca().vratiIspitanika(isp);
		                StranaSaRezultatima detalji = new StranaSaRezultatima(i);
		                detalji.setVisible(true);
		            } catch (Exception ex) {
		                System.out.println(ex.getMessage());
		            }

		        }
			}
		});
        btnDetalji.setBounds(414, 296, 97, 25);
        contentPanel.add(btnDetalji);
        btnDetalji.setVisible(false);
		tblIspitanici.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnDetalji.setVisible(true);
			}
		});
		tblIspitanici.setBounds(12, 102, 512, 181);
		contentPanel.add(tblIspitanici);
		
		JLabel lblPretraga = new JLabel("Pretraga");
		lblPretraga.setBounds(30, 31, 56, 16);
		contentPanel.add(lblPretraga);
		
		jtfKriterijumPretrage = new JTextField();
		jtfKriterijumPretrage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				TblModelIspitanici tml = (TblModelIspitanici) tblIspitanici.getModel();
		        try {
		            String text = jtfKriterijumPretrage.getText().trim();
		            List<Ispitanik> ispitanicikrt = Kontroler.getInstanca().pretraziIspitanike(text);
		            if (text == null || text.isEmpty()) {
		                //jlbObavestenje.setVisible(false);
		            	jtfKriterijumPretrage.setBackground(Color.white);
		            }else if (ispitanicikrt == null || ispitanicikrt.isEmpty()) {
		                //jlbObavestenje.setText("Pronadjeni letovi po unetoj vrednosti!!!");
		            	jtfKriterijumPretrage.setBackground(Color.RED);
		            } else {
		               // jlbObavestenje.setText("Sistem ne može da nade letove po zadatim vrednostima!!!");
		            	jtfKriterijumPretrage.setBackground(Color.white);
		            }
		            tml.setIspitanici(ispitanicikrt);
		            tml.osveziTabelu();
		        } catch (Exception ex) {
		           // jlbObavestenje.setText("Sistem ne može da nade letove po zadatim vrednostima!!!");
		            tml.setIspitanici(new ArrayList<>());
		        }
			}
		});
		jtfKriterijumPretrage.setBounds(103, 28, 232, 22);
		contentPanel.add(jtfKriterijumPretrage);
		jtfKriterijumPretrage.setColumns(10);
	}
}
