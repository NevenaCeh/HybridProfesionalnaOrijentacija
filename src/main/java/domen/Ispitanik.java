package domen;

import java.util.ArrayList;
import java.util.List;

public class Ispitanik {
	
	private String imePrezime;
	private String jmbg;
	private double prosek = 0;
	private String izabranoZanimanje = "nepoznato";
	private int bodoviAdministracija = 0;
	private int bodoviBezbednost = 0;
	private int bodoviTehnicki = 0;
	private int bodoviKultura = 0;
	private int bodoviNauka = 0;
	private int bodoviPoljoprivreda = 0;
	private int bodoviPrehrana = 0;
	private int bodoviTrgovina = 0;
	private int bodoviEstetOblik = 0;
	private int bodoviHumRad = 0;
	private List<String> oblasti;
	private List<String> objasnjenja;
	private List<String> predlozeniFakulteti;
		
	public int getBodoviAdministracija() {
		return bodoviAdministracija;
	}
	public void setBodoviAdministracija(int bodoviAdministracija) {
		this.bodoviAdministracija = bodoviAdministracija;
	}
	public int getBodoviBezbednost() {
		return bodoviBezbednost;
	}
	public void setBodoviBezbednost(int bodoviBezbednost) {
		this.bodoviBezbednost = bodoviBezbednost;
	}
	public int getBodoviTehnicki() {
		return bodoviTehnicki;
	}
	public void setBodoviTehnicki(int bodoviTehnicki) {
		this.bodoviTehnicki = bodoviTehnicki;
	}
	public int getBodoviKultura() {
		return bodoviKultura;
	}
	public void setBodoviKultura(int bodoviKultura) {
		this.bodoviKultura = bodoviKultura;
	}
	public int getBodoviNauka() {
		return bodoviNauka;
	}
	public void setBodoviNauka(int bodoviNauka) {
		this.bodoviNauka = bodoviNauka;
	}
	public int getBodoviPoljoprivreda() {
		return bodoviPoljoprivreda;
	}
	public void setBodoviPoljoprivreda(int bodoviPoljoprivreda) {
		this.bodoviPoljoprivreda = bodoviPoljoprivreda;
	}
	public int getBodoviPrehrana() {
		return bodoviPrehrana;
	}
	public void setBodoviPrehrana(int bodoviPrehrana) {
		this.bodoviPrehrana = bodoviPrehrana;
	}
	public int getBodoviTrgovina() {
		return bodoviTrgovina;
	}
	public void setBodoviTrgovina(int bodoviTrgovina) {
		this.bodoviTrgovina = bodoviTrgovina;
	}
	public int getBodoviEstetOblik() {
		return bodoviEstetOblik;
	}
	public void setBodoviEstetOblik(int bodoviEstetOblik) {
		this.bodoviEstetOblik = bodoviEstetOblik;
	}
	public int getBodoviHumRad() {
		return bodoviHumRad;
	}
	public void setBodoviHumRad(int bodoviHumRad) {
		this.bodoviHumRad = bodoviHumRad;
	}

	public String getImePrezime() {
		return imePrezime;
	}
	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public Ispitanik(){
		oblasti = new ArrayList<>();
		objasnjenja = new ArrayList<>();
		predlozeniFakulteti = new ArrayList<>();
	}	
	
	public double getProsek() {
		return prosek;
	}
	public void setProsek(double prosek) {
		this.prosek = prosek;
	}

	public String getIzabranoZanimanje() {
		return izabranoZanimanje;
	}
	public void setIzabranoZanimanje(String izabranoZanimanje) {
		this.izabranoZanimanje = izabranoZanimanje;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Ispitanik other = (Ispitanik) obj;
		if (jmbg == null) {
			if (other.jmbg != null)
				return false;
		} else if (!jmbg.equals(other.jmbg))
			return false;
		return true;
	}
	public List<String> getOblasti() {
		return oblasti;
	}
	public void setOblasti(List<String> oblasti) {
		this.oblasti = oblasti;
	}
	public List<String> getObjasnjenja() {
		return objasnjenja;
	}
	public void setObjasnjenja(List<String> objasnjenja) {
		this.objasnjenja = objasnjenja;
	}
	public List<String> getPredlozeniFakulteti() {
		return predlozeniFakulteti;
	}
	public void setPredlozeniFakulteti(List<String> predlozeniFakulteti) {
		this.predlozeniFakulteti = predlozeniFakulteti;
	}
	@Override
	public String toString() {
		return "Ispitanik [imePrezime=" + imePrezime + ", jmbg=" + jmbg + ", prosek=" + prosek + ", izabranoZanimanje="
				+ izabranoZanimanje + ", bodoviAdministracija=" + bodoviAdministracija + ", bodoviBezbednost="
				+ bodoviBezbednost + ", bodoviTehnicki=" + bodoviTehnicki + ", bodoviKultura=" + bodoviKultura
				+ ", bodoviNauka=" + bodoviNauka + ", bodoviPoljoprivreda=" + bodoviPoljoprivreda + ", bodoviPrehrana="
				+ bodoviPrehrana + ", bodoviTrgovina=" + bodoviTrgovina + ", bodoviEstetOblik=" + bodoviEstetOblik
				+ ", bodoviHumRad=" + bodoviHumRad + ", oblasti=" + oblasti + ", objasnjenja=" + objasnjenja
				+ ", predlozeniFakulteti=" + predlozeniFakulteti + "]";
	}

	
	
	

}
