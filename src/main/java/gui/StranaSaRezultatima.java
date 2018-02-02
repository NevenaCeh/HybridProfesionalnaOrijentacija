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
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.BoxView;
import javax.swing.text.ComponentView;
import javax.swing.text.Element;
import javax.swing.text.IconView;
import javax.swing.text.LabelView;
import javax.swing.text.ParagraphView;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;

import domen.Ispitanik;
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
	private JTextPane jtaObjasnjenje;
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
	JLabel slikakljuc;
	
	public StranaSaRezultatima(int brojOblasti) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Kontroler.getInstanca().vratiPocetnu();
			}
		});
		setBounds(100, 100, 923, 489);
		getContentPane().setLayout(null);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setTitle("Rezultati");
		this.brojOblasti = brojOblasti;
		
		JLabel lblNewLabel = new JLabel("Postovani");
		lblNewLabel.setBounds(82, 24, 84, 14);
		getContentPane().add(lblNewLabel);
		Font fnt = lblNewLabel.getFont();
		lblNewLabel.setFont(fnt.deriveFont(fnt.getStyle() | Font.BOLD));
		lblNewLabel.setFont(fnt.deriveFont(fnt.getStyle() | Font.ITALIC));
		
		JLabel lblIme = new JLabel("ime");
		lblIme.setBounds(156, 24, 310, 14);
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
		lblProsek.setBounds(90, 27, 239, 16);
		Font f = lblProsek.getFont();
		lblProsek.setFont(f.deriveFont(f.getStyle() | Font.ITALIC));
		panel.add(lblProsek);
		lblProsek.setText(Kontroler.getInstanca().getIspitanik().getProsek()+"");
		
		JTextPane lblIzabranoZanimanje = new JTextPane();
		lblIzabranoZanimanje.setBounds(90, 68, 239, 66);
		Font f1 = lblIzabranoZanimanje.getFont();
		lblIzabranoZanimanje.setFont(f1.deriveFont(f1.getStyle() | Font.ITALIC));
		panel.add(lblIzabranoZanimanje);
		lblIzabranoZanimanje.setEditable(false);
		lblIzabranoZanimanje.setOpaque(false);
		lblIzabranoZanimanje.setEditorKit(new MyEditorKit());
		lblIzabranoZanimanje.setText(Kontroler.getInstanca().getIspitanik().getIzabranoZanimanje());		
		
		JLabel lblProsekNeMenjaj = new JLabel("Prosek:");
		lblProsekNeMenjaj.setBounds(12, 27, 56, 16);
		panel.add(lblProsekNeMenjaj);
		
		JLabel lblIzabrano = new JLabel("Izabrano");
		lblIzabrano.setBounds(12, 82, 56, 16);
		panel.add(lblIzabrano);
		
		JLabel lblZanimanje = new JLabel("zanimanje:");
		lblZanimanje.setBounds(12, 105, 72, 16);
		panel.add(lblZanimanje);
		
		lblPreporucujemoVam = new JLabel("Preporucujemo Vam");
		lblPreporucujemoVam.setBounds(82, 73, 145, 16);
		getContentPane().add(lblPreporucujemoVam);
		
		lblZaBroj = new JLabel();
		lblZaBroj.setBounds(218, 73, 21, 16);
		getContentPane().add(lblZaBroj);
		
		lblOblasti = new JLabel("oblasti");
		lblOblasti.setBounds(251, 73, 56, 16);
		getContentPane().add(lblOblasti);			
		
		panelSaDugmicima = new JPanel();
		panelSaDugmicima.setBounds(12, 102, 432, 100);
		getContentPane().add(panelSaDugmicima);
		panelSaDugmicima.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		slikakljuc = new JLabel("");
		slikakljuc.setIcon(new ImageIcon(StranaSaRezultatima.class.getResource("/img/iStock_000019647655Small1-300x212.jpg")));
		panelSaDugmicima.add(slikakljuc);
		slikakljuc.setVisible(false);
		
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
		panelSaOblastima.setBounds(12, 207, 880, 218);
		getContentPane().add(panelSaOblastima);
		panelSaOblastima.setLayout(null);
		
		JLabel lblOblastKojaVam = new JLabel("Oblast:");
		lblOblastKojaVam.setBounds(72, 8, 214, 16);
		panelSaOblastima.add(lblOblastKojaVam);
		
		jlbOblast = new JLabel();
		jlbOblast.setBounds(126, 8, 729, 16);
		panelSaOblastima.add(jlbOblast);
		
		jtaObjasnjenje = new JTextPane();
		jtaObjasnjenje.setEditable(false);
		jtaObjasnjenje.setBounds(22, 37, 832, 111);
		panelSaOblastima.add(jtaObjasnjenje);
		jtaObjasnjenje.setOpaque(false);
		jtaObjasnjenje.setAutoscrolls(true);			
		
		JLabel lblPreporucujemo = new JLabel("Preporucujemo:");
		lblPreporucujemo.setBounds(72, 175, 97, 16);
		panelSaOblastima.add(lblPreporucujemo);
		
		jlbFaks = new JLabel();
		jlbFaks.setBounds(171, 175, 697, 16);
		panelSaOblastima.add(jlbFaks);
		
		postaviIzgledPanelaOblasti(0);		
	}
	
	public StranaSaRezultatima(Ispitanik isp) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Kontroler.getInstanca().vratiPocetnu();
			}
		});
		setBounds(100, 100, 923, 489);
		getContentPane().setLayout(null);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setTitle("Rezultati");
		this.brojOblasti = brojOblasti;
		
		JLabel lblNewLabel = new JLabel("Rezultati:");
		lblNewLabel.setBounds(82, 24, 84, 14);
		getContentPane().add(lblNewLabel);
		Font fnt = lblNewLabel.getFont();
		lblNewLabel.setFont(fnt.deriveFont(fnt.getStyle() | Font.BOLD));
		lblNewLabel.setFont(fnt.deriveFont(fnt.getStyle() | Font.ITALIC));
		
		JLabel lblIme = new JLabel("ime");
		lblIme.setBounds(156, 24, 310, 14);
		Font font = lblIme.getFont();
		lblIme.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
		lblIme.setFont(font.deriveFont(font.getStyle() | Font.ITALIC));
		getContentPane().add(lblIme);
		lblIme.setText(isp.getImePrezime());
		
		JPanel panel = new JPanel();
		panel.setBounds(470, 35, 422, 167);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblProsek = new JLabel("Prosek");
		lblProsek.setBounds(90, 27, 239, 16);
		Font f = lblProsek.getFont();
		lblProsek.setFont(f.deriveFont(f.getStyle() | Font.ITALIC));
		panel.add(lblProsek);
		lblProsek.setText(isp.getProsek()+"");
		
		JTextPane lblIzabranoZanimanje = new JTextPane();
		lblIzabranoZanimanje.setBounds(90, 68, 239, 66);
		Font f1 = lblIzabranoZanimanje.getFont();
		lblIzabranoZanimanje.setFont(f1.deriveFont(f1.getStyle() | Font.ITALIC));
		panel.add(lblIzabranoZanimanje);
		lblIzabranoZanimanje.setEditable(false);
		lblIzabranoZanimanje.setOpaque(false);
		lblIzabranoZanimanje.setEditorKit(new MyEditorKit());
		lblIzabranoZanimanje.setText(isp.getIzabranoZanimanje());		
		
		JLabel lblProsekNeMenjaj = new JLabel("Prosek:");
		lblProsekNeMenjaj.setBounds(12, 27, 56, 16);
		panel.add(lblProsekNeMenjaj);
		
		JLabel lblIzabrano = new JLabel("Izabrano");
		lblIzabrano.setBounds(12, 82, 56, 16);
		panel.add(lblIzabrano);
		
		JLabel lblZanimanje = new JLabel("zanimanje:");
		lblZanimanje.setBounds(12, 105, 72, 16);
		panel.add(lblZanimanje);
		
		lblPreporucujemoVam = new JLabel("Preporucujemo Vam");
		lblPreporucujemoVam.setBounds(82, 73, 145, 16);
		getContentPane().add(lblPreporucujemoVam);
		
		lblZaBroj = new JLabel();
		lblZaBroj.setBounds(218, 73, 21, 16);
		getContentPane().add(lblZaBroj);
		
		lblOblasti = new JLabel("oblasti");
		lblOblasti.setBounds(251, 73, 56, 16);
		getContentPane().add(lblOblasti);			
		
		panelSaDugmicima = new JPanel();
		panelSaDugmicima.setBounds(12, 102, 432, 100);
		getContentPane().add(panelSaDugmicima);
		panelSaDugmicima.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		slikakljuc = new JLabel("");
		slikakljuc.setIcon(new ImageIcon(StranaSaRezultatima.class.getResource("/img/iStock_000019647655Small1-300x212.jpg")));
		panelSaDugmicima.add(slikakljuc);
		slikakljuc.setVisible(false);
		
		lblError = new JLabel("");
		lblError.setBounds(22, 51, 422, 151);
		getContentPane().add(lblError);
		lblError.setIcon(new ImageIcon(StranaSaRezultatima.class.getResource("/img/no-results-found.png")));
		lblError.setVisible(false);
		
		try {
			postaviDugmiceZaStranuSaRezultatima(isp);
			lblZaBroj.setText(isp.getOblasti().size()+"");			
		} catch (Exception e) {
			e.printStackTrace();
		}

		panelSaOblastima = new JPanel();
		panelSaOblastima.setBounds(12, 207, 880, 218);
		getContentPane().add(panelSaOblastima);
		panelSaOblastima.setLayout(null);
		
		JLabel lblOblastKojaVam = new JLabel("Oblast:");
		lblOblastKojaVam.setBounds(72, 8, 214, 16);
		panelSaOblastima.add(lblOblastKojaVam);
		
		jlbOblast = new JLabel();
		jlbOblast.setBounds(126, 8, 729, 16);
		panelSaOblastima.add(jlbOblast);
		
		jtaObjasnjenje = new JTextPane();
		jtaObjasnjenje.setEditable(false);
		jtaObjasnjenje.setBounds(22, 37, 832, 111);
		panelSaOblastima.add(jtaObjasnjenje);
		jtaObjasnjenje.setOpaque(false);
		jtaObjasnjenje.setAutoscrolls(true);			
		
		JLabel lblPreporucujemo = new JLabel("Preporucujemo:");
		lblPreporucujemo.setBounds(72, 175, 97, 16);
		panelSaOblastima.add(lblPreporucujemo);
		
		jlbFaks = new JLabel();
		jlbFaks.setBounds(171, 175, 697, 16);
		panelSaOblastima.add(jlbFaks);
		
		postaviIzgledPanelaOblastiSaRezultatima(isp, 0);		
	}

	private void postaviIzgledPanelaOblastiSaRezultatima(Ispitanik isp, int x) {
		try {					
			String objasnjenje = isp.getObjasnjenja().get(x);
			String rez = isp.getOblasti().get(x);
			if (rez == "tehnicki") {
				rez = "Tehnika i zanati";
			}
			if (rez == "estetOblik") {
				rez = "Estetsko oblikovanje";
			}
			if (rez == "humRad") {
				rez = "Humanitarno - zdravstveni rad";
			}
			String prfax = isp.getPredlozeniFakulteti().get(x);
			jlbOblast.setText(rez.toUpperCase());
			Font f = jlbOblast.getFont();
			jlbOblast.setFont(f.deriveFont(f.getStyle() | Font.BOLD));;
			jlbFaks.setText(prfax);
			//jtaObjasnjenje.setText(objasnjenje);
			//jtaObjasnjenje.setWrapStyleWord(true);
			//jtaObjasnjenje.setLineWrap(true);
			
			jtaObjasnjenje.setEditorKit(new MyEditorKit());
			SimpleAttributeSet attrs=new SimpleAttributeSet();
	        StyleConstants.setAlignment(attrs,StyleConstants.ALIGN_CENTER);
	        StyledDocument doc=(StyledDocument)jtaObjasnjenje.getDocument();
	        try {
				doc.insertString(0,objasnjenje,attrs);
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        doc.setParagraphAttributes(0,doc.getLength()-1,attrs,false);
	        
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		
	

	private void postaviDugmiceZaStranuSaRezultatima(Ispitanik isp) {
		int oblastiIma = isp.getOblasti().size();
		if (oblastiIma == 1) {
			String text = isp.getOblasti().get(0);
			if (text == "Obavezno ponovno testiranje!!!" || text == "Premala zainteresovanost za ove oblasti!!!") {
				panelSaDugmicima.setVisible(false);
				lblPreporucujemoVam.setVisible(false);
				lblZaBroj.setVisible(false);
				lblOblasti.setVisible(false);
				lblError.setVisible(true);
			}else {
				slikakljuc.setVisible(true);
			}
		}
		if (oblastiIma >=1) {
			btnPan1 = new JButton("Oblast 1");
			lblOblasti.setText("oblast");
			btnPan1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					postaviIzgledPanelaOblastiSaRezultatima(isp, 0);
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
					postaviIzgledPanelaOblastiSaRezultatima(isp, 1);
				}
			});
		}		
		if (oblastiIma >=3) {
			btnPan3 = new JButton("Oblast 3");
			panelSaDugmicima.add(btnPan3);
			btnPan3.setVisible(true);
			btnPan3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					postaviIzgledPanelaOblastiSaRezultatima(isp, 2);
				}
			});
		}		
		if (oblastiIma == 4) {
			btnPan4 = new JButton("Oblast 4");
			panelSaDugmicima.add(btnPan4);
			btnPan4.setVisible(true);
			btnPan4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					postaviIzgledPanelaOblastiSaRezultatima(isp, 3);
				}
			});
		}
		
	}

	private void postaviDugmice() throws Exception {
		int oblastiIma = brojOblasti;
		if (oblastiIma == 0) {
			throw new Exception("Nema nijedne oblasti");
		}
		if (oblastiIma == 1) {
			String text = Kontroler.getInstanca().getIspitanik().getOblasti().get(0);
			if (text == "Obavezno ponovno testiranje!!!" || text == "Premala zainteresovanost za ove oblasti!!!") {
				panelSaDugmicima.setVisible(false);
				lblPreporucujemoVam.setVisible(false);
				lblZaBroj.setVisible(false);
				lblOblasti.setVisible(false);
				lblError.setVisible(true);
			}else {
				slikakljuc.setVisible(true);
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
			//jtaObjasnjenje.setText(objasnjenje);
			//jtaObjasnjenje.setWrapStyleWord(true);
			//jtaObjasnjenje.setLineWrap(true);
			
			jtaObjasnjenje.setEditorKit(new MyEditorKit());
			SimpleAttributeSet attrs=new SimpleAttributeSet();
	        StyleConstants.setAlignment(attrs,StyleConstants.ALIGN_CENTER);
	        StyledDocument doc=(StyledDocument)jtaObjasnjenje.getDocument();
	        try {
				doc.insertString(0,objasnjenje,attrs);
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        doc.setParagraphAttributes(0,doc.getLength()-1,attrs,false);
	        
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
}

class MyEditorKit extends StyledEditorKit {

    public ViewFactory getViewFactory() {
        return new StyledViewFactory();
    }
 
    static class StyledViewFactory implements ViewFactory {

		@Override
		public View create(Element elem) {
			String kind = elem.getName();
            if (kind != null) {
                if (kind.equals(AbstractDocument.ContentElementName)) {
                    return new LabelView(elem);
                } else if (kind.equals(AbstractDocument.ParagraphElementName)) {
                    return new ParagraphView(elem);
                } else if (kind.equals(AbstractDocument.SectionElementName)) {
                    return new CenteredBoxView(elem, View.Y_AXIS);
                } else if (kind.equals(StyleConstants.ComponentElementName)) {
                    return new ComponentView(elem);
                } else if (kind.equals(StyleConstants.IconElementName)) {

                    return new IconView(elem);
                }
            }
 
            return new LabelView(elem);
		}

    }
}
 
class CenteredBoxView extends BoxView {
    public CenteredBoxView(Element elem, int axis) {

        super(elem,axis);
    }
    protected void layoutMajorAxis(int targetSpan, int axis, int[] offsets, int[] spans) {

        super.layoutMajorAxis(targetSpan,axis,offsets,spans);
        int textBlockHeight = 0;
        int offset = 0;
 
        for (int i = 0; i < spans.length; i++) {

            textBlockHeight = spans[i];
        }
        offset = (targetSpan - textBlockHeight) / 2;
        for (int i = 0; i < offsets.length; i++) {
            offsets[i] += offset;
        }

    }
}    
