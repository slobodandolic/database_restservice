package com.rest.maven.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.rest.maven.datasource.DatabaseConnection;
import com.rest.maven.datasource.DatabaseTabela;
import com.rest.maven.model.Tabela;

@Path("/tabela")
public class DatabaseMethodsTabela {
	
	@GET
	@Produces({ MediaType.TEXT_HTML })
	public String returnString() {

		Connection connect = null;
		
		String dbase = "jdbc:mysql://localhost:3306/dbkodovi?useSSL=false";
		String dbpass = "root";
		String dbuser = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(dbase, dbuser, dbpass);
			return "Connection succesfull";

		} catch (Exception e) {
			return "Connection fail1";
		}
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Tabela find(@PathParam("id") Integer id) {

		Tabela tabela = new Tabela();
		DatabaseTabela db = new DatabaseTabela();
		tabela = db.getTabelainfo(id);
		return tabela;
		
	}
	
	@GET
	@Path("/randomkod")
	@Produces({MediaType.TEXT_HTML})
	public String generateKod () {
		
		DatabaseTabela db = new DatabaseTabela();
		return db.getRandomKod(); 
	}
	
	@GET
	@Path("/dodajkodove")
	@Produces({MediaType.APPLICATION_JSON})
	public String dodajKodove() {
		
		//povezi na bazu
		//generisi 10 novih id metoda selectLast, kod, nagrada, proveren = 0
		Connection connection = new DatabaseConnection().getConnection();
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		DatabaseTabela db = new DatabaseTabela();
		
		int kod = db.getLast();
		int firstEmptyId = kod + 1;
		int range = firstEmptyId + 10;
		int brojNagrade = 0;
		
		//petlja za 10 kodova
		for (int i = firstEmptyId; i < range; i++) {
			
			String nagrada = "";
			if (brojNagrade < 1) {
				nagrada = "Letovanje";
			} else if (brojNagrade < 3) {
				nagrada = "Prva nagrada";
			} else if (brojNagrade < 5) {
				nagrada = "Druga nagrada";
			} else if (brojNagrade < 11) {
				nagrada = "Zamena";
			}
			
			brojNagrade++;
			
			try {
				String sql = "insert into dbkodovi.tabela values (?, ?, ?, ?)";

				statement = connection.createStatement();
				preparedStatement = connection.prepareStatement(sql);

				preparedStatement.setInt(1, i);
				preparedStatement.setString(2, db.getRandomKod());
				preparedStatement.setString(3, nagrada);
				preparedStatement.setInt(4, 0);

				preparedStatement.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("Greska u databaseMethods klasi, ");
			}
			
		}
		
		ArrayList<Tabela> lista = new ArrayList<>();

		for (int i = firstEmptyId; i < range; i++) {
		lista.add(db.getTabelainfo(i));
		
	}
		
		String json = new Gson().toJson(lista);
		
		return json;

	
}
	
	@GET
	@Path("/sve")
	@Produces({MediaType.APPLICATION_JSON})
	public String sviKodovi() {
	
	
		Connection connection = new DatabaseConnection().getConnection();

		DatabaseTabela db = new DatabaseTabela();
		
		int kod = db.getLast();
			
		ArrayList<Tabela> lista = new ArrayList<>();

		for (int i = 0; i <= kod; i++) {
		lista.add(db.getTabelainfo(i));
		
	}
		
		String json = new Gson().toJson(lista);
		
		return json;

	
}
	
}
