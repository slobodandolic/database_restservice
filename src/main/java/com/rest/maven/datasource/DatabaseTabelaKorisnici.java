package com.rest.maven.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rest.maven.model.TabelaKorisnici;

public class DatabaseTabelaKorisnici {

	public TabelaKorisnici getKorisnikNagradaId(Integer id) {

		TabelaKorisnici tb = new TabelaKorisnici();
		DatabaseSource db = new DatabaseSource();

		Connection connection = db.getConnection();

		String sql = "select * from dbkodovi.tabelakorisnici where idnagrade = " + id;

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				tb.setIdkorisnika(rs.getString(1));
				tb.setIdnagrade(rs.getInt(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tb;
	}

}