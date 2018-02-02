package gui.komponente;

import domen.*;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TblModelIspitanici extends AbstractTableModel{
	
	List<Ispitanik> ispitanici;

    public TblModelIspitanici(List<Ispitanik> ispitanici) {
        this.ispitanici = ispitanici;
    }

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return ispitanici.size();
	}

	@Override
	public Object getValueAt(int i, int i1) {
		Ispitanik isp = ispitanici.get(i);
        switch(i1){
            case 0: int lastindex = isp.getImePrezime().lastIndexOf(" ");
					String ime = isp.getImePrezime().substring(0, lastindex).trim();
            		return ime;
            case 1: int last = isp.getImePrezime().lastIndexOf(" ");
					String prezime = isp.getImePrezime().substring(last).trim();
            		return prezime;
            case 2: long factor = (long) Math.pow(10, 2);
            		double value = isp.getProsek() * factor;
            		long tmp = Math.round(value);
            		return (double) tmp / factor;
           default: return "That's all folks ;)";
        }
	}
	
	@Override
    public String getColumnName(int i){
        switch(i){
            case 0: return "Ime";
            case 1: return "Prezime";
            case 2: return "Prosek";
            default: return "That's all folks ;)";
        }
    }

	public Ispitanik getIspitanik(int red) {
		return ispitanici.get(red);
	}

	public List<Ispitanik> getIspitanici() {
		return ispitanici;
	}

	public void setIspitanici(List<Ispitanik> ispitanici) {
		this.ispitanici = ispitanici;
	}

	public void osveziTabelu() {
        fireTableDataChanged();
    }
	
}
