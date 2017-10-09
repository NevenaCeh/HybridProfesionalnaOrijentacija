package kontroler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sourceforge.jFuzzyLogic.FIS;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import db.DBKonekcija;
import domen.Ispitanik;
import domen.Oblast;

public class Kontroler {

	private static Kontroler instanca;
	private Ispitanik ispitanik;
	DBKonekcija db;
	
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
	
	public void postaviPrvePodatke(String ime, String jmbg, double prosek, String izabrano){
		// TODO Auto-generated method stub
		ispitanik.setImePrezime(ime);
		ispitanik.setJmbg(jmbg);
		ispitanik.setProsek(prosek);
		ispitanik.setIzabranoZanimanje(izabrano);
		db.ubaciUBazu(jmbg, ime, prosek);
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
		// TODO Auto-generated method stub
		try {
			FIS fis = FIS.load("rules/rules.fcl", true);
			
			if (fis == null){
				System.err.println("Greska");
				return;
			}
			
			Oblast max = nadjikojihpoenaimanajvise();
			
			fis.setVariable(max.getIme(), max.getPoeni());
			//fis.setVariable("bezbednost", ispitanik.getBodoviBezbednost());
			fis.setVariable("prosek", ispitanik.getProsek());			
			fis.evaluate();
			String oblastzadefuzify = "asd";
			if(max.getIme() == "administracija"){ oblastzadefuzify = "oblastAdministracija";}
			if(max.getIme() == "bezbednost"){oblastzadefuzify = "oblastBezbednost";}
			if(max.getIme() == "estetOblik"){oblastzadefuzify = "oblastEstetOblik";}
			if(max.getIme() == "humRad"){oblastzadefuzify = "oblastHumRad";}
			if(max.getIme() == "kultura"){oblastzadefuzify = "oblastKultura";}
			if(max.getIme() == "nauka"){oblastzadefuzify = "oblastNauka";}
			if(max.getIme() == "poljoprivreda"){oblastzadefuzify = "oblastPoljoprivreda";}
			if(max.getIme() == "prehrana"){oblastzadefuzify = "oblastPrehrana";}
			if(max.getIme() == "tehnicki"){oblastzadefuzify = "oblastTehnicki";}
			if(max.getIme() == "trgovina"){oblastzadefuzify = "oblastTrgovina";}			
			double oblastsamaxpoena = fis.getVariable(oblastzadefuzify).defuzzify();
			
			System.out.println(max+" a posle deffuzifija dobijamo da je "+oblastzadefuzify+" sa poenima "+oblastsamaxpoena);
			//double oblbezbednost = fis.getVariable("oblastBezbednost").defuzzify();
			//System.out.println(fis.getVariable("napojnica").defuzzify());
			//System.out.println(obladm +" je administracija, "+oblbezbednost+" je bezbednost");
			
			
            // load up the knowledge base
	     /*   KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	
            kSession.insert(ispitanik);
            //kSession.setGlobal("ef", ef);
            kSession.fireAllRules();*/
            System.out.println(ispitanik);
        } catch (Throwable t) {
        	throw new Exception("Greska jer "+t.getMessage());
        	//JOptionPane.showMessageDialog(null, "problem zbog "+t.getMessage());
        }		
	}

	private Oblast nadjikojihpoenaimanajvise() {
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
		Oblast max = new Oblast(0, "null");
		for (Oblast obl: sveoblasti) {
			if (obl.getPoeni() > max.getPoeni()) {
				max = obl;
			}
		}
		return max;
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
	
	
	
}
