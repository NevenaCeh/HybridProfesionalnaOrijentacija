package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import domen.Oblast;
import kontroler.Kontroler;
import com.sun.javafx.css.Rule;
import com.sun.xml.internal.ws.api.Component;

public class OblastiInfo extends JDialog {

	private final JPanel contentPanel  = new JPanel(null);
	private static final long serialVersionUID = 1L;
	
	public OblastiInfo() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 900);
		setLocationRelativeTo(null);
		setTitle("Pregled oblasti");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblPregledOblasti = new JLabel("Pregled oblasti".toUpperCase());
			lblPregledOblasti.setBounds(157, 33, 130, 28);
			Font f = lblPregledOblasti.getFont();
			lblPregledOblasti.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
			contentPanel.add(lblPregledOblasti);
		
		
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(OblastiInfo.class.getResource("/img/upisi_5.jpg")));
			lblNewLabel.setBounds(33, 74, 359, 276);
			contentPanel.add(lblNewLabel);
			
			JPanel panelSaOblastima = new JPanel();
			panelSaOblastima.setBounds(12, 372, 410, 450);
			contentPanel.add(panelSaOblastima);
			
			List<Oblast> listaoblasti = Kontroler.getInstanca().vratiListuOblastiIzBaze();
			JPanel panel = createPanel(listaoblasti);
	        JScrollPane scroll1 = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scroll1.setPreferredSize(new Dimension(410, 450));
	        JScrollBar scrollbar = scroll1.getVerticalScrollBar();
	        scrollbar.addAdjustmentListener(new AdjustmentListener() {
				
				@Override
				public void adjustmentValueChanged(AdjustmentEvent e) {
					//System.out.println(scrollbar.getValue());
				}
			});
	        panelSaOblastima.add(scroll1);
	        panelSaOblastima.setBorder(null);
	        scroll1.setBorder(null);
	}
	
	public static JLabel createOblastiList(Oblast oblast) {
			JLabel lblImeOblasti = new JLabel("  "+oblast.getPunoime());
			lblImeOblasti.setBackground(Color.red);
			Font f = lblImeOblasti.getFont();
			lblImeOblasti.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
			lblImeOblasti.setPreferredSize(new Dimension(10, 10));
			return lblImeOblasti;
    }
	
	public static JTextArea createOblastiTxtPane(Oblast oblast) {			
		JTextArea txtObjasnjenje = new JTextArea();
		txtObjasnjenje.setEditable(false);
		txtObjasnjenje.setText(oblast.getObjasnjenje());
		txtObjasnjenje.setWrapStyleWord(true);
		//txtObjasnjenje.setOpaque(false);
		txtObjasnjenje.setLineWrap(true);
		txtObjasnjenje.setPreferredSize(new Dimension(100, 5));
		if (!oblast.getIme().equals("tehnicki")) {
			//System.out.println("tu je");
		//txtObjasnjenje.setBounds(new Rectangle(0, 0, 0, 0));
		//txtObjasnjenje.setSize(100, 50);
		txtObjasnjenje.setRows(5);
		}else {
			//txtObjasnjenje.setPreferredSize(new Dimension(100, 100));
		}		
		txtObjasnjenje.setAutoscrolls(true);
		//txtObjasnjenje.setBackground(Color.BLUE);
		return txtObjasnjenje;
}
	
	public static JPanel createPanel(List<Oblast> lista) {
        JPanel panel = new JPanel();
       // panel.setLayout(new GridLayout(0, 1, 0, 0));
        panel.setLayout(new GridLayout(0, 1));
        //panel.setOpaque(false);
        //panel.setBackground(Color.BLUE);
        for (Oblast oblast : lista) {
        	//System.out.println(oblast.getIme());
			panel.add(createOblastiList(oblast));
			panel.add(createOblastiTxtPane(oblast));			
		}
        return panel;
    }
}
