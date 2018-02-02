package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.*;

import domen.*;

public class DBKonekcija {

	public List<Ispitanik> vratiListuIspitanika(){
		List<Ispitanik> lista = new ArrayList<Ispitanik>();		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/proforijentacija", "root", "");
			String upit = "SELECT * FROM ispitanik";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(upit);
			while (rs.next()) {				
				String jmbg = rs.getString("maticni");
				String ime = rs.getString("ime")+" "+rs.getString("prezime");
				double prosek = rs.getDouble("prosek");
				String oblasti = rs.getString("oblasti");
				String zanimanje = rs.getString("zanimanje");
				String faksevi = rs.getString("fakulteti");
				Ispitanik i = new Ispitanik();
				i.setJmbg(jmbg);
				i.setImePrezime(ime);
				i.setProsek(prosek);
				i.setIzabranoZanimanje(zanimanje);
				lista.add(i);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return lista;		
	}
	
	public List<Oblast> vratiListuOblasti(){
		List<Oblast> lista = new ArrayList<Oblast>();		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/proforijentacija", "root", "");
			String upit = "SELECT * FROM oblast";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(upit);
			while (rs.next()) {
				
				//long jmbg = rs.getLong("id");
				String ime = rs.getString("ime");
				String objasnjenje = rs.getString("objasnjenje");
				String skraceno = rs.getString("skraceno");
				Oblast o = new Oblast();
				o.setIme(skraceno);
				o.setPunoime(ime);
				o.setObjasnjenje(objasnjenje);
				lista.add(o);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return lista;		
	}

	public void ubaciUBazu(String jmbg, String ime, double prosek, String izabrano) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/proforijentacija", "root", "");
			String upit = "INSERT INTO ispitanik VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(upit);
			ps.setString(1, jmbg);
			int lastindex = ime.lastIndexOf(" ");
			String imeime = ime.substring(0, lastindex).trim();
			String prezime = ime.substring(lastindex).trim();
			ps.setString(2, imeime);
			ps.setString(3, prezime);
			ps.setDouble(4, prosek);
			ps.setString(5, izabrano);
			ps.setString(6, "");
			ps.setString(7, "");
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
	}

	public void izmeniIspitanika(Ispitanik ispitanik) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/proforijentacija", "root", "");
			String upit = "UPDATE ispitanik SET oblasti = ?, fakulteti = ? WHERE maticni = ?";
			PreparedStatement ps = conn.prepareStatement(upit);
			String zaoblasti = "";
			if (ispitanik.getOblasti().size() == 1) {
				zaoblasti = ispitanik.getOblasti().get(0);
			}else	{
				zaoblasti = ispitanik.getOblasti().get(0);
				for (int i = 1; i < ispitanik.getOblasti().size(); i++) {
					zaoblasti+=","+ispitanik.getOblasti().get(i);
				}
			}			
			ps.setString(1, zaoblasti);
			String zafakseve = "";
			if (ispitanik.getPredlozeniFakulteti().size() == 1) {
				zafakseve = ispitanik.getPredlozeniFakulteti().get(0);
			}else	{
				zafakseve = ispitanik.getPredlozeniFakulteti().get(0);
				for (int i = 1; i < ispitanik.getPredlozeniFakulteti().size(); i++) {
					zafakseve+="="+ispitanik.getPredlozeniFakulteti().get(i);
				}
			}	
			ps.setString(2, zafakseve);
			ps.setString(3, ispitanik.getJmbg());		
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	
	public Ispitanik vratiIspitanika(Ispitanik isp) throws Exception {
		List<Ispitanik> lista = new ArrayList<Ispitanik>();		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/proforijentacija", "root", "");
			String upit = "SELECT * FROM ispitanik WHERE maticni = "+isp.getJmbg();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(upit);
			while (rs.next()) {				
				String jmbg = rs.getString("maticni");
				String ime = rs.getString("ime")+" "+rs.getString("prezime");
				double prosek = rs.getDouble("prosek");
				String oblasti = rs.getString("oblasti");
				String zanimanje = rs.getString("zanimanje");
				String[] obl = oblasti.split(",");
				String faksevi = rs.getString("fakulteti");
				String[] f= faksevi.split("=");
				Ispitanik i = new Ispitanik();
				i.setJmbg(jmbg);
				i.setImePrezime(ime);
				i.setProsek(prosek);
				i.setIzabranoZanimanje(zanimanje);
				i.setOblasti(Arrays.asList(obl));	
				List<Oblast> oblastibaza = vratiListuOblasti();
				for (String string : obl) {
					for (Oblast o : oblastibaza) {
						if (string.trim().equals(o.getIme())) {
							i.getObjasnjenja().add(o.getObjasnjenje());
							break;
						}
					}
				}
				i.setPredlozeniFakulteti(Arrays.asList(f));
				lista.add(i);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}			
		if (lista.size() == 1) {
			return lista.get(0);	
		}else {
			throw new Exception("Ima vise od jednog sa ovim jmbg!!!");
		}
		
	}

	public List<Ispitanik> pretraziIspitanike(String text) {
        
        List<Ispitanik> lista = new ArrayList<Ispitanik>();		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/proforijentacija", "root", "");
	        String sql = "SELECT * FROM ispitanik WHERE ime LIKE '%"+text+"%' OR prezime LIKE '%"+text+"%'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {				
				String jmbg = rs.getString("maticni");
				String ime = rs.getString("ime")+" "+rs.getString("prezime");
				double prosek = rs.getDouble("prosek");
				String oblasti = rs.getString("oblasti");
				String zanimanje = rs.getString("zanimanje");
				String faksevi = rs.getString("fakulteti");
				Ispitanik i = new Ispitanik();
				i.setJmbg(jmbg);
				i.setImePrezime(ime);
				i.setProsek(prosek);
				i.setIzabranoZanimanje(zanimanje);
				lista.add(i);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
		return lista;	
	}
	

}
