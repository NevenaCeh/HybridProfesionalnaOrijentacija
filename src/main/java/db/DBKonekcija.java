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
				
				String jmbg = rs.getString("jmbg");
				String ime = rs.getString("imePrezime");
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

	public void ubaciUBazu(String jmbg, String ime, double prosek) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/proforijentacija", "root", "");
			String upit = "INSERT INTO ispitanik VALUES (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(upit);
			ps.setString(1, jmbg);
			ps.setString(2, ime);
			ps.setDouble(3, prosek);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
