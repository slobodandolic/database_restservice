package com.rest.maven.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rest.maven.model.Korisnici;

public class DatabaseKorisnici {
	
	
public Korisnici getKorisnikInfo (Integer id) {
		
		Korisnici korisnik = new Korisnici();
		DatabaseSource db = new DatabaseSource();
		
		Connection connection = db.getConnection();
		
		String sql = "select * from dbkodovi.korisnici where id = " + id;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				korisnik.setId(rs.getInt(1));
				korisnik.setIme(rs.getString(2));
				korisnik.setPrezime(rs.getString(3));
				korisnik.setEmail(rs.getString(4));
				korisnik.setUsername(rs.getString(5));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return korisnik;
		
	}

}
