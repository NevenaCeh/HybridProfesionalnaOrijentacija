package domen;

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
	private String rezultat = "nepoznato";
	private String objasnjenje = "nepoznato";
	private String predlozeniFakultet = "nepoznato";
	
	public String getObjasnjenje() {
		return objasnjenje;
	}
	public void setObjasnjenje(String objasnjenje) {
		this.objasnjenje = objasnjenje;
	}
	
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
	public String getRezultat() {
		return rezultat;
	}
	public void setRezultat(String rezultat) {
		this.rezultat = rezultat;
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
	public Ispitanik(){}
	
	
	
	@Override
	public String toString() {
		return "Ispitanik [rezultat=" + rezultat +" ]";
	}
	
	public double getProsek() {
		return prosek;
	}
	public void setProsek(double prosek) {
		this.prosek = prosek;
	}
	public String getPredlozeniFakultet() {
		return predlozeniFakultet;
	}
	public void setPredlozeniFakultet(String predlozeniFakultet) {
		this.predlozeniFakultet = predlozeniFakultet;
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

	
	
	

}
