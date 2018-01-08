package domen;

public class Oblast {

	private double poeni;
	private String ime;
	private int nivo;
	
	public Oblast(double poeni, String ime, int nivo) {
		super();
		this.poeni = poeni;
		this.ime = ime;
		this.nivo = nivo;
	}

	public int getNivo() {
		return nivo;
	}

	public void setNivo(int nivo) {
		this.nivo = nivo;
	}

	public Oblast() {
	}
	
	public Oblast(double poeni, String ime) {
		this.poeni = poeni;
		this.ime = ime;
	}

	public double getPoeni() {
		return poeni;
	}
	public void setPoeni(double poeni) {
		this.poeni = poeni;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}

	@Override
	public String toString() {
		return "Oblast [poeni=" + poeni + ", ime=" + ime + ", nivo=" + nivo + "]";
	}


}
