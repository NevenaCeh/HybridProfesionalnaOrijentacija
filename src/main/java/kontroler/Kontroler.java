package kontroler;

import java.util.*;
import net.sourceforge.jFuzzyLogic.FIS;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import db.DBKonekcija;
import domen.Ispitanik;
import domen.Oblast;
import gui.Pocetna;

public class Kontroler {

	private static Kontroler instanca;
	private Ispitanik ispitanik;
	DBKonekcija db;
	private static Pocetna p;
	
	private Kontroler(){
		ispitanik = new Ispitanik();
		db = new DBKonekcija();
	}
	
	public static Kontroler getInstanca() {
		if (instanca == null) {
			instanca = new Kontroler();
		}
		return instanca;
	}
	
	public static final void main(String[] args) {
    	p = new Pocetna();
    	p.setLocationRelativeTo(null);
    	p.setVisible(true);
    }
	
	public void vratiPocetnu() {
		p.setVisible(true);
	}
	
	public void sakrijPocetnu() {
		p.setVisible(false);
	}
	
	public void postaviPrvePodatke(String ime, String jmbg, double prosek, String izabrano){
		ispitanik.setImePrezime(ime);
		ispitanik.setJmbg(jmbg);
		ispitanik.setProsek(prosek);
		ispitanik.setIzabranoZanimanje(izabrano);
		db.ubaciUBazu(jmbg, ime, prosek, izabrano);
	}
	
	public void postaviBodoveAdministracije(int poen){
		int sadIma = ispitanik.getBodoviAdministracija();
		ispitanik.setBodoviAdministracija(sadIma+poen);
	}
	
	public void postaviBodoveBezbednost(int poen){
		int sadIma = ispitanik.getBodoviBezbednost();
		ispitanik.setBodoviBezbednost(sadIma+poen);
	}
	
	public void postaviBodoveTehnicke(int poen){
		int sadIma = ispitanik.getBodoviTehnicki();
		ispitanik.setBodoviTehnicki(sadIma+poen);
	}
	
	public void postaviBodoveKultura(int poen){
		int sadIma = ispitanik.getBodoviKultura();
		ispitanik.setBodoviKultura(sadIma+poen);
	}
	
	public void postaviBodoveNauka(int poen){
		int sadIma = ispitanik.getBodoviNauka();
		ispitanik.setBodoviNauka(sadIma+poen);
	}
	
	public void postaviBodovePoljoprivreda(int poen){
		int sadIma = ispitanik.getBodoviPoljoprivreda();
		ispitanik.setBodoviPoljoprivreda(sadIma+poen);
	}
	
	public void postaviBodovePrehrana(int poen){
		int sadIma = ispitanik.getBodoviPrehrana();
		ispitanik.setBodoviPrehrana(sadIma+poen);
	}
	
	public void postaviBodoveTrgovina(int poen){
		int sadIma = ispitanik.getBodoviTrgovina();
		ispitanik.setBodoviTrgovina(sadIma+poen);
	}
	
	public void postaviBodoveEstObl(int poen){
		int sadIma = ispitanik.getBodoviEstetOblik();
		ispitanik.setBodoviEstetOblik(sadIma+poen);
	}
	
	public void postaviBodoveHumRad(int poen){
		int sadIma = ispitanik.getBodoviHumRad();
		ispitanik.setBodoviHumRad(sadIma+poen);
	}

