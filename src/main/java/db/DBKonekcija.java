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
				Ispitanik i = new Ispitanik();
				i.setJmbg(jmbg);
				i.setImePrezime(ime);
				i.setProsek(prosek);
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
			String upit = "INSERT INTO ispitanik VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(upit);
			ps.setString(1, jmbg);
			int lastindex = ime.lastIndexOf(" ");
			String imeime = ime.substring(0, lastindex).trim();
			String prezime = ime.substring(lastindex).trim();
			ps.setString(2, imeime);
			ps.setString(3, prezime);
			ps.setDouble(4, prosek);
			ps.setString(5, izabrano);			
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
