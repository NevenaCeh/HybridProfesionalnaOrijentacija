package gui;

import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import domen.Oblast;
import kontroler.Kontroler;

import javax.swing.JLabel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;

public class OblastiInfo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	DefaultBoundedRangeModel model;
	private AdjustmentListener adjlisten;
	
	public OblastiInfo() {		
		setModal(true);
		setTitle("Pregled oblasti");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblPregledOblasti = new JLabel("Pregled oblasti");
			lblPregledOblasti.setBounds(162, 33, 95, 28);
			contentPanel.add(lblPregledOblasti);
		
		
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(OblastiInfo.class.getResource("/img/upisi_5.jpg")));
			lblNewLabel.setBounds(33, 74, 359, 276);
			contentPanel.add(lblNewLabel);
		
		
		JScrollBar jsbOblasti = new JScrollBar();
		jsbOblasti.setBounds(418, 0, 21, 854);
		contentPanel.add(jsbOblasti);
		model = (DefaultBoundedRangeModel) jsbOblasti.getModel();
		adjlisten = new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getValue()+"");
			}
		};
		jsbOblasti.addAdjustmentListener(adjlisten);
		
		List<Oblast> listaoblasti = Kontroler.getInstanca().vratiListuOblastiIzBaze();
		int visina = 350;
		for (Oblast oblast : listaoblasti) {
			JPanel jpnlOblast = new JPanel();
			jpnlOblast.setBounds(33, visina, 359, 189);
			visina+=170;
			contentPanel.add(jpnlOblast);
			jpnlOblast.setLayout(null);
			
			JLabel lblImeOblasti = new JLabel(oblast.getPunoime());
			lblImeOblasti.setBounds(146, 29, 200, 16);
			jpnlOblast.add(lblImeOblasti);
			
			JTextPane txtObjasnjenje = new JTextPane();
			txtObjasnjenje.setEditable(false);
			txtObjasnjenje.setBounds(12, 70, 335, 106);
			txtObjasnjenje.setText(oblast.getObjasnjenje());
			jpnlOblast.add(txtObjasnjenje);
		}
		setBounds(100, 100, 457, 901);
	}
}