	public void odradiEspertDeo() throws Exception {
		List<Oblast> oblastisortirane = vratiListuOblasti();
		//ekstremni slucajevi
		boolean ekstrem = false;
		//svi su ne
		int ne = 0;
		int svijaki = 0;
		for (Oblast oblast : oblastisortirane) {
			if (oblast.getNivo() == 1) {
				ne+=1;
			}
			if (oblast.getNivo() == 4) {
				svijaki+=1;
			}						
		}
		if (ne == 10 || svijaki == 10) {
			ekstrem = true;
		}
		if (ekstrem) {
			Oblast ekstremoblast = new Oblast(0, "ekstrem");
            if (ne == 10) {
				ekstremoblast.setNivo(1);				
			}else if (svijaki == 10){
				ekstremoblast.setNivo(4);
			}
            ispitanik.getOblasti().add("Obavezno ponovno testiranje!!!");
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");        		
        		kSession.insert(ekstremoblast);
                kSession.insert(ispitanik);                                
            	kSession.fireAllRules();			 
        	System.out.println(ispitanik);
		}else {
			try {
				FIS fis = FIS.load("rules/rules.fcl", true);			
				if (fis == null){
					System.err.println("Greska, nema rules.fcl fajla");
					return;
				}						
				fis.setVariable("prosek", ispitanik.getProsek());			
				for (Oblast oblast : oblastisortirane) {
					fis.setVariable(oblast.getIme(), oblast.getPoeni());				
				}
				fis.evaluate();
			
				for (Oblast oblast : oblastisortirane) {
					String oblastzadefuzify = "asd";
					if(oblast.getIme() == "administracija"){ oblastzadefuzify = "oblastAdministracija";}
					if(oblast.getIme() == "bezbednost"){oblastzadefuzify = "oblastBezbednost";}
					if(oblast.getIme() == "estetOblik"){oblastzadefuzify = "oblastEstetOblik";}
					if(oblast.getIme() == "humRad"){oblastzadefuzify = "oblastHumRad";}
					if(oblast.getIme() == "kultura"){oblastzadefuzify = "oblastKultura";}
					if(oblast.getIme() == "nauka"){oblastzadefuzify = "oblastNauka";}
					if(oblast.getIme() == "poljoprivreda"){oblastzadefuzify = "oblastPoljoprivreda";}
					if(oblast.getIme() == "prehrana"){oblastzadefuzify = "oblastPrehrana";}
					if(oblast.getIme() == "tehnicki"){oblastzadefuzify = "oblastTehnicki";}
					if(oblast.getIme() == "trgovina"){oblastzadefuzify = "oblastTrgovina";}			
					double oblastsafuzzypoenima = fis.getVariable(oblastzadefuzify).defuzzify();
					oblast.setPoeni(oblastsafuzzypoenima);			
				}			
				Iterator<Oblast> it = oblastisortirane.iterator();
				while (it.hasNext()) {
				   Oblast o = it.next();
				   if (o.getNivo() == 1) {
					   it.remove();
					}
				}
				if (oblastisortirane.size() > 4) {
					oblastisortirane = oblastisortirane.subList(0, 4);
				}						
				List<String> dapopunimo = new ArrayList<String>();
				for (Oblast oblast : oblastisortirane) {
					System.out.println(oblast);
					dapopunimo.add(oblast.getIme());
				}					
				for (String string : dapopunimo) {
					System.out.println(string);
				}
				ispitanik.setOblasti(dapopunimo);
													
	            // load up the knowledge base
		        KieServices ks = KieServices.Factory.get();
	    	    KieContainer kContainer = ks.getKieClasspathContainer();
	        	KieSession kSession = kContainer.newKieSession("ksession-rules");
	        	for (Oblast oblast : oblastisortirane) {
	        		kSession.insert(oblast);
	                kSession.insert(ispitanik);                                
	            	kSession.fireAllRules();
				}  
	        	
	        	if (ispitanik.getOblasti().isEmpty()) {
	        		Oblast praznaoblast = new Oblast(0, "prazna");
	                ispitanik.getOblasti().add("Premala zainteresovanost za ove oblasti!!!");
	        		kSession.insert(praznaoblast);
	                kSession.insert(ispitanik);                                
	            	kSession.fireAllRules();
				}
	        	System.out.println(ispitanik);
	        	
	        } catch (Throwable t) {
	        	throw new Exception("Greska jer "+t.getMessage());
	        }		
		}
		db.izmeniIspitanika(ispitanik);
		
	}
	
	private List<Oblast> vratiListuOblasti(){
		List<Oblast> sveoblasti = new ArrayList<>();
		double adm = ispitanik.getBodoviAdministracija();
		Oblast oadm = new Oblast(adm, "administracija");
		sveoblasti.add(oadm);		
		double bez = ispitanik.getBodoviBezbednost();
		Oblast obez = new Oblast(bez, "bezbednost");
		sveoblasti.add(obez);
		double est = ispitanik.getBodoviEstetOblik();
		Oblast oest = new Oblast(est, "estetOblik");
		sveoblasti.add(oest);
		double humrad = ispitanik.getBodoviHumRad();
		Oblast ohumrad = new Oblast(humrad, "humRad");
		sveoblasti.add(ohumrad);
		double kultura = ispitanik.getBodoviKultura();
		Oblast okultura = new Oblast(kultura, "kultura");
		sveoblasti.add(okultura);
		double nauka = ispitanik.getBodoviNauka();
		Oblast onauka = new Oblast(nauka, "nauka");
		sveoblasti.add(onauka);
		double polj = ispitanik.getBodoviPoljoprivreda();
		Oblast opolj = new Oblast(polj, "poljoprivreda");
		sveoblasti.add(opolj);
		double preh = ispitanik.getBodoviPrehrana();
		Oblast oprehrana = new Oblast(preh, "prehrana");
		sveoblasti.add(oprehrana);
		double tehnicki = ispitanik.getBodoviTehnicki();
		Oblast otehn = new Oblast(tehnicki, "tehnicki");
		sveoblasti.add(otehn);
		double trgovina = ispitanik.getBodoviTrgovina();
		Oblast otrg = new Oblast(trgovina, "trgovina");		
		sveoblasti.add(otrg);
		for (Oblast oblast : sveoblasti) {
			oblast.setNivo(postaviNivo(oblast.getPoeni()));
		}		
		sveoblasti.sort(Comparator.comparingDouble(Oblast::getPoeni).reversed());		
		return sveoblasti;
	}

	private int postaviNivo(double poeni) {
		int nivo = 1;
		if (poeni >18 && poeni <=29) {
			nivo = 2;
		}
		if (poeni >29 && poeni <=40) {
			nivo = 3;
		}
		if (poeni >40) {
			nivo = 4;
		}
		return nivo;
	}

	public Ispitanik getIspitanik() {
		return ispitanik;
	}

	public void proveriImaLiGA(String jmbg) throws Exception{
		List<Ispitanik> lista = db.vratiListuIspitanika();
		for (Ispitanik isp : lista) {
			if (isp.getJmbg().equals(jmbg)) {
				throw new Exception("Osoba sa ovim podacima je vec radila test!!!");
			}			
		}		
	}

	public List<Oblast> vratiListuOblastiIzBaze() {
		return db.vratiListuOblasti();
	}

	public List<Ispitanik> vratiListuIspitanika() {		
		return db.vratiListuIspitanika();
	}

	public Ispitanik vratiIspitanika(Ispitanik isp) {
		try {
			Ispitanik ibaza = db.vratiIspitanika(isp);
			System.out.println(ibaza);
			return ibaza;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Ispitanik> pretraziIspitanike(String text) {
		return db.pretraziIspitanike(text);
	}	
	
}
