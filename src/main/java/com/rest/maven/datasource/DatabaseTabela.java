package com.rest.maven.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.rest.maven.model.Tabela;

public class DatabaseTabela {

	public Tabela getTabelaInfo() {

		Tabela tabela = new Tabela();
		DatabaseConnection db = new DatabaseConnection();

		Connection connection = db.getConnection();

		String sql = "select * from dbkodovi.tabela where id = 6";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				tabela.setId(rs.getInt(1));
				tabela.setKod(rs.getString(2));
				tabela.setNagrada(rs.getString(3));
				tabela.setProveren(rs.getInt(4));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tabela;

	}

	public Tabela getTabelainfo(Integer id) {

		Tabela tabela = new Tabela();
		DatabaseConnection db = new DatabaseConnection();

		Connection connection = db.getConnection();

		String sql = "select * from dbkodovi.tabela where id = " + id + "";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				tabela.setId(rs.getInt(1));
				tabela.setKod(rs.getString(2));
				tabela.setNagrada(rs.getString(3));
				tabela.setProveren(rs.getInt(4));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tabela;

	}

	public String getRandomKod() {
		final char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'Q', 'W', 'E', 'R', 'T', 'Z', 'U', 'I',
				'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Y', 'X', 'C', 'V', 'B', 'N', 'M' };

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < 8; i++) {
			stringBuilder.append(chars[new Random().nextInt(chars.length)]);
		}
		return stringBuilder.toString();

	}

	public int getLast() {

		int kod = 0;
		DatabaseConnection db = new DatabaseConnection();
		Connection connection = db.getConnection();
		try {

			String sql = "select * from dbkodovi.tabela where id = (select max(id) from dbkodovi.tabela)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet result = ps.executeQuery(sql);

			if (result.next()) {
				kod = result.getInt(1);

				System.out.println("Poslednji popunjen red u tabeli je: " + kod);
				return kod;

			} else {
				System.out.println("Greska selectLastDatabaseTabela sql");
			}
		} catch (Exception e) {
			System.out.println("Nepostojeci kod");
		}

		return kod;
	}
}
